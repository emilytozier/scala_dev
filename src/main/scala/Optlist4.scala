//Напишите функцию, которая принимает на вход список Option[String] и возвращает новый список, содержащий только те строки, у которых длина больше 5 символов
object Optlist4  extends App {
  def makeSum(et: List[Option[String]]): List[String] = {
    val list: List[String] = et.flatten
    list.filter(_.length >= 5)
  }


  val list: List[Option[String]] = List(Some("AAA"), None, Some("DDD"), Some("RRR"), Some("TTT"))
  val list2: List[Option[String]] = List(Some("AAAUUUI"), Some("DDD"), Some("RRR"), Some("TTT"))

  println(makeSum(list))
  println(makeSum(list2))

}