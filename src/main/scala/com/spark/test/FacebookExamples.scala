package com.spark.test

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext

object FacebookExamples {
  
  def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("SparkDfToList test").setMaster("local[*]")
        val sc = new SparkContext(conf) // An existing SparkContext.
        sc.setLogLevel("ERROR")
        val sqlContext = new SQLContext(sc)
        
        import sqlContext.implicits._
        
        //spark.sparkContext.setLogLevel("ERROR")
        
        val s = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferschema", "true").load("fb_data/salespersons.csv")
        s.printSchema()
        s.show()
        s.createOrReplaceTempView("salesperson")
        
        s.rdd.isEmpty()
        
        val c = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferschema", "true").load("fb_data/customer.csv")
        c.printSchema()
        c.show()
        c.createOrReplaceTempView("customer")
        
        val o = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferschema", "true").load("fb_data/orders.csv")
        o.printSchema()
        o.show()
        o.createOrReplaceTempView("orders")
        
        /**
         * The names of all salespeople that have an order with Samsonic.
         */
        sqlContext.sql(""" select s.name 
                        from 
                        orders o
                        left join
                        salesperson s
                        on 
                        o.salesperson_id=s.id
                        left join
                        customer c
                        on
                        o.cust_id=c.id
                        where
                        c.name='Samsonic'
                        """).show(false)
                        
        /**
         * The names of all salespeople that do not have any order with Samsonic
         */
        sqlContext.sql(""" select distinct s.name 
                        from 
                        salesperson s
                        left join
                        orders o
                        on 
                        o.salesperson_id=s.id
                        left join
                        customer c
                        on
                        o.cust_id=c.id
                        where
                        c.name!='Samsonic'
                        or o.salesperson_id is null
                        """).show(false)
                        
         /**
          * The names of salespeople that have 2 or more orders.
         */
        sqlContext.sql("""select s.name
                        from 
                        orders o
                        left join
                        salesperson s
                        on 
                        o.salesperson_id=s.id
                        group by s.name
                        having count(s.name) >=2
                        """).show(false)
                        
        /**
          * The names and ages of all salespersons must having a salary of 100,000 or greater.
         */
        sqlContext.sql("""select s.name,s.age
                        from 
                        salesperson s
                        where
                        s.salary > 100000
                        """).show(false)
        /**
          * What sales people have sold more than 1400 total units
         */
        sqlContext.sql("""select s.name
                        from 
                        orders o
                        left join
                        salesperson s
                        on 
                        o.salesperson_id=s.id
                        group by s.name
                        having sum(o.amount) >1400
                        """).show(false)    
         /**
          * When was the earliest and latest order made to Samony
         */
        sqlContext.sql("""select 
                        min(o.order_date) as min_date 
                        ,max(o.order_date) as max_date
                        from 
                        orders o
                        left join
                        customer c
                        on
                        o.cust_id=c.id
                        where
                        c.name='Samony'
                        """).show(false)    
                        
                     
  }
  
}