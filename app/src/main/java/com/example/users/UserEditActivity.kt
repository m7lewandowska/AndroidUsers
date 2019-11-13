package com.example.users

import User
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_edit.*

class UserEditActivity : AppCompatActivity() {

    private var dtbConnect: DTBConnect = DTBConnect(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit)


        var userName = intent.getStringExtra("UserName")
        var userSurname = intent.getStringExtra("UserSurname")

        //var user = dtbConnect.getUserById(id)

        name_editlayout.text = userName
        surname_editlayout.text = userSurname


    }
}
