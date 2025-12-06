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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font1
import com.example.designui.ui.theme.font2

class Courses_Detalis : ComponentActivity() {
    var selectegcolorBotton by mutableStateOf("1")
    var selectegcard by mutableStateOf(true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(), bottomBar = { }) { innerPadding ->
                UI()
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun UI() {
        val category = intent.getStringExtra("category")
        val item = intent.getStringExtra("item")
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(245, 249, 255))
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(300.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black),
                    ) {
                        IconButton(
                            onClick = { finish() }, colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color(
                                    32, 34, 68
                                )
                            ), modifier = Modifier.size(90.dp)
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(end = 20.dp, top = 5.dp)
                            )
                        }
                    }
                    Card(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(255, 255, 255))
                    ) {
                        Text(
                            " $category",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 25.dp, start = 15.dp),
                            color = Color(
                                255, 107, 0
                            )
                        )
                        Text(
                            "$item",
                            fontSize = 22.sp,
                            fontFamily = font2,
                            modifier = Modifier.padding(top = 15.dp, start = 15.dp),
                            color = Color(
                                0, 0, 0
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, start = 10.dp),
                        ) {
                            Box(
                                Modifier.weight(.7f)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.group_62),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(35.dp)
                                            .padding(start = 15.dp)
                                    )
                                    Spacer(modifier = Modifier.padding(start = 10.dp))
                                    Text("21 Class  |", fontFamily = font2, fontSize = 15.sp)
                                    Icon(
                                        painter = painterResource(R.drawable.group_63),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(34.dp)
                                            .padding(start = 15.dp)
                                    )
                                    Spacer(modifier = Modifier.padding(start = 10.dp))
                                    Text("45 Hours", fontFamily = font2, fontSize = 15.sp)
                                }
                            }
                            Box(
                                Modifier
                                    .padding(top = 5.dp, end = 25.dp)
                                    .weight(.3f),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    "$45",
                                    fontFamily = font2,
                                    fontSize = 23.sp,
                                    modifier = Modifier.padding(bottom = 5.dp),
                                    color = Color.Blue
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp)
                                .height(60.dp)
                        ) {
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
                                    "About",
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
                            ) {
                                Text(
                                    "Curriculcum",
                                    fontSize = 19.sp,
                                    fontFamily = font1,
                                    color = Color(0, 0, 0),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        )
                        if (selectegcard) {
                            Cardabout()
                        } else {
                            CardCurriculum()
                        }
                    }
                    if (selectegcard) {
                        Cardoutvalue()
                    }
                }
            }
        }
    }

    @Composable
    fun Cardabout() {
        Text(
            "Graphic Design now a popular profession graphic design by off your career about tantras regiones barbarous pedibus obiit",
            fontFamily = font1,
            fontSize = 15.sp,
            color = Color(160, 164, 171),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            "Graphic Design n a popular profession l Cur tantas regiones barbarorum pedibus obiit, maria transmi Et ne nimium beatus est; Addidisti ad extremum etiam",
            fontFamily = font1,
            fontSize = 15.sp,
            color = Color(160, 164, 171),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            textAlign = TextAlign.Start
        )
    }

    @Composable
    fun Cardoutvalue() {

        val imagelist = listOf(
            R.drawable.group_64 to "Lessons",
            R.drawable.group_71 to "Access Mobile, Desktop & TV",
            R.drawable.group_66 to "Beginner lever",
            R.drawable.group_72 to "Audio Book",
            R.drawable.group_73 to "Lifetime Access",
            R.drawable.group_74 to "100 Quizzes",
            R.drawable.group_75 to "Certificate of Completion"
        )
        Text(
            "Instructor", fontFamily = font1, fontSize = 26.sp, modifier = Modifier.padding(
                start = 20.dp, top = 15.dp
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(60.dp),
                border = BorderStroke(0.5.dp, Color.Black),
                shape = RoundedCornerShape(50),
            ) {
                Image(
                    painter = painterResource(R.drawable.kakashi_hatake),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "William S. Cunningham",
                    fontSize = 20.sp,
                    fontFamily = font2,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F1330)
                )
                Text(
                    "Graphic Designer",
                    fontSize = 15.sp,
                    fontFamily = font1,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 3.dp)
                )
            }
        }
        Text(
            "What You'll Get",
            fontFamily = font1,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 20.dp, top = 15.dp)
        )
        imagelist.forEach {
            val image = it.first
            val name = it.second
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, top = 15.dp)
            ) {
                Icon(
                    painter = painterResource(image),
                    contentDescription = null,
                    tint = Color(54, 54, 54),
                    modifier = Modifier.size(27.dp)
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(
                    "$name ",
                    fontSize = 16.sp,
                    color = Color(54, 54, 54),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Reviews", fontSize = 21.sp, fontFamily = font1)
            Text("See All", fontSize = 15.sp, fontFamily = font1, color = Color.Blue)
        }
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        )
        data class Reviews(
            val image: Int,
            val name: String,
            val star: String,
            var comment: String,
        )
        val reviews = listOf(
            Reviews(
                R.drawable.kakashi_hatake,
                "Kakashi Hatake",
                "4.5",
                "The Course is Very Good dolor sit amet, consect tur adipiscing elit. Naturales divitias dixit parab les esse, quod parvo"
            ),
            Reviews(
                R.drawable.sasuke_uchiha,
                "Sasuke Uchiha",
                "3.5",
                "The Course is Very Good dolor sit amet, consect tur adipiscing elit. Naturales divitias dixit parab les esse, quod parvo"
            ),
            Reviews(
                R.drawable.madara_uchiha,
                "Madara Uchiha",
                "4.0",
                "The Course is Very Good dolor sit amet, consect tur adipiscing elit. Naturales divitias dixit parab les esse, quod parvo"
            ),
            Reviews(
                R.drawable.geto_wallpaper,
                "Geto ",
                "4.9",
                "The Course is Very Good dolor sit amet, consect tur adipiscing elit. Naturales divitias dixit parab les esse, quod parvo"
            ),
        )
        reviews.forEach {
            val image = it.image
            val name = it.name
            val star = it.star
            val comment = it.comment
            Spacer(Modifier.padding(top = 10.dp, bottom = 10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.2f), contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier.size(50.dp),
                        border = BorderStroke(0.5.dp, Color.Black),
                        shape = RoundedCornerShape(50),
                    ) {
                        Image(
                            painter = painterResource(image),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.8f)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 5.dp),

                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(" $name", fontFamily = font1, fontSize = 22.sp)
                            Card(
                                modifier = Modifier
                                    .height(35.dp)
                                    .width(70.dp),
                                shape = RoundedCornerShape(50),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(
                                        232,
                                        241,
                                        255
                                    )
                                ),
                                border = BorderStroke(2.dp, color = Color(77, 129, 229))
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        "⭐ $star",
                                        fontFamily = font1,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                        Text(
                            " $comment",
                            fontFamily = font1,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            fontSize = 15.sp, color = Color(54, 54, 54)
                        )
                    }
                }
            }
        }
        Mybottombar()
    }

    @Composable
    fun CardCurriculum() {

        data class Curriculum(
            val number: Int,
            val name: String,
            val time: String,
        )

        val curriculumList = listOf(
            Curriculum(1, "Why Using Graphic De..", "15 min"),
            Curriculum(2, "Why Using Graphic De..", "17 min"),
            Curriculum(3, "Why Using Graphic De..", "14 min"),
            Curriculum(4, "Why Using Graphic De..", "10 min"),
        )

        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontFamily = font2,
                            fontSize = 17.sp
                        )
                    ) { append("Section 01 - ") }

                    withStyle(
                        SpanStyle(
                            color = Color.Blue,
                            fontFamily = font2,
                            fontSize = 17.sp
                        )
                    ) { append("Introduction") }
                }
            )

            Text(
                "25 Mins",
                fontSize = 17.sp,
                color = Color.Blue,
                fontFamily = font1
            )
        }

        // List Items
        Column(modifier = Modifier.fillMaxWidth()) {

            curriculumList.forEach { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Number Circle
                    Card(
                        modifier = Modifier.size(50.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(232, 241, 255)),
                        border = BorderStroke(0.5.dp, Color.Black),
                        shape = RoundedCornerShape(40)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.number.toString(),
                                fontFamily = font2,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    // Text Box
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(0.5.dp, Color.Black),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = item.name,
                                fontFamily = font2,
                                fontSize = 16.sp
                            )

                            Text(
                                text = item.time,
                                fontFamily = font1,
                                fontSize = 15.sp,
                                color = Color.Blue
                            )
                        }
                    }
                }
            }
        }
        Mybottombar()
    }

    @Composable
    fun Mybottombar() {
        IconButton(
            onClick = {}, modifier = Modifier
                .fillMaxSize()
                .height(95.dp)
                .padding(horizontal = 5.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.group_76),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
