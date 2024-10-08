package com.example.recipesapp.data.remote.dto

data class RecetasListState(
    val isLoading : Boolean = false,
    val recetas : List<Recetas> = emptyList(),
    val receta : Recetas,
    val categoria : Categorias,
    val categorias: List<Categorias> = emptyList(),
    val error : String = "")