import scala.math.{sqrt, floor}

object PartialFunctions extends App {

  def posi: PartialFunction[Int, Int] = {

    case x: Int if sqrt(x) - floor(sqrt(x)) == 0  => x
  }
  println(List(0,1,2,21,100,576,4,567,33,23,9) collect { posi })

}
