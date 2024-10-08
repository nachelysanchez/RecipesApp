package com.example.recipesapp.data.remote.dto

data class Preparacion(
    val id : Int,
    val recetaId : Int,
    val pasos : Int,
    val descripcion: String
)