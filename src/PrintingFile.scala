import scala.io.Source
import java.io.{FileNotFoundException, IOException}

object PrintingFile {
  def main(args: Array[String]){
    val filename = "../random.txt" // error handling on file that doesn't exist.. if you want to see this change it to something wrong!
	try {
		for (line <- Source.fromFile(filename).getLines) {
			println(line)
		}
	} catch {
		case e: FileNotFoundException => println("Couldn't find that file.")
		case e: IOException => println("Got an IOException!")
	}
  }
}
