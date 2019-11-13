package com.example.users

import User
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DTBConnect(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object
    {
        internal const val DATABASE_NAME = "Users_DB"
        internal const val DATABASE_VERSION = 1
        internal const val TABLE_NAME = "Users_Table"
        internal const val COL_ID = "Id"
        internal const val COL_NAME ="Name"
        internal const val COL_SURNAME = "Surname"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = db!!.execSQL("CREATE TABLE $TABLE_NAME( " +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME TEXT," +
                "$COL_SURNAME TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)

    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    //addUserToDTB() pod guzik btn
    fun addUserToDTB(user: User) {
        val values = ContentValues()
        values.put(COL_NAME, user.userName)
        values.put(COL_SURNAME, user.userSurname)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun editUserFromDTB(firstName: String, lastName: String) {
        val db = this.writableDatabase
    }

    fun delUserFromDTB(firstName: String, lastName: String){

        val db = this.writableDatabase
        db!!.execSQL("DELETE FROM $TABLE_NAME WHERE $COL_NAME = \"$firstName\" AND $COL_SURNAME = \"$lastName\"")
        db.close()
    }

    fun getUserFromDTB(): MutableList<User>
    {
        val query = "SELECT * FROM $TABLE_NAME"

        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null,null)

        val users = mutableListOf<User>()

        while(cursor.moveToNext())
        {
            val id = Integer.parseInt(cursor.getString(0))
            val firstNameUser = (cursor.getString(1))
            val surnameNameUser = (cursor.getString(2))

            val user= User(firstNameUser, surnameNameUser)

           users.add(user)
        }

        cursor.close()
        db.close()
        return users
    }

       /* val allUsers: MutableList<User>
        get()
        {
            val query = "SELECT + FROM $TABLE_NAME"
            val users = mutableListOf<User>()
        }*/
}
