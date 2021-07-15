package com.example.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.NicePlace
import com.example.mvvm.repositories.NicePlaceRepository

class MainActivityViewModel : ViewModel() {
    private var mNicePlaces: MutableLiveData<List<NicePlace>>? = null
    private var mRepo: NicePlaceRepository? = null

    fun initialize() {
        if (mNicePlaces != null) {
            return
        }
        mRepo = NicePlaceRepository.getInstance()
        mNicePlaces = mRepo?.getNicePlaces()
    }



    fun getNicePlaces(): LiveData<List<NicePlace>>? {
        return mNicePlaces
    }

}