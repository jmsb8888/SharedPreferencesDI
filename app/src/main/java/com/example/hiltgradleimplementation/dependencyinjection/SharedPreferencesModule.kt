package com.example.hiltgradleimplementation.dependencyinjection

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    fun provideNameSharedPreferences(): String = "shared_prefs"

    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context,
        name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

}