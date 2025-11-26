package com.example.designui

import android.content.Intent
import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.designui.ui.theme.Poppins
import com.example.designui.ui.theme.pain

class MainActivity : ComponentActivity() {
    var search by mutableStateOf("")
    var colorcheng by mutableStateOf("A")
    var selectedindex by mutableStateOf(0)
    var selectedCategory by mutableStateOf("All")

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { Topbar(scrollBehavior) }) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(Color(245, 249, 255))
                ) {
                    HomePage()
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun HomePage() {
        LazyColumn {
            item {
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
                        listOf(
                            "Logo Design",
                            "Poster Design",
                            "2D Graphic Design",
                            "3D Graphic Design"
                        )
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
                mySearchBar()
                Image(
                    painter = painterResource(R.drawable.group54),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .padding(bottom = 0.dp, start = 20.dp, end = 20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        "Categories",
                        fontFamily = Poppins,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                    TextButton(onClick = {
                        val intent = Intent(this@MainActivity, Categories::class.java)
                        startActivity(intent)
                    }) {
                        Text("See All ", color = Color.Blue, fontFamily = Poppins)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    TextButton(onClick = {
                        colorcheng = "3"
                    }) {
                        Text(
                            "3D Design",
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            color = if (colorcheng == "3") Color.Blue else Color.Black.copy(.5f)
                        )
                    }
                    TextButton(onClick = {
                        colorcheng = "A"
                    }) {
                        Text(
                            "Arts & Humanities",
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            color = if (colorcheng == "A") Color.Blue else Color.Black.copy(.5f)
                        )
                    }
                    TextButton(onClick = {
                        colorcheng = "G"
                    }) {
                        Text(
                            "Graphic Design",
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            color = if (colorcheng == "G") Color.Blue else Color.Black.copy(.5f)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        "Polupar Courses",
                        fontFamily = Poppins,
                        fontSize = 19.sp,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                    TextButton(onClick = {
                        val intent = Intent(this@MainActivity, Polupar_Courses::class.java)
                        startActivity(intent)
                    }, modifier = Modifier.padding(top = 4.dp)) {
                        Text("See All ", color = Color.Blue, fontFamily = Poppins)
                    }
                }
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

                LazyRow(modifier = Modifier.padding(horizontal = 10.dp, vertical = 0.dp)) {
                    itemsIndexed(showList.take(6)) { index, name ->
                        val selectedCategory = name.category
                        val selectedItem = name.item
                        if (index < 5) {
                            Card(
                                onClick = {},
                                modifier = Modifier
                                    .height(230.dp)
                                    .width(280.dp)
                                    .padding(10.dp),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(10.dp),
                            )
                            {
                                Column(modifier = Modifier.fillMaxSize()) {
                                    Box(modifier = Modifier.weight(.5f)) {
                                        Card(
                                            modifier = Modifier.fillMaxSize(),
                                            colors = CardDefaults.cardColors(
                                                containerColor = Color(
                                                    0, 0, 0
                                                )
                                            )
                                        ) {

                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(.5f)
                                            .background(Color.White)
                                    ) {
                                        Column {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 10.dp, vertical = 5.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    "$selectedCategory",
                                                    fontSize = 15.sp,
                                                    color = Color(255, 107, 0),
                                                    modifier = Modifier.padding(
                                                        start = 10.dp,
                                                        top = 5.dp
                                                    )
                                                )
                                                Icon(Icons.Default.Save, contentDescription = null)
                                            }
                                            Text(
                                                "$selectedItem",
                                                fontSize = 18.sp,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(top = 7.dp, start = 10.dp),
                                                textAlign = TextAlign.Start
                                            )
                                            Row(
                                                modifier = Modifier
                                                    .padding(start = 10.dp, top = 10.dp)
                                                    .fillMaxWidth()
                                                    .height(30.dp),
                                                horizontalArrangement = Arrangement.Absolute.Center
                                            ) {
                                                Text(
                                                    "$28  ",
                                                    fontSize = 15.sp,
                                                    color = Color(9, 97, 245)
                                                )
                                                Text(
                                                    "|  ⭐4.8  |  ",
                                                    fontSize = 15.sp,
                                                    color = Color.Black
                                                )
                                                Text(
                                                    "|  1100std  ",
                                                    fontSize = 15.sp,
                                                    color = Color.Black
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            Card(
                                onClick = {},
                                modifier = Modifier
                                    .height(230.dp)
                                    .width(280.dp)
                                    .padding(10.dp),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(10.dp),
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.White.copy(.5f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    TextButton(onClick = {
                                        val intent =
                                            Intent(this@MainActivity, Online_Courses::class.java)
                                        startActivity(intent)
                                    })
                                    {
                                        Text(
                                            "See All",
                                            fontSize = 18.sp,
                                            color = Color.Blue,
                                            fontFamily = pain,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 10.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Text(
                        "Top Mentor",
                        fontSize = 18.sp,
                        fontFamily = Poppins,
                        modifier = Modifier.padding(top = 15.dp, start = 5.dp)
                    )
                    TextButton(onClick = {
                        val intent = Intent(this@MainActivity, MentorsScreen::class.java)
                        startActivity(intent)
                    }) {
                        Text(
                            "See All ",
                            fontSize = 14.sp,
                            fontFamily = Poppins,
                            color = Color.Blue,
                            modifier = Modifier.padding(
                                top = 3.dp
                            )
                        )
                    }
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
                {
                    items(
                        listOf(
                            "Sonja",
                            "jesen",
                            "victori",
                            "Castaldo",
                            "madara uchiha"
                        )
                    ) { name ->
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Card(
                                modifier = Modifier
                                    .height(120.dp)
                                    .width(150.dp)
                                    .padding(10.dp)
                            )
                            {

                            }
                            Spacer(modifier = Modifier.padding(top = 5.dp))
                            Text("$name ", fontFamily = Poppins, fontSize = 17.sp)
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Topbar(scrollBehavior: TopAppBarScrollBehavior) {
        TopAppBar(
            title = { Text("HI") },
            colors = TopAppBarDefaults.topAppBarColors(Color(245, 249, 255)),
            scrollBehavior = scrollBehavior,
        )
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
    @Composable
    fun mySearchBar() {
        var searchQuery by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = { active = false },
            shape = RoundedCornerShape(12.dp),
            active = active,
            onActiveChange = { active = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .border(1.dp, color = Color.Black.copy(.5f), shape = RoundedCornerShape(14.dp))
                .shadow(elevation = 20.dp, shape = RoundedCornerShape(12.dp)),
            windowInsets = WindowInsets(left = 0.dp, right = 0.dp, top = 0.dp, bottom = 0.dp),
            placeholder = { Text("Search", fontFamily = Poppins, fontSize = 20.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = Color(0xFF4F46E5)
                )
            },
            trailingIcon = {
                if (active) IconButton(onClick = {
                    searchQuery = ""
                    active = false
                }) {
                    Icon(imageVector = Icons.Rounded.Close, contentDescription = null)
                }
            },
            colors = SearchBarDefaults.colors(
                containerColor = Color(245, 249, 255)
            ),
            tonalElevation = 0.dp,
        ) {
            LazyColumn {
                item {

                }
            }
        }
    }
}