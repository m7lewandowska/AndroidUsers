package com.example.users

import User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.userlist.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userModel: UserModel = UserModel()
    private var dtbConnect: DTBConnect = DTBConnect(this)


    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lisView_users)

        val listOfUsers = mutableListOf<User>()

        val adapter = ArrayAdapter(this, android.R.layout.activity_list_item, listOfUsers)
        listView.adapter = adapter

        var userController = UserController(this, userModel, dtbConnect)

        // ADDING CURRENT USER TO TEXT VIEW - ACTIVE USER
        //setContentView(R.layout.activity_main)
        //BTN1_ADD.setOnClickListener{AddUser()}

        listView = findViewById<ListView>(R.id.lisView_users)


    }

    /*fun AddUser()
    {
       var firstName =  UsrName_Input.text.toString()
       var surname =  UsrSurname_Input.text.toString()
       var user = User()

        user.userName = firstName
        user.userSurname = surname

        ActiveUser.text = user.userName + " " + user.userSurname
        //listOfUsers.add(user)
    }*/

    fun AddToListView(lisView_users: ArrayList<User>){
        val listOfUsers = lisView_users
        val adapter = UserAdapter(this, listOfUsers)
        listView.adapter = adapter


    }

    fun ClearLictView(lisView_users: ArrayList<User>){

        User.ID = 1
        val listOfUsers = lisView_users
        val adapter = UserAdapter(this, listOfUsers)
        listView.adapter = adapter

        listOfUsers.clear()
        adapter.notifyDataSetChanged();


    }

}
