package com.example.android_basics_affirmationsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.android_basics_affirmationsapp.adapter.ItemAdapter
import com.example.android_basics_affirmationsapp.data.DataSource

/*
*   There are a number of pieces involved in creating and using a RecyclerView.
*   You can think of them as a division of labor. The diagram below shows an overview,
*   and you will learn more about each piece as you implement it.
*
*   item - One data item of the list to display. Represents one Affirmation object in your app.
*   Adapter - Takes data and prepares it for RecyclerView to display.
*   ViewHolders - A pool of views for RecyclerView to use and reuse to display affirmations.
*   RecyclerView - Views on screen
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data
        val myDataset = DataSource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this,myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}