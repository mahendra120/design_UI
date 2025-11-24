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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designui.R
import com.example.designui.ui.theme.Poppins
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class SignUpWithGoogle : ComponentActivity() {
    var TAG = "----"
    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                SignUPWithGoogleUI()
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun SignUPWithGoogleUI() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(245, 249, 255)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 250.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    "Let's you in",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 23.sp,
                    fontFamily = Poppins
                )
                Row(
                    modifier = Modifier.padding(top = 40.dp, end = 5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = painterResource(R.drawable.googleicon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .padding(start = 15.dp)
                    )
                    TextButton(onClick = {
                        googleLogin()
                    }) {
                        Text(
                            "Continue with Google",
                            fontWeight = FontWeight.ExtraLight,
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(bottom = 13.dp)
                        )
                    }
                }
                Spacer(Modifier.padding(0.dp))
                Row(
                    modifier = Modifier.padding(top = 0.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = painterResource(R.drawable.applelogo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .padding(end = 10.dp)
                    )
                    Text(
                        "Continue with Apple",
                        fontWeight = FontWeight.ExtraLight,
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(15.dp))
                Text(
                    "( Or )",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(5.dp))
                IconButton(
                    onClick = {
                        val intent = Intent(this@SignUpWithGoogle, UserSignUpPage::class.java)
                        startActivity(intent)
                    }, modifier = Modifier
                        .height(150.dp)
                        .width(350.dp)
                )
                {
                    Image(
                        painter = painterResource(R.drawable.group49),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 15.dp),
                    )
                }
                Text(
                    buildAnnotatedString {
                        append("Don’t have an Account ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Blue,
                                fontFamily = Poppins,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append(" SIGN UP")
                        }
                    }
                )
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

