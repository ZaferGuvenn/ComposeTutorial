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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composemovie2.composetutorial.R // R sınıfını import etmeyi unutmayın!
import com.composemovie2.composetutorial.ui.theme.ComposeTutorialTheme


// Örnek veri sınıfı
data class SampleListItem(val id: Int, val title: String, val color: Color)

// Örnek veri listesi
val sampleLazyListData = List(30) { index ->
    SampleListItem(
        id = index,
        title = "Eleman ${index + 1}",
        color = Color(
            red = (0..255).random(),
            green = (0..255).random(),
            blue = (0..255).random(),
            alpha = 255
        )
    )
}


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
    // Column, içerisindeki composable'ları dikey olarak sıralar.
    // fillMaxSize() modifier'ı, Column'un mevcut tüm alanı kaplamasını sağlar.
    // padding(16.dp) modifier'ı, Column'un içeriğine her yönden 16 dp'lik bir iç boşluk ekler.
    Column(
        modifier = Modifier
            .fillMaxSize() // Bu Column'un tüm ekranı kaplamasını sağlar.
            .background(Color.LightGray) // Arka plan rengini açık gri yaparız ki sınırları görelim.
            .padding(16.dp) // İçerik ile kenarlar arasına 16dp boşluk bırakır.
    ) {
        Text(
            text = "Bu yazı Column içinde üstte yer alır."
            // Text composable'ı metin göstermek için kullanılır.
        )
        Text(
            text = "Bu yazı da Column içinde altta yer alır."
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
////////////fillMaxSize Örneği (Column içinde gösterildi)
// fillMaxSize modifier'ı bir composable'ın ebeveyninden alabileceği maksimum genişlik ve yüksekliği almasını sağlar.
// Yukarıdaki `ColumnExample` içinde `.fillMaxSize()` kullanımı bunun bir örneğidir.
// Aşağıda sadece fillMaxSize'ın etkisini göstermek için basit bir Box örneği ekleyelim.

@Composable
fun FillMaxSizeExample() {
    // Bu Box, ebeveyni olan Preview alanının tamamını kaplayacaktır.
    Box(
        modifier = Modifier
            .fillMaxSize() // Box'ın tüm alanı kaplamasını sağlar.
            .background(Color.Yellow) // Arka planı sarı yaparak kapladığı alanı görselleştiririz.
    ) {
        Text(
            text = "Bu Box tüm alanı kaplar (fillMaxSize)",
            modifier = Modifier.align(Alignment.Center) // Metni Box'ın ortasına hizalar.
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FillMaxSizePreview() {
    FillMaxSizeExample()
}

////////////////////////////
////////////Row

@Composable
fun RowExample(){
    // Row, içerisindeki composable'ları yatay olarak sıralar.
    // padding(16.dp) modifier'ı, Row'un içeriğine her yönden 16 dp'lik bir iç boşluk ekler.
    Row(
        modifier= Modifier
            .background(Color.LightGray) // Arka planı görmek için
            .padding(16.dp) // Dört bir yana 16dp padding.
    ) {
        Text("Soldaki Metin") // Row içindeki ilk eleman.
        // Spacer, elemanlar arasında boşluk oluşturmak için kullanılır.
        // width(8.dp) modifier'ı ile 8dp genişliğinde bir yatay boşluk ekliyoruz.
        Spacer(modifier=Modifier.width(8.dp))
        Text("Sağdaki Metin") // Row içindeki ikinci eleman.
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
//////////// Padding Çeşitleri
// Padding, bir composable'ın içeriği ile sınırları arasına boşluk eklemek için kullanılır.
// Farklı şekillerde padding uygulanabilir.

@Composable
fun PaddingExamples() {
    Column(modifier = Modifier.padding(8.dp)) { // Bu Column'un kendisine dıştan 8dp padding verdik.

        // Örnek 1: Her yöne eşit padding
        Text(
            text = "Her yöne 16dp padding",
            modifier = Modifier
                .background(Color.Yellow)
                .padding(16.dp) // Bu Text'e her yönden 16dp padding uygulanır.
        )

        Spacer(Modifier.size(10.dp)) // Biraz boşluk

        // Örnek 2: Yatay ve dikey farklı padding
        Text(
            text = "Yatay 16dp, Dikey 8dp padding",
            modifier = Modifier
                .background(Color.Cyan)
                .padding(horizontal = 16.dp, vertical = 8.dp)
            // Yatayda (sağ ve sol) 16dp, dikeyde (üst ve alt) 8dp padding.
        )

        Spacer(Modifier.size(10.dp))

        // Örnek 3: Sadece belirli bir yöne padding
        Text(
            text = "Sadece üste 20dp padding",
            modifier = Modifier
                .background(Color.Magenta)
                .padding(top = 20.dp) // Sadece üst tarafa 20dp padding.
        )

        Spacer(Modifier.size(10.dp))

        // Örnek 4: Farklı yönlere farklı padding değerleri
        Text(
            text = "Üst:5, Alt:10, Sol:15, Sağ:20 dp padding",
            modifier = Modifier
                .background(Color.Green)
                .padding(start = 15.dp, top = 5.dp, end = 20.dp, bottom = 10.dp)
            // Başlangıç(sol), üst, bitiş(sağ) ve alt için ayrı ayrı padding değerleri.
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaddingExamplesPreview() {
    PaddingExamples()
}


////////////////////////////
////////////Box

@Composable
fun BoxExample(){
    // Box, çocuklarını üst üste yığabileceğiniz bir layout composable'ıdır.
    // Genellikle diğer composable'ları konumlandırmak veya belirli bir alana arka plan çizmek için kullanılır.
    Box(
        modifier = Modifier
            .size(150.dp) // Box'ın boyutunu 150x150 dp olarak ayarlar.
            .background(Color.LightGray) // Box'ın arka plan rengini açık gri yapar.
            .padding(16.dp) // Box'ın iç kenarlarına 16dp padding ekler.
    ){
        // İlk Text, Box'ın merkezine hizalanır ve kırmızı bir arka plana sahiptir.
        Text("Altta",
            modifier = Modifier
                .align(Alignment.Center) // Bu Text'i Box içinde ortalar.
                .background(Color.Red) // Bu Text'in arka planını kırmızı yapar.
                .padding(4.dp) // Kendi içeriğine padding verir.
        )
        // İkinci Text, Box'ın merkezine hizalanır, ancak biraz ofsetlenir (kaydırılır)
        // ve cyan (turkuaz) bir arka plana sahiptir.
        Text("Üstte",
            modifier = Modifier
                .align(Alignment.Center) // Bu Text'i Box içinde ortalar.
                .offset(x = 20.dp, y = (-20).dp) // x ekseninde 20dp sağa, y ekseninde 20dp yukarı kaydırır.
                .background(Color.Cyan) // Bu Text'in arka planını turkuaz yapar.
                .padding(4.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BoxPreview(){
    BoxExample()
}

////////////////////////////
//////////// Size Modifier Örnekleri

@Composable
fun SizeModifierExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Örnek 1: Kare boyut (genişlik ve yükseklik eşit)
        Box(
            modifier = Modifier
                .size(100.dp) // Genişlik ve yüksekliği 100dp olarak ayarlar.
                .background(Color.Blue)
        ) {
            Text("100x100 dp", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }

        Spacer(Modifier.size(16.dp))

        // Örnek 2: Farklı genişlik ve yükseklik
        Box(
            modifier = Modifier
                .size(width = 150.dp, height = 70.dp) // Genişlik 150dp, yükseklik 70dp.
                .background(Color.Green)
        ) {
            Text("150x70 dp", color = Color.Black, modifier = Modifier.align(Alignment.Center))
        }

        Spacer(Modifier.size(16.dp))

        // Örnek 3: fillMaxWidth ile genişliği doldurma, sabit yükseklik
        Box(
            modifier = Modifier
                .fillMaxSize() // Mevcut maksimum genişliği alır.
                .size(height = 50.dp) // Yüksekliği 50dp ile sınırlar. Bu satır fillMaxSize'dan sonra gelmeli.
                                      // Aslında .height(50.dp) ve .fillMaxWidth() daha doğru olurdu.
                                      // Ancak .size(height=...) da bu şekilde çalışır, genişliği etkilemez.
                .background(Color.Magenta)
        ) {
            Text("Genişliği doldur, Yükseklik 50dp", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SizeModifierExamplesPreview() {
    SizeModifierExamples()
}

////////////////////////////
//////////// AspectRatio Örneği

@Composable
fun AspectRatioExample() {
    // aspectRatio modifier'ı, bir composable'ın genişliği ile yüksekliği arasındaki oranı korumasını sağlar.
    // Örneğin, aspectRatio(1f) kare bir alan oluşturur.
    // aspectRatio(16f / 9f) ise 16:9 bir alan oluşturur.
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Kare (1:1 Aspect Ratio):")
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f) // Genişliğin %80'ini kapla
                .aspectRatio(1f) // En-boy oranını 1:1 (kare) yap. Yükseklik genişliğe eşit olacak.
                .background(Color.Red)
        ) {
            Text("Kare", modifier = Modifier.align(Alignment.Center), color = Color.White)
        }

        Spacer(Modifier.size(20.dp))

        Text("Dikdörtgen (16:9 Aspect Ratio):")
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f) // Genişliğin %80'ini kapla
                .aspectRatio(16f / 9f) // En-boy oranını 16:9 yap.
                .background(Color.Blue)
        ) {
            Text("16:9", modifier = Modifier.align(Alignment.Center), color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AspectRatioExamplePreview() {
    AspectRatioExample()
}

////////////////////////////
//////////// Weight Modifier Örneği

@Composable
fun WeightModifierExample() {
    // weight modifier'ı, genellikle Row veya Column içinde kullanılır
    // ve çocukların mevcut alanı nasıl paylaşacağını belirler.
    // Ağırlık değerlerine göre alan orantılı olarak dağıtılır.
    // fill parametresi (varsayılan true) ile, ağırlık verilen elemanın
    // kendisine ayrılan alanı tamamen doldurup doldurmayacağı belirlenir.

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        Text("Weight Örneği (Row içinde):", modifier = Modifier.padding(bottom = 8.dp))

        // Örnek 1: Eşit ağırlıklar
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f) // Bu Box, satır genişliğinin 1/3'ünü alır.
                    .height(50.dp)
                    .background(Color.Red)
            ) {
                Text("1 Ağırlık", Modifier.align(Alignment.Center), color = Color.White)
            }
            Box(
                modifier = Modifier
                    .weight(1f) // Bu Box, satır genişliğinin 1/3'ünü alır.
                    .height(50.dp)
                    .background(Color.Green)
            ) {
                Text("1 Ağırlık", Modifier.align(Alignment.Center), color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .weight(1f) // Bu Box, satır genişliğinin 1/3'ünü alır.
                    .height(50.dp)
                    .background(Color.Blue)
            ) {
                Text("1 Ağırlık", Modifier.align(Alignment.Center), color = Color.White)
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Ağırlıklar farklı, fill=true (varsayılan):", modifier = Modifier.padding(bottom = 8.dp))
        // Örnek 2: Farklı ağırlıklar
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(2f) // Bu Box, toplam ağırlığın (2+1=3) 2/3'ünü alır.
                    .height(50.dp)
                    .background(Color.Yellow)
            ) {
                Text("2 Ağırlık", Modifier.align(Alignment.Center), color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .weight(1f) // Bu Box, toplam ağırlığın 1/3'ünü alır.
                    .height(50.dp)
                    .background(Color.Magenta)
            ) {
                Text("1 Ağırlık", Modifier.align(Alignment.Center), color = Color.White)
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Ağırlıklar farklı, fill=false:", modifier = Modifier.padding(bottom = 8.dp))
        // Örnek 3: Farklı ağırlıklar ve fill = false
        // fill = false olduğunda, elemanlar kendi içsel boyutlarını (IntrinsicSize) korumaya çalışır,
        // ancak yine de ağırlıklarına göre yerleştirilirler. Boş alan kalabilir.
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Geniş Metin (2 Ağırlık)",
                modifier = Modifier
                    .weight(2f, fill = false) // Bu Text, 2 ağırlık alır ama içeriği kadar yer kaplar.
                    .background(Color.Cyan)
                    .padding(8.dp)
            )
            Text(
                text = "Kısa (1 Ağırlık)",
                modifier = Modifier
                    .weight(1f, fill = false) // Bu Text, 1 ağırlık alır ama içeriği kadar yer kaplar.
                    .background(Color.LightGray)
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeightModifierExamplePreview() {
    WeightModifierExample()
}

////////////////////////////
//////////// Column Arrangement ve Alignment Örnekleri

@Composable
fun ColumnArrangementAlignmentExample() {
    // Bu Column, tüm ekranı kaplayacak ve çocuklarını dikey olarak sıralayacaktır.
    // Arrangement ve Alignment'ın etkilerini görmek için Column'a bir boyut ve arka plan verelim.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            "Column Arrangement & Alignment",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        // VerticalArrangement Örnekleri
        // Arrangement.Top: Çocukları Column'un üstüne yaslar. (Varsayılan)
        Text("VerticalArrangement.Top / HorizontalAlignment.Start", modifier = Modifier.padding(bottom = 4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp) // Yüksekliği sabitliyoruz ki arrangement daha net görünsün
                .background(Color.LightGray)
                .padding(4.dp),
            verticalArrangement = Arrangement.Top, // Çocukları yukarı yaslar
            horizontalAlignment = Alignment.Start // Çocukları sola yaslar (Column için)
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(30.dp).background(Color.Green))
            Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        // Arrangement.Bottom: Çocukları Column'un altına yaslar.
        Text("VerticalArrangement.Bottom / HorizontalAlignment.CenterHorizontally", modifier = Modifier.padding(bottom = 4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            verticalArrangement = Arrangement.Bottom, // Çocukları aşağı yaslar
            horizontalAlignment = Alignment.CenterHorizontally // Çocukları yatayda ortalar
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(30.dp).background(Color.Green))
            Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        // Arrangement.Center: Çocukları Column'un dikey merkezine toplar.
        Text("VerticalArrangement.Center / HorizontalAlignment.End", modifier = Modifier.padding(bottom = 4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            verticalArrangement = Arrangement.Center, // Çocukları dikeyde ortalar
            horizontalAlignment = Alignment.End // Çocukları sağa yaslar
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(30.dp).background(Color.Green))
            Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        // Arrangement.SpaceBetween: İlk çocuğu başa, son çocuğu sona yaslar, aradaki boşluğu eşit dağıtır.
        Text("VerticalArrangement.SpaceBetween", modifier = Modifier.padding(bottom = 4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Yüksekliği artıralım ki boşluklar netleşsin
                .background(Color.LightGray)
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceBetween // Çocuklar arasında eşit boşluk (ilk ve son yaslanır)
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(30.dp).background(Color.Green))
            Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        // Arrangement.SpaceAround: Çocukların etrafına eşit boşluk bırakır (başta ve sonda yarım boşluk).
        Text("VerticalArrangement.SpaceAround", modifier = Modifier.padding(bottom = 4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceAround // Çocukların etrafına eşit boşluk
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(30.dp).background(Color.Green))
            Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        // Arrangement.SpaceEvenly: Çocuklar arasına ve başa/sona eşit boşluk bırakır.
        Text("VerticalArrangement.SpaceEvenly", modifier = Modifier.padding(bottom = 4.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceEvenly // Çocuklar arasına ve kenarlara eşit boşluk
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(30.dp).background(Color.Green))
            Box(modifier = Modifier.size(40.dp).background(Color.Blue))
        }
    }
}

@Preview(showBackground = true, name = "Column Arrangement & Alignment")
@Composable
fun ColumnArrangementAlignmentExamplePreview() {
    ColumnArrangementAlignmentExample()
}

////////////////////////////
//////////// Row Arrangement ve Alignment Örnekleri

@Composable
fun RowArrangementAlignmentExample() {
    Column( // Ana düzen için bir Column, örnekleri alt alta sıralamak amacıyla
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            "Row Arrangement & Alignment",
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Bu Text'i Column içinde ortalar
                .padding(bottom = 16.dp)
        )

        // HorizontalArrangement Örnekleri
        Text("HorizontalArrangement.Start / VerticalAlignment.Top", modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp) // Row'a sabit bir yükseklik verelim
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start, // Çocukları satırın başına yaslar (Varsayılan)
            verticalAlignment = Alignment.Top // Çocukları satırın üstüne yaslar
        ) {
            Box(modifier = Modifier.size(width = 50.dp, height = 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(width = 30.dp, height = 60.dp).background(Color.Green)) // Farklı yükseklik
            Box(modifier = Modifier.size(width = 40.dp, height = 50.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        Text("HorizontalArrangement.End / VerticalAlignment.Bottom", modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalArrangement = Arrangement.End, // Çocukları satırın sonuna yaslar
            verticalAlignment = Alignment.Bottom // Çocukları satırın altına yaslar
        ) {
            Box(modifier = Modifier.size(width = 50.dp, height = 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(width = 30.dp, height = 60.dp).background(Color.Green))
            Box(modifier = Modifier.size(width = 40.dp, height = 50.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        Text("HorizontalArrangement.Center / VerticalAlignment.CenterVertically", modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center, // Çocukları satırın yatay merkezine toplar
            verticalAlignment = Alignment.CenterVertically // Çocukları satırın dikey merkezine hizalar
        ) {
            Box(modifier = Modifier.size(width = 50.dp, height = 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(width = 30.dp, height = 60.dp).background(Color.Green))
            Box(modifier = Modifier.size(width = 40.dp, height = 50.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        Text("HorizontalArrangement.SpaceBetween", modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween // İlk çocuk başa, son çocuk sona, aradaki boşluk eşit dağıtılır
        ) {
            Box(modifier = Modifier.size(width = 50.dp, height = 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(width = 30.dp, height = 60.dp).background(Color.Green))
            Box(modifier = Modifier.size(width = 40.dp, height = 50.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        Text("HorizontalArrangement.SpaceAround", modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceAround // Çocukların etrafına eşit boşluk (başta ve sonda yarım boşluk)
        ) {
            Box(modifier = Modifier.size(width = 50.dp, height = 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(width = 30.dp, height = 60.dp).background(Color.Green))
            Box(modifier = Modifier.size(width = 40.dp, height = 50.dp).background(Color.Blue))
        }
        Spacer(Modifier.height(16.dp))

        Text("HorizontalArrangement.SpaceEvenly", modifier = Modifier.padding(bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly // Çocuklar arasına ve başa/sona eşit boşluk
        ) {
            Box(modifier = Modifier.size(width = 50.dp, height = 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(width = 30.dp, height = 60.dp).background(Color.Green))
            Box(modifier = Modifier.size(width = 40.dp, height = 50.dp).background(Color.Blue))
        }
    }
}

@Preview(showBackground = true, name = "Row Arrangement & Alignment")
@Composable
fun RowArrangementAlignmentExamplePreview() {
    RowArrangementAlignmentExample()
}


////////////////////////////
//////////// LazyColumn Örneği

// LazyColumn, ekranda görünen öğeleri "tembel" bir şekilde yükleyen, dikey olarak kaydırılabilir bir liste oluşturur.
// Bu, çok sayıda öğe içeren listeler için performansı artırır, çünkü yalnızca görünür olan
// veya yakında görünecek olan öğeler oluşturulur ve bellekte tutulur (Recycling/Virtualization).
@Composable
fun LazyColumnExample() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            "LazyColumn Örneği",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Önizlemede kaydırmayı görebilmek için sabit yükseklik
                .background(Color.Gray.copy(alpha = 0.1f)),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp), // Liste içeriğine padding
            verticalArrangement = Arrangement.spacedBy(8.dp) // Elemanlar arasına dikey boşluk
        ) {
            // items bloğu, listenizdeki her bir veri öğesi için bir Composable oluşturmanızı sağlar.
            // `sampleLazyListData` listesindeki her `item` için aşağıdaki blok çalıştırılır.
            //
            // `key` kullanımı:
            // Eğer listenizdeki elemanlar eklenebilir, silinebilir veya yeniden sıralanabilir ise,
            // her elemana benzersiz bir `key` atamak önemlidir. Bu, Compose'un elemanların
            // durumunu doğru bir şekilde korumasına ve performansı optimize etmesine yardımcı olur.
            // Örn: items(items = sampleLazyListData, key = { item -> item.id }) { item -> ... }
            // Burada `item.id` her eleman için benzersiz bir anahtar görevi görür.
            items(items = sampleLazyListData, key = { item -> item.id }) { listItem ->
                // Her bir liste elemanı için bir Card içinde Text gösteriyoruz.
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp), // Kartlar arasına dikey boşluk
                    colors = CardDefaults.cardColors(containerColor = listItem.color.copy(alpha = 0.3f))
                ) {
                    Text(
                        text = listItem.title,
                        modifier = Modifier.padding(16.dp) // Card içeriğine padding
                    )
                }
            }

            // itemsIndexed kullanımı:
            // Eğer hem elemanın kendisine hem de index'ine ihtiyacınız varsa itemsIndexed kullanabilirsiniz.
            // itemsIndexed(sampleLazyListData) { index, listItem ->
            //     Text("Eleman ${listItem.title} - Index: $index")
            // }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5", widthDp = 300, heightDp = 500)
@Composable
fun LazyColumnExamplePreview() {
    LazyColumnExample()
}

////////////////////////////
//////////// LazyRow Örneği

// LazyRow, ekranda görünen öğeleri "tembel" bir şekilde yükleyen, yatay olarak kaydırılabilir bir liste oluşturur.
// LazyColumn'a benzer şekilde, çok sayıda öğe içeren yatay listeler için performansı artırır.
// Yalnızca görünür olan veya yakında görünecek olan öğeler oluşturulur ve bellekte tutulur.
@Composable
fun LazyRowExample() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            "LazyRow Örneği",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth() // Genişliği doldurur
                .height(150.dp) // Yatay liste için sabit bir yükseklik
                .background(Color.Gray.copy(alpha = 0.1f)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp), // Liste içeriğine padding
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Elemanlar arasına yatay boşluk
        ) {
            // items bloğu, listenizdeki her bir veri öğesi için bir Composable oluşturmanızı sağlar.
            // `sampleLazyListData` listesindeki her `item` için aşağıdaki blok çalıştırılır.
            // `key` kullanımı LazyColumn'daki ile aynı mantıkta, performansı ve durum korunumunu artırır.
            items(items = sampleLazyListData, key = { item -> item.id }) { listItem ->
                // Her bir liste elemanı için bir Card içinde Text gösteriyoruz.
                // LazyRow için elemanların genişliği önemlidir.
                Card(
                    modifier = Modifier
                        .width(120.dp) // Her bir kartın genişliği
                        .aspectRatio(1f) // Kartların en-boy oranını 1:1 (kare) yapar, yükseklik genişliğe eşit olur
                        .padding(horizontal = 4.dp), // Kartlar arasına yatay boşluk
                    colors = CardDefaults.cardColors(containerColor = listItem.color.copy(alpha = 0.5f))
                ) {
                    Column( // Kart içeriğini ortalamak için
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = listItem.title.replace("Eleman", "E."), // Daha kısa metin
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5", widthDp = 400, heightDp = 250)
@Composable
fun LazyRowExamplePreview() {
    LazyRowExample()
}

////////////////////////////
//////////// Card Örneği

// Card, Material Design'da yüzeyleri ve bilgileri gruplamak için kullanılan bir bileşendir.
// Genellikle ilgili içeriği bir arada tutan ve görsel olarak diğer içeriklerden ayrılan
// bir konteyner görevi görür. Kartlar gölge (elevation), köşe yuvarlaklığı (shape)
// ve farklı arka plan renkleri gibi özelliklerle özelleştirilebilir.
@Composable
fun CardExample() {
    Column( // Birden fazla kart örneğini göstermek için ana bir Column
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp) // Kartlar arasına boşluk
    ) {
        Text(
            "Card Örnekleri",
            style = MaterialTheme.typography.headlineSmall, // Başlık stili
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Örnek 1: Temel Card kullanımı
        Card(
            modifier = Modifier
                .fillMaxWidth() // Kartın mevcut genişliği doldurmasını sağlar.
                .padding(8.dp), // Kartın dışına padding uygular.
            // elevation (yükseklik), kartın yüzeyden ne kadar yukarıda görüneceğini ve gölgesini belirler.
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            // colors, kartın arka plan ve içerik rengini belirler.
            // Burada containerColor ile kartın arka plan rengini tema rengi olan surfaceVariant yapıyoruz.
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            // shape, kartın şeklini belirler. RoundedCornerShape ile köşeleri yuvarlaklaştırabiliriz.
            shape = RoundedCornerShape(12.dp) // Köşeleri 12 dp yuvarlaklıkta.
        ) {
            // Kartın içeriği buraya yerleştirilir. Genellikle bir Column veya Row kullanılır.
            Column(
                modifier = Modifier.padding(16.dp) // Kart içeriğine padding verir.
            ) {
                Text(
                    text = "Card Başlığı (Örnek 1)",
                    style = MaterialTheme.typography.titleMedium, // Başlık için tema stili
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Bu bir Card içerisinde yer alan açıklama metnidir. " +
                            "Card'lar, bilgileri gruplamak ve görsel olarak ayırmak için harikadır.",
                    style = MaterialTheme.typography.bodyMedium // Gövde metni için tema stili
                )
                Spacer(modifier = Modifier.height(10.dp)) // Biraz boşluk ekleyelim
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .align(Alignment.CenterHorizontally) // Bu Box'ı Column içinde ortalar
                ) {
                    Text("Box", modifier = Modifier.align(Alignment.Center))
                }
            }
        }

        // Örnek 2: Farklı şekil ve elevation ile Card
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f) // Genişliğin %90'ını kapla
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp, hoveredElevation = 12.dp), // Üzerine gelince gölge artar (interaktif değil ama parametre var)
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
            shape = CutCornerShape(topStart = 24.dp, bottomEnd = 24.dp) // Köşeleri kesik şekil
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.End // İçeriği sağa yasla
            ) {
                Text(
                    text = "Farklı Şekilli Card (Örnek 2)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Bu kartın köşeleri CutCornerShape ile farklılaştırılmıştır ve daha fazla gölgeye sahiptir.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Card Örnekleri")
@Composable
fun CardExamplePreview() {
    ComposeTutorialTheme { // Temayı uygula ki MaterialTheme renkleri ve şekilleri doğru gelsin
        CardExample()
    }
}

////////////////////////////
//////////// Image Örneği

// Image Composable'ı, uygulamanızda resimleri (drawable, bitmap, vector, painter vb.) göstermek için kullanılır.
// Temel kullanımı, bir `painter` ve bir `contentDescription` (içerik açıklaması) sağlamaktır.
// `contentDescription`, erişilebilirlik için önemlidir; görme engelli kullanıcıların
// resmin ne hakkında olduğunu anlamasına yardımcı olur.

// ÖNEMLİ NOT: Bu örnek, projenizin `app/src/main/res/drawable/` klasöründe
// `sample_image.png` (veya benzeri bir isimde) bir resim dosyası olduğunu varsayar.
// Eğer bu dosya yoksa, Preview'da ve uygulamada resim yüklenemeyecektir.
// Lütfen uygun bir örnek resmi bu klasöre ekleyin.

@Composable
fun ImageExample() {
    // Ana Column, tüm örnekleri dikey olarak sıralar ve kaydırılabilir yapar.
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "Image ve ContentScale Örnekleri",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Örnek 1: Temel Image kullanımı ve ContentScale.Crop
        item {
            ImageSectionTitle("ContentScale.Crop")
            // ContentScale.Crop: Resmin en-boy oranını koruyarak, verilen alana sığacak şekilde
            // ve alanı tamamen dolduracak şekilde kırpar. Resmin bir kısmı görünmeyebilir.
            Box(
                modifier = Modifier
                    .size(150.dp, 100.dp) // Sabit boyutlu bir kutu
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image), // Drawable'dan resim yükler
                    contentDescription = "Örnek Resim - Crop", // Erişilebilirlik için açıklama
                    contentScale = ContentScale.Crop, // Ölçekleme türü
                    modifier = Modifier.fillMaxSize() // Image'ın Box'ı doldurmasını sağlar
                )
            }
        }

        // Örnek 2: ContentScale.Fit
        item {
            ImageSectionTitle("ContentScale.Fit")
            // ContentScale.Fit: Resmin en-boy oranını koruyarak, verilen alana sığacak şekilde
            // ve resmin tamamı görünecek şekilde ölçekler. Alanın tamamı dolmayabilir.
            Box(
                modifier = Modifier
                    .size(150.dp, 100.dp)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Örnek Resim - Fit",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Örnek 3: ContentScale.Inside
        item {
            ImageSectionTitle("ContentScale.Inside")
            // ContentScale.Inside: Resmi, orijinal boyutunu aşmayacak şekilde ve en-boy oranını
            // koruyarak, verilen alana sığacak şekilde ölçekler. Eğer resim alandan küçükse,
            // orijinal boyutuyla merkezde gösterilir. Alanın tamamı dolmayabilir.
            Box(
                modifier = Modifier
                    .size(150.dp, 100.dp)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Örnek Resim - Inside",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Örnek 4: ContentScale.FillBounds
        item {
            ImageSectionTitle("ContentScale.FillBounds")
            // ContentScale.FillBounds: Resmin en-boy oranını göz ardı ederek, resmi verilen alanı
            // tamamen dolduracak şekilde ölçekler. Resim bozulabilir/esneyebilir.
            Box(
                modifier = Modifier
                    .size(150.dp, 100.dp)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Örnek Resim - FillBounds",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Örnek 5: ContentScale.FillWidth
        item {
            ImageSectionTitle("ContentScale.FillWidth")
            // ContentScale.FillWidth: Resmin genişliğini verilen alana sığdırırken en-boy oranını korur.
            // Yükseklik, orana göre ayarlanır ve alanı aşabilir veya doldurmayabilir.
            Box(
                modifier = Modifier
                    .width(150.dp) // Sadece genişlik belirliyoruz
                    .height(100.dp) // Yüksekliği de verelim ki sınırlar belli olsun
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Örnek Resim - FillWidth",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxSize() // Box'ı doldurur, resim kendi ölçeklemesini yapar
                )
            }
        }

        // Örnek 6: ContentScale.FillHeight
        item {
            ImageSectionTitle("ContentScale.FillHeight")
            // ContentScale.FillHeight: Resmin yüksekliğini verilen alana sığdırırken en-boy oranını korur.
            // Genişlik, orana göre ayarlanır ve alanı aşabilir veya doldurmayabilir.
            Box(
                modifier = Modifier
                    .width(150.dp) // Genişliği de verelim ki sınırlar belli olsun
                    .height(100.dp) // Sadece yükseklik belirliyoruz
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Örnek Resim - FillHeight",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Örnek 7: Modifier ile boyutlandırma ve kırpma (clip)
        item {
            ImageSectionTitle("Modifier ile Boyutlandırma ve Kırpma")
            // Image Composable'ına doğrudan Modifier uygulayarak boyutunu, şeklini vb. değiştirebiliriz.
            Image(
                painter = painterResource(id = R.drawable.sample_image),
                contentDescription = "Örnek Resim - Kırpılmış Daire",
                contentScale = ContentScale.Crop, // Kırpılmış şeklin içini doldurması için Crop iyi bir seçenek
                modifier = Modifier
                    .size(120.dp) // Image'a sabit bir boyut verir (120x120 dp).
                    .clip(CircleShape) // Image'ı dairesel bir şekle göre kırpar.
                    .background(Color.Cyan.copy(alpha = 0.3f)) // Kırpılan alanın dışını görmek için (opsiyonel)
            )
        }
    }
}

// İçerik başlıkları için yardımcı bir Composable
@Composable
fun ColumnScope.ImageSectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp),
        modifier = Modifier
            .padding(top = 16.dp, bottom = 8.dp)
            .align(Alignment.Start)
    )
}


@Preview(showBackground = true, name = "Image Örnekleri", heightDp = 1200)
@Composable
fun ImageExamplePreview() {
    ComposeTutorialTheme {
        ImageExample()
    }
}


////////////////////////////
////////////Button

// Jetpack Compose'da state (durum), zamanla değişebilen ve UI'ı etkileyen herhangi bir değerdir.
// Örneğin, bir sayacın değeri veya bir metin giriş alanındaki yazı.
// Compose, bu durum değişikliklerini izler ve UI'ı otomatik olarak günceller (recomposition).

@Composable
fun ButtonExample(){
    // `remember`: Compose'un state'i (durumu) recomposition'lar arasında hatırlamasını sağlar.
    // `remember` olmadan, her recomposition'da (UI yeniden çizildiğinde) state sıfırlanırdı.
    // Basitçe, composable'a küçük bir "hafıza" verir.
    // `mutableStateOf(0)`: Değişebilir bir state nesnesi oluşturur. Başlangıç değeri 0'dır.
    // Bu nesnenin `.value` özelliği değiştiğinde, Compose bu değişikliği fark eder.
    //
    // `countState` burada `State<Int>` tipinde bir nesnedir. Değerine erişmek için `.value` kullanılır.
    val countState = remember { mutableStateOf(0) }
    // Alternatif olarak Kotlin'in property delegate'i (`by`) kullanılabilir:
    // `var count by remember { mutableStateOf(0) }`
    // Bu durumda `count` değişkenine doğrudan değer atayabilir (`count = 5`) veya okuyabilirsiniz (`Text("Değer: $count")`).
    // `by` kullanıldığında `.value` yazmaya gerek kalmaz, kod daha okunaklı olabilir.
    // `countState`'i `val` ile tanımladık çünkü `State` nesnesinin kendisi değişmiyor, içindeki `.value` değişiyor.

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Button ve State Örneği",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            // Butona tıklandığında `onClick` lambda fonksiyonu çalışır.
            onClick = {
                // `countState.value`'yu artırıyoruz.
                // Bu değişiklik, Compose tarafından algılanır ve `countState.value`'yu
                // okuyan tüm Composable'ların yeniden çizilmesini (recomposition) tetikler.
                countState.value++
                // Eğer `var count by remember { mutableStateOf(0) }` kullansaydık,
                // burası `count++` şeklinde olurdu.
            }
        ){
            // Bu Text Composable'ı `countState.value`'yu okuduğu için,
            // `countState.value` her değiştiğinde otomatik olarak güncellenir (recompose olur).
            // Buna "recomposition" denir. Compose, sadece state'i okuyan ve değişen
            // kısımları akıllıca yeniden çizer, tüm UI'ı değil.
            Text("Butona ${countState.value} kez tıklandı")
            // Eğer `var count by remember { mutableStateOf(0) }` kullansaydık,
            // burası `Text("Butona $count kez tıklandı")` şeklinde olurdu.
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun PreviewButton(){
    ComposeTutorialTheme {
        ButtonExample()
    }
}
////////////////////////////
////////////

////////////////////////////
////////////remember mutableStateOf / Property Delegate (`by`)

// Bu örnek, TextField kullanarak kullanıcıdan girdi almayı ve bu girdiyi
// anlık olarak başka bir Text Composable'ında göstermeyi amaçlar.
// Temel state yönetimi kavramlarını (remember, mutableStateOf, property delegate) içerir.
@Composable
fun NameInput(){
    // `remember { mutableStateOf("") }`: Boş bir string ile başlayan, değişebilir bir state oluşturur.
    // `remember` sayesinde, `name` değişkeninin değeri UI yeniden çizildiğinde (recomposition) kaybolmaz, korunur.
    //
    // `var name by ...`: Kotlin'in property delegate (özellik temsilcisi) özelliğini kullanır.
    // `by` anahtar kelimesi, `name` değişkeninin değerine erişirken (`name`) ve onu güncellerken (`name = "yeni değer"`)
    // otomatik olarak `MutableState` nesnesinin `.value` özelliğini kullanmamızı sağlar.
    // Kısacası, `name.value = "yeni değer"` yerine `name = "yeni değer"` yazabiliriz.
    // Bu, kodu daha kısa ve okunaklı hale getirir.
    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)){
        Text(
            text = "Property Delegate (`by`) ile State Kullanımı",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // `TextField`, kullanıcıdan metin girişi almak için kullanılan bir Composable'dır.
        TextField(
            value = name, // TextField'ın o anki değerini `name` state'inden alır.
            // `onValueChange`: Kullanıcı TextField'a her yeni karakter girdiğinde veya sildiğinde tetiklenir.
            // `it` parametresi, TextField'ın yeni metin değerini içerir.
            onValueChange = { newText ->
                // Kullanıcının girdiği yeni metin (`newText`) ile `name` state'ini güncelliyoruz.
                // `name` state'i değiştiği anda, bu state'i okuyan tüm Composable'lar
                // (örneğin aşağıdaki `Text("Merhaba, $name")`) otomatik olarak yeniden çizilir (recompose olur).
                name = newText
            },
            label = {
                Text("İsminizi girin...") // TextField boşken görünecek etiket.
            },
            modifier = Modifier.fillMaxWidth() // TextField'ın tüm genişliği kaplamasını sağlar.
        )

        Spacer(modifier = Modifier.height(16.dp)) // Biraz boşluk bırakır.

        // Bu `Text` Composable'ı, `name` state'ini okur (`$name` ile).
        // `name` state'i her değiştiğinde (yani kullanıcı TextField'a bir şeyler yazdığında),
        // bu `Text` otomatik olarak yeni değeri gösterecek şekilde yeniden çizilir.
        // Bu, Compose'un reaktif programlama modelinin temel bir parçasıdır.
        Text(
            text = "Merhaba, $name!",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun PreviewNameInput(){
    ComposeTutorialTheme {
        NameInput()
    }
}
////////////////////////////
////////////

////////////////////////////
////////////State hoisting (Durum Yükseltme)

// `NameInputHoisted`, kendi içinde state tutmayan (stateless) bir Composable'dır.
// Gerekli olan `name` değerini parametre olarak alır ve `onNameChange` lambda fonksiyonu
// aracılığıyla `name` değiştiğinde ne yapılacağını dışarıya bildirir.
// Bu, Composable'ı daha yeniden kullanılabilir ve test edilebilir hale getirir.
// Bu Composable, `name`'in nasıl saklandığı veya yönetildiğiyle ilgilenmez.
@Composable
fun NameInputHoisted(name:String, onNameChange:(String)->Unit){
    // Bu Column, TextField ve Text'i dikey olarak sıralar.
    Column(modifier = Modifier.padding(8.dp)){ // Dışarıdan biraz boşluk
        Text(
            text = "State Hoisting (Durum Yükseltme)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = name, // Gösterilecek değer, ParentComposable'dan gelir.
            onValueChange = onNameChange, // Değer değiştiğinde ParentComposable'daki state güncellenir.
            label = {Text("İsminizi girin (Hoisted)")},
            modifier = Modifier.fillMaxWidth()
        )
        // Bu Text de `name` parametresini okuduğu için, `name` her değiştiğinde güncellenir.
        Text(
            text = "Merhaba, $name!",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

// `ParentComposable`, state'i (`name`) tutan ve yöneten Composable'dır.
// `NameInputHoisted` Composable'ına bu state'i ve state'i değiştirecek olan lambda fonksiyonunu geçer.
// Bu desene "State Hoisting" (Durum Yükseltme) denir.
// State'i yukarı (ebeveyn Composable'a) taşımak anlamına gelir.
@Composable
fun ParentComposable(){
    // `name` state'i burada, `ParentComposable` içinde tanımlanır ve yönetilir.
    var name by remember{mutableStateOf("")}

    // `NameInputHoisted` çağrılırken, mevcut `name` state'i ve bu state'i güncelleyecek
    // `onNameChange` lambda fonksiyonu (`{newName -> name = newName}`) ona parametre olarak verilir.
    // Böylece `NameInputHoisted` kendi state'ini tutmak zorunda kalmaz.
    //
    // State Hoisting'in Faydaları:
    // 1. Yeniden Kullanılabilirlik: `NameInputHoisted` gibi stateless Composable'lar farklı
    //    state kaynaklarıyla birçok yerde kolayca kullanılabilir.
    // 2. Test Edilebilirlik: Stateless Composable'ları test etmek daha kolaydır çünkü
    //    sadece aldıkları parametrelere göre UI çizerler, içsel state'leri yoktur.
    // 3. Tek Kaynak (Single Source of Truth): State tek bir yerde (burada `ParentComposable`)
    //    yönetildiği için state tutarsızlıkları ve hataları azalır.
    // 4. State Paylaşımı: State'i yukarı taşıyarak, birden fazla alt Composable arasında
    //    kolayca paylaşılabilir.
    NameInputHoisted(name = name, onNameChange = {newName -> name = newName})

    // Bu print, recomposition'ları ve state değişimini logcat'te görmek için eklenebilir.
    // Her harf girdiğinizde ParentComposable'ın da recompose olduğunu görebilirsiniz (çünkü state'i değişiyor).
    // println("ParentComposable recomposed. Name: $name")
}

@Preview(showBackground = true)
@Composable
fun StateHoistingPreview(){
    ComposeTutorialTheme {
        ParentComposable()
    }
}

////////////////////////////
//////////// ViewModel ile State Yönetimi Örneği

// Bu örnek, Jetpack ViewModel kullanarak state yönetimini gösterir.
// ViewModel, UI ile ilgili verileri ve iş mantığını tutar ve yapılandırma
// değişikliklerine (örn. ekran döndürme) karşı dayanıklıdır. Yani ekran döndüğünde
// sayaç değeri kaybolmaz.

@Composable
fun ViewModelButtonExample(
    // `viewModel<TutorialViewModel>()` fonksiyonu, bu Composable için bir TutorialViewModel
    // örneği alır veya oluşturur. Compose, ViewModel'in yaşam döngüsünü yönetir.
    // Eğer aynı ViewModel sahibi (genellikle bir Activity veya Navigation Grafiği)
    // içinde daha önce bir TutorialViewModel oluşturulmuşsa, aynı örnek tekrar kullanılır.
    // Bu, verinin yapılandırma değişiklikleri boyunca korunmasını sağlar.
    tutorialViewModel: TutorialViewModel = viewModel()
) {
    // ViewModel'deki `count` StateFlow'unu dinliyoruz.
    // `collectAsStateWithLifecycle()`: StateFlow'dan gelen değerleri Compose State'ine dönüştürür
    // ve bu Composable'ın yaşam döngüsüne duyarlı bir şekilde güncellemeleri alır.
    // Bu, Composable ekranda görünür olduğunda state'i toplar ve görünmez olduğunda durdurur,
    // böylece gereksiz kaynak kullanımını önler.
    // `count` değişkeni artık Int tipindedir ve değeri her güncellendiğinde bu Composable yeniden çizilir.
    val count by tutorialViewModel.count.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "ViewModel ile Sayaç Örneği",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            text = "Mevcut Sayı (ViewModel'den): $count",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            // Butona tıklandığında, ViewModel'deki `incrementCount` fonksiyonunu çağırırız.
            // UI (Composable), doğrudan state'i değiştirmek yerine, ViewModel'e bir "olay" (event) bildirir.
            // ViewModel daha sonra iş mantığını çalıştırır ve state'i günceller.
            // Bu, UI mantığının (Composable) iş mantığından (ViewModel) ayrılmasına yardımcı olur.
            onClick = {
                tutorialViewModel.incrementCount()
            }
        ) {
            Text(text = "Sayacı Artır")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Bu sayaç değeri, ekran döndürme gibi yapılandırma değişikliklerinde korunur çünkü state ViewModel içinde tutulmaktadır.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
    // ViewModel Kullanmanın Faydaları:
    // 1. Yaşam Döngüsü Farkındalığı: ViewModel'lar, Activity veya Fragment yaşam döngüsüne
    //    bağlıdır ve yapılandırma değişikliklerinden etkilenmezler. Bu, verilerin kaybolmamasını sağlar.
    // 2. Mantık Ayrımı (Separation of Concerns): UI (Composable) ve iş mantığı (ViewModel)
    //    birbirinden ayrılır. Composable'lar sadece UI'ı çizmekle ve kullanıcı etkileşimlerini
    //    ViewModel'e iletmekle sorumlu olur. ViewModel ise veriyi işler ve state'i yönetir.
    // 3. Test Edilebilirlik: ViewModel'lar Android framework'üne daha az bağımlı oldukları için
    //    birim testleri (unit test) daha kolay yazılır.
    // 4. Veri Paylaşımı: Aynı Activity veya Fragment içindeki farklı Composable'lar arasında
    //    aynı ViewModel örneğini kullanarak veri paylaşımı yapılabilir.
}

@Preview(showBackground = true, name = "ViewModel Sayaç Örneği")
@Composable
fun ViewModelButtonExamplePreview() {
    ComposeTutorialTheme {
        // Preview'da viewModel() çağrısı genellikle çalışır ve varsayılan bir ViewModel sağlar.
        // Eğer sorun yaşanırsa, sahte (fake) bir ViewModel veya manuel olarak oluşturulmuş
        // bir ViewModel örneği preview için sağlanabilir.
        ViewModelButtonExample()
    }
}

////////////////////////////
//////////// Basic Navigation Örneği

// Bu Composable, birinci ekranı temsil eder.
// Bir başlık ve ikinci ekrana gitmek için bir buton içerir.
@Composable
fun NavigationScreenOne(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ekran 1 / Screen One",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = {
                // "screen_two" rotasına (rota adına) sahip olan ekrana git.
                // NavController, NavHost içinde tanımlanan rotalara göre gezinmeyi yönetir.
                navController.navigate("screen_two")
            }
        ) {
            Text("Ekran İki'ye Git")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Bu ekrandan 'Ekran İki'ye Git' butonuna tıklayarak ikinci ekrana geçiş yapabilirsiniz.",
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}

// Bu Composable, ikinci ekranı temsil eder.
// Bir başlık ve birinci ekrana geri dönmek için bir buton içerir.
@Composable
fun NavigationScreenTwo(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ekran 2 / Screen Two",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = {
                // `popBackStack()`: Navigasyon yığınındaki (navigation stack) mevcut ekranı
                // kaldırır ve bir önceki ekrana döner.
                // Alternatif olarak, belirli bir hedefe (örneğin ana ekrana) dönmek için
                // `navController.navigate("screen_one") { popUpTo("screen_one") { inclusive = true } }`
                // kullanılabilir. Bu, "screen_one" hedefine kadar olan tüm ekranları yığından temizler
                // ve "screen_one" hedefini de temizler (`inclusive = true` olduğu için),
                // böylece "screen_one" yeniden oluşturulur.
                navController.popBackStack()
            }
        ) {
            Text("Ekran Bir'e Geri Dön")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Bu ekrandan 'Ekran Bir'e Geri Dön' butonuna tıklayarak önceki ekrana dönebilirsiniz.",
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}

// Bu Composable, temel navigasyon akışını kurar ve yönetir.
@Composable
fun BasicNavigationExample() {
    // `rememberNavController()`: Bir NavController örneği oluşturur ve bu örneği
    // recomposition'lar arasında hatırlar (saklar). NavController, Compose Navigation
    // kütüphanesinin merkezi API'sidir ve navigasyon eylemlerini (navigate, popBackStack vb.)
    // tetiklemek ve navigasyon yığınını yönetmek için kullanılır.
    val navController = rememberNavController()

    // `NavHost`: Navigasyon grafiğindeki hedefleri (Composable ekranları) barındıran bir konteynerdir.
    // `navController`: NavHost'un hangi NavController'ı kullanacağını belirtir.
    // `startDestination`: Navigasyon grafiği ilk oluşturulduğunda hangi hedefin (ekranın)
    //                     başlangıç noktası olacağını tanımlayan rota adıdır.
    NavHost(navController = navController, startDestination = "screen_one") {
        // `composable("rota_adi") { ... }`: Navigasyon grafiğinde bir hedef (destination) tanımlar.
        // "rota_adi": Bu hedefe ulaşmak için kullanılacak benzersiz bir string anahtarıdır.
        // Lambda bloğu (`{ ... }`): Bu rota çağrıldığında gösterilecek olan Composable içeriğini alır.
        // Bu blok içinde, ilgili ekran Composable'ı (örn. NavigationScreenOne) çağrılır ve
        // `navController` ona parametre olarak verilir, böylece o ekran da navigasyon yapabilir.

        composable("screen_one") {
            // "screen_one" rotası istendiğinde NavigationScreenOne Composable'ını gösterir.
            NavigationScreenOne(navController = navController)
        }
        composable("screen_two") {
            // "screen_two" rotası istendiğinde NavigationScreenTwo Composable'ını gösterir.
            NavigationScreenTwo(navController = navController)
        }
        // Eğer bir ana ekran (home screen) olsaydı, şöyle eklenebilirdi:
        // composable("home_screen") { NavigationHomeScreen(navController) }
        // ve startDestination = "home_screen" olarak ayarlanabilirdi.
    }
    // Navigasyon Nasıl Çalışır?
    // 1. `navController.navigate("rota_adi")` çağrıldığında, NavController NavHost'a bu
    //    rota adına sahip hedefi göstermesini söyler.
    // 2. NavHost, ilgili `composable` bloğunu bulur ve içindeki Composable'ı (ekranı) çizer.
    // 3. Geri gitmek için `navController.popBackStack()` kullanılır, bu da yığındaki bir önceki
    //    ekranı gösterir.
}

@Preview(showBackground = true, name = "Temel Navigasyon Örneği")
@Composable
fun BasicNavigationExamplePreview() {
    ComposeTutorialTheme {
        BasicNavigationExample()
    }
}

////////////////////////////
//////////// Theming Demo

// Bu Composable, Jetpack Compose'da tema kullanımını ve özelleştirmesini gösterir.
// `MaterialTheme` üzerinden renklerin ve tipografi stillerinin nasıl erişildiğini ve uygulandığını
// basit bileşenler (Text, Button, Card) üzerinde örneklendirir.
@Composable
fun ThemingDemoComposable() {
    // Bu Column, demo bileşenlerini dikey olarak sıralar ve ortalar.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp) // Bileşenler arasına boşluk ekler
    ) {
        Text(
            text = "Tema Demo Başlığı",
            // `MaterialTheme.colorScheme.primary`: Temanın birincil rengini alır.
            // Bu renk `Theme.kt` dosyasındaki `lightColorScheme` veya `darkColorScheme` içindeki
            // `primary` değerinden gelir. `Color.kt` dosyasındaki `Purple40` (veya yaptığımız
            // değişiklik sonrası yeşil tonu) `lightColorScheme.primary` için kullanılır.
            color = MaterialTheme.colorScheme.primary,
            // `MaterialTheme.typography.headlineSmall`: Temanın küçük başlık stilini alır.
            // Bu stil `Type.kt` dosyasındaki `Typography` nesnesinde tanımlanmıştır.
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "İkincil Renkli Alt Başlık",
            // `MaterialTheme.colorScheme.secondary`: Temanın ikincil rengini alır.
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Bu, temanın `bodyLarge` stilini kullanan normal bir metindir. " +
                   "Renk belirtilmediği için varsayılan içerik rengini (`onBackground` veya `onSurface`) kullanır.",
            // Stil belirtildi, renk belirtilmedi. Renk, `bodyLarge` stilinin varsayılanından
            // veya `MaterialTheme.colorScheme.onBackground` / `onSurface` gibi genel içerik renklerinden gelir.
            style = MaterialTheme.typography.bodyLarge
        )

        // Butonlar, varsayılan olarak tema renklerini kullanır.
        // Örneğin, bir `Button`'ın arkaplanı `MaterialTheme.colorScheme.primary`
        // ve içindeki metnin rengi `MaterialTheme.colorScheme.onPrimary` olur.
        Button(onClick = { /* Şimdilik bir şey yapmıyor */ }) {
            Text("Material Düğmesi (Temalı)")
        }

        Card(
            // `CardDefaults.cardColors`: Kart için renk ayarlarını sağlar.
            // `containerColor`: Kartın arkaplan rengini belirler.
            // Burada `MaterialTheme.colorScheme.surfaceVariant` kullanıyoruz.
            // `surfaceVariant`, genellikle ana yüzeylerden (surface) biraz farklılaşan
            // kartlar veya diyaloglar gibi bileşenler için kullanılır.
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth(0.8f) // Kartın genişliğini ayarlar
        ) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Bu bir Card bileşenidir.",
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Kartın arkaplanı `surfaceVariant` tema rengidir.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Text(
            text = "Tema Özelleştirme Notu:",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Temanın birincil rengini (primary color) değiştirmek için `Color.kt` dosyasındaki " +
                   "`Purple40` (veya benzeri bir renk adı) değişkeninin değerini değiştirmeniz yeterlidir. " +
                   "Bu değişiklik `Theme.kt` içindeki `lightColorScheme`'e yansır ve " +
                   "`MaterialTheme.colorScheme.primary` kullanan tüm Composable'ları etkiler. " +
                   "Bu önizlemede, `Purple40` rengi bir yeşil tonuyla (`Color(0xFF00695C)`) değiştirilmiştir, " +
                   "bu yüzden başlık ve buton gibi birincil renk kullanan elemanlar yeşil görünmektedir.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Theming Demo")
@Composable
fun ThemingDemoComposablePreview() {
    ComposeTutorialTheme { // Kendi özel temamızı uyguluyoruz.
        ThemingDemoComposable()
    }
}
