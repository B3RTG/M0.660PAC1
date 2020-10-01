package edu.uoc.android.pec1library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import edu.uoc.android.pec1library.fragment.BookDetailFragment
import edu.uoc.android.pec1library.model.BookItem
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {

    private lateinit var currentBook: BookItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportActionBar != null)
            supportActionBar?.hide()

        setContentView(R.layout.activity_book_detail)

        btn_back.setOnClickListener {
            onBackPressed()
        }

        currentBook = BookListActivity.Companion.bookModel.CurrentBook()

        book_detail_title.text = currentBook.tittle

        Log.i("BookDetailActivity" ," Fragment present on view")
        val ft = supportFragmentManager.beginTransaction()
        val fBookFragment = BookDetailFragment(BookListActivity.bookModel.CurrentBook())
        ft.replace(R.id.fl_book_detail, fBookFragment )
        ft.commit()

    }


}