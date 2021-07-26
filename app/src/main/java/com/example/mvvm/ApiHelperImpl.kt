package com.example.mvvm

import com.example.mvvm.models.NicePlace
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.ArrayList

class ApiHelperImpl:ApiHelper {
    override suspend fun getNicePlaces(): List<NicePlace> {
        val client = OkHttpClient()
        return getNicePlaces(getHTML(client))
    }
    private fun getHTML(client: OkHttpClient):String
    {
        lateinit var result:String
        try {
            // Build request
            val request = Request.Builder().url(BASE_URL).build()

            // Execute request
            val response = client.newCall(request).execute()
            result = response.body!!.string()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }

    private fun getNicePlaces(html:String): ArrayList<NicePlace>
    {
        val doc: Document = Jsoup.parse(html, "utf-8")
        val titles = ArrayList<String>()
        val link: Elements = doc.getElementsByClass("title-news")
        for (e in link) {
            titles.add(e.getElementsByTag("a").attr("title"))
        }

        val links = ArrayList<String>()
        for (e in link) {
            links.add(e.getElementsByTag("a").attr("href"))
        }

        lateinit var dataSet: ArrayList<NicePlace>
        try {
            val size = titles.size - 1
            for (i in 0..size) {
                val ele = NicePlace(titles[i], links[i])
                dataSet.add(ele)
            }

        } catch (err: Error) {
            print("Error when parsing JSON: " + err.localizedMessage)
        }
        return dataSet
    }
}