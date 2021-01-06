package com.example.gobishop.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gobishop.R
import com.example.gobishop.activity.AddActivityActivity
import com.example.gobishop.adapter.ActivityAdapter
import com.example.gobishop.entity.BuActivity
import kotlinx.android.synthetic.main.fragment_activity.*

/**
 * Created by Yee on 2020/12/26.
 * Github: Grindewald1900
 * Email: grindewald1504@gmail.com
 */
class ActivityFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var activityAdapter: ActivityAdapter
    companion object{
        fun newInstance(): ActivityFragment{
            return ActivityFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        // Initialize recycle view of activities
        var data: ArrayList<BuActivity> = ArrayList()
        for (i in 0..10){
            val activity: BuActivity = BuActivity("Title test", "2021.09.01  @Oxford", "This is a description of our activity\nThis is a description of our activity", "Released at 7:05PM, Jan 1, 2021 by Grindewald1900 ")
            data.add(activity)
        }
        linearLayoutManager = LinearLayoutManager(context)
        activityAdapter = ActivityAdapter(data)
        rv_activity_main.layoutManager = linearLayoutManager
        rv_activity_main.itemAnimator = DefaultItemAnimator()
        rv_activity_main.adapter = activityAdapter
        rv_activity_main.setOnClickListener {
        }

        btn_activity_add.setOnClickListener {
            val intent = Intent(context, AddActivityActivity::class.java)
            startActivity(intent)
        }

    }
}