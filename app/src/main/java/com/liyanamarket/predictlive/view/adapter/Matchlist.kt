package com.liyanamarket.predictlive.view.adapter

import android.annotation.SuppressLint
import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.Match
import com.squareup.picasso.Picasso

class Matchlist(val context:Context,private val list:List<Match>):RecyclerView.Adapter<Matchlist.customviewholder>() {
    inner class customviewholder(itemview:View):RecyclerView.ViewHolder(itemview)
    {
        val status:TextView=itemview.findViewById(R.id.txt_status_predictrecyclerlist)
        val imagehometeam:ImageView=itemview.findViewById(R.id.img_hometeam)
        val imageguestteam:ImageView=itemview.findViewById(R.id.img_guestteam)
        val texthometeamname:TextView=itemview.findViewById(R.id.txt_hometeamname)
        val textguestteamname:TextView=itemview.findViewById(R.id.txt_guestteamname)
        val adminhometeamgol:TextView=itemview.findViewById(R.id.txtadminhomegoal)
        val adminguestteamgol:TextView=itemview.findViewById(R.id.txt_adminguestgol)
        val btn_add:Button=itemview.findViewById(R.id.btn_addpredict)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customviewholder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.predictrecyclerlist,parent,false)
        return customviewholder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: customviewholder, position: Int) {
        if (list[position].status.isEmpty()) {
            holder.status.text = list[position].matchhour
            holder.adminguestteamgol.text="?"
            holder.adminhometeamgol.text="?"
            holder.btn_add.isEnabled=true

        } else {
            if(list[position].status=="end") {
                holder.status.text = list[position].status
                holder.status.setTextColor(context.resources.getColor(R.color.black))
                if(list[position].teamguestgols.toString().isNotEmpty()) {
                    holder.adminguestteamgol.text = list[position].teamguestgols.toString()
                    holder.adminhometeamgol.text = list[position].homegols.toString()
                    holder.btn_add.isEnabled=false

                    holder.btn_add.setBackgroundResource(R.drawable.disablebuttonpredictlist)
                }
            }
            else
            {
                holder.status.setTextColor(context.resources.getColor(R.color.greendark))
                holder.status.text = list[position].status
                if(list[position].teamguestgols.toString().isNotEmpty()) {
                    holder.adminguestteamgol.text = list[position].teamguestgols.toString()
                    holder.adminhometeamgol.text = list[position].homegols.toString()
                    holder.btn_add.isEnabled=false
                    holder.btn_add.text = "Disable"
                    holder.btn_add.setBackgroundResource(R.drawable.disablebuttonpredictlist)
                }

            }
        }
       Picasso.with(context).load(list[position].hometeam[0].logo).into(holder.imagehometeam)
        Picasso.with(context).load(list[position].guestteam[0].logo).into(holder.imageguestteam)
            holder.texthometeamname.text=list[position].hometeam[0].name
        holder.textguestteamname.text=list[position].guestteam[0].name


    }

    override fun getItemCount(): Int {
        return list.size
    }
}