package com.example.hellojetpackcompose


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            HelloJetpackComposeTheme {
                ContactList()
            }
        }
    }
}
@Composable
fun ContactCard(contact: Contact, modifier: Modifier = Modifier){
    val context = LocalContext.current
    val intent = Intent(context, SecondActivity::class.java)
    intent.putExtra("contactId", contact.id)
    Spacer(modifier = Modifier.size(4.dp))
    Row(

        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface, shape = CircleShape)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.DarkGray)
                .border(width = 2.dp, color = Color.Black, shape = CircleShape)
        )
        Column(modifier = Modifier.padding(top = 28.dp, start = 12.dp, end = 4.dp)) {
            Text(
                text = contact.name
            )
            Text(
                text = contact.phoneNumber
            )
        }
        ElevatedButton(
            onClick = {
                context.startActivity(intent)
            },
            modifier = Modifier
                .padding(top = 28.dp, end = 4.dp)
            ) {
            Text(text = "Detail View")

        }

    }
    Spacer(modifier = Modifier.size(4.dp))
}

@Composable
fun ContactList(modifier: Modifier = Modifier){
    LazyColumn {
            items(Contact.contacts) { item ->
                ContactCard(contact = item)
            }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    HelloJetpackComposeTheme {
        ContactList()
    }
}