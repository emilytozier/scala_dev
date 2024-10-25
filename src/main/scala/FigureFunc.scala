//Напишите функцию, которая принимает "фигуру", и выводит в консоль результат расчета площади. Выведите результат расчета площади "круга", "прямоугольника", "квадрата"
import scala.math.Pi
object FigureFunc extends App {
  trait Figure

  case class Square(r: Double) extends Figure

  case class Circle(r: Double) extends Figure

  case class Rectangle(a: Double, b: Double) extends Figure

  def processCommand(ac: Figure): String = {
    ac match {
      case Square(r) =>
        s"square: ${r * r}"
      case Circle(r) =>
        s"square: ${r * Pi}"
      case Rectangle(a, b) =>
        s"square: ${a * b}"
      case _ =>
        "unknown figure"
    }
  }

  def processCommandType(ac: Figure): String = {
    ac match {
      case s: Square =>
        s"square: ${s.r * s.r}"
      case c: Circle =>
        s"square: ${c.r * Pi}"
      case r: Rectangle if r.a == r.b =>
        s" It is not rectangle, it's square! square of square: ${r.a * r.b}"
      case p: Rectangle =>
        s"square: ${p.a * p.b}"
      case _ =>
        "unknown figure"
    }
  }


  val sq = Square(2.9)
  val pr = Rectangle(3.2, 5.7)
  val pr2 = Rectangle(3.2, 3.2)

  println(processCommand(sq)) //
  println(processCommandType(pr2))


}
