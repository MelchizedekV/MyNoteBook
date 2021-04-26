package com.example.mynotebook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import com.example.mynotebook.R
import com.example.mynotebook.databinding.ActivityAddNotesBinding
import com.example.mynotebook.repo.NoteBookRepository
import com.example.mynotebook.room.NoteDAO
import com.example.mynotebook.viewmodel.NoteBookFactory
import com.example.mynotebook.viewmodel.NoteBookViewModel
import com.example.roomdb.Db.RoomDb

class AddNotesActivity : AppCompatActivity() {

    lateinit var binding:ActivityAddNotesBinding
    lateinit var mViewModel:NoteBookViewModel
    lateinit var noteDao: NoteDAO
    lateinit var noteBookRepository: NoteBookRepository
    lateinit var noteBookFactory:NoteBookFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_notes)
        noteDao = RoomDb.getInstance(this).noteDAO
        noteBookRepository = NoteBookRepository(noteDao)
        noteBookFactory = NoteBookFactory(noteBookRepository)
        mViewModel = ViewModelProvider(this,noteBookFactory).get(NoteBookViewModel::class.java)

        callSubmitBtnClick()


    }

    private fun callSubmitBtnClick() {

        var subject:String
        var description:String

        binding.apply {

         submitBtn.setOnClickListener {
             subject = subTxt.text.toString()
             description = notesTxt.text.toString()
             mViewModel.callInsertDataFun(subject,description)

         }

        }

    }
}