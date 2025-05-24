package com.composemovie2.composetutorial.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Bu dosya, uygulamanızın tipografi (yazı tipi stilleri) ayarlarını tanımlar.
// `Typography` sınıfı, Material Design'daki farklı metin stillerini (örneğin, başlık, gövde, etiket)
// özelleştirmenize olanak tanır.
// Bu tanımlamalar daha sonra `Theme.kt` dosyasındaki `MaterialTheme`'e aktarılır.

// `Typography` nesnesi, uygulamanızda kullanılacak metin stillerini içerir.
// Material 3, `bodyLarge`, `titleLarge`, `labelSmall` gibi birçok ön tanımlı stil sunar.
// Projenizin ihtiyaçlarına göre bu stilleri burada özelleştirebilirsiniz.
// Örneğin, farklı font aileleri (FontFamily), font ağırlıkları (FontWeight),
// font boyutları (fontSize), satır yükseklikleri (lineHeight) ve harf aralıkları (letterSpacing) belirleyebilirsiniz.

// Başlangıç için Material tarafından sağlanan tipografi stilleri seti.
val Typography = Typography(
    // `bodyLarge`: Genellikle uzun metinler ve ana içerik için kullanılır.
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Varsayılan sistem fontunu kullanır. Özel fontlar için `FontFamily(Font(R.font.custom_font))` gibi tanımlamalar yapılabilir.
        fontWeight = FontWeight.Normal, // Normal font ağırlığı. Diğerleri: Bold, Medium, Light vb.
        fontSize = 16.sp, // Font boyutu "scalable pixels" (ölçeklenebilir piksel) biriminde.
        lineHeight = 24.sp, // Satır yüksekliği.
        letterSpacing = 0.5.sp // Harfler arası boşluk.
    ),
    // Aşağıda yorum satırı olarak bırakılmış diğer stil tanımlamalarını aktif hale getirip
    // uygulamanızın genel görünümünü değiştirebilirsiniz.
    // Örneğin, tüm başlıkların (`titleLarge`) farklı bir font veya boyutta olmasını sağlayabilirsiniz.
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif, // Örnek: Farklı bir font ailesi
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Monospace, // Örnek: Farklı bir font ailesi
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    // İhtiyaç duyulan diğer Material Design tipografi stillerini (headlineSmall, bodyMedium, caption vb.)
    // burada `TextStyle` objeleri oluşturarak ve Typography constructor'ına parametre olarak vererek
    // tanımlayabilir ve özelleştirebilirsiniz.
    // Bu `Typography` nesnesi, `Theme.kt` içerisindeki `MaterialTheme` Composable'ına
    // parametre olarak verilir ve böylece tüm uygulama genelinde bu yazı stilleri
    // `MaterialTheme.typography.bodyLarge` gibi çağrılarla kullanılabilir hale gelir.
)