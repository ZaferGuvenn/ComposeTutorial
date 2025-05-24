package com.composemovie2.composetutorial.ui.theme

import androidx.compose.ui.graphics.Color

// Bu dosya, uygulamanızın renk paletini tanımlar.
// Jetpack Compose projeleri genellikle açık ve koyu tema için ayrı renk setleri tanımlar.
// Bu renkler daha sonra `Theme.kt` dosyasındaki `MaterialTheme` renk şemalarında (color schemes) kullanılır.

// Örnek Renkler (Genellikle tema oluşturucular tarafından otomatik olarak eklenir):
// Bu renkler, Material Design'ın renk sistemiyle uyumlu olacak şekilde adlandırılmıştır.
// Örneğin, "Primary" (Birincil), "Secondary" (İkincil), "Tertiary" (Üçüncül) gibi
// ana tema renklerini ve bunların açık/koyu varyasyonlarını burada tanımlayabilirsiniz.

// Açık tema için kullanılan renkler genellikle daha canlı veya pastel tonlarda olabilir.
// Koyu tema için ise daha doygun veya daha az parlak renkler tercih edilebilir.

// Bu varsayılan renkler, Android Studio'nun "New Project" sihirbazı tarafından
// Material 3 teması için oluşturulan örneklerdir.

// Açık ve Koyu Tema için Ortak Renk Tanımlamaları (Örnek Amaçlı)
// Gerçek bir uygulamada, bu renkler genellikle Primary, Secondary, Background, Surface, Error,
// OnPrimary, OnSecondary, OnBackground, OnSurface, OnError gibi Material Design renk rollerine
// atanmak üzere burada tanımlanır. `Theme.kt` dosyasında bu atamalar yapılır.

val Purple80 = Color(0xFFD0BCFF) // Açık tema için birincil rengin daha açık bir tonu olabilir.
val PurpleGrey80 = Color(0xFFCCC2DC) // Açık tema için ikincil veya yüzey renklerinden biri olabilir.
val Pink80 = Color(0xFFEFB8C8) // Açık tema için üçüncül veya vurgu rengi olabilir.

// val Green80 = Color(0xFFB1F0B0) // Örnek: Yeni bir renk ekleyebilirsiniz.

// Koyu tema için kullanılan renkler veya açık tema için ana renkler.
// val Purple40 = Color(0xFF6650a4) // Orijinal Birincil renk (Primary).
val Purple40 = Color(0xFF00695C) // Örnek Değişiklik: Birincil rengi Teal Green yaptık.
                                 // Bu değişiklik Theme.kt'deki LightColorScheme'i ve dolayısıyla
                                 // ThemingDemoComposable preview'ındaki birincil renkleri etkileyecektir.
val PurpleGrey40 = Color(0xFF625b71) // İkincil veya yüzey renklerinden biri.
val Pink40 = Color(0xFF7D5260) // Üçüncül veya vurgu rengi.

// Örnek: Bir rengi değiştirelim. `Purple40`'ı bir yeşil tonu yapalım.
// Bu değişiklik, `Theme.kt` dosyasındaki `lightColorScheme`'de `primary` olarak kullanılıyorsa,
// uygulamanın birincil rengini etkileyecektir.
// val YesilPrimary = Color(0xFF2E7D32) // Koyu Yeşil
// val Purple40 = YesilPrimary // Purple40 yerine YesilPrimary kullanılsın.
// Yorum satırını kaldırıp denemek için yukarıdaki iki satırı aktif edebilirsiniz.
// Orijinal Purple40'ı geri almak için bu satırları tekrar yorum satırı yapın.
// NOT: Yukarıdaki değişiklik (Purple40 = Color(0xFF00695C)) zaten bu konsepti göstermektedir.