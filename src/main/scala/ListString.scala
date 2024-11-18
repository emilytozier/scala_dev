//Напишите функцию, которая принимает на вход два списка List[String] и возвращает новый список, содержащий элементы, которые присутствуют в обоих исходных списках
object ListString extends App{

  val list1 = List("gh","rt","dark side")
  val list2=List("get well","shadowwww","dark side")
  val intersect = list1.intersect(list2)


  println(intersect)

}
