package com.example.designui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font1
import com.example.designui.ui.theme.font2
import com.example.designui.ui.theme.pain

class UserFavoritePage : ComponentActivity() {
    var selectedindex by mutableStateOf(0)
    var selectedCategory by mutableStateOf("All")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                topbar()
            }) { innerPadding ->
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview(showSystemUi = true)
    fun UI() {
        val sheetState = rememberModalBottomSheetState()
        var showSheet by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        var selectedItem by remember { mutableStateOf<DisplayItem?>(null) }


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
        Column(modifier = Modifier.fillMaxSize()) {
            LazyRow {
                itemsIndexed(
                    listOf(
                        "All", "Graphic Design", "3D Design", "Arts & Humanities",
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
                            fontFamily = font2,
                            fontSize = 14.sp,
                            color = if (selectedindex == index) Color(
                                255, 255, 255
                            ) else Color.Black
                        )
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp)
            )
            {
                items(showList) {
                    val items = it
                    Card(
//                        onClick = {
//                            scope.launch {
//                                selectedItem = items          // 👈 save card data here
//                                delay(2000)                   // wait 2 sec
//                                showSheet = true              // open sheet
//                            }
//                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .pointerInput(Unit) {
                                awaitPointerEventScope {
                                    while (true) {
                                        val down = awaitFirstDown()   // finger touched
                                        val start = System.currentTimeMillis()

                                        var released = false

                                        while (!released) {
                                            val event = awaitPointerEvent()

                                            // finger removed
                                            if (event.changes.all { !it.pressed }) {
                                                released = true
                                            }

                                            val holdTime = System.currentTimeMillis() - start

                                            if (holdTime >= 2000 && !released) {
                                                selectedItem = items
                                                showSheet = true
                                                released = true
                                            }
                                        }
                                    }
                                }
                            },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(15.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Box(
                                modifier = Modifier.weight(.4f)
                            ) {
                                Card(
                                    onClick = {
                                    },
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
                                        text = items.category,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = pain,
                                        fontSize = 15.sp,
                                        color = Color(255, 107, 0)
                                    )
                                    Spacer(modifier = Modifier.padding(3.dp))
                                    Text(
                                        text = items.item,
                                        fontFamily = font2,
                                        fontSize = 19.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.padding(3.dp))
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 7.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Text(
                                            "$23",
                                            fontSize = 22.sp,
                                            color = Color(9, 97, 245),
                                            fontWeight = FontWeight.ExtraBold,
                                            fontFamily = font2,
                                            modifier = Modifier.padding(end = 5.dp)
                                        )
                                        Text(
                                            "$42",
                                            fontSize = 18.sp,
                                            color = Color.Gray,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontFamily = font2,
                                            modifier = Modifier.padding(top = 1.dp),
                                            textDecoration = TextDecoration.LineThrough,
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Row {
                                        Text(
                                            "⭐4.8  |  ",
                                            fontSize = 15.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            "7830 Std",
                                            fontFamily = font2,
                                            fontSize = 13.sp,
                                            modifier = Modifier.padding(top = 2.dp),
                                            color = Color(0, 0, 0)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (showSheet && selectedItem != null) {
                RemoveBookmarkBottomSheet(
                    sheetState = sheetState,
                    item = selectedItem!!,
                    onCancel = { showSheet = false },
                    onConfirm = {
                        // remove bookmark action here
                        showSheet = false
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun topbar() {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255)),
            modifier = Modifier.padding(start = 10.dp),
            title = {
                Text(
                    "My Bookmark",
                    fontFamily = font1,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            finish()
                        }
                )
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RemoveBookmarkBottomSheet(
        sheetState: SheetState,
        item: DisplayItem,        // 👈 get selected item here
        onCancel: () -> Unit,
        onConfirm: () -> Unit
    ) {
        ModalBottomSheet(
            onDismissRequest = onCancel,
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Text("Remove From Bookmark?")

                Spacer(Modifier.height(16.dp))

                // Show item data
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier.padding(10.dp)) {

                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Black)
                        )

                        Spacer(Modifier.width(12.dp))

                        Column {
                            Text(item.category, color = Color(0xFFF36F2A))
                            Text(item.item, fontSize = 18.sp)
                            Text("$42", color = Color.Blue)
                        }
                    }
                }
            }
        }
    }
}
