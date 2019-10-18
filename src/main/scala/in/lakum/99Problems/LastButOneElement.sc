// Find the last but one (penultimate) element of a list
def lastButOneElement[A](elements: List[A]): Any = elements.takeRight(2).head

lastButOneElement(List(1, 2, 3))
lastButOneElement(List(1))
lastButOneElement(List("John", "Jack", "Jose"))
//lastButOneElement(List()) // Fix: gives out NoSuchElementException
