/**
  * =======Scala-Day-One=======
  *
  * Scala supports both object-oriented and functional programming language
  * In pure OOP language like Scala, everything is an object
  * Scala is a statically typed language with an expressive type system. Its compiler catches the type errors at compile time.
  * Dynamically typed languages like python and javascript
  * Scala supports duck typing
  * every value is an object
  * every function is a value
  * every expression has a type
  * functions are first class citizens/constructs
  * higher order functions
  * anonymous function or lambda
  * functions can be nested
  * currying - partial functions
  * case class
  * pattern matching
  * Java APIs or code can be used in Scala. Both are inter-operative.
  * Scala runs on JVM, so it is platform independent.
  * Scala supports Akka actor system and Erlang model to provides concurrency
  *
  * Unit is anolog to void; Unit vs. Null vs. Nothing ???
  *
  * variables can be declared with val or var
  * val is similar to final variable in java. var is similar to non-final variable in java.
  * val can immutable whereas var is mutable. best practice is to use val and avoid var in FP like Scala as it's mutable
  *
  * @ val names = new Array[String](3)
  * names: Array[String] = Array(null, null, null)
  * @ names(0) = "Jack"
  * @ names(1) = "Jane"
  * @ names(2) = "James"
  * @ for (i <- 0 to 2)
  * print(names(i))
  * JackJaneJames
  * @ names = Array("a", "b", "c")
  * cmd9.sc:1: reassignment to val
  * val res9 = names = Array("a", "b", "c")
  * ^
  * Compilation Failed
  *
  * rather than using if-construct like if(x > 0) s = 1 else s = 1; use
  * val s = if(x > 0) 1 else -1 // as it does not use any mutable variables
  * @ val x = 5
  * x: Int = 5
  *
  * @ val s = if(x > 0) 1 else -1
  * s: Int = 1
  *
  * @ val y = if(x > 0) () else -1
  * y: AnyVal = ()
  * () acts as a placeholder for no useful value
  *
  * {} block contains a sequence of expressions
  * the value of the block is the value of the last expression
  * block that ends with an assignment results in a Unit value
  *
  * @ print('a')
  * a
  * @ print("abcdef")
  * abcdef
  * @ print("result: "+x)
  * result: 5
  * @ print(s"result: ${x}")
  * result: 5
  * @ print(f"result: ${x+0.5}%7.2f")
  * result:    5.50
  * @ print(raw"result: ${x}\n")
  * result: 5\n
  *
  * read a line of input from console using readLine method of scala.io.StdIn class
  *
  * every function is a value
  * @ def max(x:Int, y:Int): Int = {
  * if (x > y) x
  * else y
  * }
  * defined function max
  * @ max(1, 3)
  * res24: Int = 3
  * @ max(3, 1)
  * res25: Int = 3
  *
  * @ def greet = print("Hello")
  * defined function greet
  * @ typeOf(greet)
  * res27: reflect.runtime.package.universe.Type = TypeRef(ThisType(package scala), class Unit, List())
  *
  * printing to console output is a side effect
  * side effect ???
  *
  * recursive functions must have a return type. why???
  *
  * <<<<<<<<< default parameters >>>>>>>>
  *
  * @ def run(left:String="<-", right:String="->", forward:String="^", back:String="v") = left + right + forward + back
  * defined function run
  *
  * @ run()
  * res30: String = "<-->^v"
  *
  * @ run("l", "r", "f", "b")
  * res31: String = "lrfb"
  *
  * @ run('a', 'b', 'c', 'd')
  * cmd32.sc:1: type mismatch;
  * found   : Char('a')
  * required: String
  *
  * -------
  *
  * variable number of arguments (*)
  * @ def sum(args: Int*) = {
  * var result = 0
  * for(arg <- args) result += arg
  * result
  * }
  * defined function sum
  *
  * @ sum(1, 2, 3, 4, 5)
  * res33: Int = 15
  *
  * @ sum(1, 2, 3)
  * res34: Int = 6
  *
  * @ sum(1 to 5:_*)
  * res36: Int = 15
  *
  * // recursiveSum
  *
  * --------
  *
  * a function without an equals = sign is a procedure. procedure returns no value, and you only call it for its side effect. Always write a function with equals sign that returns Unit rather than writing a procedure
  *
  * @ val r1 = 0 until 10
  * r1: Range = Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  *
  * @ r1.head
  * res39: Int = 0
  *
  * @ r1.tail
  * res40: Range = Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
  *
  * @ val hd::tail = List(1,2,3,4,5)
  * hd: Int = 1
  * tail: List[Int] = List(2, 3, 4, 5)
  *
  * --------Lazy values
  *
  * lazy val = 50 // initailisation of val is deferred until it is accessed for the first time
  * useful to delay costly initailisation
  * disadvantage ???
  *
  * no need to provide type for polymorphic methods
  *
  * --------type inference can be a problem
  *
  * @ Object IT{
  * var obj = null // obj has Null type assigned
  * obj = new Object() // no other value can be assigned to Null type variable
  * }
  * cmd43.sc:1: value IT is not a member of object Object
  * val res43 = Object IT{
  * ^
  * cmd43.sc:3: type mismatch;
  * found   : Object
  * required: Null
  * obj = new Object()
  * ^
  * Compilation Failed
  *
  * ---------Loops
  *
  * Java's increment and decrement operators does not work in scala
  * i +=1
  *
  * @ for(i <- 1 to 5)
  * print(i)
  * 12345 // returns 1 to n (inclusive)
  *
  * type of variable i is the element type of the collection; no need to explicitly mention val or var before i because i represents the each element from the collection. The scope of the for loop variable extends until the end of the loop.
  * @ for(var i <- 1 to 5) // don't declare i with val or var
  * print(i)
  * (console):1:5 expected (TypePattern | BindPattern)
  * for(var i <- 1 to 5)
  *
  * @ for(c <- "Hello") print(c)
  * Hello
  *
  * // sum of chars
  *
  * -----------for comprehension
  * @ for(i <- 1 to 10) yield i % 3
  * res52: collection.immutable.IndexedSeq[Int] = Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  *
  * ----------lambda
  * @ def sumTwo = (x:Int, y:Int) => x + y
  * defined function sumTwo
  * @ sumTwo(34, 56)
  * res59: Int = 90
  *
  * ----------foreach
  * List is an immutable sequence of objects that share the same type.
  * List is always immutable
  *
  * @ val listA = List(1, 2, 3, 4, 5)
  * listA: List[Int] = List(1, 2, 3, 4, 5)
  *
  * @ List(1,2,3):::List(4, 5,6)
  * res60: List[Int] = List(1, 2, 3, 4, 5, 6)
  *
  * @ List(1,2,3):::List.range(6, 10)
  * res63: List[Int] = List(1, 2, 3, 6, 7, 8, 9)
  *
  * In Scala, List has an operator ::, which is known as the Cons operator. It is useful to add new elements at the beginning of the List.
  * @ 10::List(1,2,3)
  * res66: List[Int] = List(10, 1, 2, 3)
  * @ 10::List(1,2,3)
  * res67: List[Int] = List(10, 1, 2, 3) // you cannot prepend same value as list is immutable???
  *
  * @ var numbersList = List (1,2,3)
  * numbersList: List[Int] = List(1, 2, 3)
  * @ numbersList = numbersList :: 4
  * cmd66.sc:1: value :: is not a member of Int
  * val res66 = numbersList = numbersList :: 4
  * ^
  * Compilation Failed
  * We cannot use the Cons operator to add a new element at the end of the List. It accepts it only to add it at the beginning of the List.
  *
  * @ 1::2::3::Nil
  * res69: List[Int] = List(1, 2, 3)
  *
  * List.append() method is rarely used and instead cons operator is used. The append method increases time complexity as the list grows
  *
  * @ listA.foreach((i: Int) => print(i))
  * 12345
  * @ List.range(1, 10).foreach((i: Int) => print(i))
  * 123456789
  *
  * @ val xyz:List[Any] = List(1, "abc", 'c', 0.98)
  * xyz: List[Any] = List(1, "abc", 'c', 0.98)
  * better use Tuple to store elements of different type
  *
  * @ val jnames = "james"::"john"::"jack"::Nil
  * jnames: List[String] = List("james", "john", "jack")
  *
  * :: vs ::: ???
  *
  * @ jnames.exists(name => name == "jack")
  * res72: Boolean = true
  *
  * @ jnames.foreach(name => print(name))
  * jamesjohnjack
  *
  * @ jnames.count(name => name.length == 4)
  * res75: Int = 2
  *
  * // filter out subset of elements whose length is 4
  * // filter works only on a subset of elements which satisfy the given condition
  * @ jnames.filter(name => name.length == 4)
  * res89: List[String] = List("john", "jack")
  *
  * @ jnames.filterNot(name => name.length == 4)
  * res97: List[String] = List("james")
  *
  * @ jnames:::List("jane")
  * res79: List[String] = List("james", "john", "jack", "jane")
  *
  * // does all list elements start with "j"?
  * @ jnames.forall(name => name.startsWith("j"))
  * res86: Boolean = true
  *
  * @ jnames.drop(2)
  * res80: List[String] = List("jack")
  * @ jnames
  * res81: List[String] = List("james", "john", "jack")
  *
  * @ jnames.dropRight(1)
  * res87: List[String] = List("james", "john")
  * @ jnames
  * res88: List[String] = List("james", "john", "jack")
  *
  * @ jnames.foreach(print)
  * jamesjohnjack
  *
  * @ jnames.isEmpty
  * res95: Boolean = false
  *
  * @ jnames.head
  * res91: String = "james"
  *
  * @ jnames.tail
  * res92: List[String] = List("john", "jack")
  *
  * // map does not mutate jnames, but returns a new List
  * @ jnames.map(name => name + "y")
  * res93: List[String] = List("jamesy", "johny", "jacky")
  *
  * // returns a string with elements of the list separated by a separator
  * @ jnames.mkString(",")
  * res96: String = "james,john,jack"
  *
  * // sort strings ??? with sortedby, sorted, sortedwith
  *
  * ----------parameterised arrays with types
  * when you instantiate an object in Scala, you can parameterise it with values and types
  *
  * instantiate objects and classes with new keyword
  * arrays use parentheses, not square brackets to access value by index
  * var arr1:Array[Int] = new Array[Int](5)
  * val arr2:Array[Int] = Array(1, 2, 3)
  * arr: Array[Int] = Array(0, 0, 0, 0)
  * @ arr = 0 +: arr :+ 4
  * res3: Array[Int] = Array(0, 0, 0, 0, 0, 4)
  *
  * no operator overloading in Scala
  *
  * ----------pure functions
  * functions shouldn't have side effects. make them pure functions
  * pure functions compute and return value; that way they are reusable and reliable
  *
  * ----------tuples
  * you can't access tuple elements by index like in list. why ??? bcz it's elements are of different types
  *
  * @ val t = (1, "abc", 'c', 0.98)
  * t: (Int, String, Char, Double) = (1, "abc", 'c', 0.98)
  * @ print(t._1)
  * 1
  * @ print(t._2)
  * abc
  * @ val (one, two, three, four) = t
  * one: Int = 1
  * two: String = "abc"
  * three: Char = 'c'
  * four: Double = 0.98
  *
  * // zip
  *
  * ----------set--map
  * set is a pairwise elements of same type
  * map is a collection of keys and values
  * iterator is a way to access the elements of a collection one by one
  *
  * mutable.Map
  * immutable.Map
  *
  * immuatable.Map
  * @ val r = Map(1->"I", 2->"II", 3->"III")
  * r: Map[Int, String] = Map(1 -> "I", 2 -> "II", 3 -> "III")
  * @ r.contains(2)
  * res106: Boolean = true
  * @ r.getOrElse(1, 0)
  * res107: Any = "I"
  *
  * withDefault, withDefaultValue ???
  * to remove a key and value from a mutable map, use -= operator
  *
  * @ for((k,v) <- r) yield (v,k)
  * res108: Map[String, Int] = Map("I" -> 1, "II" -> 2, "III" -> 3)
  *
  * sort maps using hash tables and balanced trees
  * scala uses hash tables for map
  *
  * scala has SortedMap and LinkedHashMap
  * use SortedMap to get keys in sorted order
  * use LinkedHashMap to get keys in insertion order
  *
  * Scala interoperating with Java using JavaConversions API e.g. mapAsScalaMap, propertiesAsScalaMap
  *
  * -------Class & Object
  * class is a blueprint for object
  *
  * import scala.annotation.tailrec
  * https://stackoverflow.com/questions/3114142/what-is-the-scala-annotation-to-ensure-a-tail-recursive-function-is-optimized
  * https://stackoverflow.com/questions/35010965/the-need-for-the-tailrec-annotation-in-scala
  *
  * map -> one. to one.
  * flatmap -> one to many
  * flatMap is equivalent to running map and then flatten
  * https://alvinalexander.com/scala/collection-scala-flatmap-examples-map-flatten
  *
  * Strings and String formatting
  * +:, :+
  *
  * call by value vs. call by name
  *
  */

