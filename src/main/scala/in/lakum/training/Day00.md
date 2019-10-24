#### Functional programming
- pure functional programs consist of only immutable values and pure functions without side-effects.

__Side Effect__
- a function has a side-effect if it does something other than returning a result, like:
    - Modifying a variable
    - Modifying a data structure in place
    - Setting a field on an object
    - Throwing an exception or halting with an error
    - Printing to the console or reading user input
    - Reading from or writing to a file
    - Drawing on the screen

#### FP Concepts
- First-class functions
- Anonymous functions / lambda functions
- Higher-order functions
- closures
- partial application
- currying
- pure functions
- recursion
- strict (eager) evaluation vs. non-strict (lazy) evaluation
- Referential transparency

#### Category Theory

#### Category
A category C consists of:
- a class of objects (or elements) denoted Obj(C)
- a class of morphisms (or arrows, maps) between the objects

#### Morphism
- In category theory, morphisms are sometimes also called arrows.
- every morphism has a source and target  objects
- a morphism f, with source x and target y is f: x -> y
- morphisms are functions from an object to another object
- source and the target of a morphism are also called as domain and co-domain
- morphisms can be mono-morphism, epi-morphism, iso-morphism, or endo-morphism
- bi-morphism = a morphism that is both epi-morphism and a mono-morphism
- auto-morphism = a morphism that is both an endo-morphism and an iso-morphism
- f is an isomorphism if it has an inverse morphism e.g. g: y → x


#### Composition of morphisms

Composite functions are functions that combine to make a new function.

f ◦ g is the composition function that has f composed with g

f ◦ g is not the same as g ◦ f. (This means that composition is not commutative)

f ◦ g ◦ h is the composition that composes f with g with h.

h = f ◦ g, where h is the function that is made from f composed with g

**Commutative involves the condition that a group of quantities connected by operators gives the same result whatever the order of the quantities involved, e.g. a × b = b × a

f(x) = 3x 2 + 2x + 1 // pure function

plug in various values of x into the function and we would have different outputs for each input

```
f(−2) = 3(−2)2 + 2(−2) + 1 = 12 − 4 + 1 = 9
f(0) = 3(0)2 + 2(0) + 1 = 1
f(2) = 3(2)2 + 2(2) + 1 = 12 + 4 + 1 = 17
```

When composing functions, we plug whole functions instead of plugging in numbers as input (higher-order function composition)

```
f(x) = 3x + 4
g(x) = x^2 + 1/x
```

first, we will plug x into g and then g into f. g acts as our new variable and we have f(g(x)).

```
(f ◦ g)(x) or f(g(x)) = 3x^2 + 3/x + 4
f(x) = 2x
g(x) = x^2 + 2x
h(x) = 2x
(f ◦ g ◦ h)(x) or f(g(h(x))) = 8x^2 + 8x
```

#### Functor
- In category theory, a Functor is a map between categories
- Functors are containers you can call map on.
- Functors contain stuff and if you apply a function to that stuff you get the same kind of container back out with the stuff inside it transformed.
- Functor applies functions to the values it contains, instead of to itself.

#### Endo-functor
- It is a Functor mapping a category to itself

#### Applicative

#### Monoid
- In category theory, it means a category with one object.
- A monoid is a type, together with the monoid operations and a set of monoid laws.
- A monoid is associative binary operations with an identity
- A monoid is the algebra, and nothing more.
- numbers form monoids under both addition and multiplication

The laws of associativity and identity are collectively called the monoid laws.

Monoid consists of:
- some type A
- an associative binary operation `op` that takes two values of type A and combines them into one, such that (op(op(x,y), z) == op(x, op(y,z))
- a value, zero: A, that is an identity for that operation: op(x, zero) == x and op(zero, x) == x for any x: A

```scala
trait Monoid[A] {
  def op(a1: A, a2: A): A // associative binary operation
  def identity: A // identity
}
val stringMonoid = new Monoid[String] {
  def op(a1: String, a2: String) = a1 + a2
  val identity = ""
}
val intAdditionMonoid = new Monoid[Int] {
  def op(lhs: Int, rhs: Int) = lhs + rhs
  val identity = 0
}
val intMultiplicationMonoid = new Monoid[Int] {
  def op(lhs: Int, rhs: Int) = lhs * rhs
  val identity = 1
}
val booleanOrMonoid = new Monoid[Boolean] {
  def op(lhs: Boolean, rhs: Boolean) = lhs || rhs
  val identity = false
}
val booleanAndMonoid = new Monoid[Boolean] {
  def op(lhs: Boolean, rhs: Boolean) = lhs && rhs
  val identity = true
}
def listMonoid[A] = new Monoid[List[A]] {
  def op(lhs: List[A], rhs: List[A]) = lhs ++ rhs
  val identity = Nil
}
def optionMonoid[A]: Monoid[Option[A]] // TODO

// A function having the same argument and return type is called an endo-function.
// endofunction’s codomain is within its domain
def endoMonoid[A]: Monoid[A => A] // TODO
```

Other  than  satisfying  the  Monoid  laws,  the  various  Monoid  instances do not  have  much  to  do  with  each  other.

""+"foo" or "foo"+"" results in "foo". Here, the empty string is an identity element for that operation

"foo"+"bar"+"buzz" or (("foo" + "bar") + "buzz") or ("foo" + ("bar" + "buzz")) results in "foobarbuzz". This operation is associative.

This operation can also be applied to integer addition and multiplication e.g. (x + y) + z = x + (y + z)

If we consider the set ℝ then standard addition is associative since for all a,b,c ∈ R:
```
a+(b+c)=(a+b)+c
```

Standard multiplication is associative on ℝ because the order of operations is not strict when it comes to multiplying out an expression that is solely multiplication:
```
a⋅(b⋅c)=(a⋅b)⋅c
```

Even though the parentheses were rearranged on each line, the values of the expressions were not altered.
Since this holds true when performing addition and multiplication on any real numbers, it can be said that "addition and multiplication of real numbers are associative operations".

Function composition on S is associative:
```
(f o g) o h = f o (g o h) = f o g o h ; for all f, g, h ∈ S.
```

#### Monad
- lambda calculus was invented in 1936, but monads weren’t described (in-vented) until 1991
- Eugenio Moggi first described the general use of monadsto structure programs in 1991
- Haskell 1.3 (1998) introduced monads as amore flexible way to combine I/O with lazy evaluation
- A monad is just a monoid in the category of endofunctors
- Monads are containers you can call flatMap
- Monads help in modeling of computations with mutable state (and other side effects such as I/O) in an imperative manner without losing purity.

#### Co-Monad???

#### Monad Laws
- Category Theory defines the Monad laws
- Each monad must satisfy these laws
- These laws can be used to verify the Monadic code

