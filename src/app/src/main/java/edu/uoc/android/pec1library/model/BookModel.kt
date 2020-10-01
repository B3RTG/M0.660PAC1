package edu.uoc.android.pec1library.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class BookModel ()
{
    val bookItemList: MutableList<BookItem> = ArrayList()
    var currentIndex: Int

    init {
        currentIndex = 0
        val book1 = BookItem(0, "Title1", "Author1", Date(), "Description 1", null)
        val book2 = BookItem(1, "Title2", "Author2", Date(), "Description 2", null)
        bookItemList.add(book1)
        bookItemList.add(book2)
    }

    public fun BookCount(): Int {
        return bookItemList.count()
    }

    operator fun get(position: Int): BookItem {
        return bookItemList[position]
    }

    public fun CurrentBook(): BookItem
    {
        return bookItemList[currentIndex]
    }

}