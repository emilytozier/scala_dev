object Implicit2  extends App{

  implicit class IntUmn(i: Int) {
    def umn: Int = i*10
  }
  val j = 5
  val ju = j.umn
  println(ju)

}

object Implicit3  extends App{


  implicit class IntUmn(i: Int) {
    def umn: Unit =
      if(i%2==0) println("четное")
      else println("нечетное")
  }
  val j = 4
  val ju = j.umn


}
object Implicit4  extends App{

  case class Rub(value: Int)
  def convert(dollar: Int)(implicit rub: Rub) =
    println(s"$dollar dollars - it is  ${rub.value*dollar} rubles")


  //  f("1")
  implicit val kursNow = Rub(80)

  convert(2)

}

object OrderingCase extends App{


  case class Person(name: String, age: Int)

  implicit val personOrdering: Ordering[Person] = Ordering.by(_.age)
  val person  = Person("Peter",28)
  val person2 = Person("Janny",22)
  val person3= Person("Stewart", 42)
  val person4=Person("Tabita", 54)
  val x= List[Person](person4,person3,person2,person)

  println(x.sorted)
}


