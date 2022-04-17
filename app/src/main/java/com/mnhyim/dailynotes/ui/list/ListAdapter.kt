package com.mnhyim.dailynotes.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mnhyim.core.domain.model.Note
import com.mnhyim.dailynotes.databinding.ListItemNotesBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var listNotes = ArrayList<Note>()

    inner class ListViewHolder(private val binding: ListItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(binding) {
                tvNoteTitle.text = note.title
                tvNoteDate.text = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(note.date)
                tvNoteContent.text = note.content
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val binding = ListItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        val note = listNotes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    fun setNotes(notes: List<Note>?) {
        if (notes == null) {
            this.listNotes.clear()
            notifyDataSetChanged()
        } else {
            this.listNotes.clear()
            this.listNotes.addAll(notes)
            notifyDataSetChanged()
        }
    }
}