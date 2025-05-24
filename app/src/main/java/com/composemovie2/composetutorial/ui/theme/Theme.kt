package com.composemovie2.composetutorial.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Bu dosya, uygulamanızın genel temasını tanımlayan ana Composable'ı içerir.
// `ComposeTutorialTheme` Composable'ı, uygulamanızın kök (root) Composable'ını sararak
// tüm alt Composable'lara renk şemalarını, tipografi ayarlarını ve şekil stillerini sağlar.

// `darkColorScheme`: Koyu tema için kullanılacak renk paletini tanımlar.
// `MaterialTheme` için `ColorScheme` nesnesi oluşturur.
// Renkler (primary, secondary, tertiary vb.) `Color.kt` dosyasında tanımlanan renklerden gelir.
// Örneğin, `primary = Purple80` ifadesi, koyu temadaki birincil rengin `Color.kt`'deki `Purple80`
// değişkeni tarafından tanımlanan renk olacağını belirtir.
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,       // Koyu temada ana birincil renk (örn: butonlar, vurgular)
    secondary = PurpleGrey80, // Koyu temada ikincil renk (örn: filtre çipleri, daha az önemli butonlar)
    tertiary = Pink80,        // Koyu temada üçüncül renk (örn: kontrast vurgular)
    // Diğer renkleri de burada override edebilirsiniz.
    // background = Color.Black, // Örneğin, koyu tema arka planını tamamen siyah yapabilirsiniz.
    // surface = Color(0xFF121212) // Kartlar, menüler gibi yüzeylerin rengi.
)

// `lightColorScheme`: Açık tema için kullanılacak renk paletini tanımlar.
// Tıpkı `darkColorScheme` gibi, renkleri `Color.kt`'den alır.
private val LightColorScheme = lightColorScheme(
    primary = Purple40,       // Açık temada ana birincil renk
    secondary = PurpleGrey40, // Açık temada ikincil renk
    tertiary = Pink40,        // Açık temada üçüncül renk

    // Material Design renk sistemine göre diğer varsayılan renkleri de burada
    // kendi `Color.kt`'deki tanımlamalarınızla değiştirebilirsiniz.
    // Örneğin:
    // background = Color(0xFFFFFBFE), // Ekranların genel arka plan rengi.
    // surface = Color(0xFFFFFBFE),    // Kartlar, sheet'ler ve menüler gibi bileşenlerin yüzey rengi.
    // onPrimary = Color.White,        // `primary` rengi üzerindeki metin ve ikonların rengi.
    // onSecondary = Color.White,      // `secondary` rengi üzerindeki metin ve ikonların rengi.
    // onTertiary = Color.White,       // `tertiary` rengi üzerindeki metin ve ikonların rengi.
    // onBackground = Color(0xFF1C1B1F),// `background` rengi üzerindeki metin ve ikonların rengi.
    // onSurface = Color(0xFF1C1B1F),   // `surface` rengi üzerindeki metin ve ikonların rengi.
)

// `ComposeTutorialTheme`: Uygulamanızın ana tema Composable'ıdır.
// Bu fonksiyon, uygulamanızın içeriğini (`content` parametresi) alır ve
// Material Design temasıyla sarmalar.
@Composable
fun ComposeTutorialTheme(
    // `darkTheme`: Mevcut temanın koyu mu açık mı olacağını belirler.
    // Varsayılan olarak sistem ayarını (`isSystemInDarkTheme()`) kullanır.
    darkTheme: Boolean = isSystemInDarkTheme(),

    // `dynamicColor`: Dinamik renk özelliğinin (Android 12+ "Material You") aktif olup olmayacağını belirler.
    // Eğer `true` ise ve cihaz Android 12 veya üzeriyse, kullanıcının duvar kağıdından
    // türetilen bir renk paleti kullanılır.
    // Varsayılan olarak `true` ayarlanmıştır, ancak eski sürümlerde veya istenmiyorsa `false` yapılabilir.
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit // Temanın uygulanacağı asıl UI içeriği.
) {
    // Hangi renk şemasının kullanılacağını belirleyen mantık:
    val colorScheme = when {
        // Dinamik renkler destekleniyorsa ve aktifse:
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current // Mevcut context'i alır.
            // Sistem koyu temadaysa dinamik koyu renk şemasını, değilse dinamik açık renk şemasını kullanır.
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // Dinamik renkler kullanılmıyorsa veya desteklenmiyorsa:
        darkTheme -> DarkColorScheme // Manuel olarak tanımlanmış koyu tema renk şemasını kullanır.
        else -> LightColorScheme      // Manuel olarak tanımlanmış açık tema renk şemasını kullanır.
    }

    // Sistem çubuğu (status bar) renklerini tema ile uyumlu hale getirmek için.
    // Bu kısım genellikle UI'ın daha bütünleşik görünmesini sağlar.
    val view = LocalView.current
    if (!view.isInEditMode) { // Preview modunda çalışmaması için kontrol.
        SideEffect { // Composable'ın her recomposition'ında değil, sadece bir yan etki olarak çalışır.
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb() // Status bar rengini temanın birincil rengi yapar.
            // Status bar ikonlarının (saat, pil vb.) görünürlüğünü ayarlar (açık tema için koyu ikonlar, koyu tema için açık ikonlar).
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }


    // `MaterialTheme`: Jetpack Compose'daki ana tema bileşenidir.
    // Bu Composable, sağlanan `colorScheme`, `typography` ve `shapes` (eğer tanımlıysa)
    // ayarlarını alır ve bunları hiyerarşideki tüm alt Composable'lara uygular.
    MaterialTheme(
        colorScheme = colorScheme, // Seçilen renk şemasını (dinamik veya manuel, açık/koyu) tema renkleri olarak ayarlar.
        typography = Typography,   // `Type.kt` dosyasında tanımlanan tipografi stillerini tema tipografisi olarak ayarlar.
                                   // Buraya `shapes = Shapes` şeklinde şekil tanımları da eklenebilir (örn: `ui/theme/Shape.kt` dosyasında).
        content = content          // Temanın uygulanacağı UI içeriğini (genellikle uygulamanın tamamı) buraya yerleştirir.
    )
    // `MaterialTheme` içinde yer alan Composable'lar, tema özelliklerine şu şekilde erişebilir:
    // - Renkler: `MaterialTheme.colorScheme.primary`, `MaterialTheme.colorScheme.background` vb.
    // - Tipografi: `MaterialTheme.typography.bodyLarge`, `MaterialTheme.typography.headlineSmall` vb.
    // - Şekiller (eğer tanımlıysa): `MaterialTheme.shapes.medium`, `MaterialTheme.shapes.large` vb.
}