//Напишите функцию, которая принимает на вход список Option[Int] и возвращает среднее значение чисел (игнорируя None)
object ListOpt extends App {

  def makeAvg(et: List[Option[Int]]): Double = {
    val list: List[Int] = et.flatten
    list.sum/list.size
  }

  val list: List[Option[Int]] = List(Some(1), None, Some(3), Some(5), Some(3))

  println(makeAvg(list))
}
