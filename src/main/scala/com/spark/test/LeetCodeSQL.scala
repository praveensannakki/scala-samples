package com.spark.test

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object LeetCodeSQL {
  
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
                              .master("local[*]")
                              .appName("Sample DF")
                              .getOrCreate()
                              
        spark.sparkContext.setLogLevel("ERROR")
        
        /**
         * Query to find employee whi is earning more than their managers
         */
        
        val emp = spark.read.option("header", "true")
                            .option("inferschema", "true")
                            .option("delimiter", "|")
                            .csv("sample_data/emp_earnings.csv")
            
            if(emp.rdd.isEmpty()){
              println("Empty Dataframe")
                return 1;
            }
    
    //select sale_date, (YEAR(NOW()) -year(sale_date) ) as age
    
           emp.printSchema()
           
           emp.createOrReplaceTempView("emp")
           
           spark.sql("""select e1.name as emp_name 
                        from 
                        emp e1, emp e2 where e1.managerid=e2.id
                        and e1.salary> e2.salary""").show(false)
                        
          //emp.write.csv("/")
  }
  
}