val numbers_20 = List.range(0, 21)

// List of even numbers
for(number <- numbers_20) {
  if(number % 2 == 0)
    print(s" $number")
}

// for-yield: twice each number
for(number <- numbers_20) yield number * 2

// for comprehension without yield to perform side-effect like print/stdout
// List of even numbers greater than 4
for(number <- numbers_20
    if(number % 2 == 0)
    if(number > 4)
) print(s" $number")

val letters = 'a' to 'c'
val numbers = List.range(1, 4)
for(letter <- letters) {
  for(number <- numbers) {
    println(number, letter)
  }
}

// for-yield comprehension
val result_ln = for {
  letter <- letters
  number <- numbers
} yield (letter, number)
result_ln.foreach(print(_))

val salaries = Seq(200000, 700000, 1000000, 1200000, 2200000)
// higher order functions - map, filter, etc.
val bonus = salaries.map(_*0.012)
val highSalaries = salaries.filter(_ >= 1000000)

import scala.collection.JavaConversions.propertiesAsScalaMap
for((i, j) <- System.getProperties)
  println(s"$i --- $j")

val map = Map("Andreas" -> 28,
  "Jonathan" -> "",
  "Alexander" -> 25)
for((k,v) <- map)
  println(s"$k -> $v")

// --- help ---
// How does the yield work - https://docs.scala-lang.org/tutorials/FAQ/yield.html
// Understanding For-comprehension - https://medium.com/wix-engineering/scala-comprehending-the-for-comprehension-67c9f7953655
// for without yield internally translates to foreach
// for with yield internally translates to flatMap
// for with yield and guard internally translates to withFilter or filter
// for with yield and an expression internally translates to map
