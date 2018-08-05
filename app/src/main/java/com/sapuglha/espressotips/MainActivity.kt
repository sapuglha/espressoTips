package com.sapuglha.espressotips

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            main_activity_text_output.text = savedInstanceState.getString(CURRENT_TEXT)
        }

        main_activity_button_lower.setOnClickListener { lower() }
        main_activity_button_upper.setOnClickListener { upper() }
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save the user's current game state
        savedInstanceState.putString(CURRENT_TEXT, main_activity_text_output.text.toString())

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState)
    }

    private fun upper() {
        val input = main_activity_text_input.text.toString()
        main_activity_text_output.text = input.toUpperCase()

        Snackbar.make(main_activity_parent_view, "You entered: " + input, Snackbar.LENGTH_LONG).show()
    }

    private fun lower() {
        val input = main_activity_text_input.text.toString()
        main_activity_text_output.text = input.toLowerCase()

        if (main_activity_checkbox_new_window.isChecked) {
            val intent = Intent(this, HelloActivity::class.java)
            intent.putExtra("name", input)

            startActivity(intent)
            //            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        } else {
            Snackbar.make(main_activity_parent_view, "You entered: " + input, Snackbar.LENGTH_LONG).show()
        }
    }

    companion object {
        internal const val CURRENT_TEXT = "current_text"
    }
}
