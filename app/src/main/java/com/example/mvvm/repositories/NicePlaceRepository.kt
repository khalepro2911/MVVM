package com.example.mvvm.repositories

import com.example.mvvm.ApiHelper
import com.example.mvvm.models.NicePlace
import okhttp3.*
import java.util.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NicePlaceRepository(private val apiHelper: ApiHelper) {
    suspend fun getNicePlaces() = apiHelper.getNicePlaces()
}



