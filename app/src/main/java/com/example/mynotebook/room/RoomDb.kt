package com.example.roomdb.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotebook.room.NoteDAO
import com.example.mynotebook.room.NoteEntityClass

@Database(entities = [NoteEntityClass::class], version = 1)
abstract class RoomDb : RoomDatabase() {

    abstract val noteDAO: NoteDAO

    companion object {

        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getInstance(context: Context): RoomDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            RoomDb::class.java,
                            "NoteBookDb"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}