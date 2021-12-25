package app

import utils.CalcUtils

class App {
    private var maxData: Int = 0
    private var score: Int = 0
    private val scores = arrayListOf<Int>()

    fun run() {
        printHeader()
        inputScore()
        checkScoreList(scores)
        calculateScore()
    }

    private fun printHeader() {
        println("=============================================")
        println("Aplikasi Penghitung Rata-Rata Nilai Mahasiswa")
        println("=============================================")
    }

    private fun inputScore() {
        println("Masukkan Total Mahasiswa ?")
        maxData = try {
            readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            0
        }

        //Recursive If maxData != Int || maxData <=0
        if (maxData <= 0) {
            println("Input Total Mahasiswa salah, silahkan coba masukkan lagi!")
            inputScore()
        } else {
            for (i in 1..maxData) {
                println("Masukkan Nilai Mahasiswa Ke-$i")
                score = readLine()?.toInt() ?: 0
                scores.add(score)
            }
        }
    }

    private fun checkScoreList(scores: ArrayList<Int>) {
        for (i in 0 until scores.size) {
            while (scores[i] < 0 || scores[i] > 100) {
                println("Input nilai Mahasiswa ke-${i + 1} salah, silahkan masukkan lagi :")
                scores[i] = readLine()?.toInt() ?: 0
                checkScoreList(scores)
            }
        }
    }

    private fun calculateScore() {
        val utils = CalcUtils()
        println("=============================================")
        println("Total Mahasiswa = $maxData")
        println("Total Nilai = ${utils.calculateTotal(scores)}")
        println("Rata - Rata Nilai Mahasiswa = ${utils.calculateMean(scores, maxData)}")
        println("=============================================")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}