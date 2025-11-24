package com.example.designui.UserRegister

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designui.R
import kotlinx.coroutines.delay

class LanchingPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaunchedEffect(Unit) {
                delay(2000)
                val intent = Intent(this@LanchingPage, InteroScreens::class.java)
                startActivity(intent)
            }
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                UI()
            }
        }
    }

    @Composable
    fun UI() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(9, 97, 245)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.group46),
                contentDescription = null,
                modifier = Modifier.size(390.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

