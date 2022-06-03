object reorderDigits {
	/**
	  * Takes an array of integers and a string of "asc" or "desc" and returns the array
	  * with the digits within each element sorted ascending or descending, respectively.
	  *
	  * @param A	Array of integers.
	  * @param ord	Either "asc" or "desc" to indicate the sort order.
	  * @return		The array with each element's digits sorted.
	  */
	def apply(A: Array[Int], ord: String): Array[Int] = {
		var newArr = Array.empty[Char]
		var sortedArr = A
		for (i <- 0 to sortedArr.length - 1) {
			if (sortedArr(i) < 0 || sortedArr(i) > 9) {  // Only sort on multiple digits
				newArr = sortedArr(i).toString().toArray.sorted  // Convert to an array of char and then sort them
				if (ord != "asc")
					newArr = newArr.reverse  // Reverse the array if it's not an ascending sort
				sortedArr(i) = newArr.mkString.toInt  // Store the sorted array of char as an integer
			}
		}
		sortedArr  // Return the sorted digits array
	}

	/**
	  * Tests the reorderDigits function.
	  *
	  * @param args
	  */
	def main(args: Array[String]): Unit = {
		println("Array(" + reorderDigits(Array(515, 341, 98, 44, 211), "asc").mkString(", ") + ")")   // Should return Array(155, 134, 89, 44, 112)
		println("Array(" + reorderDigits(Array(515, 341, 98, 44, 211), "desc").mkString(", ") + ")")  // Should return Array(551, 431, 98, 44, 211)
		println("Array(" + reorderDigits(Array(63251, 78221), "asc").mkString(", ") + ")")   // Should return Array(12356, 12278)
		println("Array(" + reorderDigits(Array(63251, 78221), "desc").mkString(", ") + ")")  // Should return Array(65321, 87221)
		println("Array(" + reorderDigits(Array(1, 2, 3, 4), "asc").mkString(", ") + ")")   // Should return Array(1, 2, 3, 4)
	}
}