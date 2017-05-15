import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.graphx.{Edge, Graph}

/**
  * Created by seyz on 15/05/17.
  */
object Main extends App {
  val sparkConf = new SparkConf()
    .setAppName("Simple Application")
    .setMaster("local[*]")

  val sparkContext = new SparkContext(sparkConf)
  sparkContext.setLogLevel("ERROR")

  val vertices = sparkContext.makeRDD(Array((1L, 0), (2L, 0), (3L, 0), (4L, 0), (5L, 0), (6L, 0)))

  val edges = sparkContext.makeRDD(Array(
    Edge(1L, 2L, ""), Edge(1L, 3L, ""), Edge(1L, 6L, ""),
    Edge(2L, 3L, ""), Edge(2L, 4L, ""), Edge(2L, 5L, ""),
    Edge(3L, 5L, ""),
    Edge(4L, 6L, ""),
    Edge(5L, 6L, "")))

  val graph = Graph(vertices, edges)
}
