package com.example.geeks_for_eeks_news_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class NewsAdapter(val newslist:List<Article>,val context:Context): Adapter<Myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val inflator=LayoutInflater.from(parent.context)
        val view=inflator.inflate(R.layout.news_item,parent,false)
        return Myviewholder(view)
    }

    override fun getItemCount(): Int {
        return newslist.size

    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {


        holder.title.text=newslist[position].title
        holder.description.text=newslist[position].description
        Glide.with(context)
            .load(newslist[position]
                .urlToImage).into(holder.news_imageview)
    }

}

class Myviewholder(itemView: View) : ViewHolder(itemView){

    val news_imageview=itemView.findViewById<ImageView>(R.id.news_imageview)
    val title=itemView.findViewById<TextView>(R.id.title)
    val description=itemView.findViewById<TextView>(R.id.description)


}