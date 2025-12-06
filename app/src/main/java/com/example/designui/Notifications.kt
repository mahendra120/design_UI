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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.ui.theme.font2

class Notifications : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize(), topBar = { topBar() }) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(Color(245, 249, 255))
                ) {
//                    UI()
                }
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun UI() {
        data class notificationdata(
            val name: String,
            val notification: String,
            val day: String,
            val image: Int,
        )

        val notificationlist = listOf(
            notificationdata(
                "New Category Course.!",
                "New the 3D Design Course is Availa..",
                "Today",
                R.drawable.group_86
            ),
            notificationdata(
                "New Category Course.!",
                "New the 3D Design Course is Availa..",
                "Today",
                R.drawable.group_88
            ),
            notificationdata(
                "Today’s Special Offers",
                "You Have made a Coure Payment.",
                "Today",
                R.drawable.group_87
            ),
            notificationdata(
                "Credit Card Connected.!",
                "Credit Card has been Linked.!",
                "yesterday",
                R.drawable.group_88
            ),
            notificationdata(
                "Account Setup Successful.!",
                "Your Account has been Created.",
                "nov 20,2022",
                R.drawable.group_89
            ),
        )

        LazyColumn(modifier = Modifier.fillMaxSize())
        {
            items(notificationlist) {
                val name = it.name
                val notification = it.notification
                val day = it.day
                val image = it.image
                Text(
                    "$day ",
                    fontWeight = FontWeight.Bold,
                    fontFamily = font2,
                    fontSize = 19.sp,
                    modifier = Modifier.padding(start = 15.dp, top = 20.dp)
                )
                notificationCard(name, notification, day, image)
            }
        }

    }

    @Composable
    fun notificationCard(name: String, notification: String, day: String, image: Int) {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color(232, 241, 255))
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.2f)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp),
                        colors = CardDefaults.cardColors(contentColor = Color(255, 255, 255))
                    ) {
                        Log.d("00998877", "notificationCard: $image")
                        Image(
                            painter = painterResource(image),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.7f)
                ) {

                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun topBar() {
        TopAppBar(
            modifier = Modifier.padding(start = 5.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(245, 249, 255)),
            title = {
                Text(
                    "Notifications",
                    fontFamily = font2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(start = 10.dp)
                )
            },
            navigationIcon = {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(26.dp)
                        .clickable {
                            finish()
                        })
            }
        )
    }
}
