// Enumeration
object FruitType extends Enumeration {
  type FruitType = Value

  val Apple   = Value("Apple")
  val Mango   = Value("Mango")
  val Banana  = Value("Banana")
}

// Case Class
case class Fruit(commonName: String, technicalName: Option[String], fruitType: FruitType.Value)

val granny_apple: Fruit = Fruit("Granny Smith Apple", Option("Malus pumila x sylvestris"), FruitType.Apple)
val fuji_apple: Fruit = Fruit("Fuji Apple", Option("Malus domestica"), FruitType.Apple)
val red_declicious_apple: Fruit = Fruit("Red Delicious Apple", Option("Malus pumila"), FruitType.Apple)
val ralls_janet_apple: Fruit = Fruit("Ralls Janet Apple", Option("Malus pumila"), FruitType.Apple)
val golden_delicious_apple: Fruit = Fruit("Golden Delicious Apple", Option("Malus domestica 'Golden Delicious'"), FruitType.Apple)

val apples: List[Fruit] = List(granny_apple, fuji_apple, red_declicious_apple, ralls_janet_apple, golden_delicious_apple)

// foreach to print every item in the List
apples.foreach { print } // OR apples.foreach { print(_) }

// foreach to loop over every item and perform an operation
apples.foreach(apple => println(apple.commonName))
apples.foreach(apple => {
  if(apple.commonName.startsWith("R")) {
    println(apple.commonName)
  }
})

// for-comprehension (NOTE: not a loop construct)
for(fruit <- apples) println(fruit.commonName)

// generator and guard that filters out commonName with "R"
for(fruit <- apples if fruit.commonName.startsWith("R")) println(fruit.commonName)
