package com.example.mvvm

import com.example.mvvm.models.NicePlace

interface ApiHelper {
    suspend fun getNicePlaces():List<NicePlace>
}