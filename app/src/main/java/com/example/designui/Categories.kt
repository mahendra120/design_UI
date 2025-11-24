package com.example.designui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.designui.ui.theme.Poppins

class Categories : ComponentActivity() {
    var Serachbar by mutableStateOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = { Topbar() }) { innerPadding ->
                UI()
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
        )
        {
            val imagelist = listOf(
                R.drawable.image_01,
                R.drawable.image_02,
                R.drawable.image_03,
                R.drawable.image_04,
                R.drawable.image_05,
                R.drawable.image_06,
                R.drawable.image_07,
                R.drawable.image_08,
            )
            val list = listOf(
                "3d Design",
                "Graphic Design",
                "Wed Design",
                "SEO & Marketing",
                "Finance & Accounting"
            )
            Column {
                SimpleSearchBar(
                    Serachbar,
                    { Serachbar = it },
                    list,
                    modifier = Modifier.padding(top = 70.dp)
                )
                Spacer(Modifier.padding(vertical = 20.dp))
                LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
                    items(imagelist) { image ->
                        Log.d("00998", "UI: image$image ")
                        Image(
                            painter = painterResource(image),
                            contentDescription = null,
                            modifier = Modifier
                                .height(140.dp)
                                .padding(15.dp)
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
            title = {
                Text(
                    "All Category",
                    fontSize = 30.sp,
                    fontFamily = Poppins,
                    modifier = Modifier.padding(top = 25.dp, start = 5.dp)
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        finish()
                    },
                    modifier = Modifier.padding(start = 10.dp, top = 30.dp),
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255))
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleSearchBar(
        textFieldState: String,
        onSearch: (String) -> Unit,
        searchResults: List<String>,
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
                            headlineContent = { Text(result) },
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