/**
  * <<<<< Data types and Operators >>>>>
  */
2 + 1
(2).+(1) // + operator is a method in Int class which takes an integer as argument

def aFunction(a: String, b: Int): String = {
  a + " " + b
}
println(aFunction("Hello, Scala!", 1))

def aParameterlessFunction(): Int = 135
println(aParameterlessFunction())
println(aParameterlessFunction)

def aRepeatedFunction(aString: String, n: Int): String = {
  if (n == 1) aString
  else aString + aRepeatedFunction(aString, n-1)
}
println(aRepeatedFunction("hello", 2))

def aGreeting(name:String, age:Int):String =
  s"Hi, my name is $name and I'm ${age} years old"
println(aGreeting("Hello Sung", 10))

def aFactorial(n: Int): Int = {
  if (n != 1) n * aFactorial(n - 1)
  else 1
}
println(aFactorial(5))

/**
  * --------Fibonacci numbers
  * The Fibonacci numbers are the numbers in the following integer sequence.
  * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, …
  * Mathematically, Fn = Fn-1 + Fn-2 with seed values F0 = 0 and F1 = 1
  */
def aFibonacci(n: Int):Int = {
  if(n<=2) 1
  else aFibonacci(n-1) + aFibonacci(n-2)
}
print(aFibonacci(10))

