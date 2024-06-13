package com.dangchph33497.fpoly.tutorkot104khongapi

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dangchph33497.fpoly.tutorkot104khongapi.ui.theme.TutorKot104KhongAPITheme
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.schedule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Chuyển màn hình sau x giây
        var intent = Intent(this,Home::class.java)
        var i = Timer()
        i.schedule(object :TimerTask(){
            override fun run() {
                startActivity(intent)
            }

        },2000)
        setContent {
            Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
                Text(text = "Hello")
                Button(onClick = { var i = Intent(this@MainActivity, Home::class.java)
                    startActivity(i)
                }

                ) {
                    Text(text = "Go To Main")
                }
            }
        }
    }
}

