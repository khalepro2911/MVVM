package com.example.mvvm.repositories

import androidx.lifecycle.MutableLiveData
import com.example.mvvm.models.NicePlace
import java.util.*

class NicePlaceRepository {
    private var dataSet: ArrayList<NicePlace> = ArrayList<NicePlace>()

    companion object{
        private var instance: NicePlaceRepository? = null
        fun getInstance(): NicePlaceRepository? {
            if (instance == null) {
                instance = NicePlaceRepository()
            }
            return instance
        }
    }


    // Pretend to get data from a webservice or online source
    fun getNicePlaces(): MutableLiveData<List<NicePlace>>{
        setNicePlaces()
        val data: MutableLiveData<List<NicePlace>> = MutableLiveData()
        data.value = dataSet
        return data
    }

    private fun setNicePlaces() {
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Havasu Falls"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Trondheim"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Portugal"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Rocky Mountain National Park"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Havasu Falls"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Mahahual"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Frozen Lake"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i1-dulich.vnecdn.net/2019/05/03/1-1556253576-r-1200x0-15568487-4453-6572-1556849014.png?w=1020&h=0&q=100&dpr=1&fit=crop&s=eCojTFGmKk3MrPv3ljS-vQ",
                "Austrailia"
            )
        )
    }


}