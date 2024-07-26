package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloJetpackComposeTheme {
                val name = "SERMAD AHMAD"
                val phoneNumber = 123456789
                Hello(name, phoneNumber)
            }
        }
    }
}
@Composable
fun Hello(name: String, phoneNumber: Int){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(color = Color.Gray)
        ) {
            Spacer(
                modifier = Modifier
                    .padding(32.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.dp),
                contentDescription = "Picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(
                modifier = Modifier
                    .padding(10.dp)
            )
            StyledText(text = name)
            StyledText(text = phoneNumber.toString())
        }

    }

}
@Composable
fun StyledText(text: String){
    Text(
        text = text,
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(3.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloJetpackComposeTheme {
        Hello("SERMAD AHMAD", 123456789)
    }
}