package com.example.contact.db

interface MyInterface {

    fun AddContact(myContact: MyContact)
    fun getAllContact():List<MyContact>
}