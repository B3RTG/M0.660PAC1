package edu.uoc.android.pec1library

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import edu.uoc.android.pec1library.adapters.BookAdapter
import edu.uoc.android.pec1library.fragment.BookDetailFragment
import edu.uoc.android.pec1library.model.Book
import kotlinx.android.synthetic.main.activity_book_list.*


class BookListActivity : AppCompatActivity() {

    private val TAG = "BookListActivity"
    private val bookList = arrayListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        initListviewBooks()

        val haveDetailFragment = fl_book_detail != null

        lvw_books.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            if(haveDetailFragment) {

                Log.i(TAG ,"Book Clicked " + bookList[id.toInt()].tittle + ". Show in detail fragment")

            } else {

                Log.i(TAG ,"Book Clicked " + bookList[id.toInt()].tittle + ". Open activity.")

                val i = Intent(applicationContext, BookDetailActivity::class.java)
                startActivity(i)
            }

        }

        if(haveDetailFragment)
        { //Load fragment
            Log.i( TAG," Fragment present on view")
            val ft = supportFragmentManager.beginTransaction()
            val fBookFragment = BookDetailFragment()
            ft.replace(R.id.fl_book_detail, fBookFragment )
            ft.commit()

        } else
        { //no fragment pressed
            Log.i("BookListActivity" ," No fragment present")
        }
    }

    private fun initListviewBooks()
    {
        //Dynamic creation of book list
        for(i in 1..20 ) {
            //items.add("Item $i")
            bookList.add(Book(i, "Item $i"))
        }

        // Create/set adapter for listview
        val bookAdapter = BookAdapter(this, bookList)
        lvw_books.adapter = bookAdapter
    }

}