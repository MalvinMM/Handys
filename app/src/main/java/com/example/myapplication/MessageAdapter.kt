package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import java.util.ArrayList

class MessageAdapter(val context : Context, val messageList: ArrayList<Messages>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val item_received = 1
    val item_sent = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1){
            val view:View = LayoutInflater.from(context).inflate(R.layout.message_received,parent, false)
            return ReceiveViewHolder(view)
        }else{
            val view:View = LayoutInflater.from(context).inflate(R.layout.message_sent,parent, false)
            return SentViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentMessage = messageList[position]

        if(holder.javaClass == SentViewHolder::class.java){
            val viewHolder = holder as SentViewHolder
            holder.sentMessages.text = currentMessage.message
        }else{
            val viewHolder = holder as ReceiveViewHolder
            holder.receivedMessages.text = currentMessage.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        val currentMessage = messageList[position]

        if(FirebaseAuth.getInstance().currentUser?.uid.equals(currentMessage.senderId)){
            return item_sent
        }else{
            return item_received
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class SentViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val sentMessages = itemView.findViewById<TextView>(R.id.txt_sent_message)
    }

    class ReceiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val receivedMessages = itemView.findViewById<TextView>(R.id.txt_receive_message)
    }
}