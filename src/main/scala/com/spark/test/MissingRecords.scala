package com.spark.test

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MissingRecords {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local[*]").appName(this.getClass.getSimpleName).config("SPARK_MAJOR_VERSION", "2").getOrCreate()

    val lookupFile = spark.read.format("csv").option("header", "false").option("delimiter", "~").load(args { 0 }).rdd.map(_.mkString(",")).collect()
    
    //lookupFile.foreach(println)
    spark.udf.register("get_file_name", (path: String) => path.split("/").last.split("\\.").head)
    
    val data=spark.read.format("csv").option("header","false").option("delimiter","~").load(args {1} )//.rdd.map(_.mkString(","))
             .withColumn("fileName", callUDF("get_file_name", input_file_name())).rdd.map(_.mkString(","))
             
    data.cache()
    
    lookupFile.foreach(x =>{
         val out = data.filter(line => line.contains(x)).map(line => (x,line))
         if(!out.isEmpty()){
           out.coalesce(1).saveAsTextFile(args {2} + "/" +x)
         //out.collect().foreach(println)
         }
       })
  }
}