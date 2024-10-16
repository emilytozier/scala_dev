import scala.math.Pi
object SecondDemo {
  def main(args: Array[String]) = {
    val addSq = (r: Double) => s"square for r=$r : "  + r * 2 * Pi
    println(addSq(5)) 
    println(addSq(9)) 
    println(addSq(10)) 
  }
}
