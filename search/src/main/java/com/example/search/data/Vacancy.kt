package com.example.search.data

data class Vacancy(
    val id: String,
    val title: String,
    val company: String,
    val address: Address,
    val experience: Experience,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: Salary?,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

data class Address(val town: String, val street: String, val house: String)
data class Experience(val previewText: String, val text: String)
data class Salary(val full: String?)
