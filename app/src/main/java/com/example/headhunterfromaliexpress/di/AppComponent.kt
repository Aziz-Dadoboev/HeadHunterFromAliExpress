package com.example.headhunterfromaliexpress.di

import android.app.Application
import com.example.favorites.di.FavoritesModule
import com.example.headhunterfromaliexpress.App
import com.example.search.di.SearchModule
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
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(application: App)
}