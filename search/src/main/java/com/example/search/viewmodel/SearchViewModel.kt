package com.example.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.search.data.Offer
import com.example.search.data.Vacancy
import com.example.search.repository.SearchRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _vacancies = MutableLiveData<List<Vacancy>>()
    val vacancies: LiveData<List<Vacancy>> = _vacancies

    private val _offers = MutableLiveData<List<Offer>>()
    val offers: LiveData<List<Offer>> = _offers

    suspend fun loadVacancies() {
        _vacancies.value = searchRepository.getVacancies()
    }

    suspend fun loadOffers() {
        _offers.value = searchRepository.getOffers()
    }
}