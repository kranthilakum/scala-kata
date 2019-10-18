/**
  * <<<<<<<<<<< Classes, Objects >>>>>>>>>>
  */
class Counter {
  private var value = 0
  def increment() = { value += 1}
  def current() = value
}

val myCounter = new Counter
myCounter.increment()
print(myCounter.current())


/**
  * Auxiliary constructor
  * Eliminate use of Auxiliary constructors by using default arguments
  */
class Human {
  private var name = ""
  private var age = 0
  // first auxiliary constructor
  def this(name: String) {
    this()
    this.name = name
  }
  // second auxiliary constructor
  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }
}
val human1 = new Human() // primary constructor
val human2 = new Human("Jack") // first auxiliary constructor
val human3 = new Human("Jack", 23) // second auxiliary constructor

// Write and a Novel
// without val - year would be private to Writer
class Writer(firstName:String, lastName:String, val year:Int) {
  def fullname():String = firstName + " " + lastName
}
class Novel(name:String, releaseYear:Int, author:Writer) {
  def authorAge():Int = releaseYear - author.year
  def isWritterBy(author:Writer) = author == this.author
  def copy(newYear: Int) = new Novel(name, releaseYear, author)
}
val author = new Writer("John", "Tolkein", 1912)
val novel = new Novel("Lord of the Rings", 1935, author)
author.fullname()
novel.authorAge()
novel.isWritterBy(author)

/**
  * Nested classes
  */

import scala.collection.mutable.ArrayBuffer
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }
  private val members = new ArrayBuffer[Member]
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}
val chatter = new Network
val myFace = new Network
val fred = chatter.join("Fred")
val wilma = chatter.join("Wilma")
val barney = myFace.join("Barney")
fred.contacts += wilma
// fred.contacts += barney - results in error - can't add myFace member to chatter buffer

/**
  * Objects and Companion Objects
  *
  * Instance and Static members go into an Object rather than a Class
  * Scala does not have `static` keyword
  * Define non-static (instance) members in a Class and static members in an Object with same name as Class
  * https://alvinalexander.com/scala/how-to-static-members-in-scala-companion-objects-fields-methods
  *
  * Objects can extend a Class and one or more Trait
  */
class Rectangle(val a:Int, val b:Int)
object Rectangle {
  def createValidRectangle(a:Int, b:Int) = new Rectangle(math.max(a, 1), math.max(b, 1))
}
val validRectangle = Rectangle.createValidRectangle(3, -10000)
println("Valid rectangle: " + validRectangle.a + ", " + validRectangle.b) //Prints "Valid rectangle: 3, 1".

/**
  * Apply method
  * factory method
  * https://blog.matthewrathbone.com/2017/03/06/scala-object-apply-functions.html
  */
object Greet {
  def apply(name: String): String = {
    "Hello %s".format(name)
  }
}
// I can call apply explicitly if I want:
Greet.apply("bob")  // => "Hello bob"

// Or I can call Greet like it is a function:
Greet("bob") // => "Hello bob"

/**
  * Main method and Object extending App
  *
  * get command-line arguments from the args property
  *
  * scalac Hello.scala
  * scala -Dscala.time Hello
  */

/**
  * Enumeration
  *
  * Scala does not have enumerated types like enum in Java
  * Scala has Enumeration class which an Object can extend
  */
//object TrafficLightColor extends Enumeration {
//  val Red, Yellow, Green = Value
//  val Violet = Value
//  val Indigo = Value(1, "#ccc")
//}
//def doWhat(color: TrafficLightColor) = {
//  if(color == Red) "stop"
//  else if(color == Yellow) "hurry up"
//  else "go"
//}
//for(c <- TrafficLightColor.values) println(s"${c.id}: $c")
//TrafficLightColor(0)
//TrafficLightColor.withName("Red")

