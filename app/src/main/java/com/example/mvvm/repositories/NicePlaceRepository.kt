package com.example.mvvm.repositories

import com.example.mvvm.models.NicePlace
import okhttp3.*
import java.util.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NicePlaceRepository {
    private val url = "https://vnexpress.net/"
    private var dataSet: ArrayList<NicePlace> = ArrayList<NicePlace>()
    private var titles: ArrayList<String> = ArrayList()
    private var links: ArrayList<String> = ArrayList()
    private var client = OkHttpClient()

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
    fun getNicePlaces(): List<NicePlace> {
        setNicePlaces()
        return dataSet
    }
    private fun getTitles(html: String?): ArrayList<String> {
        val doc: Document = Jsoup.parse(html, "utf-8")
        val titles = ArrayList<String>()
        val link: Elements = doc.getElementsByClass("title-news")
        for (e in link) {
            titles.add(e.getElementsByTag("a").attr("title"))
        }
        return titles
    }

    private fun getURL(html: String?): ArrayList<String> {
        val doc: Document = Jsoup.parse(html, "utf-8")
        val links = ArrayList<String>()
        val link: Elements = doc.getElementsByClass("title-news")
        for (e in link) {
            links.add(e.getElementsByTag("a").attr("href"))
        }
        return links
    }

    private fun getRequest():String?
    {

        var result: String? = null
        try {
            // Build request
            val request = Request.Builder().url(url).build()

            // Execute request
            val response = client.newCall(request).execute()
            result = response.body?.string()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }


    private fun setNicePlaces() {

        val result = getRequest()
        titles = getTitles(result)
        links = getURL(result)
        if (result != null) {
            try {
                val size = titles.size - 1
                for (i in 0..size) {
                    val ele = NicePlace(titles[i], links[i])
                    dataSet.add(ele)
                }

            } catch (err: Error) {
                print("Error when parsing JSON: " + err.localizedMessage)
            }
        } else {
            print("Error: Get request returned no response")
        }

    }
}



