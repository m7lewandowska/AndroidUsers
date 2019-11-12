package com.example.users

import User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class UserAdapter(private val context: Context, private val dataSource: ArrayList<User>): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rowView = inflater.inflate(R.layout.layout_user, parent, false)

        val idTextView = rowView.findViewById(R.id.id_layout) as TextView

        val nameTextView = rowView.findViewById(R.id.name_layout) as TextView

        val surnameTextView = rowView.findViewById(R.id.surname_layout) as TextView

        val user = getItem(position) as User

        idTextView.text = user.id.toString()
        nameTextView.text = user.userName.toString()
        surnameTextView.text = user.userSurname.toString()

        return rowView
    }
}
