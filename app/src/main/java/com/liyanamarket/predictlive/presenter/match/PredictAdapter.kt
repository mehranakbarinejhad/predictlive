package com.liyanamarket.predictlive.presenter.match

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.Match
import com.liyanamarket.predictlive.dataclass.Predict
import com.liyanamarket.predictlive.presenter.predict.Sendpredictlisttoview
import com.liyanamarket.predictlive.view.thread.predict.ThreadInsertPredictuser
import com.squareup.picasso.Picasso

class PredictAdapter(
    var context: Context,
    var listmatch: List<Match>,
    var predictlist: List<Predict>
) :
    RecyclerView.Adapter<PredictAdapter.CustomViewholder>() {

    inner class CustomViewholder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val textstatus: TextView = itemview.findViewById(R.id.txt_status_predictrecyclerlist)
        val btnadd: Button = itemView.findViewById(R.id.btn_addpredict)
        val edittextuserhometeamgols: EditText = itemview.findViewById(R.id.edt_userhometeamgol)
        val edittextuserguestteamgols: EditText = itemview.findViewById(R.id.edt_userguestteamgol)
        val imagehometeam: ImageView = itemview.findViewById(R.id.img_hometeam)
        val imageguestteam: ImageView = itemview.findViewById(R.id.img_guestteam)
        val texthometeamname: TextView = itemview.findViewById(R.id.txt_hometeamname)
        val textguesteamname: TextView = itemview.findViewById(R.id.txt_guestteamname)
        val textadminhomegols: TextView = itemview.findViewById(R.id.txtadminhomegoal)
        val textadminguestgols: TextView = itemview.findViewById(R.id.txt_adminguestgol)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.predictrecyclerlist, parent, false)
        return CustomViewholder(view)
    }

    override fun onBindViewHolder(holder: CustomViewholder, position: Int) {
        val pref=context.getSharedPreferences("saveusername", Context.MODE_PRIVATE)
        val username=pref.getString("username","").toString()
        if (predictlist.count() == 0) {
            predictlist= listOf(Predict(username,0,0,0,""))
        }

            applymatchtorecycler(
                position,
                holder.textstatus,
                holder.imagehometeam,
                holder.imageguestteam,
                holder.texthometeamname,
                holder.textguesteamname,
                holder.textadminhomegols,
                holder.textadminguestgols
            )
            applyuserpredicttorecycler(
                predictlist,
                position,
                holder.btnadd,
                holder.edittextuserhometeamgols,
                holder.edittextuserguestteamgols
            )
            applubuttoncommand(
                holder.btnadd,
                holder.edittextuserhometeamgols,
                holder.edittextuserguestteamgols,
                predictlist[0].username, position, predictlist
            )


        }


    override fun getItemCount(): Int {
        return listmatch.size
    }

    @SuppressLint("SetTextI18n")


//region Apply Match Details To Recycler Predict
    fun applymatchtorecycler(
        position: Int,
        txtstatus: TextView,
        imagehome: ImageView,
        imageguest: ImageView,
        txthometeamname: TextView,
        txtguestteamname: TextView,
        txtadminhomegols: TextView,
        txtadminguestgolas: TextView

    ) {
        if (listmatch[position].status != "") {
            txtstatus.text = listmatch[position].status
        } else {
            val time = listmatch[position].matchhour
            val hour = time.substring(0, 2)
            val min = time.substring(2, 4)
            txtstatus.text = "$hour:$min"

        }

        Picasso.with(context).load(listmatch[position].hometeam[0].logo).into(imagehome)
        Picasso.with(context).load(listmatch[position].guestteam[0].logo).into(imageguest)
        txthometeamname.text = listmatch[position].hometeam[0].name
        txtguestteamname.text = listmatch[position].guestteam[0].name
        if (listmatch[position].status == "") {
            txtadminhomegols.text = "?"
            txtadminguestgolas.text = "?"
        } else {
            txtadminhomegols.text = listmatch[position].homegols.toString()
            txtadminguestgolas.text = listmatch[position].teamguestgols.toString()
        }


    }
    //endregion

    //region Apply User Predict Details To Recycler Predict
    @SuppressLint("SetTextI18n")
    fun applyuserpredicttorecycler(
        listpredict: List<Predict>,
        position: Int,
        btnok: Button,
        edtuserhometeamgols: EditText,
        edtuserguestteamgols: EditText

    ) {

        var counter = 0

        while (counter < listpredict.count()) {
            if (listpredict[counter].matchid == listmatch[position].matchid) {
                if (listpredict[counter].scorematch != "") {
                    btnok.text = listpredict[counter].scorematch
                    btnok.isEnabled = false
                    when (listpredict[counter].scorematch) {
                        "2" -> {
                            btnok.setBackgroundResource(R.drawable.predictscore2shape)
                        }
                        "5" -> {
                            btnok.setBackgroundResource(R.drawable.predictscore5shape)
                        }
                        "7" -> {
                            btnok.setBackgroundResource(R.drawable.predictscore7shape)
                        }
                        "10" -> {
                            btnok.setBackgroundResource(R.drawable.predictscore10shape)
                        }
                    }


                } else {
                    btnok.text = "Edit"
                    btnok.setBackgroundResource(R.drawable.editbuttnpredictshape)

                }

                edtuserhometeamgols.setText(listpredict[counter].hometeamgols.toString())
                edtuserhometeamgols.isEnabled = false

                edtuserguestteamgols.setText(listpredict[counter].guestteamgols.toString())
                edtuserguestteamgols.isEnabled = false

                return
            }
            counter++
        }
    }
    //endregion

    @SuppressLint("SetTextI18n")
    fun applubuttoncommand(
        btnok: Button,
        edttextuserhomegoals: EditText,
        edttextuserguestgols: EditText,
        username:String,
        position: Int,
        predictlist: List<Predict>
    ) {

        btnok.setOnClickListener {
            if (btnok.text == "Edit") {
                btnok.isEnabled = true
                btnok.text = "Add"
                edttextuserhomegoals.isEnabled=true
                edttextuserguestgols.isEnabled=true
                btnok.setBackgroundResource(R.drawable.predictitembuttonshape)
            }
            else if(btnok.text=="Add")
            {
                if(edttextuserhomegoals.text.isNotEmpty()&&edttextuserguestgols.text.isNotEmpty()) {
                    btnok.isEnabled = true
                    btnok.text = "Edit"
                    edttextuserhomegoals.isEnabled = false
                    edttextuserguestgols.isEnabled = false
                    btnok.setBackgroundResource(R.drawable.editbuttnpredictshape)

                 //  Toast.makeText(context,predictlist[position].matchid.toString(),Toast.LENGTH_LONG).show()
                   ThreadInsertPredictuser(context as AppCompatActivity,username,listmatch[position].matchid.toString().toInt(),edttextuserhomegoals.text.toString().toInt(),edttextuserguestgols.text.toString().toInt()).start()
                }
                else
                {
                    Toast.makeText(context,"Please Enter Goals",Toast.LENGTH_LONG).show()
                }

            }
        }

    }
}