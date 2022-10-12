package com.example.contact.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context):SQLiteOpenHelper(context,"my_contact_db",null,1),MyInterface {
    override fun onCreate(db: SQLiteDatabase?) {
        val query="create table  my_contacts(id integer  not null primary key autoincrement unique,name text not null ,number text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    override fun AddContact(myContact: MyContact) {
        val database=writableDatabase
        val contactValues=ContentValues()
        contactValues.put("name",myContact.name)
        contactValues.put("number",myContact.number )
        database.insert("my_contacts",null,contactValues)
        database.close()
    }

    override fun getAllContact(): List<MyContact> {
        var list:ArrayList<MyContact> = ArrayList()
        val database=readableDatabase
        val query="select * from my_contacts"
        val cursor=database.rawQuery(query,null)

        if (cursor.moveToFirst()){
            do {
                val myContact=MyContact(
                    cursor.getString(1),
                    cursor.getString(2)
                )
                list.add(myContact)

            }while (cursor.moveToNext())
        }
        return list

    }
}