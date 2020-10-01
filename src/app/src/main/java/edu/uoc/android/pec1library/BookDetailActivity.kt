package edu.uoc.android.pec1library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportActionBar != null)
            supportActionBar?.hide()

        setContentView(R.layout.activity_book_detail)

        //set click to go back to previous activity
        btn_back.setOnClickListener {
            onBackPressed()
        }

    }
}