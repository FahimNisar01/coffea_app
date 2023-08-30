package com.example.coffee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffee.ui.theme.iconColor

@Composable
fun BottomNav() {

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.background(color = Color(0xFFFFFF))
    ) {
        CustomBottomNav()

    }


}

@Composable
fun CustomBottomNav() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .paint(
                painterResource(id = R.drawable.ellipse),
                contentScale = ContentScale.FillHeight
            )
            .padding(start = 20.dp, end = 20.dp,top=20.dp)
    ) {
        listOf(
            Icon(painter = painterResource(id = R.drawable.bag), contentDescription = null, modifier = Modifier.size(24.dp)),
            Icon(painter = painterResource(id = R.drawable.book), contentDescription = null, modifier = Modifier.size(24.dp)),
            Icon(painter = painterResource(id = R.drawable.heart), contentDescription = null, modifier = Modifier.size(24.dp)),
            Icon(painter = painterResource(id = R.drawable.user), contentDescription = null, modifier = Modifier.size(24.dp))
        )
    }
    FloatingActionButton(
        onClick = { },
        elevation = FloatingActionButtonDefaults.elevation(0.dp),
        containerColor = iconColor,
        modifier = Modifier.scale(1.25f)
            .padding(bottom = 50.dp),
        shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
    ) {
        Icon(painterResource(id = R.drawable.home), contentDescription = null, modifier = Modifier.size(24.dp))
    }
}
