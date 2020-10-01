package edu.uoc.android.pec1library.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import edu.uoc.android.pec1library.R
import edu.uoc.android.pec1library.model.Book
import java.security.AccessControlContext

// class BookAdapter
public class BookAdapter(context: Context, items: List<Book>): ArrayAdapter<Book>(context, 0, items ) {
    var bookList: List<Book> = items

    public override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val rowView = inflater.inflate(R.layout.book_listitem,null,true)

        val txtIdBook = rowView.findViewById<TextView>(R.id.txt_id_book)
        val txtDescriptionBook = rowView.findViewById<TextView>(R.id.txt_book)
        val currentBook = bookList[position]

        txtIdBook.text = currentBook.id.toString()
        txtDescriptionBook.text = currentBook.tittle
        //return super.getView(position, convertView, parent)

        return rowView
    }

}