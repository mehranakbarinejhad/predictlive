package com.liyanamarket.predictlive.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.changeprofile
import com.liyanamarket.predictlive.presenter.changeprofile.PresenterChangeProfile
import com.liyanamarket.predictlive.presenter.changeprofile.Sendchangeprofiledatatoview
import com.liyanamarket.predictlive.utils.EncodeAndDecodeImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fregmentsetting.*


@Suppress("DEPRECATION")
class SettingFragment(val activity: AppCompatActivity):Fragment(),Sendchangeprofiledatatoview {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fregmentsetting,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_changeprofile.setOnClickListener {
          val intent=Intent()
            intent.type="image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent,21)



        }



    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==21 && resultCode==-1 && data!=null)
        {
            val pref=activity.getSharedPreferences("saveusername", Context.MODE_PRIVATE)
            val username=pref.getString("username","").toString()
          val path=data.data
            val strimage=EncodeAndDecodeImage().encodeimage(activity,path!!)
            PresenterChangeProfile(this).changeprofile(strimage,username)

        }



    }

    override fun onsuccess(list: List<changeprofile>) {
        Picasso.with(activity).load(list[0].imageurl).into(img_user)
    }

    override fun onerror(t: Throwable) {
        Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()
    }

}