package com.composemovie2.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composemovie2.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {



            }
        }
    }
}


////////////////////////////
////////////Text
@Composable
fun BasicText(name:String){
    Text(
        text = name
    )
}

@Preview(showBackground = true)
@Composable
fun BasicTextPreview(){
    BasicText(name = "Deneme İsim")
}

////////////////////////////
////////////

////////////////////////////
////////////Column
@Composable
fun ColumnExample(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Üstteki yazı"
        )
        Text(
            text = "Alttaki yazı"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview(){
    ColumnExample()
}
////////////////////////////
////////////

////////////////////////////
////////////Row

@Composable
fun RowExample(){
    Row(
        modifier= Modifier.padding(16.dp)
    ) {

        Text("sol")
        Spacer(modifier=Modifier.width(8.dp))// Boşluk
        Text("sağ")
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview(){
    RowExample()
}

////////////////////////////
////////////

////////////////////////////
////////////Box

@Composable
fun BoxExample(){

    Box(modifier= Modifier.size(100.dp)){
        Text("Altta",
            modifier = Modifier.align(Alignment.Center).background(Color.Red)

        )
        Text("Üstte",
            modifier = Modifier.align(Alignment.Center).offset(10.dp,10.dp).background(Color.Cyan)

        )
    }

}

@Composable
@Preview(showBackground = true)
fun BoxPreview(){
    BoxExample()
}

////////////////////////////
////////////

////////////////////////////
////////////Button

@Composable
fun ButtonExample(){

    var countState = remember {
        mutableStateOf(0)
    }

    Button(
        onClick = {
            countState.value++
        }
    ){
        Text("Count value= ${countState.value}")
    }

}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun PreviewButton(){
    ButtonExample()
}
////////////////////////////
////////////

////////////////////////////
////////////remember mutableStateOf

@Composable
fun NameInput(){

    var name by remember { mutableStateOf("") }

    Column{

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Enter your name..")
            }
        )

        Text("Hello, $name")

    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun PreviewNameInput(){
    NameInput()
}
////////////////////////////
////////////

////////////////////////////
////////////State hoisting

@Composable
fun NameInputHoisted(name:String, onNameChange:(String)->Unit){

    Column{
        TextField(
            value = name,
            onValueChange = onNameChange,
            label = {Text("Enter your name..")}
        )
        Text("Hello, $name")
    }
}

@Composable
fun ParentComposable(){
    var name by remember{mutableStateOf("")}

    NameInputHoisted(name, onNameChange = {name=it})
    println(name)
}

@Preview(showBackground = true)
@Composable
fun StateHoistingPreview(){
    ParentComposable()
}
