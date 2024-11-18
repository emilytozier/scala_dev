//Напишите функцию, которая принимает на вход два списка List[Int] и возвращает список из всех возможных комбинаций элементов этих двух списков
object Optlist5  extends App {
  def combinator(x: List[List[Int]]): List[List[Int]] = x match {
    case Nil    => List(Nil)
    case h :: _ => h.flatMap(i => combinator(x.tail).map(i :: _))
  }


  val list = List(List(1,2,3), List(4,6,89))


  println(combinator(list))


}