package com.example.search.data

data class SearchResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)