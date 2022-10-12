package com.example.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contact.adapter.MyRvAdapter
import com.example.contact.databinding.FragmentKorishBinding
import com.example.contact.db.MyContact
import com.example.contact.db.MyDbHelper

class KorishFragment : Fragment() {

    private lateinit var binding: FragmentKorishBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var myRvAdapter: MyRvAdapter
    private lateinit var list:ArrayList<MyContact>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentKorishBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(binding.root.context)
        list=ArrayList()
        list.addAll(myDbHelper.getAllContact())

          binding.apply {
              myRvAdapter = MyRvAdapter(list)


              rv.adapter=myRvAdapter
          }

        return binding.root
    }


}