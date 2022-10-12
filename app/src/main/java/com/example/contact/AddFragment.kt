package com.example.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.contact.databinding.FragmentAddBinding
import com.example.contact.db.MyContact
import com.example.contact.db.MyDbHelper

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var myDbHelper: MyDbHelper

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        binding.buttonSave.setOnClickListener {

            val myContact = MyContact(
                name = binding.edtName.text.toString().trim(),
                number = binding.edtNumber.text.toString().trim()

            )
            myDbHelper.AddContact(myContact)
            Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()

        findNavController().popBackStack()
        }


        return binding.root
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}