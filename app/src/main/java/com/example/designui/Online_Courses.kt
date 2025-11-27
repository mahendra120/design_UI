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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
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
        var results by remember { mutableStateOf(mentorslist) }
        var Serachbar by remember { mutableStateOf("") }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                SimpleSearchBar(
                    Serachbar,
                    onSearch = { query ->
                        results = mentorslist.filter {
                            it.name.contains(query, ignoreCase = true) ||
                                    it.work.contains(query, ignoreCase = true)
                        }
                    },
                    searchResults = results,
                )
                Row(modifier = Modifier.fillMaxWidth())
                {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(.5f)
                            .padding(horizontal = 10.dp)
                    ) {
                        Text("Courses")
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(.5f)
                            .padding(horizontal = 10.dp)
                    ) {
                        Text("Mentors")
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleSearchBar(
        textFieldState: String,
        onSearch: (String) -> Unit,
        searchResults: List<Any>,
        modifier: Modifier = Modifier
    ) {
        var expanded by rememberSaveable { mutableStateOf(false) }
        Box(
            modifier
                .fillMaxWidth()
                .semantics { isTraversalGroup = true }
        ) {
            SearchBar(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .semantics { traversalIndex = 0f },
                colors = SearchBarDefaults.colors(containerColor = Color(255, 255, 255)),
                shape = RoundedCornerShape(15.dp),
                inputField = {
                    SearchBarDefaults.InputField(
                        query = textFieldState,
                        onQueryChange = {

                        },
                        onSearch = {
                            onSearch(textFieldState)
                            expanded = false
                        },
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                expanded = false
                            }) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = null
                                )
                            }
                        },
                        placeholder = { Text("Search", fontFamily = Poppins, fontSize = 19.sp) }
                    )
                },
                expanded = expanded,
                onExpandedChange = { expanded = it },
            ) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    searchResults.forEach { result ->
                        ListItem(
                            headlineContent = { Text(result.toString()) },
                            modifier = Modifier
                                .clickable {
                                }
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
