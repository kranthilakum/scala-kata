#### Dotty compiler
- It is a Scala compiler
- It is based on DOT, the calculus of Dependent Object types

#### Scala 2 vs. Scala 3
- Scala 2 and Scala 3 are the same language. They share the same standard library. They are mostly source compatible.
- Scala 3 uses Dotty compiler (dotc), whereas Scala 2 uses Scalac
- Scala 3 is not binary compatible with Scala 2

__Hello World using Dotty compiler__

```bash
git clone https://github.com/lampepfl/dotty.git
cd dotty
sbt managedSources
sbt
dotc tests/pos/HelloWorld.scala
dotr HelloWorld
hello world
```

#### Dotty concepts
- Intersecti on types
    - & operator creates an intersection type
- Union types
- Type lambdas
- Context query (implicit function types)
- Trait parameters
- Implied instances
- Inferable parameters
- Extension methods
- Opaque type aliases
- Top-level definitions
- Export clauses
- Vararg patterns
- Creator applications
- @static methods and fields
- Optiona-less pattern matching
- Multiversal equality
- Erased terms
- Auto-specialization
- HList & HMaps/Record types
- SBT incremental build

- [Dotty overview](https://dotty.epfl.ch/docs/reference/overview.html)