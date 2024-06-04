package com.spark.test

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

import java.util.concurrent.TimeUnit

object MergeTableFiles {
  def main(args: Array[String]): Unit = {

    val startTime = System.currentTimeMillis()

    val spark = SparkSession.builder().config("SPARK_MAJOR_VERSION", "2").enableHiveSupport().getOrCreate()

    val tbldata = spark.sql(s"select * from $args{0}")
    var srcCount = tbldata.count
    tbldata.persist(StorageLevel.MEMORY_AND_DISK_SER)
    tbldata.write.mode("overwrite").saveAsTable(args { 1 })
    val tmpLoadTime = System.currentTimeMillis()

    println(s"saved the table $args{0} to $args{1} temp table, ")
    print("Time taken to load to temp table " + TimeUnit.MILLISECONDS.toMinutes(tmpLoadTime - startTime) + " Min, " +
      (TimeUnit.MILLISECONDS.toSeconds(tmpLoadTime - startTime) -
        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(tmpLoadTime - startTime))) + " Sec")

    val tgtTblData = spark.sql(s"select * from $args{1}")
    var tgtCount = tgtTblData.count
    if (srcCount == tgtCount) {
      tbldata.unpersist()
      tgtTblData.persist(StorageLevel.MEMORY_AND_DISK_SER)
      tgtTblData.createOrReplaceTempView("tgtTable")
      spark.sql(s""" insert overwrite table $args{0} select * from tgtTable """)
      println(s"compaction complete for table $args{0}, records inserted $tgtCount")
      tgtTblData.unpersist()

      spark.sql(s"drop table if exists $args { 1 }")

      val endTime = System.currentTimeMillis()
      println("End time : " + endTime)
      print("Time taken to complete compactoin " + TimeUnit.MILLISECONDS.toMinutes(endTime - startTime) + " Min, " +
        (TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) -
          TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(endTime - startTime))) + " Sec")
    } else {
      spark.sql(s"drop table if exists $args { 1 }")
      println(s"Source count $srcCount and taget count $tgtCount did not match")
    }
  }
}