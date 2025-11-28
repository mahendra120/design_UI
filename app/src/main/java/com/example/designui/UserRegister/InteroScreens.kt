package com.example.designui.UserRegister

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.R
import com.example.designui.ui.theme.font2

class InteroScreens : ComponentActivity() {
    var screenNumber by mutableStateOf("1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                when (screenNumber) {
                    "1" -> {
                        intro1()
                    }

                    "2" -> {
                        intro2()
                    }

                    "3" -> {
                        intro3()
                    }
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun intro1() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(245, 249, 255)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(Modifier.padding(bottom = 50.dp)) {
                Text(
                    text = "Online Learning",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = font2,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.padding(8.dp))
                Text(
                    text = "We Provide Classes Online Classes and Pre Recorded Leactures.!",
                    fontSize = 14.sp,
                    fontFamily = font2,
                    color = Color.Black.copy(.7f),
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(vertical = 90.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 20.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.intronumber1),
                        contentDescription = null, modifier = Modifier.size(50.dp)
                    )

                    IconButton(onClick = {
                        screenNumber = "2"
                    }, modifier = Modifier.size(65.dp)) {
                        Image(
                            painter = painterResource(R.drawable.button),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun intro2() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(245, 249, 255)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(Modifier.padding(bottom = 50.dp)) {
                Text(
                    text = "Learn from Anytime",
                    fontSize = 29.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = font2,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.padding(10.dp))
                Text(
                    text = "Booked or Same the Lectures for Future",
                    fontSize = 13.sp,
                    fontFamily = font2,
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.Black.copy(.7f),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(vertical = 90.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 20.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.intronumber2),
                        contentDescription = null, modifier = Modifier.size(50.dp)
                    )
                    IconButton(onClick = {
                        screenNumber = "3"
                    }, modifier = Modifier.size(65.dp)) {
                        Image(
                            painter = painterResource(R.drawable.button),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun intro3() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(245, 249, 255)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column( modifier = Modifier.padding(bottom = 50.dp)){
                Text(
                    text = "Get Online Certificate",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = font2,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.padding(8.dp))
                Text(
                    text = "Analyse your scores and Track your results",
                    fontSize = 14.sp,
                    fontFamily = font2,
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(vertical = 90.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 20.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.intronumber3),
                        contentDescription = null, modifier = Modifier.size(50.dp)
                    )
                    IconButton(onClick = {
                        val intent = Intent(this@InteroScreens, SignUpWithGoogle::class.java)
                        startActivity(intent)
                        finish()
                    }, modifier = Modifier.height(100.dp).width(160.dp)) {
                        Image(
                            painter = painterResource(R.drawable.group48),
                            contentDescription = null, modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}