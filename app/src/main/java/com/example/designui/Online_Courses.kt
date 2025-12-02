package com.example.designui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font1
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
            val scrollState = rememberLazyListState()
            var bottomBarVisible by remember { mutableStateOf(true) }
            LaunchedEffect(scrollState) {
                var lastScrollOffset = 0

                snapshotFlow { scrollState.firstVisibleItemScrollOffset }
                    .collect { currentOffset ->
                        bottomBarVisible = currentOffset <= lastScrollOffset
                        lastScrollOffset = currentOffset
                    }
            }
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { Topbar() },
                bottomBar = {
                    AnimatedVisibility(
                        visible = bottomBarVisible,
                        enter = slideInVertically { it },
                        exit = slideOutVertically { it }
                    ) {
                        BottomBar()
                    }
                }) { innerPadding ->
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
                        it.name.contains(searchText, ignoreCase = true) || it.work.contains(
                            searchText,
                            ignoreCase = true
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp)
            ) {
                SimpleSearchBar(
                    searchText = searchText,
                    onSearchTextChange = { newText ->
                        searchText = newText
                    },
                    onSearch = { query ->
                        results = mentorslist.filter {
                            it.name.contains(
                                query,
                                ignoreCase = true
                            ) || it.work.contains(query, ignoreCase = true)
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
                                22, 127, 113
                            ) else Color(232, 241, 255)
                        )
                    ) {
                        Text(
                            "Courses",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = pain,
                            color = if (selectedColor == "1") Color(253, 253, 253) else Color(
                                0, 0, 0
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
                                22, 127, 113
                            ) else Color(232, 241, 255)
                        )
                    ) {
                        Text(
                            "Mentors",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = pain,
                            color = if (selectedColor != "1") Color(252, 252, 252) else Color(
                                0, 0, 0
                            )
                        )
                    }
                }
                if (selectedColor == "1") {
                    Courses()
                } else {
                    Mentors()
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
                    "Online Courses ", fontFamily = font2, fontSize = 24.sp
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
                .semantics { isTraversalGroup = true }) {
            SearchBar(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .align(Alignment.TopCenter)
                    .semantics { traversalIndex = 0f },
                colors = SearchBarDefaults.colors(containerColor = Color(255, 255, 255)),
                shape = RoundedCornerShape(15.dp),
                query = searchText,
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = {
                        expanded = false
                    })
                    {
                        Icon(Icons.Default.Close, contentDescription = null)
                    }
                },
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
                        "Search... ", fontFamily = pain, // Use default or define Poppins
                        fontSize = 19.sp
                    )
                }) {
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
                                .fillMaxWidth())
                    }
                }
            }
        }
    }
    @Composable
    fun Courses() {
        data class Courses(
            val Categoties: String,
            val courses_name: String,
            val original_price: String,
            val fack_price: String,
            val rating: String,
            val students: String
        )

        val showList = listOf(
            Courses("3D Design", "Graphic Design Advanced", "$23", "$42", "⭐ 4.8", "7830 Std"),
            Courses("3D Design", "3D Modeling", "$35", "$46", "⭐ 4.9", "1100 Std"),
            Courses("3D Design", "3D Animation", "$29", "$49", "⭐ 5.0", "2243 Std"),
            Courses("3D Design", "Architectural Design", "$22", "$44", "⭐ 4.0", "1435 Std"),
            Courses("Programming", "C language", "$17", "$32", "⭐ 4.8", "1992+ Std"),
            Courses("Programming", "C++ language", "$20", "$45", "⭐ 4.3", "2982+ Std"),
            Courses("Programming", "java language", "$22", "$30", "⭐ 4.3", "1111+ Std"),
            Courses("Programming", "C# language", "$20", "$32", "⭐ 2.3", "1000+ Std")
        )

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 5.dp)
            ) {
                items(showList) {
                    val items = it
                    Card(
                        onClick = {
                            val intent = Intent(this@Online_Courses, Courses_Detalis::class.java)
                            intent.putExtra("category", items.Categoties)
                            intent.putExtra("item", items.courses_name)
                            startActivity(intent)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(15.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Box(
                                modifier = Modifier.weight(.4f)
                            ) {
                                Card(
                                    modifier = Modifier.fillMaxSize(),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0, 0, 0)
                                    )
                                ) {

                                }
                            }
                            Box(modifier = Modifier.weight(.6f)) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp)
                                ) {
                                    Text(
                                        text = "${items.Categoties} ",
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = pain,
                                        fontSize = 15.sp,
                                        color = Color(255, 107, 0)
                                    )
                                    Spacer(modifier = Modifier.padding(2.dp))
                                    Text(
                                        text = "${items.courses_name} ",
                                        fontFamily = font1,
                                        fontSize = 18.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.padding(3.dp))
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 5.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            "${items.original_price} ",
                                            fontSize = 20.sp,
                                            color = Color.Blue,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontFamily = font2,
                                            modifier = Modifier
                                        )
                                        Spacer(modifier = Modifier.padding(3.dp))
                                        Text(
                                            "${items.fack_price} ",
                                            fontSize = 18.sp,
                                            color = Color.Gray,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontFamily = font2,
                                            textDecoration = TextDecoration.LineThrough,
                                            modifier = Modifier.padding(top = 0.dp)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 6.dp)
                                    ) {
                                        Text(
                                            "${items.rating} ",
                                            fontSize = 18.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            "${items.students} ",
                                            fontFamily = font1,
                                            fontSize = 15.sp,
                                            modifier = Modifier.padding(top = 0.dp, start = 2.dp),
                                            color = Color(0, 0, 0)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    if (showList.last() == items) {
                        Spacer(modifier = Modifier.padding(bottom = 95.dp))
                    }
                }
            }
        }
    }

    @Composable
    fun Mentors() {
        Box(modifier = Modifier.fillMaxSize()) {
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
                Mentor(R.drawable.madara_uchiha, "madara  uchiha", "genjutsu sensei"),
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
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
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
                                    " $work",
                                    fontSize = 17.sp,
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
                    if (mentorslist.last() == item) {
                        Spacer(modifier = Modifier.padding(bottom = 95.dp))
                    }
                }
            }
        }
    }
}

