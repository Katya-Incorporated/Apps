package app.katyasystem.apps.autoupdate

import android.app.Notification
import android.app.job.JobParameters
import android.app.job.JobService
import android.text.format.Formatter
import android.util.Log
import androidx.navigation.NavDeepLinkBuilder
import app.katyasystem.apps.ApplicationImpl
import app.katyasystem.apps.Notifications
import app.katyasystem.apps.PackageStates
import app.katyasystem.apps.R
import app.katyasystem.apps.core.RPackage
import app.katyasystem.apps.core.RepoUpdateError
import app.katyasystem.apps.core.appContext
import app.katyasystem.apps.core.appResources
import app.katyasystem.apps.core.collectOutdatedPackageGroups
import app.katyasystem.apps.setContentTitle
import app.katyasystem.apps.show
import app.katyasystem.apps.ui.DetailsScreen
import app.katyasystem.apps.ui.ErrorDialog
import app.katyasystem.apps.ui.MainActivity
import app.katyasystem.apps.util.componentName
import app.katyasystem.apps.util.isAppInstallationAllowed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "UpdateCheckJob"

class UpdateCheckJob : JobService() {

    override fun onStartJob(jobParams: JobParameters?): Boolean {
        ApplicationImpl.exitIfNotInitialized()
        Log.d(TAG, "onStartJob")

        if (!isAppInstallationAllowed()) {
            return false
        }

        CoroutineScope(Dispatchers.Main).launch {
            val repoUpdateError = PackageStates.requestRepoUpdate()
            if (repoUpdateError != null) {
                showUpdateCheckFailedNotification(repoUpdateError)
            } else {
                val outdatedPackageGroups = collectOutdatedPackageGroups()

                if (outdatedPackageGroups.isEmpty()) {
                    showAllUpToDateNotification()
                } else {
                    showUpdatesAvailableNotification(outdatedPackageGroups)

                    AutoUpdatePrefs.maybeScheduleAutoUpdateJob()
                }
            }

            jobFinished(jobParams, false)
            Log.d(TAG, "finished")
        }

        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        // ignore the stop signal: update check is inexpensive and doesn't have relevant cancellation points
        return false
    }

    private fun showUpdatesAvailableNotification(rPackageGroups: List<List<RPackage>>) {
        val rPackages = ArrayList<RPackage>()
        rPackageGroups.forEach { it.forEach { rPackages.add(it) } }

        check(rPackages.size >= 1)

        val filteredRPackages = rPackages.filter { it.common.showAutoUpdateNotifications }

        if (filteredRPackages.isEmpty()) {
            return
        }

        val config = appResources.configuration
        val sumSize = rPackages.sumOf {
            it.collectNeededApks(config).sumOf { it.compressedSize }
        }.let {
            Formatter.formatShortFileSize(appContext, it)
        }

        Notifications.builder(Notifications.CH_AUTO_UPDATE_UPDATES_AVAILABLE).apply {
            setSmallIcon(R.drawable.ic_updates_available)

            setContentTitle(
                appResources.getQuantityString(R.plurals.notif_pkg_updates_available_title,
                rPackages.size, sumSize))
            if (filteredRPackages.size == 1) {
                val rpkg = filteredRPackages[0]
                setContentText(
                    appResources.getString(R.string.notif_pkg_update_available_text,
                    rpkg.label, rpkg.versionName))
                setContentIntent(DetailsScreen.createPendingIntent(rpkg.packageName))
            } else {
                setContentText(filteredRPackages.map { it.label }.joinToString())
                NavDeepLinkBuilder(appContext).run {
                    setGraph(R.navigation.nav_graph)
                    setDestination(R.id.updates_screen)
                    setComponentName(componentName<MainActivity>())
                    createPendingIntent()
                }.let {
                    setContentIntent(it)
                }
            }
            setStyle(Notification.BigTextStyle())
            show(Notifications.ID_AUTO_UPDATE_JOB_STATUS)
        }
    }
}

fun showAllUpToDateNotification() {
    if (PackageStates.numberOfInstallTasks() != 0) {
        return
    }

    Notifications.builder(Notifications.CH_AUTO_UPDATE_ALL_UP_TO_DATE).run {
        setSmallIcon(R.drawable.ic_check)
        setContentTitle(R.string.notif_auto_update_all_up_to_date)
        setAutoCancel(false)
        show(Notifications.ID_AUTO_UPDATE_JOB_STATUS)
    }
}

fun showUpdateCheckFailedNotification(repoUpdateError: RepoUpdateError) {
    Notifications.builder(Notifications.CH_BACKGROUND_UPDATE_CHECK_FAILED).run {
        setSmallIcon(R.drawable.ic_error)
        setContentTitle(R.string.unable_to_fetch_app_list)
        setContentIntent(ErrorDialog.createPendingIntent(repoUpdateError))
        show(Notifications.ID_AUTO_UPDATE_JOB_STATUS)
    }
}
