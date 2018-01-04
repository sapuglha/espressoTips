package com.sapuglha.espressotips

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*
import java.util.*

class ListActivity : AppCompatActivity() {

    private val arrayAdapter: ArrayAdapter<String>
        get() {
            val listItems = ArrayList<String>()
            listItems.add("Item 0")
            listItems.add("Item 1")
            listItems.add("Item 2")
            listItems.add("Item 3")
            listItems.add("Item 4")
            listItems.add("Item 5")
            listItems.add("Item 6")
            listItems.add("Item 7")
            listItems.add("Item 8")
            listItems.add("Item 9")

            return ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        list_activity_listview!!.adapter = arrayAdapter
    }
}
