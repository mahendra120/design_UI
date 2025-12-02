package com.example.designui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font2
import com.example.designui.ui.theme.pain

class MentorsScreen : ComponentActivity() {
    var selectedIndex by mutableStateOf(0)
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
                        .padding(innerPadding)
                ) {
                    UI()
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun UI() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(245, 249, 255))
        ) {
            data class Mentor(
                val image: Int,
                val name: String,
                val work: String,
            )

            val mentorslist = listOf(
                Mentor(R.drawable.mentors, "William K. Olivas", "3D Design"),
                Mentor(R.drawable.mentors, "Donald S. Channel", "Arts & Humanities"),
                Mentor(R.drawable.mentors, "Elvira E. Limones", "personal Development"),
                Mentor(R.drawable.mentors, "Scott S, Simpson", "SEC & Marketing"),
                Mentor(R.drawable.mentors, "Patricia G. peters", "office Productivity"),
                Mentor(R.drawable.mentors, "Carmen P. Mercado", "Web Developer"),
                Mentor(R.drawable.kakashi_hatake, "kakashi  Hatake", "ninjutsu sensei"),
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(mentorslist) { item ->
                    val image = item.image
                    val name = item.name
                    val work = item.work
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(.3f)
                                .height(120.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(20.dp),
                                border = BorderStroke(.5.dp, color = Color(0, 0, 0)),
                                shape = RoundedCornerShape(120.dp),
                            ) {
                                Image(
                                    painter = painterResource(image),
                                    contentDescription = null, contentScale = ContentScale.Crop
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(.7f)
                                .height(120.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 30.dp)
                            ) {
                                Text(
                                    " $name",
                                    fontSize = 22.sp,
                                    fontFamily = font2,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Text(
                                    " $work", fontSize = 17.sp,
                                    fontFamily = pain,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp),
                        color = Color(223, 229, 238, 255),
                        thickness = 1.dp
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Topbar() {
        TopAppBar(
            title = { Text("Top Mentors", fontFamily = font2, fontSize = 24.sp) },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255)),
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
                        modifier = Modifier.size(30.dp)
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
        BottomAppBar(
            containerColor = Color(245, 249, 255)
        ) {
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
                        Text(name, fontSize = 12.sp, color = textColor)
                    }
                }
            }
        }
    }
}

