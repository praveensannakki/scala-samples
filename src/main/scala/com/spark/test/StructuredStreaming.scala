package com.spark.test

import org.apache.spark.sql.SparkSession

//https://www.hpe.com/psnow/resources/ebooks/a00110181en_us_v11/Spark/StructuredStreamingWordCountApplication_2.html

object StructuredStreaming extends App {

  val spark = SparkSession
    .builder()
    .appName("Spark Structured Streaming Example")
    .master("local[4]")
    .getOrCreate()

  import spark.implicits._

  val df = spark
    .readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", "localhost:9092")
    .option("subscribe", "spark_sql_test_topic")
    .load()

  val values = df.selectExpr("CAST(value AS STRING)").as[String]

//  values.writeStream
//    .trigger(ProcessingTime("5 seconds"))
//    .outputMode("append")
//    .format("console")
//    .start()
//    .awaitTermination()

  val wordCounts = values.flatMap(_.split(" ")).groupBy("value").count()
  //Run the query that prints the running counts to the console
  val query = wordCounts.writeStream
    .outputMode("complete")
    .format("console")
    .option("checkpointLocation", "checkpointLocation")
    .start()

  query.awaitTermination()
}
