package com.example.myemptyactivity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyStudyViewModel : ViewModel() {
    val text: MutableState<String> = mutableStateOf<String>("")
    val image: MutableState<Int> = mutableIntStateOf(R.drawable.myang1)

    fun changeName(name: String) {
        text.value = "내 이름은 ${name}!"
        when(name) {
            "윤석열" -> image.value = R.drawable.yun
            "이재명" -> image.value = R.drawable.lee
            "최순실" -> image.value = R.drawable.pig
            "공명" -> image.value = R.drawable.gong
            else -> image.value=R.drawable.myang1
        }
    }
}