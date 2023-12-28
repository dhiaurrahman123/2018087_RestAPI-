package com.example.pertemuan12.repository

import com.example.pertemuan12.model.Kontak
import com.example.pertemuan12.ui.theme.home.akses.KontakService
import java.io.IOException

interface KontakRepository{
    suspend fun getKontak():List<Kontak>
    suspend fun insertkontak(kontak: Kontak)
    suspend fun updatekontak(Id:Int, kontak: Kontak)
    suspend fun deletekontak(Id: Int)
    suspend fun getkontakById(Id: Int):Kontak
}
class NetworkKontakRepository(
    private val kontakApiService: KontakService
): KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
    override suspend fun insertkontak(kontak: Kontak){
        kontakApiService.insertkontak(kontak)
    }

    override suspend fun updatekontak(Id: Int, kontak: Kontak) {
        kontakApiService.updatekontak(kontak)
    }

    override suspend fun deletekontak(Id: Int) {
        try {
            val response = kontakApiService.deletekontak(id)
            if(!response.isSuccessful){
                throw IOException("Failed to delete kontak. RTP status code:")
                ${response.code()}
            }
            else{
                response.message()
                printIn(response.message())
            }
        }
        catch(e:Exception)
        throw e
    }

    override suspend fun getkontakById(Id: Int): Kontak {
        return kontakApiService.getkontakById(id)
    }
}