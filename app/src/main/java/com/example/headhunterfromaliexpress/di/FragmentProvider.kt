package com.example.headhunterfromaliexpress.di

import com.example.search.ui.SearchFragment
import com.example.search.ui.SearchListFragment
import com.example.search.ui.VacanciesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun bindSearchListFragment(): SearchListFragment

    @ContributesAndroidInjector
    abstract fun bindVacanciesListFragment(): VacanciesListFragment
}