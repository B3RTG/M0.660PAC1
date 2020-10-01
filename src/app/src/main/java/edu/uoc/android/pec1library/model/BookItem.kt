package edu.uoc.android.pec1library.model

import java.util.*

class BookItem (bookId: Int, bookTitle: String) {

    val id = bookId
    val tittle = bookTitle
    var author : String = ""
    var description : String = ""
    var imageUrl: String? = ""
    var publishedDate: Date = Date()

    constructor(bookId: Int, bookTitle: String, bookAuthor: String, bookPublishedDate: Date, bookDescription: String, bookImageURL: String? ) : this(bookId, bookTitle) {
        author = bookAuthor
        description = bookDescription
        imageUrl = bookImageURL
        publishedDate=bookPublishedDate
    }



}