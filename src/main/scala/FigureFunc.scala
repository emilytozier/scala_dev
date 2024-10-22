import scala.math.Pi
object FigureFunc {
  trait Figure

  case class Square(r: Double) extends Figure

  case class Circle(r: Double) extends Figure
  case class Pryamo(r: Double, a: Double) extends Figure

  def processCommand(ac: Figure): String = {
    ac match {
      case Square(r) =>
        s"square: ${r*r}"
      case Circle(r) =>
        s"square: ${r*Pi}"
      case Pryamo(r, a) =>
        s"square: ${r*a}"
      case _ =>
        "unknown figure"
    }
  }
  def main(args: Array[String]) {

    val sq = Square(2.9)
    val pr = Pryamo(3.2, 5.7)

    println(processCommand(sq)) //
    println(processCommand(pr))
  }
}
