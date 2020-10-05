package edu.uoc.android.pec1library.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import edu.uoc.android.pec1library.R
import edu.uoc.android.pec1library.model.BookItem
import edu.uoc.android.pec1library.model.BookModel

class BookRecycleViewAdapter(
    private val isTableDevice: Boolean,
    private val bookModel: BookModel,
    private val listener: (BookItem) -> Unit
) : RecyclerView.Adapter<BookRecycleViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if(viewType == 1) {
            val view= inflater.inflate(R.layout.book_recycleview_even, parent, false)
            ViewHolder(view)
        } else {
            val view= inflater.inflate( R.layout.book_recycleview_odd, parent, false)
            ViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.currentBookItem = bookModel[position]
        holder.tvTitle?.text = holder.currentBookItem.tittle.toString()
        holder.tvAutor?.text = holder.currentBookItem.author


        var imageid = when(holder.currentBookItem.imageUrl) {
            "portada_0" -> R.drawable.portada_0
            "portada_1" -> R.drawable.portada_1
            "portada_2" -> R.drawable.portada_2
            "portada_3" -> R.drawable.portada_3
            "portada_4" -> R.drawable.portada_4
            "portada_5" -> R.drawable.portada_5
            else -> R.drawable.portada_6
        }
        holder.ivBookImage?.setImageResource(imageid)


        holder.itemView.setOnClickListener {
            bookModel.currentIndex = position
            listener(holder.currentBookItem)
        }

    }

    override fun getItemCount(): Int = bookModel.BookCount()

    override fun getItemViewType(position: Int): Int {
        return position % 2 //super.getItemViewType(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var currentBookItem: BookItem
        val tvTitle: TextView? = view.findViewById(R.id.txt_book_title_rv)
        val tvAutor: TextView? = view.findViewById(R.id.txt_book_author_rv)
        val ivBookImage: ImageView? = view.findViewById(R.id.iv_detail_book_image)

        override fun toString(): String {
            return super.toString() + " '" + tvAutor?.text + "'"
        }
    }

}