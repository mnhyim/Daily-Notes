package com.mnhyim.dailynotes.ui.home

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.mnhyim.core.domain.model.Note
import com.mnhyim.dailynotes.R
import com.mnhyim.dailynotes.databinding.DialogAddNoteBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddNoteDialog : DialogFragment() {

    private var _binding: DialogAddNoteBinding? = null
    private val binding get() = _binding!!
    private val TAG: String = AddNoteDialog::class.java.simpleName.toString()
    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddNoteBinding.inflate(layoutInflater)
        binding.tieDate.setOnClickListener {
            setDate()
        }

        return AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton(R.string.prompt_submit) { _, _ ->
                Log.d(TAG, "positiveButton ${convertToMilliseconds(binding.tieDate.text.toString())}")
                lifecycleScope.launch {
                    viewModel.insertNote(
                        Note(
                            title = binding.tieTitle.text.toString(),
                            content = binding.tieContent.text.toString(),
                            date = convertToMilliseconds(binding.tieDate.text.toString())
                        )
                    )
                }
            }
            .setNegativeButton(R.string.prompt_cancel) { dialog, _ ->
                Log.d(TAG, "negativeButton")
                dialog.cancel()
            }
            .create()
    }

    override fun onStart() {
        super.onStart()
        setDialogBackground()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDialogBackground() {
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun setDate() {
        val c = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { a, year, monthOfYear, dayOfMonth ->
                val x = "${a.dayOfMonth}-${monthOfYear+1}-${a.year}"
                binding.tieDate.setText(x)
            },
            c.get(Calendar.YEAR),
            c.get(Calendar.MONTH),
            c.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun convertToMilliseconds(date: String): Long {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val mDate: Date = sdf.parse(date) as Date
        return mDate.time
    }
}