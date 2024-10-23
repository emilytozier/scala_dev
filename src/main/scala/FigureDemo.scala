//Создайте класс "фигура", с методом расчета площади
//Создайте кейс-классы для представления геометрических фигур: "круг", "прямоугольник", "квадрат", с необходимыми им параметрами. Отнаследуйте их от класса "фигура". Переопределите метод расчета площади в каждом из наследников
import scala.math.Pi
object FigureDemo {
  trait Figure {

    def makeSquare(): Double

  }

  case class Circle(r: Double) extends Figure {
    override def makeSquare(): Double = r * Pi
  }

  case class Square(r: Double) extends Figure {
    override def makeSquare(): Double = r * r
  }

  case class Pryamo(r: Double, a: Double) extends Figure {
    override def makeSquare(): Double = r * a
  }

  def main(args: Array[String]) {

    val sq = Square(2.9)
    val tr = Pryamo(3.2, 5.7)

    println(sq.makeSquare()) //
    println(tr.makeSquare())
  }
}
