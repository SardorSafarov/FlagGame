package com.example.flaggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {



    lateinit var listSavol: ArrayList<Savol>
    var savolNomeri = 0
    lateinit var textSavol: TextView
    lateinit var textTugri: TextView
    lateinit var textXato: TextView
    lateinit var imgBayroq: ImageView
    lateinit var liner1: LinearLayoutCompat
    lateinit var liner2: LinearLayoutCompat
    lateinit var liner3: LinearLayoutCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listSavol = ArrayList<Savol>(10)
        textSavol = findViewById<TextView>(R.id.text_savol)
        textTugri = findViewById(R.id.text_togri_javob)
        textXato = findViewById(R.id.text_xato_javob)
        imgBayroq = findViewById(R.id.img_bayroq)
        liner1 = findViewById(R.id.linear1)
        liner2 = findViewById(R.id.linear2)
        liner3 = findViewById(R.id.linear3)
        savolQush()
        savolBerish(savolNomeri)

    }

    private fun savolBerish(savolNomeri: Int) {


        textSavol.text = "${savolNomeri + 1} -savol"
        imgBayroq.setImageResource(listSavol[savolNomeri].image)
        var tugriJavob = listSavol[savolNomeri].name
        for (i in 1..tugriJavob.length) {
            var btn = Button(this)
            btn.layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, 1F
            )
            liner1.addView(btn)
        }
        var randomSavol = randomSavol(tugriJavob)

        for (i in 0..8) {
            var btn = Button(this)
            btn.layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, 1F
            )
            btn.text = randomSavol[i].toString()
            liner2.addView(btn)
        }
        for (i in 9..17) {
            var btn = Button(this)
            btn.layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, 1F
            )
            btn.text = randomSavol[i].toString()
            liner3.addView(btn)
        }

    }

    private fun randomSavol(tugriJavob: String): String {
        var s = "qwertyuiopasdfghjklzxcvbnm"
        s = tugriJavob + s.substring(0, 18 - tugriJavob.length)
        var char = s.toCharArray()
        char.shuffle()
        s = ""
        char.forEach {
            s += it
        }
        return s
    }

    fun savolQush() {
        listSavol.add(Savol("filnandiya", R.drawable.img_flag_finlandiya))
        listSavol.add(Savol("uzbekiston", R.drawable.img_flag_uzb))
        listSavol.add(Savol("argentina", R.drawable.img_argentina))
        listSavol.add(Savol("turmaniston", R.drawable.img_turkmaniston))
    }

}