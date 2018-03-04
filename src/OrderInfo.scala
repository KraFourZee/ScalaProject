//read in data about customers and such, fill and print out in order using sort functions
import scala.io.Source
import scala.collection.mutable.ListBuffer
import java.io.{FileNotFoundException, IOException}


// Scala favors immutibility, so making case classes like this helps insure no loophole entry like in Java final's
// Classes for a user with thier orders and products
case class User(firstName: String, lastName: String,number: String)

object OrderInfo {
	def main(args: Array[String]){

		var users = new ListBuffer[User]()
		val filename = "../users.txt" // error handling on file that doesn't exist.. if you want to see this change it to something wrong!
		try {
			for (line <- Source.fromFile(filename).getLines) {
				val inputLine = line.split("\\s+")
				val user = new User(inputLine(0), inputLine(1), inputLine(2))
				users += user
			}
		} catch {
			case e: FileNotFoundException => println("Couldn't find that file.")
			case e: IOException => println("Got an IOException!")
		}

		println("Users by last name as read in:")
		val usersList = users.toList //toList is used to change the ListBuffer to just a list after you're done adding to it
		for (n <- usersList) {
			println(n.lastName)
		}

		println("\nUsers by last name after being sorted:")
		val sortedNames = sortedCustomerNames(usersList)
		for (u <- sortedNames) {
			println(u)
		}
	}

	// very small function that takes in a list of users and maps the sorted last names and returns them.
	def sortedCustomerNames(users: List[User]): List[String] =
  	  users.map(c => c.lastName).sorted
}
