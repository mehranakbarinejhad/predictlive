package com.liyanamarket.predictlive.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.Users
import com.squareup.picasso.Picasso

class Rankinglist(val context:Context,var list: List<Users>):RecyclerView.Adapter<Rankinglist.Customviewholder>() {

    inner class Customviewholder(itemview:View):RecyclerView.ViewHolder(itemview){
        val txtname:TextView = itemview.findViewById(R.id.name_rankingrecyclerlist)
        val txtscore:TextView=itemview.findViewById(R.id.score_recyclerranking)
        val txtrank:TextView=itemview.findViewById(R.id.rank_recyclerranking)
        val img:ImageView=itemview.findViewById(R.id.image_recyclerranking)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Customviewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.rankingrecyclerlist,parent,false)
        return Customviewholder(view)
    }

    override fun onBindViewHolder(holder: Customviewholder, position: Int) {


                holder.txtname.text = list[position].name
                holder.txtscore.text = list[position].Score.toString()
                val rank = position + 4
                holder.txtrank.text = rank.toString()
                Picasso.with(context).load(list[position].image).into(holder.img)


    }

    override fun getItemCount(): Int {
        return list.size
    }
}