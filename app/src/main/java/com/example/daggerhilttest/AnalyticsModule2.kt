package com.example.daggerhilttest

import com.example.daggerhilttest.retrofit.ServiceBuilder
import com.example.daggerhilttest.retrofit.UserService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule2 {

    @Provides
    fun provideAnalyticsService(): UserService{
        return ServiceBuilder.getService("https://jsonplaceholder.typicode.com/", UserService::class.java)
    }
}