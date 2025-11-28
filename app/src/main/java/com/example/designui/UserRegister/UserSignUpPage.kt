package com.example.designui.UserRegister

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.MainActivity
import com.example.designui.R
import com.example.designui.ui.theme.font2
import com.example.designui.ui.theme.pain
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class UserSignUpPage : ComponentActivity() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var TAG = "----"
    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
        ) {
            Column(modifier = Modifier.padding(top = 90.dp)) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(R.drawable.signuplogo),
                        contentDescription = null,
                        modifier = Modifier
                            .height(80.dp)
                            .width(195.dp)
                    )
                }
                Text(
                    "Getting Started.!",
                    fontFamily = pain,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp, start = 25.dp),
                    fontSize = 30.sp
                )
                Text(
                    "Create an Account to Continue your allCourses",
                    fontFamily = font2,
                    color = Color.Black.copy(alpha = 0.5f),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, top = 5.dp)
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = {
                                Text(
                                    "Email",
                                    modifier = Modifier.padding(top = 5.dp),
                                    fontFamily = font2, fontWeight = FontWeight.ExtraBold
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = null
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(65.dp)
                                .padding(horizontal = 30.dp),
                            shape = RoundedCornerShape(15.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                            )
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = {
                                Text(
                                    "Password",
                                    modifier = Modifier.padding(top = 5.dp),
                                    fontFamily = font2, fontWeight = FontWeight.ExtraBold
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = null
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(65.dp)
                                .padding(horizontal = 30.dp),
                            shape = RoundedCornerShape(15.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                            )
                        )
                    }
                }
                Text(
                    "Agree to Terms & Conditions",
                    fontFamily = font2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, top = 30.dp),
                )
                Spacer(modifier = Modifier.padding(20.dp))
                IconButton(
                    onClick = {
                        val intent = Intent(this@UserSignUpPage, MainActivity::class.java)
                        startActivity(intent)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                )
                {
                    Icon(
                        painter = painterResource(R.drawable.group50),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    "Or Continue With",
                    fontFamily = font2,
                    color = Color.Black.copy(alpha = 1f),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth(), textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = {
                        googleLogin()
                    })
                    {
                        Icon(
                            painter = painterResource(R.drawable.googleicon),
                            contentDescription = null, modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(Modifier.padding(horizontal = 20.dp))
                    IconButton(onClick = {})
                    {
                        Icon(
                            painter = painterResource(R.drawable.googleicon),
                            contentDescription = null, modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
                TextButton(onClick = {
                    val intent = Intent(this@UserSignUpPage, UserLoginPage::class.java)
                    startActivity(intent)
                })
                {
                    Text(
                        buildAnnotatedString {
                            append("Already have an Account? ")
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = font2
                                )
                            ) {
                                append("SIGN IN")
                            }
                        },
                        fontFamily = font2,
                        fontSize = 14.sp,
                        color = Color.Black.copy(alpha = .7f),
                        modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                    )
                }
            }
        }
    }


    private fun googleLogin() {
        try {
            // ensure googleSignInClient is initialized (call setupGoogleSignInClient in onCreate)
            if (!::googleSignInClient.isInitialized) setupGoogleSignInClient()
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        } catch (t: Throwable) {
            Log.e(TAG, "googleLoginOldAPI failed: ${t.localizedMessage}\n${t.stackTraceToString()}")
            Toast.makeText(this, "Cannot start Google Sign-In", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupGoogleSignInClient() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // must be WEB client id
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }
}
