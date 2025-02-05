package com.example.headhunterfromaliexpress.di

import com.example.headhunterfromaliexpress.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}