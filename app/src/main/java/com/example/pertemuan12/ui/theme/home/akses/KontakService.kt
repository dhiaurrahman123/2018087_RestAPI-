package com.example.pertemuan12.ui.theme.home.akses

import com.example.pertemuan12.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PUT
interface KontakService{
    @Header(
        *Accept:application/json*
    )
    @GET("kontak")
    suspend fun getKontak():List <Kontak>
    @GET("kontak/{id}")
    suspend fun getkontakById(@Path("id")id:Int):Kontak
    @POST("kontak")
    suspend fun insertkontak(@Body kontak: Kontak)
    @PUT("kontak/{id}")
    suspend fun updatekontak(@Path("id")Id:Int, @Body kontak: Kontak)

    @DELETE("kontak/{id}")
    suspend fun deletekontak(@Path("id")Id: Int): Response<Void>
}