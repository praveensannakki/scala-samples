package com.spark.test

object Transpose {
  def main(args: Array[String]): Unit = {
    val in = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))

    //for (i <-  0 to in.length-1; j <- 0 to in(i).length-1) println(in(i)(j))
    println("Input metrix")
    displayMetrix(in)

    val out = transpose(in, in.size)
    println("After transpose")
    displayMetrix(out)
    
    transpose(in)
    println("After transpose without extra array")
    displayMetrix(in)

    //for (i <- 0 to out.length - 1; j <- 0 to out(i).length - 1) println(out(i)(j))
  }

  def transpose(in: Array[Array[Int]], size: Int): Array[Array[Int]] = {
    //var out = Array(Array(0, 0, 0), Array(0, 0, 0), Array(0, 0, 0))
    val out = Array.ofDim[Int](size,size) // we can use in.length
    
    for (i <- 0 to in.length - 1) {
      for (j <- 0 to in(i).length - 1) {
        out(i)(j) = in(j)(i)
      }
    }
    out
  }

  def transpose(in: Array[Array[Int]]): Array[Array[Int]] = {
    //val out = Array[Array[Int]] ()

    for (i <- 0 to in.length - 1) {
      for (j <- i+1 to in(i).length - 1) {
        var temp = in(i)(j)
        in(i)(j) = in(j)(i)
        in(j)(i) = temp
      }
    }
    in
  }
  
  def displayMetrix(m : Array[Array[Int]]) : Unit = {
    for (i <- 0 to m.length - 1) {
      for (j <- 0 to m(i).length - 1) {
        print(m(i)(j))
      }
      println()
    }
  }

}