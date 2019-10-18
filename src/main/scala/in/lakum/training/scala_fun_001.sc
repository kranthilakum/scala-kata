// variable declarations
val x = 2.45
val y = 3.45
val a: Array[Int] = Array(1, 2, 3)
val b: Array[Double] = Array(10.0, 20.0, 30.0)
val elements_50: Array[Int] = Array.range(1, 20)
val greeting: String = " Hello, Scala! "

// anonymous function
val exp = (x: Double, y: Double) => Math.pow(x, y)
exp(2, 4)

def divide(x: Double, y: Double): Double = {
  val result = x / y
  print(s"Divide $x by $y yields $result")
  result
}

// pure functions, no side-effects
def three: Int = 1.+(2)
def product (x: Int, y: Int): Int = x * y
def addOne(m: Int): Int = m + 1
def addAll(nums: Int*) = nums.reduceLeft(_+_) // variable length arguments
// NOTE: varargs field must be the last field in the method signature

addAll(1, 2, 34, 456, 53400)

// Arithmetic Operations
12.34.-(9.54)
res0.getClass()

11.+(3.45)
12.*(15)
34./(12)
56.%(7.24)

scala.math.pow(x, y)
Math.pow(2,3)
x max y
x min y

// String operations
greeting.length
greeting.charAt(3)
greeting.isEmpty()
greeting.substring(1, 6)
greeting.indexOf("Scala")
greeting.startsWith("H")
greeting.endsWith("!")
greeting.replace("l", "c")
greeting.toLowerCase()
greeting.toUpperCase()
greeting.trim()
greeting.codePointBefore(4)
greeting.split(",", 2)
greeting.subSequence(3, 8)

// String formatting
"Hello, " + "World!"
print(greeting)

// reduce, reduceLeft, reduceRight with wildcard operator
a.reduce(_+_)
a.reduceLeft(_+_)
a.reduceRight(_+_)

b.reduceLeft(divide)
b.reduceRight(divide)

List(-10.34, 10.80, 20.4, 40.54).reduceLeft(divide)
List(-10.34, 10.80, 20.4, 40.54).reduceRight(divide)

// foldLeft, foldRight
a.foldLeft(20)(_+_)
a.foldRight(50)(_+_)
List(1, 2, 3).foldRight(20)(_+_)

// scanLeft, scanRight
elements_50.scanLeft(10)(product)
