package com.example.coffee.utils

sealed class NavigationScreen(val route:String){
    object MainScreen:NavigationScreen("main_screen")
    object DetailScreen:NavigationScreen("detail_screen")
}