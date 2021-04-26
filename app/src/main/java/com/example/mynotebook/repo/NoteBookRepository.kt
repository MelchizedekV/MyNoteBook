package com.example.mynotebook.repo

import com.example.mynotebook.room.NoteDAO
import com.example.mynotebook.room.NoteEntityClass

class NoteBookRepository(val noteDAO: NoteDAO) {


    suspend fun insertAllData(notePojo: NoteEntityClass){

        noteDAO.insertAll(notePojo)

    }

}