package com.example.myapplication
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class UserAdapter(val context: Context, val userList : ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewsHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.user_layout,parent, false)
        return UserViewsHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewsHolder, position: Int) {

        val currentUser = userList[position]

        holder.textEmail.text = currentUser.email

        holder.itemView.setOnClickListener{
            val intent = Intent(context, ChatLog::class.java)

            intent.putExtra("email", currentUser.email)
            intent.putExtra("uid", currentUser.uid)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textEmail = itemView.findViewById<TextView>(R.id.txt_name)

    }
}