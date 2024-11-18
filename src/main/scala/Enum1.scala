//Напишите функцию, которая принимает на вход два значения из перечисления (Enumeration) и возвращает список всех значений между ними
object Enum1 extends Enumeration{
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  // Main Method

    def value(i: WeekDay, j: WeekDay): Unit = {
      
      for (a <- i.id+1 to j.id-1) println(Enum1(a))

    }
  //
    def main(args: Array[String]) {

      Enum1.value(Mon,Sun)
    }
}
