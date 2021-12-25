package utils

import app.App

class CalcUtils {
    //Menghitung total dari ArrayList nilai
    fun calculateTotal(totalScore: ArrayList<Int>): Int {
        var total: Int = 0
        for (score in totalScore) { //bisa juga menggunakan method bawaan Kotlin
            total += score
        }
        return total
    }

    //Rata-rata dari ArrayList nilai
    fun calculateMean(totalScore: ArrayList<Int>, maxData: Int): Double{
        var total: Int = 0
        totalScore.forEach { score ->
            total += score
        }
        return total.toDouble()/maxData
    }
}