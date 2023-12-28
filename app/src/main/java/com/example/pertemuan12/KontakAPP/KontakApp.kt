package com.example.pertemuan12.KontakAPP

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan12.R
import com.example.pertemuan12.navigation.PengelolaHalaman
import com.example.pertemuan12.ui.theme.HomeScreen
import com.example.pertemuan12.ui.theme.PenyediaViewModel
import com.example.pertemuan12.ui.theme.home.viewmodel.HomeViewModel
import org.w3c.dom.Text

@Composable
fun KontakApp(
    homeViewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ){
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            PengelolaHalaman()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarKontak(
    title:String,
    canNavigateBack:Boolean,
    modifier:Modifier=Modifier,
    scrollBehavior:TopAppBarScrollBehavior?=null,
    navigateUp:()->Unit={}
){
    CenterAlignedTopAppBar(title={Text (title)}),
    modifier = modifier,
    scrollBehavior = scrollBehavior,
    navigationIcon= {
        if (canNavigateBack){
            IconButton(onClick = navigateUp){
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDesciption=""
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier:Modifier= Modifier){
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text ={
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            }
        },
       modifier = Modifier
    )
}
