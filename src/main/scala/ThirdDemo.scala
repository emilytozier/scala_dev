
object ThirdDemo {
  def main(args: Array[String]) = {
    val addCel = (t: Double) => s"Celsium =$t °C "+"Fahrenheit: "  + ((t*9.0)/5.0 +32.0) +" °F"
    println(addCel(25))
    println(addCel(9))
    println(addCel(10))
    println(addCel(2))
  }
}
