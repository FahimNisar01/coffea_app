package com.example.coffee

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.ui.theme.iconColor
import com.example.coffee.ui.theme.textColor
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(200.dp)
            .background(Color(0xFFF5E8E4)),
        contentAlignment = Alignment.Center


    ) {
        Image(
            painterResource(id = R.drawable.header_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(130.dp)
                .clip(shape = CircleShape)
        )
        Text(
            text = "Crazy Dev",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 170.dp),
            color = textColor
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClicked: (MenuItem) -> Unit
) {
    LazyColumn(modifier = Modifier.background(Color.White).fillMaxHeight()) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color.Transparent)
                .clickable { onItemClicked(item) }
                .padding(16.dp))
            {
                Icon(imageVector = item.icon, contentDescription = item.contentDescription, tint = iconColor)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title, modifier = Modifier.weight(1f), color = textColor)

            }
        }
    }
}

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val contentDescription: String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawer() {

}

@Composable
fun AppBar(onNavigationItemClicked: () -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .height(50.dp),


        ) {
        IconButton(onClick = { onNavigationItemClicked }) {
            Icon(painterResource(id = R.drawable.drawe_icon), contentDescription =null ,Modifier.size(24.dp),tint = iconColor)

        }
        Text(
            text = "Star Coffee",
            color = textColor,
            fontSize = 24.sp,
        )
        Icon(painterResource(id = R.drawable.search_icon), contentDescription =null, Modifier.size(24.dp), tint = iconColor )

    }


}