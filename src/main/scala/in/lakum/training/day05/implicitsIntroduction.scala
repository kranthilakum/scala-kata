package in.lakum.training.day05;

object implicitsIntroduction extends App {
  val pair = "Jackson" -> "999"
  val intPair = 1 -> 2
  case class Person(name: String) {
    def greet = s"Hi, my name is ${name}"
  }
  implicit def fromStringToPerson(str: String): Person = Person(str)
  print("Micheal".greet)

  def increment(x: Int)(implicit amt: Int) = x + amt
  implicit val defaultAmount = 10
}
