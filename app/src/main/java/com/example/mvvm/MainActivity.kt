package com.example.mvvm

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.adapters.RecyclerAdapter
import com.example.mvvm.models.NicePlace
import com.example.mvvm.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {



    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerAdapter? = null

    private lateinit var mMainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_view)

        mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mMainActivityViewModel.initialize()

        initRecyclerView()

        mMainActivityViewModel.getNicePlaces()?.observe(this,{
            mAdapter?.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        mAdapter = mMainActivityViewModel.getNicePlaces()?.value?.let { RecyclerAdapter(this, it) }
        val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = linearLayoutManager
        mRecyclerView?.adapter = mAdapter
    }



}