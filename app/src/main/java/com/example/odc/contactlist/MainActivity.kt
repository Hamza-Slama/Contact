package com.example.odc.contactlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var adpater: TicketAdapter?=null
    var arr = ArrayList<TicketContact>()
    val mContext = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rln_show.visibility=View.VISIBLE
        Handler().postDelayed({
            rln_show.visibility=View.INVISIBLE

    }, 1000)
        arr.add(TicketContact(1,"\t\n" +
                "Oscar ","description"))
        arr.add(TicketContact(1,"AZERTY ","description"))
        arr.add(TicketContact(1,"Noah","description"))
        arr.add(TicketContact(1,"Noah ","description"))
        arr.add(TicketContact(1,"\t\n" +
                "Oscar ","description"))
        arr.add(TicketContact(1,"Charlie ","description"))
        arr.add(TicketContact(1,"Lily ","description"))
        arr.add(TicketContact(1,"Jacob ","description"))
        arr.add(TicketContact(1,"Sophia ","description"))
        arr.add(TicketContact(1,"Sophia ","description"))
        arr.add(TicketContact(1,"Alfie ","description"))
        arr.add(TicketContact(1,"\t\n" +
                "Oscar ","description"))

        Collections.sort(arr, object : Comparator<TicketContact> {
            override fun compare(news1: TicketContact, news2: TicketContact): Int {

                return news1.name!!.compareTo(news2.name!!)
            }
        })
        var layoutManager = LinearLayoutManager(mContext)
        rec.layoutManager = layoutManager
        adpater = TicketAdapter(arr)
        rec.adapter = adpater


    }
}
