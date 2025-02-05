package com.example.search.repository

import com.example.search.data.Offer
import com.example.search.data.Vacancy

interface SearchRepository {
    suspend fun getOffers(): List<Offer>
    suspend fun getVacancies(): List<Vacancy>
}