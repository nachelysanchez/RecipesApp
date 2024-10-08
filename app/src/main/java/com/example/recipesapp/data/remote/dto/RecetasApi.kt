package com.example.recipesapp.data.remote.dto

import retrofit2.http.GET

interface RecetasApi {
    @GET("/recipes")
    suspend fun getRecetas() : List<Recetas>

    @GET("/category")
    suspend fun  getCategorias() : List<Categorias>

    @GET("/recipes/{id}")
    suspend fun getReceta(id : Int) : Recetas

    @GET("/category/{id}")
    suspend fun getCategoria(id:Int) : Categorias
}