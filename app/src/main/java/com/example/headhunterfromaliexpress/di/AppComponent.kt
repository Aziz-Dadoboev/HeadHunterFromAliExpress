package com.example.headhunterfromaliexpress.di

import android.app.Application
import com.example.favorites.di.FavoritesModule
import com.example.headhunterfromaliexpress.App
import com.example.search.di.SearchModule
import com.example.search.di.ViewModelModule
import com.example.search.ui.SearchFragment
import com.example.search.ui.SearchListFragment
import com.example.search.ui.VacanciesListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        FavoritesModule::class,
        SearchModule::class,
        ViewModelModule::class,
        ActivityBuilder::class,
        FragmentProvider::class
    ]
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(application: App)

    fun inject(searchFragment: SearchFragment)

    fun inject(searchListFragment: SearchListFragment)

    fun inject(vacanciesListFragment: VacanciesListFragment)
}