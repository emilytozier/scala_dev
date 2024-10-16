
object FourthDemo {
  def main(args: Array[String]) = {
    val addStr = (str: String) => s"Length of string '$str' is  ${str.length}"
    println(addStr("little string"))
    println(addStr("very little string"))
    println(addStr("very-very little string"))
  }
}
