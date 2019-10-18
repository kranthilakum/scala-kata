// Compute all pairs of numbers between 0 and n-1 whose sum is equal to a given value

// for comprehension using yield statement
def sumPairs(n: Int, v: Int): Unit = {
  val result = for {
    i <- 0 until n
    j <- 0 until n if i + j == v
  } yield (i, j)
  result.foreach {
    case (i, j) => print(i, j)
  }
}
sumPairs(10, 10)
