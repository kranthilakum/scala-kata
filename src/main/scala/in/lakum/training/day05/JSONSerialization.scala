package in.lakum.training.day05

import java.util.Date

object JSONSerialization extends App {
  case class User(name: String, age: Int, email: String)
  case class Post(content: String, createdAt: Date)
  case class Feed(user: User, posts: List[Post])

  sealed trait JSONValue {
    def stringify: String
  }

  final case class JSONString(value: String) extends JSONValue {
    def stringify: String = "\"" + value + "\""
  }

  final case class JSONNumber(value: Int) extends JSONValue {
    def stringify: String = value.toString
  }

  final case class JSONArray(values: List[JSONValue]) extends JSONValue {
    def stringify: String = values.map(_.stringify).mkString("[", ",", "]")
  }

  final case class JSONObject(values: Map[String, JSONValue]) extends JSONValue {
    def stringify: String = values.map {
      case(key, value) => "\"" + key + "\":" + value}.mkString("{", ",", "}")
  }

  val data = JSONObject(Map(
    "user" -> JSONString("Jack"),
    "posts" -> JSONArray(List(JSONString("Good Morning, Sunshine!"),
      JSONNumber(31)
    ))
  ))

  print(data.stringify) // {"user":JSONString(Jack),"posts":JSONArray(List(JSONString(Good Morning, Sunshine!), JSONNumber(31)))}
}
