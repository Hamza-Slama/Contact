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

class TicketAdapter(private val mDataset: ArrayList<TicketContact>, private var communication: Communication) : RecyclerView.Adapter<TicketAdapter.DataObjectHolder>() {


    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_contact, parent, false)
        val dataObjectHolder = DataObjectHolder(view)
        context = parent.context
        return dataObjectHolder
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {


        holder.tv_name.text = mDataset[position].name + position
        holder.label_caractere.text = "${mDataset[position].name.first().toUpperCase()}"
//        while ((position + 1 < mDataset.size - 1 && (mDataset[position].name.first().toUpperCase() != mDataset[position + 1].name.first().toUpperCase())
//                        || (position - 1 > 0 && mDataset[position].name.first().toUpperCase() != mDataset[position - 1].name.first().toUpperCase()))) {

            if (mDataset[position].name.first().toUpperCase() == 'A') {
                communication.listener(position, 'A'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'B') {
                communication.listener(position, 'B'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'C') {
                communication.listener(position, 'C'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'D') {
                communication.listener(position, 'D'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'O') {
                communication.listener(position, 'O'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'N') {
                communication.listener(position, 'N'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'S') {
                communication.listener(position, 'S'.toString())

            } else if (mDataset[position].name.first().toUpperCase() == 'L') {
                communication.listener(position, 'L'.toString())

            }

//            when (mDataset[position].name.first().toUpperCase()) {
//
//                'A' -> {
//                    communication.listener(position, 'A'.toString())
//
//                }
//                'B' -> {
//                    communication.listener(position, 'B'.toString())
//                }
//                'C' -> {
//                    communication.listener(position, 'C'.toString())
//                }
//                'D' -> {
//                    communication.listener(position, 'D'.toString())
//                }
//                'E' -> {
//                    communication.listener(position, 'E'.toString())
//                }
//                'F' -> {
//                    communication.listener(position, 'F'.toString())
//                }
//                'G' -> {
//                    communication.listener(position, 'G'.toString())
//                }
//                'O' -> {
//                    communication.listener(position, 'O'.toString())
//                }
//                'N' -> {
//                    communication.listener(position, 'N'.toString())
//                }
//                'L' -> {
//                    communication.listener(position, 'L'.toString())
//                }
//                'J' -> {
//                    communication.listener(position, 'J'.toString())
//                }
//                'H' -> {
//                    communication.listener(position, 'H'.toString())
//                }
//                'S' -> {
//                    communication.listener(position, 'S'.toString())
//                }
//            }
//        }


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

interface Communication {
    fun listener(position: Int, name: String)
}
