package app.katyaos.apps.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import app.katyaos.apps.core.ReleaseChannel
import app.katyaos.apps.PackageStates
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import app.katyaos.apps.R

class ReleaseChannelDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val pkgName = navArgs<ReleaseChannelDialogArgs>().value.pkgName
        val pkgState = PackageStates.getPackageState(pkgName)

        val channels = ReleaseChannel.entries

        val channelNames = channels.map { resources.getText(it.uiName) }
        val curIndex = channels.indexOf(pkgState.preferredReleaseChannel())

        return MaterialAlertDialogBuilder(requireContext()).run {
            setTitle(R.string.release_channel)
            setSingleChoiceItems(channelNames.toTypedArray(), curIndex) { _, index ->
                PackageStates.setPreferredChannelOverride(pkgState, channels[index])
                findNavController().popBackStack()
            }
            create()
        }
    }
}
