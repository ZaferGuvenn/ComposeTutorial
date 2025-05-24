package com.composemovie2.composetutorial

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * TutorialViewModel, UI ile ilgili verileri ve iş mantığını yönetmek için tasarlanmış bir ViewModel'dir.
 * ViewModel'lar, Android yaşam döngüsüne duyarlı bir şekilde veri tutarlar, yani yapılandırma
 * değişikliklerinde (örneğin ekran döndürme) verilerin kaybolmasını önlerler.
 *
 * Bu ViewModel, basit bir sayaç durumunu (count) yönetir.
 */
class TutorialViewModel : ViewModel() {

    // _count, sayacın mevcut değerini tutan özel (private) bir MutableStateFlow'dur.
    // MutableStateFlow, değeri güncellenebilen bir state flow'dur.
    // ViewModel dışından doğrudan değiştirilmemesi için private olarak işaretlenmiştir.
    // Başlangıç değeri 0'dır.
    private val _count = MutableStateFlow(0)

    // count, ViewModel dışından gözlemlenebilen, değişmez (immutable) bir StateFlow'dur.
    // Composable'lar bu StateFlow'u dinleyerek UI'larını güncelleyebilirler.
    // .asStateFlow() ile MutableStateFlow'dan immutable bir StateFlow elde edilir.
    // Bu, state'in sadece ViewModel içerisinden değiştirilebilmesini garanti eder (Encapsulation).
    val count: StateFlow<Int> = _count.asStateFlow()

    /**
     * incrementCount fonksiyonu, sayacın değerini bir artırır.
     * Bu fonksiyon, UI tarafından (örneğin bir buton tıklamasıyla) çağrılabilir.
     *
     * _count.update { currentState -> currentState + 1 } ifadesi, StateFlow'un değerini
     * atomik (thread-safe) bir şekilde günceller. Önceki durumu alır ve yeni durumu döndürür.
     */
    fun incrementCount() {
        _count.update { currentCount ->
            currentCount + 1
        }
        // Alternatif olarak: _count.value = _count.value + 1 de kullanılabilir,
        // ancak .update daha karmaşık state'ler ve eşzamanlılık durumları için daha güvenlidir.
    }

    // ViewModel temizlendiğinde (associated Activity/Fragment yok edildiğinde) çağrılır.
    // Kaynakları serbest bırakmak için kullanılabilir. Bu basit örnekte gerekmiyor.
    // override fun onCleared() {
    //     super.onCleared()
    // }
}
