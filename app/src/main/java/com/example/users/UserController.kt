package com.example.users

import User
import android.widget.Toast
import com.example.userlist.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class UserController(activity: MainActivity, userModel: UserModel, dtbConnect: DTBConnect) {

    private var userModel = userModel
    private var activity = activity
    private var dtbConnect = dtbConnect

    init {
        activity.BTN1_ADD.setOnClickListener({ btnClickAdd() })
        activity.BTN2_SHOW.setOnClickListener({ btnClickShow() })
        activity.BTN3_DEL.setOnClickListener({btnClickDel()})
    }

    //Dodanie jednego usera do bazy oraz rozszerzenie listView_users o jednego usera
    fun btnClickAdd() {
        var firstName: String = activity.UsrName_Input.text.toString()
        var lastName: String = activity.UsrSurname_Input.text.toString()

        userModel.addUser(firstName, lastName)

        //pobranie ostatnio dodanego usera
        var lastUser = userModel.getLastUser()

        //aktywny user czyli ostatnio dodany user
        activity.ActiveUser.text = "${lastUser.userName} ${lastUser.userSurname}"
        extendList()

        //dodanie usera do bazy
        dtbConnect.addUserToDTB(lastUser)

    }

    fun btnClickDel()
    {
        var firstName: String = activity.UsrName_Input.text.toString()
        var lastName: String = activity.UsrSurname_Input.text.toString()

        dtbConnect.delUserFromDTB(firstName, lastName)
    }

    //Wczytanie wszystkich rekordow znajdujacych sie w tabeli (bazie danych)
    fun btnClickShow() {

        btnClickClear()
        var users = dtbConnect.getUserFromDTB()

        //Dodanie do listView_users wszystkich userów
        activity.AddToListView(users as ArrayList<User>)

    }

    //Rozszerzenie listy (listView_users) o jednego usera
    fun extendList() {
        activity.AddToListView(userModel.getUsers() as ArrayList<User>)
    }

    fun btnClickClear(){
        activity.ClearLictView(userModel.getUsers() as ArrayList<User>)
    }

}