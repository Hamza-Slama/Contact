package com.example.odc.contactlist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.odc.contactlist.R.color.A


import java.util.ArrayList
import java.util.logging.Handler

class TicketAdapter(private val mDataset: ArrayList<TicketContact>) : RecyclerView.Adapter<TicketAdapter.DataObjectHolder>() {


    private var context: Context? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_contact, parent, false)
        val dataObjectHolder = DataObjectHolder(view)
        context = parent.context
        return dataObjectHolder
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {




        holder.tv_name.setText(mDataset[position].name)
        holder.label_caractere.setText("${mDataset[position].name.first().toUpperCase()}")



    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    inner class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var label_caractere: TextView
        internal var tv_name: TextView


        init {
            label_caractere = itemView.findViewById<TextView>(R.id.label_caractere) as TextView
            tv_name = itemView.findViewById<TextView>(R.id.tv_name) as TextView

        }
    }



}
