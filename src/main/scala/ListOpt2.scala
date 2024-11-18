//Напишите функцию, которая принимает на вход список Option[Int] и возвращает сумму всех значений, если они все есть, или None, если хотя бы одно значение отсутствует
object ListOpt2 extends App {


  def makeSum(et: List[Option[Int]]): Unit = {
    if (et.forall(_.isDefined)) {
      println(et.flatten.sum)
    } else if (et.forall(_ == None)) {
      println(None)
    } else {
      println(None)
    }
  }


  val list: List[Option[Int]] = List(Some(1), None, Some(3), Some(5), Some(3))
  val list2: List[Option[Int]] = List(Some(1), Some(6), Some(3), Some(5), Some(3))

  makeSum(list)
  makeSum(list2)
}
