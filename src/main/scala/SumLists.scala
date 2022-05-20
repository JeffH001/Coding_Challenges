import scala.collection.mutable.ListBuffer

/* Coding challenge:

	Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
	The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
	function that adds the two numbers and returns the sum as a linked list.

	EXAMPLE
	Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
	Output: 2 -> 1 -> 9. That is, 912.

	FOLLOW UP
	Suppose the digits are stored in forward order. Repeat the above problem.
	Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
	Output: 9 -> 1 -> 2. That is, 912.
*/
object SumLists {
	/**
	  * Takes an integer and converts it to a list of integers in reverse order.
	  * For example: 1234 -> List(4, 3, 2, 1)
	  *
	  * @param x	Integer to be converted.
	  * @return		Reversed list of numbers within the integer.
	  */
	def intToReverseList(x: Int): List[Int] = {
		var ret = ListBuffer.empty[Int]
		var value = x
		while (value > 0) {
			ret += value % 10  // Adds the current last digit of an integer to the end of the list
			value /= 10  // Removes the last digit
		}
		ret.toList
	}

	/**
	  * Takes an integer and converts it to a list of integers.
	  * For example: 1234 -> List(1, 2, 3, 4)
	  *
	  * @param x	Integer to be converted.
	  * @return		List of numbers within the integer.
	  */
	def intToList(x: Int): List[Int] = {
		var ret = ListBuffer.empty[Int]
		var value = x
		while (value > 0) {
			ret.prepend(value % 10)  // Adds the current last digit of an integer to the front of the list
			value /= 10  // Removes the last digit
		}
		ret.toList
	}

	/**
	  * Takes two lists of integers and converts then into the digits in an integer in reverse order,
	  * sums those two integers, and returns the sum as a reversed list of the sum's digits.
	  *
	  * @param listA
	  * @param listB
	  * @return
	  */
	def reverse(listA: List[Int], listB: List[Int]): List[Int] = {
		val valA = listA.foldRight(0)((x, y) => (y * 10) + x)  // Turns the reversed integer list into a single integer
		val valB = listB.foldRight(0)((x, y) => (y * 10) + x)
		var sum = valA + valB  // Sums the two integers
		// println(s"A: $valA\nB: $valB\nSum: $sum")  // Test code to verify everything works
		intToReverseList(sum)  // Returns the sum as a reverse order integer list
	}

	/**
	  * Takes two lists of integers and converts then into the digits in an integer,
	  * sums those two integers, and returns the sum as a list of the sum's digits.
	  *
	  * @param listA
	  * @param listB
	  * @return
	  */
	def forward(listA: List[Int], listB: List[Int]): List[Int] = {
		val valA = listA.foldLeft(0)((x, y) => (x * 10) + y)  // Turns the integer list into a single integer
		val valB = listB.foldLeft(0)((x, y) => (x * 10) + y)
		var sum = valA + valB  // Sums the two integers
		// println(s"A: $valA\nB: $valB\nSum: $sum")  // Test code to verify everything works
		intToList(sum)  // Returns the sum as an integer list
	}

	/**
	  * Tests the SumLists function.
	  *
	  * @param args
	  */
	def main(args: Array[String]): Unit = {
		// Reverse lists
		println("Reverse List: " + reverse(List(7, 1, 6), List(5, 9, 2)))
		println("Int to Reverse List: " + reverse(intToReverseList(617), intToReverseList(295)))

		// Forward lists
		println("\nList: " + forward(List(6, 1, 7), List(2, 9, 5)))
		println("Int to List: " + forward(intToList(617), intToList(295)))
	}
}