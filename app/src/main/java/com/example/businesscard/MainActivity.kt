package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()

                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column( Modifier.fillMaxWidth()) {


        Row(Modifier.weight(1f)) {
            ViewCardPrincipal(
                title = stringResource(R.string.full_name),
                description = stringResource(R.string.full_post),
                backgroundColor = Color(0xFF00BCD4),
                modifier = Modifier.weight(1f)
            )

        }

        Row(Modifier.weight(1f)) {
            ViewCardSecond(
                title = stringResource(R.string.phone),
                description = stringResource(R.string.red_social),
                email= stringResource(R.string.email_card),
                backgroundColor = Color(0xFF00BCD4) )


        }

    }
}

@Composable
private fun ViewCardPrincipal(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    Column(

        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val image = painterResource(R.drawable.android_logo)
        Box {
            Image(
                painter = image,
                contentDescription = null

            )
        }

        Text(
            text = title,
            modifier = Modifier.padding(bottom = 40.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            modifier = Modifier.padding(bottom = 20.dp),
            fontWeight = FontWeight.Bold
        )



    }
}
@Composable
private fun ViewCardSecond(
    title: String,
    description: String,
    email:String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    Column(

        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = email,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
       BusinessCardApp()
    }
}