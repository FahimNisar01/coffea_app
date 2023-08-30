package com.example.coffee.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffee.DetailScreen
import com.example.coffee.MainScreen

@Composable
fun StartNavigation() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.MainScreen.route){
        composable(NavigationScreen.MainScreen.route){
            MainScreen(navController)
        }
        composable(NavigationScreen.DetailScreen.route+"/{image}/{name}/{price}"){backStackEntry->
            DetailScreen(backStackEntry,navController)
        }
    }
}