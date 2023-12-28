package com.example.pertemuan12.ui.theme.home.viewmodel

import android.net.http.HttpException
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan12.repository.KontakRepository
import kotlinx.coroutines.launch
import java.io.IOException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.pertemuan12.model.Kontak


sealed class KontakUIState{
    data class Success(val kontak: List<Kontak>) : KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}

class HomeViewModel(private val KontakRepository: KontakRepository): ViewModel() {
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
    init{
        getKontak()
    }
    fun getKontak(){
        viewModelScope.launch{
            kontakUIState= KontakUIState.Loading
            kontakUIState = try{
                KontakUIState.Success(KontakRepository.getKontak())
            } catch (e: IOException){
                KontakUIState.Error
            }catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
}
fun deleteKontak(id:Int){

}