package com.example.headhunterfromaliexpress.di

import com.example.search.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector
    abstract fun bindSearchFragment(): SearchFragment
}