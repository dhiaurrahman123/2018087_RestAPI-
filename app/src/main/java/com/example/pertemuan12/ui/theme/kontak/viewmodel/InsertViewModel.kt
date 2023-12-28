package com.example.pertemuan12.ui.theme.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan12.model.Kontak
import com.example.pertemuan12.repository.KontakRepository
import kotlinx.coroutines.launch

class InsertViewModel (private val kontakRepository: KontakRepository): ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
    private set
    fun updateInsertKontakState(insertUiEvent: InsertUiEvent){
        insertKontakState= InsertUIState(insertUiEvent = insertUiEvent)
    }
    suspend fun insertKontak(){
        viewModelScope.launch {
            try {
                kontakRepository.insertkontak(insertKontakState.insertUIEvent.toKontak())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}
data class InsertUIState(
    val insertUIEvent: InsertUIEvent = InsertUIEvent()
)
data class InsertUIEvent(
    val id: Int= 0,
    val nama:String="",
    val email: String="",
    val nohp:String=""
)
fun InsertUIEvent.toKontak():Kontak = Kontak(
    id=id,
    nama=nama,
    email=email,
    nohp=nohp,

)
fun Kontak.toUIStateKontak():InsertUIState=InsertUIState(
    insertUIEvent = toInsertUiEvent(),
)
fun Kontak.toInsertUiEvent():InsertUIEvent= InsertUIEvent(
    id = id,
    nama= nama,
    email = email,
    nohp = nohp,
)