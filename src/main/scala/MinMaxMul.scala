object MinMaxMul {
	/**
	  * Takes an array of N elements and returns the minimum * maximum value of the elements
	  * in the array from the L'th element up to and including the R'th element.
	  *
	  * @param N	Array length.
	  * @param L	First element to include (array index + 1).
	  * @param R	Last element to include (array index + 1).
	  * @param A	Array of integers.
	  * @return		The minimum * maximum values of the sub-array.
	  */
	def apply(N: Int, L: Int, R: Int, A: Array[Int]): Int = {
		var newArr = Array.ofDim[Int](R - L + 1)    // New sub-array of correct length
		Array.copy(A, L - 1, newArr, 0, R - L + 1)  // Copies subgroup of elements to the new array
		newArr.min * newArr.max
	}

	/**
	  * Tests the SumLists function.
	  *
	  * @param args
	  */
	def main(args: Array[String]): Unit = {
		println("MinMaxMul = " + MinMaxMul(5, 2, 4, Array(1, 2, 3, 4, 5)))  // Should return 8 (because 2 * 4 = 8)
	}
}