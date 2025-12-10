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
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font1
import com.example.designui.ui.theme.font2
import com.example.designui.ui.theme.font3

class Mentorsprofile : ComponentActivity() {
    var selectegcolorBotton by mutableStateOf("1")
    var selectegcard by mutableStateOf(true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    UI()
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun UI() {
        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val work = intent.getStringExtra("work")
        Column(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(.45f),
                shadowElevation = 10.dp,
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp, start = 20.dp)
                ) {
                    IconButton(
                        onClick = { finish() }, modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .size(130.dp),
                            border = BorderStroke(.5.dp, color = Color(0, 0, 0)),
                            shape = RoundedCornerShape(120.dp),
                        ) {
                            if (image != null) {
                                Image(
                                    painter = painterResource(image.toInt()),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Image(
                                    painter = painterResource(R.drawable.group54),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Text(
                        "$name",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = font2,
                        color = Color(0, 0, 0),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "$work",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,
                        fontFamily = font1,
                        color = Color(0, 0, 0),
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        toyo(26, "Courses", Modifier.weight(1f))
                        toyo(15800, "Students", Modifier.weight(1f))
                        toyo(8750, "Ratings", Modifier.weight(1f))
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.5f)
                                .height(60.dp)
                                .padding(horizontal = 13.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(
                                    222, 227, 241, 255
                                )
                            ),
                            border = BorderStroke(.5.dp, color = Color(0, 0, 0)),
                        ) {
                            Text(
                                "Follow",
                                fontFamily = font1,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0, 0, 0)
                            )
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(.5f)
                                .height(60.dp)
                                .padding(horizontal = 13.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(
                                    9, 97, 245
                                )
                            ),
                            elevation = ButtonDefaults.buttonElevation(3.dp)
                        ) {
                            Text(
                                "Message",
                                fontFamily = font1,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(255, 255, 255)
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(.55f)
                    .background(Color(245, 249, 255)),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp, vertical = 20.dp),
                    shape = RoundedCornerShape(topStart = 27.dp, topEnd = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(255, 255, 255))
                )
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 9.dp)
                        )
                        Text(
                            "Sed quanta s alias nunc tantum possitne tanta Nec vero sum nescius esse utilitatem in historia non modo voluptatem.",
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp,
                            fontFamily = font3,
                            color = Color(160, 164, 171),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            textAlign = TextAlign.Center
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 7.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 0.dp)
                                .height(60.dp)
                        )
                        {
                            Button(
                                onClick = {
                                    selectegcolorBotton = "1"
                                    selectegcard = true
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(.5f),
                                shape = RectangleShape,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selectegcolorBotton == "1") Color(
                                        232, 241, 255
                                    ) else Color(245, 249, 255)
                                )
                            ) {
                                Text(
                                    "Courses",
                                    fontSize = 19.sp,
                                    fontFamily = font1,
                                    color = Color(0, 0, 0),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Button(
                                onClick = {
                                    selectegcolorBotton = "0"
                                    selectegcard = false
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(.5f),
                                shape = RectangleShape,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selectegcolorBotton != "1") Color(
                                        232, 241, 255
                                    ) else Color(245, 249, 255)
                                )
                            )
                            {
                                Text(
                                    "Ratings",
                                    fontSize = 19.sp,
                                    fontFamily = font1,
                                    color = Color(0, 0, 0),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        if (selectegcolorBotton == "1") {
                            couses()
                        } else {
                            Ratings()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun couses() {
        data class CourseCategory(
            val category: String,
            val name: String,
            val fackprice: String,
            val price: String,
            var rating: String,
            var students: String
        )

        val allList = listOf(
            CourseCategory("3D Design", "Graphic Design Advanced", "42", "29", "4.8", "7830"),
            CourseCategory("3D Design", "Graphic Design Advanced", "42", "29", "4.8", "7830"),
            CourseCategory("3D Design", "Graphic Design Advanced", "42", "29", "4.8", "7830"),
            CourseCategory("3D Design", "Graphic Design Advanced", "42", "29", "4.8", "7830")
        )

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(allList) {
                    val category: String = it.category
                    val name: String = it.name
                    val price: String = it.price
                    val rating: String = it.rating
                    val students: String = it.students
                    val fackprice: String = it.fackprice
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                            .background(Color.Transparent)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 3.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .weight(.3f)
                                    .height(90.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0, 0, 0))
                            )
                            {

                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(.7f)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 12.dp)
                                    )
                                    Text(
                                        "$category ",
                                        color = Color(255, 107, 0),
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                    Spacer(modifier = Modifier.padding(top = 5.dp))
                                    Text(
                                        "$name ",
                                        color = Color.Black,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        maxLines = 1,
                                        fontFamily = font2
                                    )
                                    Spacer(modifier = Modifier.padding(top = 5.dp))
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 5.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    )
                                    {
                                        Text(
                                            "$price", fontSize = 19.sp,
                                            color = Color.Blue,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontFamily = font2,
                                            modifier = Modifier.padding(end = 8.dp)
                                        )
                                        Text(
                                            "$fackprice",
                                            fontSize = 16.sp,
                                            color = Color.Gray,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontFamily = font2,
                                            textDecoration = TextDecoration.LineThrough,
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(top = 5.dp))
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth().padding(bottom = 10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Text(
                                            "⭐$rating",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(end = 10.dp)
                                        )
                                        Text(
                                            " $students Std", fontFamily = font2,
                                            fontSize = 12.sp,
                                            color = Color(0, 0, 0),
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        color = Color.Green,
                        thickness = 0.5.dp
                    )
                }
            }
        }
    }

    @Composable
    fun Ratings() {

    }

    @Composable
    fun toyo(number: Int, text: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "$number",
                fontWeight = FontWeight.Bold,
                fontFamily = font1,
                fontSize = 19.sp,
                modifier = Modifier.padding(top = 5.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                "$text",
                fontFamily = font1,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 5.dp),
                fontSize = 21.sp,
            )
        }
    }
}
