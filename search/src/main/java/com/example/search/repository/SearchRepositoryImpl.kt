package com.example.search.repository

import android.content.Context
import com.example.search.data.Offer
import com.example.search.data.SearchResponse
import com.example.search.data.Vacancy
import com.google.gson.Gson
import java.io.IOException
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val context: Context
): SearchRepository {

    private fun getMockData(): SearchResponse? {
        val json = loadJsonFromAssets(context, "search_mock.json")
        return Gson().fromJson(json, SearchResponse::class.java)
    }

    private fun loadJsonFromAssets(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getOffers(): List<Offer> {
        val result = getMockData()?.offers
        return result.orEmpty()
    }

    override suspend fun getVacancies(): List<Vacancy> {
        val result = getMockData()?.vacancies
        return result.orEmpty()
    }
}