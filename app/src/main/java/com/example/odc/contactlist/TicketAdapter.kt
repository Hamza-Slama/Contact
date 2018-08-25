package com.example.odc.contactlist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.odc.contactlist.R.color.A
import java.util.*


import java.util.logging.Handler

class TicketAdapter() : RecyclerView.Adapter<TicketAdapter.DataObjectHolder>() {

    private var mDataset: ArrayList<TicketContact>?=null
    constructor(mDataset: ArrayList<TicketContact> , Agefiltre : Int , desTri : Boolean) : this() {
        this.mDataset = mDataset
        this.mDataset = mDataset.filter { s -> s.age> Agefiltre } as ArrayList<TicketContact>
        if (mDataset.isNotEmpty()){
            if (desTri){
                Collections.sort(mDataset, object : Comparator<TicketContact> {
                    override fun compare(news1: TicketContact, news2: TicketContact): Int {

                        return news2.age!!.compareTo(news1.age)
                    }
                })
            }else {
                Collections.sort(mDataset, object : Comparator<TicketContact> {
                    override fun compare(news1: TicketContact, news2: TicketContact): Int {

                        return news1.age!!.compareTo(news2.age)
                    }
                })
            }
        }
//
//        Collections.sort(mDataset, object : Comparator<TicketContact> {
//            override fun compare(news1: TicketContact, news2: TicketContact): Int {
//
//                return news1.name!!.compareTo(news2.name!!)
//            }
//        })

    }
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_contact, parent, false)
        val dataObjectHolder = DataObjectHolder(view)
        context = parent.context
        return dataObjectHolder
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {


        holder.tv_name.text = mDataset!![position].name + position
        holder.tvAge.text = mDataset!![position].age.toString()
        holder.label_caractere.text = "${mDataset!![position].name.first().toUpperCase()}"
    }

    override fun getItemCount(): Int {
        return mDataset!!.size
    }

    inner class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var label_caractere: TextView
        internal var tv_name: TextView
        internal var tvAge: TextView


        init {
            label_caractere = itemView.findViewById<TextView>(R.id.label_caractere) as TextView
            tv_name = itemView.findViewById<TextView>(R.id.tv_name) as TextView
            tvAge = itemView.findViewById<TextView>(R.id.tvAge) as TextView

        }
    }


}

interface Communication {
    fun listener(position: Int, name: String)
}
