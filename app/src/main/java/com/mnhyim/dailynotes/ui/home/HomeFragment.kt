package com.mnhyim.dailynotes.ui.home

import android.app.ProgressDialog.show
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mnhyim.core.domain.model.Note
import com.mnhyim.dailynotes.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormat

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.fabAddNote.setOnClickListener {
            Toast.makeText(context, "TESTT", Toast.LENGTH_LONG).show()
            AddNoteDialog().show(parentFragmentManager, "TEST")
//            lifecycleScope.launch {
//                viewModel.insertNote(
//                    Note(
//                        title = "Note ${DateFormat.getTimeInstance()}",
//                        content = "LORLRORORLROR",
//                        date = "123213123123123"
//                    )
//                )
//            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addNoteDialog() {

    }
}