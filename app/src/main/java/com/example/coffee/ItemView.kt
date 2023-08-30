package com.example.coffee

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffee.ui.theme.iconColor
import com.example.coffee.ui.theme.textColor
import com.example.coffee.utils.NavigationScreen

@Composable
fun ItemView(
    name: String,
    price: String,
    quality: String,
    image: Int,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .width(125.dp)
            .padding(top = 20.dp)
            .height(216.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Card(
            modifier = Modifier
                .padding(top = 36.dp)
                .width(125.dp)
                .clickable {
//                    val imag1=image
                    Log.d("TAG123", "ItemView: "+image)
                    navController.navigate(NavigationScreen.DetailScreen.route + "/${image}/${name}/${price}")
                }
                .height(180.dp),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(start = 16.dp, top = 63.dp)) {


                    Text(
                        text = name,
                        fontSize = 16.sp,
                        color = textColor,
//                    modifier = Modifier.padding(top = 10.dp)
                    )
                    Text(text = quality, fontSize = 12.sp, color = iconColor)
                    Text(
                        text = price,
                        fontSize = 14.sp,
                        color = textColor,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFF2C217),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(text = "4.5", fontSize = 12.sp, color = textColor)
                        Spacer(modifier = Modifier.width(37.dp))
                        Card(
                            modifier = Modifier
                                .size(40.dp),
                            colors = CardDefaults.cardColors(containerColor = iconColor),
                            shape = RoundedCornerShape(
                                topStart = 24.dp,
                                bottomEnd = 24.dp

                            ),


                            ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }

                        }

                    }


                }

            }
        }
        Image(
            painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )

    }
}

data class ItemViewData(val name: String, val price: String, val quality: String, val img: Int)

fun getItemData(): MutableList<ItemViewData> {
    val list = mutableListOf<ItemViewData>()
    list.add(ItemViewData("Espresso", "$2.50", "with milk", R.drawable.coffe))
    list.add(ItemViewData("Cappucino", "$5.99", "2% milk", R.drawable.cuppucino))
    list.add(ItemViewData("Latte", "$3.20", "with bakery", R.drawable.latte))
    list.add(ItemViewData("Americano", "$7.00", "with whole milk", R.drawable.ammericano))
    list.add(ItemViewData("Espresso", "$2.50", "with milk", R.drawable.coffe))
    list.add(ItemViewData("Cappucino", "$5.99", "2% milk", R.drawable.cuppucino))
    list.add(ItemViewData("Latte", "$3.20", "with bakery", R.drawable.latte))
    list.add(ItemViewData("Americano", "$7.00", "with whole milk", R.drawable.ammericano))
    list.add(ItemViewData("Espresso", "$2.50", "with milk", R.drawable.coffe))
    list.add(ItemViewData("Cappucino", "$5.99", "2% milk", R.drawable.cuppucino))
    list.add(ItemViewData("Latte", "$3.20", "with bakery", R.drawable.latte))
    list.add(ItemViewData("Americano", "$7.00", "with whole milk", R.drawable.ammericano))
    return list
}

@Preview(showSystemUi = true, device = Devices.PIXEL)
@Composable
fun ItemPreview() {
//    ItemView()
}