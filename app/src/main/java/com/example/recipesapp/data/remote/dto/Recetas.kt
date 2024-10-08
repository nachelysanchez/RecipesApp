package com.example.recipesapp.data.remote.dto

data class Recetas(
    val id : Int,
    val categoriaId : Int,
    val dificultadId : Int,
    val nombre : String,
    val rating : Double,
    val diners : Int,
    val preparationTime : String,
    val urlImg : String,
    val numComments : Int,
    val numReviews : Int,
    val ingredientes : Array<String>,
    val preparacions : List<Preparacion>
)

data class Preparacion(
    val id : Int,
    val recetaId : Int,
    val pasos : Int,
    val descripcion: String
)