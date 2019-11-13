package com.example.users

import User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class UserAdapter(private val context: Context, private val dataSource: ArrayList<User>): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private var dtbConnect: DTBConnect = DTBConnect(context)

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



        //Button edit on listView
        val editButton = rowView.findViewById<Button>(R.id.buton_edit)
        editButton.setOnClickListener {changeActivity(context,user.userName, user.userSurname)}

        //Button del on listView
        val delButton = rowView.findViewById<Button>(R.id.buton_del)
        delButton.setOnClickListener ({dtbConnect.delUserFromDTB(nameTextView.text.toString(),surnameTextView.text.toString())})

        idTextView.text = user.id.toString()
        nameTextView.text = user.userName.toString()
        surnameTextView.text = user.userSurname.toString()

        return rowView
    }

    /*fun changeActivity(idView: String, nameView: String, surnameView: String)
    {
        val intent = Intent(context, UserEditActivity::class.java)

        intent.putExtra("idUser", idView)
        intent.putExtra("nameUser", nameView)
        intent.putExtra("surnameUser", surnameView)

        startActivity(intent)

    }*/

     companion object {
         fun changeActivity(context: Context,usernameView: String,usersurnameView: String) {

             val intent = Intent(context, UserEditActivity::class.java)
             intent.putExtra("UserName", usernameView)
             intent.putExtra("UserSurname", usersurnameView)
             context.startActivity(intent)

         }
     }
}
