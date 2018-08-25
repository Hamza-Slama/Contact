package com.example.odc.contactlist

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.v4.content.ContextCompat
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var adpater: TicketAdapter? = null
    var arr = ArrayList<TicketContact>()
    val mContext = this
    var firstPosition = 0
    var firstVisibleCharacter = '#'//35
    //A = 65
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arrCaracter = arrayListOf<TextView>(caracterSharp, caracter_1_A, caracter_2_B, caracter_3_C, caracter_4_D, caracter_5_E, caracter_6_F, caracter_7_G, caracter_8_H, caracter_9_I, caracter_10_J
                , caracter_11_K, caracter_12_L, caracter_13_M, caracter_14_N, caracter_15_O, caracter_16_P, caracter_17_Q, caracter_18_R, caracter_19_S, caracter_20_T, caracter_21_U, caracter_22_V, caracter_23_W, caracter_24_X, caracter_25_Y, caracter_26_Z)

        loadData()

        var communication: Communication = object : Communication {
            override fun listener(position: Int, name: String) {
            }

        }


        var layoutManager = LinearLayoutManager(mContext)
        rec.layoutManager = layoutManager
        adpater = TicketAdapter(arr, 0, true)
        rec.adapter = adpater

        tvAge1.setOnClickListener {
            adpater = TicketAdapter(arr, 10, true)
            adpater!!.notifyDataSetChanged()
            rec.adapter = adpater
        }
        tvAge2.setOnClickListener {
            adpater = TicketAdapter(arr, 20, true)
            adpater!!.notifyDataSetChanged()
            rec.adapter = adpater
        }
        tvAge3.setOnClickListener {
            adpater = TicketAdapter(arr, 30, true)
            adpater!!.notifyDataSetChanged()
            rec.adapter = adpater
        }

        rec.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            @SuppressLint("ResourceAsColor")
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)


                val layoutManager = recyclerView!!.layoutManager as LinearLayoutManager
                val position = layoutManager.findFirstCompletelyVisibleItemPosition()
                val character = arr[position].name.first().toUpperCase()


                if (position >= 0 && position != firstPosition && firstVisibleCharacter != character) {

//                    arrCaracter[character.toInt() -'A'.toInt() +1].setTextColor(ContextCompat.getColor(mContext!!, R.color.black))
//                    arrCaracter[character.toInt() -'A'.toInt() +1].setBackground(ContextCompat.getDrawable(mContext!!, R.drawable.rounded_text_empty))


                    firstPosition = position
                    firstVisibleCharacter = arr[firstPosition].name.first().toUpperCase()
                    Toast.makeText(mContext, "${firstVisibleCharacter.toInt() - 'A'.toInt() + 1}", Toast.LENGTH_LONG).show()
                    arrCaracter[firstVisibleCharacter.toInt() - 'A'.toInt() + 1].setTextColor(ContextCompat.getColor(mContext!!, R.color.white))
                    arrCaracter[firstVisibleCharacter.toInt() - 'A'.toInt() + 1].setBackground(ContextCompat.getDrawable(mContext!!, R.drawable.rounded_text))


                    rln_show.visibility = View.VISIBLE
                    Handler().postDelayed({
                        tv_show.text = firstVisibleCharacter.toString()
                        rln_show.visibility = View.INVISIBLE

                    }, 500)
                }
            }
        })

    }

    private fun loadData() {
        arr.add(TicketContact(1, "Oscar ", "description", 12))
        arr.add(TicketContact(1, "AZERTY ", "description", 12))
        arr.add(TicketContact(1, "Noah", "description", 12))
        arr.add(TicketContact(1, "Noah ", "description", 12))
        arr.add(TicketContact(1, "Noah", "description", 12))
        arr.add(TicketContact(1, "Noah ", "description", 12))
        arr.add(TicketContact(1, "Noah", "description", 12))
//        arr.add(TicketContact(1, "Noah ", "description",12)))
        arr.add(TicketContact(1, "Noah", "description", 12))
        arr.add(TicketContact(1, "Noah ", "description", 45))
        arr.add(TicketContact(1, "Noah", "description", 33))
        arr.add(TicketContact(1, "Noah ", "description", 36))
        arr.add(TicketContact(1, "Noah", "description", 21))
        arr.add(TicketContact(1, "Noah ", "description", 33))
        arr.add(TicketContact(1, "Noah", "description", 46))
        arr.add(TicketContact(1, "Noah ", "description", 66))
        arr.add(TicketContact(1, "Noah", "description", 23))
        arr.add(TicketContact(1, "Noah ", "description", 28))
        arr.add(TicketContact(1, "Noah", "description", 23))
        arr.add(TicketContact(1, "Noah ", "description", 25))

        arr.add(TicketContact(1, "Charlie ", "description", 34))
        arr.add(TicketContact(1, "Hamza ", "description", 45))
        arr.add(TicketContact(1, "Alfie ", "description", 111))
        arr.add(TicketContact(1, "Charlie ", "description", 110))
        arr.add(TicketContact(1, "Charlie ", "description", 2))
        arr.add(TicketContact(1, "Lily ", "description", 11))
        arr.add(TicketContact(1, "Jacob ", "description", 14))
        arr.add(TicketContact(1, "Sophia ", "description", 13))
        arr.add(TicketContact(1, "Sophia ", "description", 2))
        arr.add(TicketContact(1, "Alfie ", "description", 22))
    }
}
