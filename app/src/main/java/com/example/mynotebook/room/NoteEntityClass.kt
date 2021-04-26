package com.example.mynotebook.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class NoteEntityClass (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int?=null,
    @ColumnInfo(name = "subject")
    val subject:String?=null,
    @ColumnInfo(name = "description")
    val description:String?=null

)