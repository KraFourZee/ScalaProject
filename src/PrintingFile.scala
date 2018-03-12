import scala.io.Source
import java.io.{FileNotFoundException, IOException}

object PrintingFile extends App {
  //def main(args: Array[String]){
		val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
		println(fibs.take(10).toList)
	//}
}
