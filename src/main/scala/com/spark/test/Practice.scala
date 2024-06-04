package com.spark.test

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object Practice {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("Practice DF")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val df = spark.read.format("com.databricks.spark.csv").option("header", "true").option("delimiter", ",")
      .option("inferschema", "true").load("sample_data/180.csv")

    spark.read.format("csv").options(Map("header"->"true","delimiter" ->",","inferSchema" ->"true"))
      .load("sample_data/180.csv").show(false)

    df.show(false)
    df.createOrReplaceTempView("temp")

    val step = spark.sql("""WITH consecutive_numbers AS (
  SELECT id, num,
    LAG(num, 2) OVER (ORDER BY id) AS num_l2,
    LAG(num, 1) OVER (ORDER BY id) AS num_l1,
    LEAD(num, 1) OVER (ORDER BY id) AS num_r1,
    LEAD(num, 2) OVER (ORDER BY id) AS num_r2
  FROM temp
)
select * from consecutive_numbers
""")

    step.show()

    step.createOrReplaceTempView("step")

    spark.sql("""SELECT distinct num as ConsecutiveNums
FROM step
WHERE num = num_l1 AND num = num_l2
   OR num = num_r1 AND num = num_r2""").show()
   
   spark.sql("""select a1.*,a2.* from temp a1 join temp a2 on a1.id=a2.id-1 and a1.num=a2.num""").show()
   
   spark.sql("""SELECT 
a1.*,a2.*,a3.*
--DISTINCT a1.Num AS ConsecutiveNums
FROM temp a1
JOIN temp a2
 ON a2.id = a1.id + 1
 AND a1.Num = a2.Num
JOIN temp a3
 ON a3.id = a1.id + 2
 AND a1.Num = a3.Num""").show()
  }
}