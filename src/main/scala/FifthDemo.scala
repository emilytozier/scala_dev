import scala.math.abs
object FifthDemo {
  def main(args: Array[String]) = {
    val points = (x1: Int, y1: Int, x2:Int, y2:Int) => s"Point 1 ($x1, $y1); Point 2 ($x2, $y2) Distance: (${abs(x2-x1)}"+","+s"${abs(y2-y1)})"
    println(points(1,1,5,6))
    println(points(3,7,17,4))
    println(points(40,60,90,220))
  }
}