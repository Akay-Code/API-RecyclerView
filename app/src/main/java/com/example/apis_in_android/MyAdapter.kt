package com.example.apis_in_android

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity , val productListArr : List<Product>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    lateinit var myListener : MyClickListener

    interface MyClickListener{
        fun onItemClicking(position: Int)
    }

    fun mySetItemClickListener(listener: MyClickListener){
        myListener = listener
    }

    class MyViewHolder(itemView : View, listener: MyClickListener) : RecyclerView.ViewHolder(itemView) {
        //used to set elements of eachitem
        var title : TextView
        var img : ImageView

        init{
            title = itemView.findViewById(R.id.textView1)
            img = itemView.findViewById(R.id.imageView1)
            itemView.setOnClickListener{
                listener.onItemClicking(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem , parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun getItemCount(): Int {
        return productListArr.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // used to populate data
        val currentItem = productListArr[position]

        holder.title.text = currentItem.title

        //to set title we dont have images in drawable , neither in int form
        // we have images in form URLs , and to use those images we will use Picasso 3rd party extension
        Picasso.get().load(currentItem.thumbnail).into(holder.img)
    }
}