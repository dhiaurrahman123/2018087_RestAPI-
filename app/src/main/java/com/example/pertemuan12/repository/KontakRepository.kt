package com.example.pertemuan12.repository

interface KontakRepository{
    suspend fun getKontak():List<Kontak>
}
class NetworkKontakRepository(
    private val kontakApiService: KontakService
): KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}