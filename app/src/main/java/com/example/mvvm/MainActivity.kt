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
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: RecyclerAdapter
    private val mMainActivityViewModel by viewModel<MainActivityViewModel>()
    private val niceListUpdatesObserver = Observer<List<NicePlace>> {
        mNicePlaces ->
        mAdapter = RecyclerAdapter(mNicePlaces,this@MainActivity)
        mRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        mRecyclerView.adapter = mAdapter
        mAdapter = RecyclerAdapter(mNicePlaces,this@MainActivity)
        mAdapter.notifyDataSetChanged()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_view)
        //mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mMainActivityViewModel.mNicePlaces.observe(this,niceListUpdatesObserver)

    }

}


