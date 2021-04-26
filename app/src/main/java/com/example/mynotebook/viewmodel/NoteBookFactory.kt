package com.example.mynotebook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mynotebook.repo.NoteBookRepository
import com.example.mynotebook.room.NoteDAO
import java.lang.IllegalStateException

class NoteBookFactory(val noteBookRepository: NoteBookRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteBookViewModel::class.java)){

            return NoteBookViewModel(noteBookRepository)  as T
        }
        throw IllegalStateException("ViewModel not found")

    }
}