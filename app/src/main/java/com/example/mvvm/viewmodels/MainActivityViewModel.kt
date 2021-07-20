package com.example.mvvm.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.models.NicePlace
import com.example.mvvm.repositories.NicePlaceRepository
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    private var _mNicePlaces = MutableLiveData<List<NicePlace>>()
    val mNicePlaces : LiveData<List<NicePlace>>
    get() = _mNicePlaces
    private var mRepo:NicePlaceRepository = NicePlaceRepository.getInstance()!!

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