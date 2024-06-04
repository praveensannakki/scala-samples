package com.spark.test

import java.text.SimpleDateFormat

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{SparkConf, TaskContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

object KafkaStreams extends App {

  val date_today = new SimpleDateFormat("yyyy_MM_dd");
  val date_today_hour = new SimpleDateFormat("yyyy_MM_dd_HH");
  val PATH_SEPERATOR = "/";

  override def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println(s"""
                            |Usage: KafkaStreams path to the configuration file
                            |
        """.stripMargin)
      System.exit(1)
    }

    //    val conf = ConfigFactory.parseFile(new File(args { 0 }))

    //    println( conf.getString("hive.driver"))

    val Array(brokers, zookeeper, topics, consumergroups, duration, autoOffset, autoCommit, outputPathBasePath) = args

    // Create context with custom second batch interval
    val sparkConf = new SparkConf().setAppName("KafkaStreams")
    val ssc = new StreamingContext(sparkConf, Seconds(duration.toLong))

    // Create direct kafka stream with brokers and topics
    val topicsSet = topics.split(",").toSet

    val topicList = topicsSet.toList

    //    val kafkaParams = Map[String, Object](
    //      "bootstrap.servers" -> conf.getString("kafka.brokers"),
    //      "zookeeper.connect" -> conf.getString("kafka.zookeeper"),
    //      "group.id" -> conf.getString("kafka.consumergroups"),
    //      "auto.offset.reset" -> conf.getString("kafka.autoOffset"),
    //      "enable.auto.commit" -> (conf.getString("kafka.autoCommit").toBoolean : java.lang.Boolean),
    //      "key.deserializer" -> classOf[StringDeserializer],
    //      "value.deserializer" -> classOf[StringDeserializer],
    //      "security.protocol" -> "SASL_PLAINTEXT")

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> brokers,
      "zookeeper.connect" -> zookeeper,
      "group.id" -> consumergroups,
      "auto.offset.reset" -> autoOffset,
      "enable.auto.commit" -> (autoCommit.toBoolean: java.lang.Boolean),
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "security.protocol" -> "SASL_PLAINTEXT")

    val messages = KafkaUtils.createDirectStream[String, String](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](topicsSet, kafkaParams))

    for (i <- 0 until topicList.length) {
      //      val topicStream = filterStreams(messages, topicList(i));
      val topicStream = messages.filter(_.topic().equals(topicList(i)))

      topicStream.foreachRDD((rdd, batchTime) => {
        val data = rdd.map(_.value())
        if (!data.isEmpty()) {
          data.saveAsTextFile(outputPathBasePath + PATH_SEPERATOR + topicList(i) + PATH_SEPERATOR + date_today.format(batchTime.milliseconds)
            + PATH_SEPERATOR + date_today_hour.format(batchTime.milliseconds) + PATH_SEPERATOR + batchTime.milliseconds)
        }
      })
    }

    // After all successful processing, commit the offsets to kafka
    messages.foreachRDD { rdd =>
      val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      messages.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
    }

  }

}