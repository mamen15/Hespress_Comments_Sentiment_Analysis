ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "spark_streaming"
  )

val sparkVersion = "3.3.1"


libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-streaming" % sparkVersion
libraryDependencies += "org.apache.kafka" %% "kafka" % "3.3.2"
libraryDependencies += "org.mongodb.spark" %% "mongo-spark-connector" % "10.1.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.12" % sparkVersion
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % sparkVersion
