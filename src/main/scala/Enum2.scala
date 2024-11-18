//Создайте перечисление (реализовать 2 варианта) дней недели и напишите функцию, которая принимает на вход день недели и возвращает следующий за ним день
object Enum2 extends Enumeration{
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  // Main Method

  def value1(i: WeekDay): Unit = {    
    println(this(i.id+1))
  }

  
  //
  def main(args: Array[String]) {
    Enum2.value1(Mon)   
  
  }
}

object Enum3 extends Enumeration{
  protected case class Wday(i: Int, s: String) extends super.Val(i) {
    def printRGBValue(): Unit = println(s"${this.getClass.getSimpleName} day is $s")
  }
  type WeekDay = Wday
  val Mon = Wday(1,"Monday")
  val Tue = Wday(2, "Tuesday")
  val Wed = Wday(3, "Wednesday")
  val Thu = Wday(4, "Thursday")
  val Fri = Wday(5, "Friday")
  val Sat = Wday(6, "Saturday")
  val Sun = Wday(7, "Sunday")
  // Main Method

  def value2(i: WeekDay): Unit = {
    println(this(i.id+1))
    
  } 
  //
  def main(args: Array[String]) {
    Enum3.value2(Mon)   
  }
}