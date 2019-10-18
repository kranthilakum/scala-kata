// Last Element of a List

// Find the last element of a list - solution 001
def lastElement001[A](elements: List[A]): A = elements.last

// Find the last element of a list - solution 002
def lastElement002[A](elements: List[A]): Any = elements match {
  case Nil => None
  case x :: Nil => Some(x)
  case _ :: rest => rest.last
}

lastElement001(List(1, 2, 3, 4, 5))
lastElement001(List(1, 2, 3))
lastElement001(List(1))
lastElement001(List("John", "Jack", "Jose"))
// lastElement001(List()) // gives out NoSuchElementException

lastElement002(List(1, 2, 3))
lastElement002(List(1))
lastElement001(List("John", "Jack", "Jose"))
lastElement002(List())
