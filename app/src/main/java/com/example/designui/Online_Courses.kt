package com.example.designui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font2
import com.example.designui.ui.theme.pain

class Online_Courses : ComponentActivity() {
    var selectedIndex by mutableStateOf(0)
    var selectedColor by mutableStateOf("1")

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { Topbar() },
                bottomBar = { BottomBar() }) { innerPadding ->
                UI()
            }
        }
    }

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

    @Composable
    @Preview(showBackground = true)
    fun UI() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .background(Color(245, 249, 255))
        ) {
            var searchText by remember { mutableStateOf("") }
            var results by remember { mutableStateOf(mentorslist) }
            LaunchedEffect(searchText) {
                results = if (searchText.isBlank()) {
                    mentorslist
                } else {
                    mentorslist.filter {
                        it.name.contains(searchText, ignoreCase = true) ||
                                it.work.contains(searchText, ignoreCase = true)
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp)
            ) {
                item {
                    SimpleSearchBar(
                        searchText = searchText,
                        onSearchTextChange = { newText ->
                            searchText = newText
                        },
                        onSearch = { query ->
                            results = mentorslist.filter {
                                it.name.contains(query, ignoreCase = true) ||
                                        it.work.contains(query, ignoreCase = true)
                            }
                        },
                        searchResults = results,
                    )
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = {
                                selectedColor = 1.toString()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.5f)
                                .height(55.dp)
                                .padding(start = 10.dp, end = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedColor == "1") Color(
                                    22,
                                    127,
                                    113
                                ) else Color(232, 241, 255)
                            )
                        ) {
                            Text(
                                "Courses",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = pain,
                                color = if (selectedColor == "1") Color(253, 253, 253) else Color(
                                    0,
                                    0,
                                    0
                                )
                            )
                        }
                        Button(
                            onClick = {
                                selectedColor = 0.toString()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.5f)
                                .height(55.dp)
                                .padding(start = 10.dp, end = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedColor != "1") Color(
                                    22,
                                    127,
                                    113
                                ) else Color(232, 241, 255)
                            )
                        ) {
                            Text(
                                "Mentors", fontSize = 18.sp,
                                fontWeight = FontWeight.Bold, fontFamily = pain,
                                color = if (selectedColor != "1") Color(252, 252, 252) else Color(
                                    0,
                                    0,
                                    0
                                )
                            )
                        }
                    }
                    Card() {

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
            title = {
                Text(
                    "Online Courses ",
                    fontFamily = font2,
                    fontSize = 24.sp
                )
            },
            navigationIcon = {
                IconButton(onClick = { finish() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(30.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
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
        BottomAppBar(containerColor = Color(245, 249, 255)) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                image.forEachIndexed { index, items ->
                    val name = items.first
                    val imageRes = items.second
                    val isSelected = index == selectedIndex
                    val imagecolor = if (isSelected) Color(22, 127, 113) else Color(0, 0, 0)
                    val textColor = if (isSelected) Color(22, 127, 113) else Color(0, 0, 0)
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = {
                            selectedIndex = index
                        }) {
                            Image(
                                painter = painterResource(imageRes),
                                contentDescription = name,
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleSearchBar(
        searchText: String,
        onSearchTextChange: (String) -> Unit,
        onSearch: (String) -> Unit,
        searchResults: List<Mentor>,
        modifier: Modifier = Modifier
    ) {
        var expanded by remember { mutableStateOf(false) }
        Box(
            modifier
                .fillMaxWidth()
                .semantics { isTraversalGroup = true }
        ) {
            SearchBar(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .align(Alignment.TopCenter)
                    .semantics { traversalIndex = 0f },
                colors = SearchBarDefaults.colors(containerColor = Color(255, 255, 255)),
                shape = RoundedCornerShape(15.dp),
                query = searchText,
                onQueryChange = { query ->
                    onSearchTextChange(query)
                    onSearch(query)
                },
                onSearch = {
                    expanded = false
                    onSearch(it)
                },
                active = expanded,
                onActiveChange = { expanded = it },
                placeholder = {
                    Text(
                        "Search",
                        fontFamily = pain, // Use default or define Poppins
                        fontSize = 19.sp
                    )
                }
            ) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    searchResults.forEach { result ->
                        ListItem(
                            headlineContent = { Text(result.name) },
                            supportingContent = { Text(result.work) },
                            leadingContent = {
                                Image(
                                    painter = painterResource(result.image),
                                    contentDescription = "Mentor image"
                                )
                            },
                            modifier = Modifier
                                .clickable {
                                    expanded = false
                                }
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

