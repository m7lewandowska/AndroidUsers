package com.example.userlist

import User

class UserModel() {
    private var userList = mutableListOf<User>()

    fun addUser(firstName: String, lastName: String) {
        var newUser = User(firstName, lastName)
        userList.add(newUser)
    }

    fun getUsers(): MutableList<User> {
        return userList
    }

    fun getLastUser(): User {
        return userList.last()
    }
}