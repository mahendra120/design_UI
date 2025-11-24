package com.example.designui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.DesignUITheme
import com.example.designui.ui.theme.Poppins
import com.example.designui.ui.theme.pain

class Polupar_Courses : ComponentActivity() {
    var selectedCategory by mutableStateOf("All")
    var selectedindex by mutableStateOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = { Topbar() }) { innerPadding ->
                Box(
                    modifier = Modifier
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
            val name: String,
            val items: List<String>
        )

        data class DisplayItem(
            val category: String,
            val item: String
        )

        val allList = listOf(
            CourseCategory(
                "3D Design",
                listOf("Graphic Design Advanced", "Advertisement Design")
            ),
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
            allList.first { it.name == selectedCategory }
                .items
                .map { itemName ->
                    DisplayItem(selectedCategory, itemName)
                }
        }
        Column(modifier = Modifier.fillMaxSize()) {
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
                        modifier = Modifier.padding(5.dp),
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
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            color = if (selectedindex == index) Color(
                                255, 255, 255
                            ) else Color.Black
                        )
                    }
                }
            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Topbar() {
        TopAppBar(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255)),
            title = { Text("Popular ", fontFamily = Poppins, fontSize = 24.sp) },
            navigationIcon = {
                IconButton(onClick = { finish() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null, modifier = Modifier.size(30.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = {})
                {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null, modifier = Modifier.size(30.dp)
                    )
                }
            }
        )
    }
}

