package com.liyanamarket.predictlive.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.Users
import com.liyanamarket.predictlive.presenter.login.Presenter
import com.liyanamarket.predictlive.presenter.login.Senddatatoview
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragmenthome.*
import kotlinx.android.synthetic.main.homesection1.*
import org.koin.android.ext.android.get

class HomeFragment( val activity: AppCompatActivity):Fragment(),Senddatatoview {

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmenthome,container,false)

    }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
             val username=activity.intent.getStringExtra("usernameloginuser").toString()
           activity.name_userprofile.text=activity.intent.getStringExtra("nameuser").toString()
            activity.score_text.text=activity.intent.getIntExtra("scoreloginuser",-1).toString()

val picasso=get<Picasso>()
        picasso.load(activity.intent.getStringExtra("imageloginuser")).into(activity.img_userprofile)
        Presenter(this).getusers("selectuser",username)
            




    }

    override fun onsuccess(user: List<Users>) {
        if(activity.intent.getStringExtra("imageloginuser")!=user[0].image)
        {
           activity.intent.putExtra("imageloginuser",user[0].image)
        }
       val score=activity.intent.getIntExtra("scoreloginuser",-1)
       if(score!=user[0].Score &&score!=-1)
       {
           activity.intent.putExtra("scoreloginuser",user[0].Score)
       }



    }

    override fun onerror(t: Throwable) {
        Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()

    }



}