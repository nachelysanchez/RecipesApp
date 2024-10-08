package com.example.recipesapp.data.repositorios

import com.example.recipesapp.data.remote.dto.Categorias
import com.example.recipesapp.data.remote.dto.Recetas
import com.example.recipesapp.data.remote.dto.RecetasApi
import com.example.recipesapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RecetasRepository @Inject constructor(
    private val api : RecetasApi
) {

    fun getRecetas() : Flow<Resource<List<Recetas>>> = flow {
        try {
            emit(Resource.Loading())

            val recetas = api.getRecetas()

            emit(Resource.Success(recetas))
        }catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    fun getCategorias() : Flow<Resource<List<Categorias>>> = flow {
        try {
            emit(Resource.Loading())

            val categorias = api.getCategorias()

            emit(Resource.Success(categorias))
        }catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    fun getReceta(id : Int) : Flow<Resource<Recetas>> = flow {
        try {
            emit(Resource.Loading())

            val receta = api.getReceta(id)

            emit(Resource.Success(receta))
        }catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    fun getCategoria(id : Int) : Flow<Resource<Categorias>> = flow {
        try {
            emit(Resource.Loading())

            val categoria = api.getCategoria(id)

            emit(Resource.Success(categoria))
        }catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }
}