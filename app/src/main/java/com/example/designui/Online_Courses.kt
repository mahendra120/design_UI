package com.example.designui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.Poppins

class Online_Courses : ComponentActivity() {
    var selectedIndex by mutableStateOf(0)

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { Topbar() },
                bottomBar = { BottomBar() }) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(245, 249, 255))
                        .padding(innerPadding)
                ) {
                    UI()
                }
            }
        }
    }

    @Composable
    fun UI() {

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Topbar() {
        TopAppBar(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255)),
            title = { Text("Online Courses ", fontFamily = Poppins, fontSize = 24.sp) },
            navigationIcon = {
                IconButton(onClick = { finish() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.Companion.size(30.dp)
                    )
                }
            })
    }
    @Composable
    fun BottomBar() {
        val image = listOf(
            "HOME" to R.drawable.group_55,
            "INDOX" to R.drawable.group_56,
            "TRANSACTION" to R.drawable.group_57,
            "PROFILE" to R.drawable.group_58,
            "MY COURSES" to R.drawable.group_59
        )
        BottomAppBar(containerColor = Color(245, 249, 255)) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                image.forEachIndexed { index, items ->
                    val name = items.first
                    val image = items.second
                    val isSelected = index == selectedIndex
                    val imagecolor = if (isSelected) Color(22, 127, 113) else Color(0, 0, 0)
                    val textColor = if (isSelected) Color(22, 127, 113) else Color(0, 0, 0)
                    Column(
                        modifier = Modifier.Companion,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = {
                            selectedIndex = index
                        }) {
                            Image(
                                painter = painterResource(image),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(imagecolor),
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        Text("$name", fontSize = 12.sp, color = textColor)
                    }
                }
            }
        }
    }
}
