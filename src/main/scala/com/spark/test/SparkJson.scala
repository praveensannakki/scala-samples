package com.spark.test

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

//https://medium.com/expedia-group-tech/working-with-json-in-apache-spark-1ecf553c2a8c

object SparkJson {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
                              .master("local[*]")
                              .appName("JSON DF")
                              .getOrCreate()
                              
        spark.sparkContext.setLogLevel("ERROR")

    val jsondata = """[
                  	{
                  		"id": "0001",
                  		"type": "donut",
                  		"name": "Cake",
                  		"ppu": 0.55,
                  		"batters":
                  			{
                  				"batter":
                  					[
                  						{ "id": "1001", "type": "Regular" },
                  						{ "id": "1002", "type": "Chocolate" },
                  						{ "id": "1003", "type": "Blueberry" },
                  						{ "id": "1004", "type": "Devil's Food" }
                  					]
                  			},
                  		"topping":
                  			[
                  				{ "id": "5001", "type": "None" },
                  				{ "id": "5002", "type": "Glazed" },
                  				{ "id": "5005", "type": "Sugar" },
                  				{ "id": "5007", "type": "Powdered Sugar" },
                  				{ "id": "5006", "type": "Chocolate with Sprinkles" },
                  				{ "id": "5003", "type": "Chocolate" },
                  				{ "id": "5004", "type": "Maple" }
                  			]
                  	},
                  	{
                  		"id": "0002",
                  		"type": "donut",
                  		"name": "Raised",
                  		"ppu": 0.55,
                  		"batters":
                  			{
                  				"batter":
                  					[
                  						{ "id": "1001", "type": "Regular" }
                  					]
                  			},
                  		"topping":
                  			[
                  				{ "id": "5001", "type": "None" },
                  				{ "id": "5002", "type": "Glazed" },
                  				{ "id": "5005", "type": "Sugar" },
                  				{ "id": "5003", "type": "Chocolate" },
                  				{ "id": "5004", "type": "Maple" }
                  			]
                  	},
                  	{
                  		"id": "0003",
                  		"type": "donut",
                  		"name": "Old Fashioned",
                  		"ppu": 0.55,
                  		"batters":
                  			{
                  				"batter":
                  					[
                  						{ "id": "1001", "type": "Regular" },
                  						{ "id": "1002", "type": "Chocolate" }
                  					]
                  			},
                  		"topping":
                  			[
                  				{ "id": "5001", "type": "None" },
                  				{ "id": "5002", "type": "Glazed" },
                  				{ "id": "5003", "type": "Chocolate" },
                  				{ "id": "5004", "type": "Maple" }
                  			]
                  	}
                  ]"""
    import spark.implicits._
    
    import org.apache.spark.sql.functions._

    val DF= spark.read.json(spark.createDataset(jsondata :: Nil))
    
    DF.printSchema()
    
    val jsonDF=spark.read.options(Map("multiLine"->"true","mode"->"PERMISSIVE")).json(Seq(jsondata).toDS)
    
    jsonDF.printSchema()
    
    jsonDF.withColumnRenamed("id", "key").select($"key", explode($"batters.batter").as("new_batter"))
          .select($"key",$"new_batter.*").withColumnRenamed("id", "bat_id").withColumnRenamed("type", "bat_type").show(false)
          
    jsonDF.withColumnRenamed("id", "key").withColumnRenamed("type", "head_type").select($"key",$"head_type",$"name",$"ppu", explode($"topping").as("top"))
          .select($"key",$"head_type",$"name",$"ppu",$"top.*").withColumnRenamed("id", "top_id").withColumnRenamed("type", "top_type").show(false)
  }

}