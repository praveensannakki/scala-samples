package com.examples.leetcode

object ArrayToBCD {

  // Function to convert a decimal digit to BCD format
  def decimalToBCD(digit: Int): String = {
    val binary = digit.toBinaryString // Convert the decimal digit to binary
    println(binary)
    val paddedBinary = binary.reverse.padTo(4, '0').reverse // Pad with leading zeros to ensure four bits
    paddedBinary
  }

  // Function to convert an array of numbers to BCD format
  def arrayToBCD(arr: Array[Int]): String = {
    val bcdArray = arr.map(decimalToBCD) // Convert each digit in the array to BCD format
    bcdArray.mkString // Concatenate the BCD representations together
  }

  def digitsToBinary(digit: Int): String = {
    val binary:Array[Char] = new Array(4)
    for(i<- 0 until 4) {
      //binary(3-i) = if((digit & (1<< i) !=0)) '1' else '0'
      binary.mkString
    }
    binary.mkString
  }

  def main(args: Array[String]): Unit = {
    var bcdOut = arrayToBCD(Array(1, 2, 3, 4, 5))
    println("BCD representation:", bcdOut)
  }
}
