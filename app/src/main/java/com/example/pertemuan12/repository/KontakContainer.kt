package com.example.pertemuan12.repository

import retrofit2.Retrofit

interface  AppContainer {
    val kontakRepository: KontakRepository
}

class KontakContainer : AppContainer{
    private val baseUrl : "https://kancadonor.net//donorq/"
    private val json = Json{ ignoreUnknownKeys = true}
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(this.baseUrl)
        .build()
}
private val kontakService: KontakService by lazy {

    retrofit.create(KontakService::class.json)
}
private val KontakRepository: KontakRepository by lazy{
    NetworkKontakRepository(kontakService)
}