import OrderingCase.Person

object Generics extends App{

//Напишите обобщенную функцию, которая принимает список элементов типа T и возвращает первый элемент списка
  def listGenericDef[A](input: Seq[A]): A = input(0)
  case class Person(name: String, age: Int)
  val person  = Person("Peter",28)
  val person2 = Person("Janny",22)
  val person3= Person("Stewart", 42)
  val person4=Person("Tabita", 54)
  val person7  = Person("Peter",28)
  val person6=Person("Tabita", 54)
  val x= List[Person](person4,person3,person2,person,person6,person7)
  val z = List[Int](1,2,3,4,5,4,8,8,2)
  println(listGenericDef(x))
  println(listGenericDef(z))

//Напишите обобщенную функцию, которая принимает список элементов типа T и возвращает новый список, содержащий только уникальные элементы исходного списка
def setGenericDef[A](input: Seq[A]): List[A] = {
  val p = input.toSet.filter (i => input.indexOf (i) == input.lastIndexOf (i))
  p.toList
}
  println(setGenericDef(x))
  println(setGenericDef(z))



//Напишите обобщенную функцию, которая принимает список элементов типа T и возвращает количество элементов в этом списке

def quantGenericDef[A](input: Seq[A]): Int = input.length
  println(quantGenericDef(x))
  println(quantGenericDef(z))

//Напишите обобщенную функцию, которая принимает список элементов типа T и функцию преобразования
// типа T в тип U, и возвращает список элементов типа U, полученных применением этой функции к каждому элементу исходного списка

  def map[T, U](list: List[T])(f: T => U): List[U] = {
    list.map(f)
  }
  val numbers = List(1, 2, 3, 4, 5)
  val str11 = List("one", "two", "three")
  val squares = map(numbers)(x => x * x)
  val doub = map(numbers)(x => x.toDouble)
  val strings = map(str11)(_.toUpperCase)
  val strinfFromNum= map(numbers)(x => x.toString)
  val char1= map(numbers)(x => x.toByte)

  println(doub)
  println(squares)
  println(strings)
  println(char1)
  println(strinfFromNum)

}