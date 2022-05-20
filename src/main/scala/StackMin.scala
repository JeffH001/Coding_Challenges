import scala.collection.mutable.ListBuffer

/* Coding challenge:

	Stack Min: How would you design a stack which, in addition to "push" and "pop", has a function
	"min" which returns the minimum element?  Push, pop, and min should all operate in O(1) time.
*/
object StackMin {
	var stackLen = 0  // The length of the stack
	var stackMin = 0  // The current minimum value in the stack
	var stack = ListBuffer.empty[Int]  // Tracks the values in the stack (head = most recently pushed value)
	var minList = ListBuffer.empty[Int]  // Tracks the minimum values in the stack (head = most recently pushed minimum value)

	/**
	  * An O(1) push implementation for a stack of integers.  Adds an element to the top of the stack.
	  *
	  * @param N	Integer to push to the stack.
	  * @return		The new length of the stack.
	  */
	def push(N: Int): Int = {
		if (stackLen == 0 || stackMin > N)  // Determine if a new minimum value is added to the stack
			stackMin = N
		if (stackMin == N)  // If the value pushed is equal to the current minimum value on the stack...
			minList.prepend(N)  // ...add that value to the front of minList
		stackLen += 1
		stack.prepend(N)  // Push value to the top of the stack
		stackLen
	}

	/**
	  * An O(1) pop implementation for a stack of integers.  Removes the top element off the stack.
	  *
	  * @return	The first integer on the stack as Option(value), or None if the stack is empty.
	  */
	def pop(): Option[Int] = {
		var ret = stack.headOption  // Gets the value at the top of the stack, if there is one
		if (ret != None) {  // See if the minimum needs to be changed
			val value = ret.get
			if (value == stackMin) {  // Value being popped is the current minimum value
				minList.remove(0)  // Remove the old minimum value from the list
				if (stackLen > 1)  // If the list isn't going to be empty after this pop...
					stackMin = minList.head  // ...get the new minimum value
			}
		}
		if (stackLen > 0) {
			stackLen -= 1
			stack.remove(0)  // Pop the value off the top of the stack (the .remove() method is only an O(1) operation for .remove(0))
		}
		ret
	}

	/**
	  * Gets the current length of the stack.
	  *
	  * @return	Stack length.
	  */
	def len(): Int = {
		stackLen
	}

	/**
	  * An O(1) implementation to get the current minimum value within the stack of integers.
	  *
	  * @return	The lowest integer value in the stack as Option(value), or None if the stack is empty.
	  */
	def min(): Option[Int] = {
		if (stackLen > 0)
			Option(stackMin)
		else
			None  // Stack is empty
	}

	/**
	  * Tests the StackMin object.
	  *
	  * @param args
	  */
	def main(args: Array[String]): Unit = {
		var result = pop()
		if (result == None)
			println("Pop: Stack is empty")
		else
			println("Pop: " + result.get)
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		println("Len: " + len())
		println("Push(5): len = " + push(5))
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		result = pop()
		if (result == None)
			println("Pop: Stack is empty")
		else
			println("Pop: " + result.get)
		println("Len: " + len())
		println("Push(5): len = " + push(5))
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		println("Push(7): len = " + push(7))
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		println("Push(2): len = " + push(2))
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		result = pop()
		if (result == None)
			println("Pop: Stack is empty")
		else
			println("Pop: " + result.get)
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		result = pop()
		if (result == None)
			println("Pop: Stack is empty")
		else
			println("Pop: " + result.get)
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		result = pop()
		if (result == None)
			println("Pop: Stack is empty")
		else
			println("Pop: " + result.get)
		println("Len: " + len())
		result = min()
		if (result == None)
			println("Min: Stack is empty")
		else
			println("Min: " + result.get)
		result = pop()
		if (result == None)
			println("Pop: Stack is empty")
		else
			println("Pop: " + result.get)
		println("Len: " + len())
	}
}
