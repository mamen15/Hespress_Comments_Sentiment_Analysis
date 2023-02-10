package com.hespresscomments

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object Spark extends App {

    // Create Spark session
    val spark = SparkSession.builder().appName("KafkaToSparkStreaming").master("spark.master").getOrCreate()

    // Define the schema for the JSON data
    val schema = new StructType()
      .add("author", StringType)
      .add("date", StringType)
      .add("text", StringType)


    // Read data from Kafka
    val df = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "comments")
      .option("startingOffsets", "earliest")
      .load()
      .select(from_json(col("value").cast("string"), schema).as("data"))
      .select("data.*")

    // Write the data frame to MongoDB
    df.write
      .format("com.mongodb.spark.sql.DefaultSource")
      .option("uri", "mongodb://localhost:27017/db_name.collection_name")
      .mode("overwrite")
      .save()

    // Stop the Spark session
    spark.stop()

}



