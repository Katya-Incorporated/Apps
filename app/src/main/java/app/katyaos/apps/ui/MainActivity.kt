package app.katyaos.apps.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import app.katyaos.apps.NavGraphDirections
import app.katyaos.apps.PackageStates
import app.katyaos.apps.R
import app.katyaos.apps.core.mainHandler
import app.katyaos.apps.databinding.MainActivityBinding
import app.katyaos.apps.util.ActivityUtils
import app.katyaos.apps.util.InternalSettings
import app.katyaos.apps.util.InternalSettings.KEY_SUPPRESS_NOTIFICATION_PERMISSION_DIALOG

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    lateinit var views: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val views = MainActivityBinding.inflate(layoutInflater)
        this.views = views

        window.setDecorFitsSystemWindows(false)

        ViewCompat.setOnApplyWindowInsetsListener(views.root) { v, insets ->
            val paddingInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = paddingInsets.left
                rightMargin = paddingInsets.right
            }
            insets
        }

        ViewCompat.setOnApplyWindowInsetsListener(views.toolbar) { v, insets ->
            val paddingInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = paddingInsets.top
            }
            insets
        }

        setContentView(views.root)
        navController = supportFragmentManager.findFragmentById(R.id.container)!!.findNavController()
        setSupportActionBar(views.toolbar)

        // doesn't work properly if setup in onCreate() if activity is recreated
        mainHandler.post {
            NavigationUI.setupWithNavController(views.toolbar, navController)
        }

        intent.let {
            if (it.action == Intent.ACTION_SHOW_APP_INFO) {
                val pkg = intent.getStringExtra(Intent.EXTRA_PACKAGE_NAME) ?: return@let
                val pkgState = PackageStates.maybeGetPackageState(pkg) ?: return@let
                val opts = NavOptions.Builder().setPopUpTo(R.id.main_screen, true).build()
                navController.navigate(NavGraphDirections.actionToDetailsScreen(pkgState.pkgName), opts)
            }

            ActivityUtils.maybeAddPendingActionFromIntent(it)
        }

        if (Build.VERSION.SDK_INT >= 33) {
            maybeAskForNotificationPermission()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        ActivityUtils.maybeAddPendingActionFromIntent(intent)
    }

    override fun onResume() {
        super.onResume()
        PackageStates.requestRepoUpdateNoSuspend()
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) {}

    @RequiresApi(33)
    private fun maybeAskForNotificationPermission() {
        val perm = Manifest.permission.POST_NOTIFICATIONS

        if (checkSelfPermission(perm) == PERMISSION_GRANTED) {
            return
        }
        if (InternalSettings.file.getBoolean(KEY_SUPPRESS_NOTIFICATION_PERMISSION_DIALOG, false)) {
            return
        }
        if (shouldShowRequestPermissionRationale(perm)) {
            navController.navigate(R.id.notification_permission_dialog)
        } else {
            requestPermissionLauncher.launch(perm)
        }
    }
}