// Binet's Formula for the nth Fibonacci number
// http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html
def bFibonacci(n: Int): Long = {
  val phi = (1 + math.sqrt(5.0)) / 2;
  math.round(math.pow(phi, n) / math.sqrt(5))
}
print(bFibonacci(10))

// https://peter-braun.org/2012/06/fibonacci-numbers-in-scala/
def cFibonacci( n : Int) : Int = n match {
  case 0 | 1 => n
  case _ => cFibonacci( n-1 ) + cFibonacci( n-2 )
}
print(cFibonacci(10))

// --------Prime numbers
def isPrime(n: Int) = {
  // TODO
  val list = List.range(2, n)
  for(x <- list) {
    if(n%x==0) false
    else true
  }
}
println(isPrime(10))

/**
  * <<<<<<<<<< Map, FlatMap, Filter, Reduce >>>>>>>>>
  */
val list = List.range(1, 10)
list.head
list.tail
list.map(_ + 1)
val pair = (x: Int) => List(x, x+1)
println(list.flatMap(pair))

/**
  * <<<<<<<<<<< Strings >>>>>>>>>>
  */
// characters need single-quote while string literals need double-quote
val a = 'A' // a: Char = 'A'
val hell = "What's up, dude!"
val name: String = "David"
val speed: Float = 1.2f
println(f"$name can eat $speed%2.2f burgers per minute")
println(raw"$name can eat $speed%2.2f burgers per minute")

/**
  * Call by Value vs Call by Name
  */
def calledByValue(x: Long): Unit = {
  println(x)
  println(x)
}
calledByValue(23213213312313L)

def calledByName(startTime: Long): Unit = {
  val estimatedTime = System.nanoTime() - startTime
  println(estimatedTime)
  println(estimatedTime)
  println(estimatedTime)
}
println(calledByName(System.nanoTime()))
