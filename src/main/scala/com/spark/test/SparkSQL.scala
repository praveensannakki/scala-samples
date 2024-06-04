package com.spark.test

import org.apache.spark.sql.SparkSession

object SparkSQL {

  case class Cust(id: Integer, name: String, sales: Double, discount: Double, state: String)
  
  def main(args: Array[String]): Unit = {

    val spark =
      SparkSession.builder()
        .appName("DataFrame-Basic")
        .master("local[4]")
        .getOrCreate()

    import spark.implicits._
    
     val custs = Seq(
      Cust(1, "Widget Co", 120000.00, 0.00, "AZ"),
      Cust(2, "Acme Widgets", 410500.00, 500.00, "CA"),
      Cust(3, "Widgetry", 410500.00, 200.00, "CA"),
      Cust(4, "Widgets R Us", 410500.00, 0.0, "CA"),
      Cust(5, "Ye Olde Widgete", 500.00, 0.0, "MA")
    )
    // make it an RDD and convert to a DataFrame
    val customerDF = spark.sparkContext.parallelize(custs, 4).toDF()
    
    println(">>>>>>>>> " + customerDF.count())
    
    
    spark.udf.register("get_file_name", (path: String) => path.split("/").last.split("\\.").head)
    
    val customers = spark.read
         .format("csv")
         .option("header", "true") //first line in file has headers
         .option("mode", "DROPMALFORMED")
         .option("delimiter", "|")
         .load(args{0})
         
   val orders = spark.read
         .format("csv")
         .option("header", "true") //first line in file has headers
         .option("mode", "DROPMALFORMED")
         .option("delimiter", "|")
         .load(args{1})
         
    customers.show(false)
    customers.printSchema()
    
    orders.show()
    orders.printSchema()
  }
}