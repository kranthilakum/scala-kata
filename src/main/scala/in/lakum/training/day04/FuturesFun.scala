package in.lakum.training.day04

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.Source
import scala.util.{Failure, Success}

object FuturesFun {
  def answers = {
    val netiquette = Future { Source.fromURL("http://www.ietf.org/rfc/rfc1855.txt").mkString }
    val urlSpec = Future { Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt").mkString }
    val answer = for {
      nettext <- netiquette
      urltext <- urlSpec
    } yield {
      "First of all, read this: " + nettext + " Once you're done, try this: " + urltext
    }
    answer foreach {
      case contents => print(contents)
    }
    Thread.sleep(4000)
  }

  def test: Unit = {
    val f = Future {
      val result = Source.fromURL("https://api.oceandrivers.com/static/resources.json")
      result
    }
    f.failed foreach {
      case t => println(s"exception occurred - $t")
    }
    f onComplete {
      case Success(result) => for (post <- result) println(post)
      case Failure(e) => println(s"Failed to find vanilla donut stock, exception = $e")
    }
    Thread.sleep(4000)
  }
}

/**
  * NOTES
  * Concurrency and Parallelism
  * Asynchronous programming
  * Execution Context
  * Future and Promises
  * https://wuciawe.github.io/scala/2017/03/07/notes-on-promise-and-future.html
  * https://docs.scala-lang.org/sips/completed/futures-promises.html
  * https://alvinalexander.com/scala/concurrency-with-scala-futures-tutorials-examples
  * https://docs.scala-lang.org/overviews/core/futures.html
  * https://alvinalexander.com/scala/how-use-multiple-scala-futures-in-for-comprehension-loop
  */
