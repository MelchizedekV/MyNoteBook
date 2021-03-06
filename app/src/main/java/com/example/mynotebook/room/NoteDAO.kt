package com.example.mynotebook.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
 interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insertAll(notePojo: NoteEntityClass)

}