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
        arr.add(TicketContact(1,"Hamza Slama","description"))
        arr.add(TicketContact(1,"Hamza Slama","description"))
        arr.add(TicketContact(1,"Hamza Slama","description"))
        arr.add(TicketContact(1,"Hamza Slama","description"))
        arr.add(TicketContact(2,"Bilel Slama","description"))
        arr.add(TicketContact(2,"Bilel Slama","description"))
        arr.add(TicketContact(2,"Bilel Slama","description"))
        arr.add(TicketContact(3,"islem Slama","description"))
        arr.add(TicketContact(3,"islem Slama","description"))
        arr.add(TicketContact(3,"islem Slama","description"))
        arr.add(TicketContact(4,"Moataz Ben","description"))
        arr.add(TicketContact(5,"zoubair Tourki","description"))
        arr.add(TicketContact(5,"zoubair Tourki","description"))
        arr.add(TicketContact(5,"zoubair Tourki","description"))
        arr.add(TicketContact(5,"zoubair Tourki","description"))
        arr.add(TicketContact(5,"zoubair Tourki","description"))
        arr.add(TicketContact(6,"abrar Abrar","description"))
        arr.add(TicketContact(7,"cheima Elj","description"))
        arr.add(TicketContact(7,"cheima Elj","description"))
        arr.add(TicketContact(7,"cheima Elj","description"))
        arr.add(TicketContact(7,"cheima Elj","description"))
        arr.add(TicketContact(7,"cheima Elj","description"))
        arr.add(TicketContact(7,"cheima Elj","description"))
        arr.add(TicketContact(8,"hamza","description" ))
        arr.add(TicketContact(8,"Riadh ellouze","description" ))
        arr.add(TicketContact(8,"Riadh ellouze","description" ))
        arr.add(TicketContact(8,"Riadh ellouze","description" ))
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
