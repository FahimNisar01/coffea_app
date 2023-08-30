package com.example.coffee

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Upper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.coffee.ui.theme.iconColor
import com.example.coffee.ui.theme.lightTextColor
import com.example.coffee.ui.theme.textColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(backStackEntry: NavBackStackEntry, navController: NavHostController) {
    val name = backStackEntry.arguments?.getString("name")
    val price = backStackEntry.arguments!!.getString("price")
    ModalNavigationDrawer(drawerContent = { /*TODO*/ }, content = {
        Scaffold(topBar = { HeaderUpper(name = name, navController = navController) }, bottomBar = {
            BottomNvi(
                price = price
            )
        }, content = { Content() })
    })
}

@Composable
fun Content() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.latte),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp),
            contentAlignment = Alignment.TopCenter
//                .background(Color(0xFFF5E8E4))

        ) {
            Image(
                painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            ContentInside()
        }

    }
}

@Composable
fun ContentInside() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Ingredients",
            fontSize = 18.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 40.dp)
        )

        Image(
            painterResource(id = R.drawable.milk_quantity),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Coffee Size",
            fontSize = 18.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,
//          modifier = Modifier.padding(top = 20.dp)
        )

        var selectedBoxIndex = remember { mutableStateOf(-1) }

        val boxData = listOf(
            BoxData("Small", 64.dp, 24.dp, 15.dp),
            BoxData("Medium", 80.dp, 35.dp, 15.dp),
            BoxData("Large", 104.dp, 56.dp, 15.dp)
        )

        Row(
            modifier = Modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            boxData.forEachIndexed { index, data ->
                val isSelected = index == selectedBoxIndex.value
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(data.boxSize)
                            .clip(shape = RoundedCornerShape(data.cornerRadius))
                            .background(if (isSelected) iconColor else Color.White)
                            .clickable {
                                if (isSelected) {
                                    selectedBoxIndex.value = -1 // Reset when clicked again
                                } else {
                                    selectedBoxIndex.value = index
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cup),
                            contentDescription = null,
                            modifier = Modifier.size(data.imageSize),
                            tint = if (isSelected) Color.White else iconColor
                        )
                    }
                    Text(
                        text = data.text,
                        fontSize = 14.sp,
                        color = if (isSelected) textColor else lightTextColor,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 20.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun BottomNvi(price: String?) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .paint(
                painterResource(id = R.drawable.ellipse),
                contentScale = ContentScale.FillHeight
            )
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = price.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFFF5E8E4)
        )
        Text(
            text = "Add to cart",
            fontSize = 14.sp,
            color = Color(0xFFF5E8E4),
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun HeaderUpper(name: String?, navController: NavHostController) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painterResource(id = R.drawable.arrow_back),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )
        }


        Text(
            text = name.toString(),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,

            )

        Icon(
            painterResource(id = R.drawable.heart_save),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            tint = Color.White
        )
    }
}

data class BoxData(
    val text: String,
    val boxSize: Dp,
    val imageSize: Dp,
    val cornerRadius: Dp
)