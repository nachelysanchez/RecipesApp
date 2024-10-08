package com.example.recipesapp.di

import com.example.recipesapp.data.remote.dto.RecetasApi
import com.example.recipesapp.data.repositorios.RecetasRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMoshi() : Moshi{
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRecetasAPI(moshi: Moshi) : RecetasApi{
        return Retrofit.Builder()
            .baseUrl("https://cocinacreativaapi.onrender.com/API")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RecetasApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecetasRepository(api: RecetasApi) : RecetasRepository{
        return RecetasRepository(api)
    }
}