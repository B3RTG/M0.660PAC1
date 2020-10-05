package edu.uoc.android.pec1library.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.uoc.android.pec1library.R
import edu.uoc.android.pec1library.model.BookItem
import edu.uoc.android.pec1library.model.BookModel
import kotlinx.android.synthetic.main.fragment_book_detail.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class BookDetailFragment () : Fragment() {

    lateinit var currentBook: BookItem

    constructor(bookItem: BookItem) : this() {
        this.currentBook = bookItem
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_bool_detail_constraint_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dateFormatter = SimpleDateFormat("dd-MM-yyyy")

        txt_author.text = this.currentBook?.author
        txt_publish_date.text = dateFormatter.format(this.currentBook?.publishedDate)
        txt_description.text = this.currentBook?.description

    }
}