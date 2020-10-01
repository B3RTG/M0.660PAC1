package edu.uoc.android.pec1library

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.pec1library.adapters.BookAdapter
import edu.uoc.android.pec1library.adapters.BookRecycleViewAdapter
import edu.uoc.android.pec1library.fragment.BookDetailFragment
import edu.uoc.android.pec1library.model.BookItem
import edu.uoc.android.pec1library.model.BookModel
import kotlinx.android.synthetic.main.activity_book_list.*


class BookListActivity : AppCompatActivity() {
    companion object{
        lateinit var bookModel: BookModel
    }
    private val bookList = arrayListOf<BookItem>()
    //private val bookModel = BookModel()

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var haveDetailFragment: Boolean = false
    private var ACTIVITY_TAG = "BookListActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        haveDetailFragment = (fl_book_detail != null)
        bookModel = BookModel()

        viewManager = LinearLayoutManager(this)
        viewAdapter = BookRecycleViewAdapter(bookModel) {

            Log.i("BookListActivity", "Clicked Desc=" + it.tittle.toString())
            Log.i("BookListActivity", "Index:  " + bookModel.currentIndex)

            SetupActivity()

        }
        rvw_books.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        if(haveDetailFragment) {
            SetupActivity()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_list, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemid=item.title.toString()

        when(itemid) {
            getString(R.string.sort_by_author) ->
            {
                Log.d(ACTIVITY_TAG, "Click sort by author")
                bookModel.SortBookItemList("author")
            }
            getString(R.string.sort_by_title)->
            {
                Log.d(ACTIVITY_TAG, "Click sort by Title")
                bookModel.SortBookItemList("title")
            }
        }

        viewAdapter.notifyDataSetChanged()

        return super.onOptionsItemSelected(item)
    }

    private fun SetupActivity()
    {
        if(haveDetailFragment) {
            SetupFrangemtInformation()
        } else {
            StartIntentActivityBookDetail()
        }
    }


    private fun SetupFrangemtInformation()
    {
        Log.i("BookListActivity" ," Fragment present on view")
        val ft = supportFragmentManager.beginTransaction()
        val fBookFragment = BookDetailFragment(bookModel.CurrentBook())
        ft.replace(R.id.fl_book_detail, fBookFragment )
        ft.commit()
    }

    private fun StartIntentActivityBookDetail()
    {
        val intent = Intent(this, BookDetailActivity::class.java)
        intent.apply {
            putExtra("currentBookIndex", bookModel.currentIndex)
        }
        startActivity(intent)
    }

}


