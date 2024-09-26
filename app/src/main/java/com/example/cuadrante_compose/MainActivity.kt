package com.example.cuadrante_compose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.ResourceFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadrante_compose.ui.theme.Cuadrante_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cuadrante_ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        title = stringResource(R.string.text_composable),
                        paragraph = stringResource(R.string.displays),
                        title2 = stringResource(R.string.image_composable),
                        paragraph2 = stringResource(R.string.creates),
                        title3 = stringResource(R.string.row_composable),
                        paragraph3 = stringResource(R.string.a_layout),
                        title4 = stringResource(R.string.column_composable),
                        paragraph4 = stringResource(R.string.that_places),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun GreetingText(title: String, paragraph:String, modifier: Modifier=Modifier ){
    Column(modifier= modifier.fillMaxSize().padding(10.dp), verticalArrangement = Arrangement.Center) {
        Text(text = title, fontWeight= FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))
        Text(text = paragraph, textAlign = TextAlign.Justify)
    }

}
@Composable
fun Greeting(
    title: String, paragraph: String,
    title2:String, paragraph2: String,
    title3:String, paragraph3: String,
    title4:String, paragraph4: String,
    modifier: Modifier = Modifier) {
    val context = colorResource(R.color.purple_200)
    val context2 = colorResource(R.color.purple_500)
    Column(modifier= modifier
        .fillMaxSize()
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            GreetingText(title = title, paragraph = paragraph, modifier = Modifier
                .weight(1f)
                .background(context))
            GreetingText(title = title2, paragraph = paragraph2, modifier = Modifier.weight(1f).background(context2))
        }
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically){
            GreetingText(title = title3, paragraph = paragraph3, modifier = Modifier.weight(1f).background(context2))
            GreetingText(title = title4, paragraph = paragraph4, modifier = Modifier.weight(1f).background(context))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cuadrante_ComposeTheme {
        Greeting(
            title = stringResource(R.string.text_composable),
            paragraph = stringResource(R.string.displays),
            title2 = stringResource(R.string.image_composable),
            paragraph2 = stringResource(R.string.creates),
            title3 = stringResource(R.string.row_composable),
            paragraph3 = stringResource(R.string.a_layout),
            title4 = stringResource(R.string.column_composable),
            paragraph4 = stringResource(R.string.that_places)
            )
    }
}