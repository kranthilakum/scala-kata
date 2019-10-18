// Find the Kth element of a list
def findElement[A](index: Int, elements: List[A]): Any = elements match {
  case Nil => None
  case head :: tail => {
    try {
      if (index == 1) {
        head
      } else {
        tail(index)
      }
    } catch {
      case e: IndexOutOfBoundsException => println("invalid index")
      case _: Throwable => print("error")
    }
  }
}

findElement(1, List(1, 2, 3))
findElement(1, List("John", "Jack", "Jose"))
findElement(3, List(1, 2, 3, 4, 5))
findElement(2, List("John", "Jack", "Jose"))
