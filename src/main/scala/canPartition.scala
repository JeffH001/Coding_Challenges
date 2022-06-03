object canPartition {
	/**
	  * Determines if one element of the array can be the product of all of the other digits in the array.
	  *
	  * @param A	Array of integers.
	  * @return		The array with each element's digits sorted.
	  */
	def apply(A: Array[Int]): Boolean = {
		val tot = A.product  // Multiplies all the values in the array together
		val min = A.min
		val max = A.max
		tot / min == min || tot / max == max  // Returns whether the largest or smallest value in the array is the square root of the product of all digits
	}

	/**
	  * Tests the canPartition function.
	  *
	  * @param args
	  */
	def main(args: Array[String]): Unit = {
		println(canPartition(Array(2, 8, 4, 1)))			// Should return true (since 1 * 2 * 4 = 8)
		println(canPartition(Array(-1, -10, 1, -2, 20)))	// Should return false
		println(canPartition(Array(-1, -20, 5, -1, -2, 2)))	// Should return true
	}
}