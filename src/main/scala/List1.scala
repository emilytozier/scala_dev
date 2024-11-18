
//Напишите функцию, которая принимает на вход список и возвращает новый список, содержащий только уникальные элементы из исходного списка
object List1  extends App{

  def makeSet(num: List[Int]): Unit = {
    val l1Set = num.toSet
    println(l1Set)
  }

  val num = List(1,2,3,6,10,17,10,2)
  List1.makeSet(num)
}
