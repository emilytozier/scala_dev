import scala.util.{Try,Success,Failure}
object NumDev extends App {
  def divide(a: Int, b: Int): Try[Int] = Try(a / b)

  val result1 = divide(6, 0)
  result1 match {
    case Success(v) =>
      println("result is " + v)
    case Failure(e) =>
      println("failed to divide " + e.getMessage)
  }

}
object NumDevOpt extends App{

  def divide(e1: Double, e2: Double): Option[Double] = {
    if (e2 == 0) None
    else Option(e1/e2)
  }


  val result2 = divide(5,0)
  println(result2)

}

object NumDevEither extends App{

  def divide(e1: Double, e2: Double): Either[String, Double] = {
    if (e2 == 0)
      Left("You cannot divide by 0")
    else
      Right(e1/e2)
  }


  val result3: Either[String, Double] = divide(4,0)
  println(result3)

}
