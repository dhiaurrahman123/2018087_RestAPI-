package com.example.pertemuan12.ui.theme.kontak.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan12.KontakAPP.TopAppBarKontak
import com.example.pertemuan12.navigation.DestinasiNavigasi
import com.example.pertemuan12.ui.theme.PenyediaViewModel
import com.example.pertemuan12.ui.theme.kontak.viewmodel.InsertViewModel
import kotlinx.coroutines.launch




object DestinasiEntry : DestinasiNavigasi {
    override val route = "item entry"
    override val titleRes =  "Entry Siswa"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryKontakScreen(
    navigateBack:()->Unit,
    modifier:Modifier= Modifier,
    viewModel:InsertViewModel=viewModel(factory= PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll (scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBarKontak(
                title = DestinasiEntry.titleRes,
                canNavigateBack = true,
                scrollBehavior= scrollBehavior,
                navigateUp = navigateBack
        }){ innerPadding ->
        EntryKontakBody(
            insertuistate = viewModel.insertKontakState,
            onSiswaValueChange = viewModel::updateInsertKontakState, onSaveClick = {
                coroutineScope.launch {
                    viewModel.insertKontak()
                    navigateBack()
                }
            },
            modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll (rememberScrollState())
                    .fillMaxWidth()

    }
}