/**
  * Inheritance
  *
  * override a method that is not an abstract method
  * isInstanceOf - check if an object belongs to a given class
  * asInstanceOf - convert object reference to a subclass reference
  * type checks and casts
  * pattern matching for type checks and casts
  * protected fields and methods
  * Scala replaces interfaces with traits
  * mix traits with `with` keyword
  * scala supports single inheritance
  * derived class can have one parent/base class
  * Any class has no parent as it is the top-most/root class
  * extends keyword is used to extend class or trait
  * traits can inherit classses
  * traits do not have constructor parameters like classes
  * multiple traits may be inherited by the same class
  * if we don't extend a parent class, anyRef is its default parent
  * abstract class
  */

// Inheritance - Example 001
// https://alvinalexander.com/scala/how-to-declare-constructor-parameters-extending-scala-class
case class Address (city: String, state: String)
class Person (var name: String, var address: Address) {
  override def toString = if (address == null) name else s"$name @ $address"
}
class Employee (name: String, address: Address, var age: Int)
  extends Person (name, address) {
  // rest of the class
}
val teresa = new Employee("Teresa", Address("Louisville", "KY"), 25)
teresa.name
teresa.address
teresa.age

// Inheritance - Example 002
class ServiceImportant(name: String) {
  def work(i: Int) = {
    println(s"ServiceImportant: doing important work: $i")
    i+1
  }
}
val service1 = new ServiceImportant("uno")
(1 to 3).foreach(i => println(s"result: ${service1.work(i)}"))

trait Logging {
  def info(message:String): Unit
}
trait StdoutLogging extends Logging {
  def info(message: String) = println(s"INFO: $message")
}

val service2 = new ServiceImportant("dos") with StdoutLogging {
  override def work(i: Int): Int = {
    info(s"starting work: i = $i")
    val result = super.work(i)
    info(s"ending work: i = $i, result = $result")
    result
  }
}
(1 to 3).foreach(i => println(s"result: ${service2.work(i)}"))

/**
  * Reference types vs. Value types
  * Value Classes
  * type classes
  * extension methods
  * universal traits
  * wrappers around value types turn them into reference types
  * parent types
  */
class USPhoneNumber(val s: String) extends AnyVal {
  private def digits(str: String): String = str.replaceAll("""\D""", "")
  override def toString = {
    val digs = digits(s)
    val areaCode = digs.substring(0,3)
    val exchange = digs.substring(3,6)
    val subnumber = digs.substring(6, 10)
    s"($areaCode) $exchange-$subnumber"
  }
}
val number = new USPhoneNumber("987-343-1321")

trait Digitizer extends Any {
  def digits(s: String): String = s.replaceAll("""\D""", "")
}
trait Formatter extends Any {
  def format(areaCode:String, exchange:String, subnumber:String):String =
    s"($areaCode) $exchange-$subnumber"
}
// value class
class EUPhoneNumber(val s:String) extends AnyVal with Digitizer with Formatter {
  override def toString = {
    val digs = digits(s)
    val areaCode = digs.substring(0,3)
    val exchange = digs.substring(3,6)
    val subnumber = digs.substring(6, 10)
    s"<$areaCode>-$exchange-$subnumber"
  }
}
val euNumber = new EUPhoneNumber("987-232-2343")

/**
  * Case Class
  * class parameters are fields
  *
  */
case class Dinosaur(name:String, age:Int)
val tyrannosaurus = new Dinosaur("Tyron", 32)
print(tyrannosaurus.name)

// Example
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = {
    balance += amount
    balance
  }
  def withdraw(amount: Double) = {
    balance -= amount;
    balance
  }
}
class CheckingAccount(balance: Double) extends BankAccount(initialBalance = balance) {
  override def deposit(amount: Double): Double = {
    super.deposit(amount-1)
  }
  override def withdraw(amount: Double): Double = {
    super.withdraw(amount-1)
  }
}
val checkingAccount = new CheckingAccount(100)
checkingAccount.deposit(10)

class SavingsAccount(balance: Double) extends BankAccount(initialBalance = balance) {
  def earnMonthlyInterest = {

  }
}

abstract class Item {
  def price = {}

  def description = {}
}
class SimpleItem(price: Double, description: String) extends Item {

}
class Bundle() extends Item {

}
