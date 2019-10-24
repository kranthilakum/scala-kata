/**
  * Pattern matching
  *
  * match is an expression, not a statement
  * match statements can be used with any types
  * patterns always match from top-to-bottom
  * guard clause pattern
  * patterns can match array, lists, tuples
  *
  * Scala extractor, apply, unapply, unapplySeq
  * https://www.journaldev.com/8270/scala-extractors-apply-unapply-and-pattern-matching
  *
  * use lowercase variable names as arguments; otherwise they will be treated as constants
  */

val anyKey = false
anyKey match {
  case x if x == true => print("Hello!")
  case _ => print("Anyway, Hello!")
}

val str = "ABC"
str(0) match {
  case '+' => print("plus sign")
  case '-' => print("minus sign")
  case c:Char if Character.isDigit(c) => print(Character.digit(c, 0))
  case c:Char if Character.isLetter(c) => print(Character.toLowerCase(c))
}

val obj:Any = "123232"
obj match {
  case x:Int => x
  case s:String => Integer.parseInt(s)
  case _:BigInt => Int.MaxValue
  case _ => 0
}

// to bind variable argument _* to a variable use @ notation
// for lists use cons operator
// val arr:Array[Int] = Array(0) // case 0
// val arr:Array[Int] = Array(1, 1) // case 1
// val arr:Array[Int] = Array(0, 1, 2) // case 2
val arr:Array[Int] = Array(10, 11, 12)
arr match {
  case Array(0) => "zero"
  case Array(x, y) => s"$x $y"
  case Array(0, _*) => "zero or more"
  case Array(x, rest@_*) => rest.min
  case _ => "something else"
}

//val lst:List[Int] = List(0) // case 0
//val lst:List[Int] = List(1, 2) // case 1
//val lst:List[Int] = List(0, 1, 2) // case 2
// val lst:List[Int] = List() // case 3
val lst:List[Int] = List(0, 1, 2)
lst match {
  case 0 :: Nil => "zero"
  case x :: y :: Nil => s"$x $y"
  case 0 :: tail => "zero or more"
  case _ => "something else"
}

val ingredient:(Any, Any) = ("Sugar" , 0)
ingredient match {
  case (0, _) => "zero"
  case (y, 0) => s"$y zero"
  case _ => "neither is zero"
}

val (x, y , z, w) = (1, 0.4, "hello", 'x')
print(s"$x $w")

// /% method returns a pair containing quotient and remainder
val xyz = Array(22, 23, 24, 25, 26)
val Array(first, second, rest@_*) = xyz
print(s"$first $rest")

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.util.Random
for((i, j) <- System.getProperties if j == "")
  println(s"$i --- $j")

// patterns in expressions
val map = Map("Andreas" -> 28,
  "Jonathan" -> "",
  "Alexander" -> 25)
// NOTE: in a for expression, match failures are silently ignored
// for-expression with pattern and guard
for((k, v) <- map if v == "")
  println(k)

// case classes are optimized for use in pattern matching
// case object is a singleton object
// use paranthesis with case class instances
// no parantheses are needed for case objects
abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount
val amt = "1123"
//amt match {
//  case Dollar(v) => s"$$$v"
//  case Currency(_, v) => s"$v"
//}

case class Person (name:String, age:Int)
val bob = Person("Bob", 24)
val greeting = bob match {
  case Person(n, a) if a < 21 => s"Hey! What's up!"
  case Person(n, a) => s"Hey! $n, How are ya doing?!"
  case _ => s"Howdy!"
}

// copy method and named parameters
val eur = Currency(29.4, "Euro")
println(eur.copy())

// match nested structures
abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description:String, discount: Double, items: Item*) extends Item
// no need to use new here
Bundle("Father's day special", 20.0)

// sealed class
// all subclasses of a sealed class must be defined in same file
// supresses warnings ???
// https://www.waitingforcode.com/scala-core/sealed-keyword-scala/read

