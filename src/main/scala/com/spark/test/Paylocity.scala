package com.spark.test

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object Paylocity {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
                              .master("local[*]")
                              .appName("test")
                              .getOrCreate()
                              
        spark.sparkContext.setLogLevel("ERROR")

    val s = spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferschema", "true").load("sample_data/population")
    s.printSchema()
    s.show(false)
    s.createOrReplaceTempView("records")
    
    s.rdd.getNumPartitions

//    sqlContext.sql("""
//select year, sum(case when type='b' then 1 else -1 end) as total
// from records group by year order by year
//""").createOrReplaceTempView("temp")
//
//    sqlContext.sql("select * from temp").show(false)
//
//    sqlContext.sql("""select t1.year,t1.total, coalesce(sum(t2.total),t1.total) cumulative
//from temp t1
//left join temp t2
//on t1.year>t2.year
//group by t1.year""").show(false)
    
    spark.sql("""with temp as (
select year, sum(case when type='b' then 1 else -1 end) as total
 from records group by year
),
step2  as(
select t1.year, coalesce(sum(t2.total),t1.total) cumulative
from temp t1
left join temp t2
on t1.year>t2.year
group by t1.year
)
select year,coalesce(lead(cumulative) over(order by year),0) cnt
from step2
order by 2 desc,1 
limit 1""").show(false)

  }
}