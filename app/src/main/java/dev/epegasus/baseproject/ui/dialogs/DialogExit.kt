package dev.epegasus.baseproject.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.epegasus.baseproject.databinding.DialogExitBinding

class DialogExit : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogExitBinding.inflate(layoutInflater)
        binding.mbExitExit.setOnClickListener { onExitClick() }
        binding.mbCancelExit.setOnClickListener { dismiss() }
        isCancelable = false
        return MaterialAlertDialogBuilder(binding.root.context)
            .setView(binding.root)
            .create()
    }

    private fun onExitClick() {
        context?.let {
            (it as Activity).finishAndRemoveTask()
        } ?: dismiss()
    }
}