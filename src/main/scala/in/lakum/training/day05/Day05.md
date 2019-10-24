#### Type parameters
you can implement traits, classes, functions
type parameters help in defining types of variables, method parameters, and return values
e.g. Array[T] stores elements of an arbitrary type T

#### Generic classes
class with one or more type parameters

```scala
class Pair[T, S](val first: T, val second: S)
val p = new Pair(42, "String")
```

#### Generic functions
```scala
def getMiddle[T](a: Array[T]) = a(a.length/2)
```

#### Bounds for Type variables
Bounds are restrictions on type variables

##### upper bound
sub-type <: super-type
Upper bound for a type T <: Comparable[T] here T will be a subtype of Comparable[T]

```scala
class Pair[T <: Comparable[T]](val first: T, val second: S)
val q = new Pair("Robin", "Batman")
```

##### lower bound

Lower bound for a type super-type >: sub-type

#### Multiple bounds

- Type variable can have both upper bound and lower bound - T >: Lower <: Upper
- multiple lower or upper bounds on a type is not possible
- Type can implement multiple traits

#### Type constraints

- three constraints
    - T =:= U // check if T equals U
    - T <:< U // check if T is a sub-typee of U
    - T => U // check if T is convertible to U
    
- implicit evidence parameter

- it is possible to restrict use of a method in generic class using type constraints
- type constraints improve type inference

#### orNull method in Option class
https://stackoverflow.com/questions/4467601/please-explain-use-of-options-ornull-method

#### Co-Variance and Contra-Variance

- Liskov substitution principle
- helps with inheritance

#### In-Variance
left-invariance

```scala
class Pair[+T](val first: T, val second: T)
```
[+T] means type is covariant in T. It varies in the same direction
[-T] means type is contra-variant

- Arrays are invariable, mutable
- List is immutable, covariant
- It is not possible to add type parameters to objects.
- All generic types are invariant. You can vary the types of generics by using wildcards.

- You cannot create an object for an Empty class. Empty class does not have any state (members and behavior).

```scala
abstract class List[+T] {
  def isEmpty: Boolean
}
class Empty[T] extends List[T] {
  def isEmpty = true
}
// not possible to add type parameters to objects
object Empty extends List[Nothing] {
  def isEmpty = true 
}
// defined object Empty

object Empty extends List[T] {
  def isEmpty = true
} 
// cmd27.sc:1: not found: type T
// object Empty extends List[T] {
//                        ^
//Compilation Failed
```

#### Implicits
- implicit parameters
- [implicit conversion function](https://www.scala-lang.org/blog/2016/12/07/implicit-function-types.html) converts values from one type to another
- implicit functions are both monads and comonads
- An implicit class is a class marked with the implicit keyword.
    - They must be defined inside of another trait/class/object
    - They may only take one non-implicit argument in their constructor.
    - There may not be any method, member or object in scope with the same name as the implicit class

```scala
class Fraction(n: Int, d: Int) {
    private val num = n
    private val den = d
    def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
}
implicit def int2Function(n: Int) = Fraction(n, 1)
val result = 3 * Fraction(4, 5)

// implicit parameter converstion
def smaller[T](a: T, b: T) = if(a < b) a else b // cannot resolve symbol <

def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if(order(a) < b) a else b
// OR
def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if(a < b) a else b
// Ordered trait has < concrete value member
```

#### Context bounds
type parameter can have a context bound of the form T:M where M is another generic type

#### View bounds

Predef implicitly method

#### Type class
e.g. Ordering trait, Numeric class

#### JSON

json4s to serialize/de-serialize