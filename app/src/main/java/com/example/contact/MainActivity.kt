package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.contact.adapter.MyRvAdapter
import com.example.contact.databinding.ActivityMainBinding
import com.example.contact.databinding.ItemDialogBinding
import com.example.contact.db.MyContact
import com.example.contact.db.MyDbHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var myRvAdapter: MyRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        myDbHelper= MyDbHelper(this)
        myRvAdapter= MyRvAdapter(myDbHelper.getAllContact())

        binding.apply {






        }
    }
}