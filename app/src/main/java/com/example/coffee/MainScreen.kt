package com.example.coffee

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.ui.theme.iconColor
import com.example.coffee.ui.theme.textColor
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E8E4))
    ) {
        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    DrawerHeader()

                    DrawerBody(
                        items = listOf(
                            MenuItem(
                                id = "home",
                                title = "Home",
                                contentDescription = "Go to Home",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "order",
                                title = "Order",
                                contentDescription = "Go to Home",
                                icon = Icons.Default.ShoppingCart
                            ),
                            MenuItem(
                                id = "setting",
                                title = "Setting",
                                contentDescription = "Go to Setting",
                                icon = Icons.Default.Settings
                            ),
                        ), onItemClicked = {}
                    )
                }
            },
            content = {
                Scaffold(containerColor = Color(0xFFF5E8E4), topBar = {
                    AppBar {
                        scope.launch { drawerState.isOpen }
                    }
                },
                    bottomBar = { BottomNav() },
                    content = { inner ->
                        Column(modifier = Modifier.padding(inner)) {
                            TextHead()

                            CoffeeListView(navController)
                        }
                    }
                )


            })
    }


}

@Composable
fun CoffeeListView(navController: NavHostController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(horizontal = 34.dp)){
        items(getItemData()) {item->
            ItemView(name = item.name, price = item.price, quality = item.quality, image = item.img,navController)
        }
    }
}

@Composable
fun TextHead() {
    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 25.dp)) {
        Text(text = "Welcome", fontSize = 14.sp, color = iconColor)
        Text(
            text = "Crazy Dev",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(top = 10.dp)
        )

    }
}

