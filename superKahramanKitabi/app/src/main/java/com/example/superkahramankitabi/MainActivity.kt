package com.example.superkahramankitabi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Verilerin hazırlanması
        var superKahramanIsimleri = ArrayList<String>()
        superKahramanIsimleri.add("ironman")
        superKahramanIsimleri.add("spiderman")
        superKahramanIsimleri.add("superman")


        //Bitmap ile görsel tanımlamaları - Verimli bir yol değil

        /*val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ironman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.spiderman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.superman)

        var superKahramanGorselleri = ArrayList<Bitmap>()
        superKahramanGorselleri.add(ironmanBitmap)
        superKahramanGorselleri.add(spidermanBitmap)
        superKahramanGorselleri.add(supermanBitmap)
        */

        //verimli görsel tanımlama
        val ironmanDrawableId = R.drawable.ironman
        val supermanDrawableId = R.drawable.superman
        val spidermanDrawableId = R.drawable.spiderman

        var superKahramanDrawableListesi = ArrayList<Int>()
        superKahramanDrawableListesi.add(ironmanDrawableId)
        superKahramanDrawableListesi.add(supermanDrawableId)
        superKahramanDrawableListesi.add(spidermanDrawableId)


        //adapter bağlantısı
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter  = RecyclerAdapter(superKahramanIsimleri,superKahramanDrawableListesi)
        recyclerView.adapter = adapter
    }
}