// option type
//https://alvinalexander.com/scala/best-practice-option-some-none-pattern-scala-idioms
//https://alvinalexander.com/scala/using-scala-option-some-none-idiom-function-java-null
class Connection {
  def connect = "Connected"
}
object Connection {
  val random = new Random(System.nanoTime())

  def apply(host:String, port:String): Option[Connection] =
    if(random.nextBoolean()) Some(new Connection)
    else None
}
val config: Map[String, String] = Map(
  "host" -> "127.0.0.1",
  "port" -> "8080"
)
val host = config.get("host")
val port = config.get("port")

/**
  * partially applied function
  */
def div(x:Double, y:Double):Double = x/y
val inv = div(1, _:Double)
inv(10)

def sum(x:Int, y:Int) = x + y // function definition
val sum1 = sum(_:Int, _:Int) // function value
val sum2 = sum _ // _ is placeholder for entire parameter list
sum1(1, 23)
sum2(23, 4)

/**
  * Currying - syntactic sugar
  */

/**
  * Partial Functions
  * NOTE: Do not confuse the topic with Partially applied functions
  * NOTE: PartialFunction is a Scala class
  * collect, orElse, andThen are helper functions
  * // partial functions can be converted into regular functions using a lift method
  * // functions can use un-lift method to convert into partial functions
  * // https://docs.scala-lang.org/sips/converters-among-optional-functions-partialfunctions-and-extractor-objects.html#motivation
  * https://www.youtube.com/watch?v=DJ3RbPYbNHg
  */

val squareRootA: PartialFunction[Double, Double] = {
  case x: Double if x > 0 => Math.sqrt(x)
}
//squareRootA(-9) // results in MatchError
squareRootA(9)

val squareRootB = new PartialFunction[Double, Double] {
  def isDefinedAt(x: Double): Boolean = x > 0
  def apply(x: Double): Double = Math.sqrt(x)
}
squareRootB(9)
squareRootB.isDefinedAt(9)
squareRootB.apply(9)
squareRootB.isDefinedAt(-9) // false
squareRootB.apply(-9) // NaN
squareRootB(-9) // NaN

val list: List[Double] = List(4.0, 9.0, 16.0, -25.0)
list.map(Math.sqrt(_))
//list.map(squareRootA) //Match Error
list.collect(squareRootA)
list.collect(squareRootA) == list.collect(squareRootB) // true

val gradeAschool1: PartialFunction[Int, String] = {
  case marks: Int if marks >=80 => "A"
}
val gradeBschool1: PartialFunction[Int, String] = {
  case marks: Int if marks >=60 && marks < 80 => "B"
}
val gradeAschool2: PartialFunction[Int, String] = {
  case marks: Int if marks >=85 => "A"
}
val gradeBSchool2: PartialFunction[Int, String] = {
  case marks: Int if marks >=60 && marks < 85 => "B"
}
val gradeC: PartialFunction[Int, String] = {
  case marks: Int if marks >=45 && marks < 60 => "C"
}
val gradeD: PartialFunction[Int, String] = {
  case marks: Int if marks >=30 && marks < 45 => "D"
}
val gradeE: PartialFunction[Int, String] = {
  case marks: Int if marks >= 0 && marks < 30 => "E"
}
val johnMarks:List[Int] = List(82, 20, 43)
johnMarks.map(gradeE orElse gradeD orElse gradeC orElse gradeBschool1 orElse gradeAschool1)
johnMarks.map(gradeE orElse gradeD orElse gradeC orElse gradeBSchool2 orElse gradeAschool2)

val names = Array("Vodafone", "Airtel", "Reliance")
val calls = Map("Vodafone" -> 10, "Reliance" -> 9)
names.collect(calls)

// https://medium.com/@thejasbabu/partial-partially-applied-functions-in-scala-a0d179e7df3

/**
  * XML processing
  */
