package com.example.ud06_3_hanged

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words = listOf("Calamar", "Android", "Caballo", "Despiste", "Sabela", "Error")
    var targetWord = words.random().uppercase()
    var targetWordHidden = MutableLiveData<String>()
    var lives = MutableLiveData<Int>(7)
    var attempts = mutableListOf<Char>()
    init {
        targetWordHidden.value = showTargetWordHidden()
    }
    fun showTargetWordHidden() =
        targetWord.map {
            if (it in attempts) it
            else '_'
        }.joinToString {" "}


    fun guess(charAttempt : Char){
        attempts.add(charAttempt.uppercaseChar())
        targetWordHidden.value = showTargetWordHidden()
        if (!targetWord.contains(charAttempt.uppercaseChar())) lives.value = lives.value?.minus(1)
    }

    fun resultMessage() =
        if (win()) "Ganaste!"
        else "Perdiste! \n La palabra secreta era $targetWord"

    fun restart(){
        attempts.clear()
        lives.value = 7
        targetWord = words.random().uppercase()
        targetWordHidden.value = showTargetWordHidden()
    }

    fun win() = targetWord == targetWordHidden.value

    fun lost() = lives.value?:0 <= 0
}
