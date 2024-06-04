package com.spark.test

import org.apache.spark.sql._

object CVSCode {
  
  case class Metrix(a: Integer, b: Integer, c: Integer)
  
   def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
                              .master("local[*]")
                              .appName("JSON DF")
                              .getOrCreate()
                              
        spark.sparkContext.setLogLevel("ERROR")
        
        /**
         * Query to find employee whi is earning more than their managers
         */
        
        import spark.implicits._
    
     val metrix = Seq(
      Metrix(1,2,3),
      Metrix(4,5,6),
      Metrix(7,8,9)
    )
    
    val m = spark.sparkContext.parallelize(metrix, 4).toDF()
    
    m.printSchema()
  }
  
}