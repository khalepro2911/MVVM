package com.example.mvvm.viewmodels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.mvvm.models.NicePlace
import com.example.mvvm.repositories.NicePlaceRepository
import kotlinx.coroutines.*

class MainActivityViewModel(private var mRepo: NicePlaceRepository) : ViewModel() {
    private var _mNicePlaces = MutableLiveData<List<NicePlace>>()
    val mNicePlaces : LiveData<List<NicePlace>>
    get() = _mNicePlaces


    init{
        viewModelScope.launch(Dispatchers.IO){
            try {
                _mNicePlaces.postValue(mRepo.getNicePlaces())

            }
            catch (e: Exception) {
                print(e.message)
            }
        }


    }





}