package com.example.designui

import android.content.Intent
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font2
import com.example.designui.ui.theme.pain

class Polupar_Courses : ComponentActivity() {
    var selectedCategory by mutableStateOf("All")
    var selectedindex by mutableStateOf(0)
    var selectedIndex by mutableStateOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.Companion.fillMaxSize(),
                topBar = { Topbar() },
                bottomBar = { BottomBar() }) { innerPadding ->
                Box(
                    modifier = Modifier.Companion
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(Color(245, 249, 255))
                ) {

                    UI()
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun UI() {
        data class CourseCategory(
            val name: String, val items: List<String>
        )

        data class DisplayItem(
            val category: String, val item: String
        )

        val allList = listOf(
            CourseCategory("3D Design", listOf("Graphic Design Advanced", "Advertisement Design")),
            CourseCategory("Arts & Humanities", listOf("History", "Culture", "Economics")),
            CourseCategory(
                "Graphic Design",
                listOf("Logo Design", "Poster Design", "2D Graphic Design", "3D Graphic Design")
            )
        )
        val showList = if (selectedCategory == "All") {
            allList.flatMap { category ->
                category.items.map { itemName ->
                    DisplayItem(category.name, itemName)
                }
            }
        } else {
            allList.first { it.name == selectedCategory }.items.map { itemName ->
                DisplayItem(selectedCategory, itemName)
            }
        }
        Column(modifier = Modifier.Companion.fillMaxSize()) {
            LazyRow {
                itemsIndexed(
                    listOf(
                        "All", "3D Design", "Arts & Humanities", "Graphic Design"
                    )
                ) { index, category ->
                    Button(
                        onClick = {
                            selectedCategory = category
                            selectedindex = index
                        },
                        modifier = Modifier.Companion.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            if (selectedindex == index) Color(
                                22, 127, 113
                            ) else Color(
                                232, 241, 255
                            )
                        )
                    ) {
                        Text(
                            category,
                            fontFamily = font2,
                            fontSize = 14.sp,
                            color = if (selectedindex == index) Color(
                                255, 255, 255
                            ) else Color.Companion.Black
                        )
                    }
                }
            }
            LazyColumn(
                modifier = Modifier.Companion
                    .fillMaxSize()
                    .padding(start = 5.dp)
            ) {
                items(showList) {
                    val items = it
                    Card(
                        onClick = {
                            val intent = Intent(this@Polupar_Courses, Courses_Detalis::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier.Companion
                            .fillMaxWidth()
                            .height(160.dp)
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(15.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Companion.White)
                    ) {
                        Row(modifier = Modifier.Companion.fillMaxSize()) {
                            Box(
                                modifier = Modifier.Companion.weight(.4f)
                            ) {
                                Card(
                                    modifier = Modifier.Companion.fillMaxSize(),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0, 0, 0)
                                    )
                                ) {

                                }
                            }
                            Box(modifier = Modifier.Companion.weight(.6f)) {
                                Column(
                                    modifier = Modifier.Companion
                                        .fillMaxSize()
                                        .padding(10.dp)
                                ) {
                                    Text(
                                        text = items.category,
                                        fontWeight = FontWeight.Companion.Bold,
                                        fontFamily = pain,
                                        fontSize = 15.sp,
                                        color = Color(255, 107, 0)
                                    )
                                    Spacer(modifier = Modifier.Companion.padding(5.dp))
                                    Text(
                                        text = items.item,
                                        fontFamily = font2,
                                        fontSize = 16.sp,
                                        color = Color.Companion.Black
                                    )
                                    Spacer(modifier = Modifier.Companion.padding(5.dp))
                                    Row(
                                        modifier = Modifier.Companion
                                            .fillMaxWidth()
                                            .padding(start = 15.dp),
                                        verticalAlignment = Alignment.Companion.CenterVertically
                                    ) {
                                        Text(
                                            "$23",
                                            fontSize = 19.sp,
                                            color = Color.Companion.Blue,
                                            fontWeight = FontWeight.Companion.ExtraBold,
                                            fontFamily = font2,
                                            modifier = Modifier.Companion.padding(end = 5.dp)
                                        )
                                        Text(
                                            "$42",
                                            fontSize = 16.sp,
                                            color = Color.Companion.Gray,
                                            fontWeight = FontWeight.Companion.ExtraBold,
                                            fontFamily = font2,
                                            textDecoration = TextDecoration.Companion.LineThrough,
                                        )
                                    }
                                    Spacer(modifier = Modifier.Companion.padding(6.dp))
                                    Row {
                                        Text(
                                            "⭐4.8  |  ",
                                            fontSize = 15.sp,
                                            color = Color.Companion.Black
                                        )
                                        Text(
                                            "7830 Std",
                                            fontFamily = font2,
                                            fontSize = 12.sp,
                                            color = Color(0, 0, 0)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    val image = listOf(
        "HOME" to R.drawable.group_55,
        "INDOX" to R.drawable.group_56,
        "TRANSACTION" to R.drawable.group_57,
        "PROFILE" to R.drawable.group_58,
        "MY COURSES" to R.drawable.group_59
    )

    @Composable
    fun BottomBar() {
        BottomAppBar {
            Row(
                modifier = Modifier.Companion.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Companion.CenterVertically
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
                        horizontalAlignment = Alignment.Companion.CenterHorizontally
                    ) {
                        IconButton(onClick = {
                            selectedIndex = index

                        }) {
                            Image(
                                painter = painterResource(image),
                                contentDescription = null,
                                colorFilter = ColorFilter.Companion.tint(imagecolor),
                                modifier = Modifier.Companion.size(22.dp)
                            )
                        }
                        Text("$name", fontSize = 12.sp, color = textColor)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Topbar() {
        TopAppBar(
            modifier = Modifier.Companion.padding(start = 10.dp, end = 10.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255)),
            title = { Text("Popular ", fontFamily = font2, fontSize = 24.sp) },
            navigationIcon = {
                IconButton(onClick = { finish() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.Companion.size(30.dp)
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
}