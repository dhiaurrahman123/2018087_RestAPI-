package com.example.pertemuan12.ui.theme

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan12.ui.theme.home.viewmodel.HomeViewModel


object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel( aplikasiKontak().container.kontakRepository) }
    }
}
fun CreationExtras.aplikasiKontak(): KontakAplikation =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as KontakAplikation)
