package com.firstwebexample.components

fun calculate(sub1 : Int, sub2 : Int, sub3 : Int) : String
{
    if(sub1 < 0 || sub2 < 0 || sub3 < 0) return "Invalid Input"

    val totalMarks = (sub1 + sub2 + sub3) / 3

    val output = when(totalMarks)
    {
       in 0..35 -> "GRADE : D"
       in 36..50 -> "GRADE : C"
       in 51..70 -> "GRADE : B"
       else -> "GRADE : A"
    }

    return "You Scored ${(totalMarks*3*100/300).toFloat()}% \n and got $output"
}
