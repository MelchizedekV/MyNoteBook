package com.example.mynotebook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotebook.repo.NoteBookRepository
import com.example.mynotebook.room.NoteDAO
import com.example.mynotebook.room.NoteEntityClass
import kotlinx.coroutines.launch

class NoteBookViewModel(val noteBookRepository: NoteBookRepository) : ViewModel() {


    lateinit var notePojo: NoteEntityClass

    fun callInsertDataFun(subject:String,description:String) {
        notePojo = NoteEntityClass(0,subject,description)
         viewModelScope.launch {
             noteBookRepository.insertAllData(notePojo)
         }

    }


}