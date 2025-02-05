package com.example.search.data

data class Offer(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonInfo?
)

data class ButtonInfo(val text: String)