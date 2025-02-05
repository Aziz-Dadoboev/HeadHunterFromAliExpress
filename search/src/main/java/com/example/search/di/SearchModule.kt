package com.example.search.di

import android.content.Context
import com.example.search.repository.SearchRepository
import com.example.search.repository.SearchRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SearchModule {

    @Provides
    @Singleton
    fun provideSearchRepository(context: Context): SearchRepository {
        return SearchRepositoryImpl(context)
    }
}