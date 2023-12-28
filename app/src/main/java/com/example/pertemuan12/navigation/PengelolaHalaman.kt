package com.example.pertemuan12.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pertemuan12.ui.theme.DestinasiHome
import com.example.pertemuan12.ui.theme.HomeScreen
import com.example.pertemuan12.ui.theme.kontak.screen.DestinasiEntry
import com.example.pertemuan12.ui.theme.kontak.screen.EntryKontakScreen

@Composable
fun PengelolaHalaman (navController: NavHostController=rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination=DestinasiHome.route,
        modifier = Modifier,
    ){
        composable(DestinasiHome.route) {
            HomeScreen (navigateToItemEntry = {
                NavController.navigate(DestinasiEntry.route)
            },
                onDetailClick = {
                })
        }
        composable(DestinasiEntry.route){
            EntryKontakScreen(
                navigateBack = {
                    navController.navigate(
                        DestinasiHome.route
                    ){
                        popUpTo(DestinasiHome.route){
                            inclusive = true
                        }
                    }
                })
        }
    }