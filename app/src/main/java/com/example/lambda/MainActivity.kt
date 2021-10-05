package com.example.lambda

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var tvname: TextView
    lateinit var tvrA: TextView
    lateinit var tvcA: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        tvname = findViewById(R.id.tvname)
        tvrA = findViewById(R.id.tvrA)
        tvcA = findViewById(R.id.tvcA)

        //Find one function (with no parameters) you have used in the past and rewrite it using a lambda expression
        // Lambda
        val changeColor = { textView.text = getString(R.string.name) }
        changeColor()

        // Function
//        fun changeColorFun(){
//            textView.text = getString(R.string.name)
//        }
//        changeColorFun()
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Find two functions that take in one or more parameters and rewrite them using a lambda expression
        val allowed = listOf("Amal", "Ahmad", "Sam")

        val access = { name:String ->
            if(allowed.contains(name))
                tvname.text = "Hello $name" }

        access("Sam")

        // Function
//        fun accessFun(name: String){
//            if(allowed.contains(name))
//                tvname.text = "Hello $name"
//        }
//        accessFun("Sam")

        // Lambda
        val rectangleArea  = { a: Int, b: Int -> a * b }
        val area = rectangleArea(4, 5).toString()
        tvrA.text = "rectangle Area = $area"
        Log.d("Main","rectangle Area = $area")

        // Function
//        fun rectangleAreaFun(a: Int, b: Int): Int{
//            return a * b
//        }
//        val areafromfun = rectangleAreaFun(4, 5).toString()
//        Log.d("Main","rectangle Area (fun) = $area")
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Find two functions that return a value and rewrite them using a lambda expression
        // Lambda
        val circleArea = {  radius: Double ->
            val cArea = 3.14159 * radius * radius
            cArea.toString()}
        val Area = circleArea(3.5)
        tvcA.text = "rectangle area = $Area"

        // Function
//        fun circleAreaFun (radius: Double)  : Double {
//            val cArea = 3.14159 * radius * radius
//            return cArea
//        }
//        Log.d("Main","circle area (fun) = ${circleAreaFun (1.5)}")

        // Lambda
        val Grade = { grade : Int ->
                var Evaluation =""
                if (grade < 0 || grade > 10) {
                    Evaluation = "Error"
                    Evaluation.toString()
                } else if (grade <= 4) {
                    Evaluation = "Fail"
                    Evaluation.toString()
                } else if (grade <= 7) {
                    Evaluation = "Pass"
                    Evaluation.toString()
                }else {
                    Evaluation = "Excellent"
                    Evaluation.toString()
                }
        }
        Log.d("Main", " ${Grade(8)} " )

        // Function
//        fun GradeFun(grade: Int): String{
//            var Evaluation =""
//            if (grade < 0 || grade > 10) {
//                Evaluation = "Error"
//            } else if (grade <= 4) {
//                Evaluation = "Fail"
//            } else if (grade <= 7) {
//                Evaluation = "Pass"
//            }else {
//                Evaluation = "Excellent"
//            }
//            return Evaluation
//        }
//        Log.d("Main", " ${GradeFun(5)} " )
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        Make use of a data class to create a Player class with attributes name, age, height (in cm)
//        Create a list of 20 players
//        Use a lambda expression to sort and print the list by each attribute

        // Lambda
        data class Playerdata(val name: String, val age: Int, val height: Int)
            val players = listOf(
                                  Playerdata("a",17,180),
                                  Playerdata("b",17,182),
                                  Playerdata("c",18,183),
                                  Playerdata("d",18,181),
                                  Playerdata("e",18,188),
                                  Playerdata("f",19,189),
                                  Playerdata("g",19,179),
                                  Playerdata("h",19,187),
                                  Playerdata("i",20,186),
                                  Playerdata("j",20,180),
                                  Playerdata("k",21,178),
                                  Playerdata("l",21,179),
                                  Playerdata("m",21,190),
                                  Playerdata("n",22,182),
                                  Playerdata("o",17,183),
                                  Playerdata("p",18,187),
                                  Playerdata("q",19,185),
                                  Playerdata("r",17,188),
                                  Playerdata("s",20,177),
                                  Playerdata("t",17,183))


        val playermaxheight = players.maxByOrNull { it.height }
        Log.d("Main","${playermaxheight!!.name} is the tallest!")

        val playerOldest = players.maxByOrNull { it.age }
        Log.d("Main","${playerOldest!!.name} is the oldest!")

        // Function

        fun playermaxheight(): String{
           val playertallest = players.maxByOrNull { it.height }
            val nameOfplayertallest = playertallest!!.name

           return nameOfplayertallest
        }
        fun playeroldest(): String {
            val Oldestplayer = players.maxByOrNull { it.age }
            val nameOfOldestplayer = Oldestplayer!!.name

            return nameOfOldestplayer
        }

        Log.d("Main","${playermaxheight()} is the tallest!")

        Log.d("Main","${playeroldest()} is the tallest!")



    }
}