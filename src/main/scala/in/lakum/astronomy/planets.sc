// Tuples
val titan: (String, Int) = ("Titan", 22342)
val enceladus: (String, Int) = ("Enceladus", 34421)
val tethys: (String, Int) = ("Tethys", 53432)
val (tethysName, tethysDistance) = tethys // pattern matching on Tuple

val saturnMoons: List[(String, Int)] = List(titan, enceladus, tethys)

saturnMoons.foreach(moon => {
  // tuple accessors
  val name = moon._1
  val distance = moon._2
  println(s"$name is away from the Saturn by $distance KM.")
})

for((name, distance) <- saturnMoons) println(s"$name is away from the Saturn by $distance KM.")

// case class
case class Planet(name: String, distanceFromSun: Option[BigInt])

val mercury = Planet("Mercury", Some(57909000))
val venus = Planet("Venus", Some(108160000))
val earth = Planet("Earth", Some(149600000))
val mars = Planet("Mars", Some(227990000))
val jupiter = Planet("Jupiter", Some(778360000))
val saturn = Planet("Saturn", Some(1433500000))
val uranus = Planet("Uranus", Some(BigInt("2872400000")))
val neptune = Planet("Pluto", Some(BigInt("4498400000")))
val xyz = Planet("XYZ", None)

val planets: List[Planet] = List(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune)

// using foreach
planets.foreach(planet => {
  val name = planet.name
  val distance = planet.distanceFromSun
  println(s"$name is away from the Sun by $distance KM.")
})

// using for with yield
val planetsInfo = for {
  planet <- planets
} yield (planet.name, planet.distanceFromSun)

planetsInfo.foreach {
  case(name, distance) => println(s"$name is away from the Sun by $distance KM.")
}

// using for without yield statement
for {
  planet <- planets
} println(s"${planet.name} is away from the Sun by ${planet.distanceFromSun} KM.")

for(planet <- planets) {
  val name = planet.name
  val distance = planet.distanceFromSun
  println(s"$name is away from the Sun by $distance KM.")
}

// Get distance for a given planet from the Sun
def getPlanetDistance(name: String): Option[Option[BigInt]] = {
  val result = for {
    planet <- planets
    if planet.name == name
    distance = planet.distanceFromSun // basic assignment, no need for var or val declaration
  } yield distance
  result.headOption
}
getPlanetDistance("XYZ")
