import scala.language.postfixOps

object LectionOption extends  App{
  val o1: Option[Int] = Option(1) // Some(1)// o1  является контейнером для 1
  val o2: Option[Int] = None // None // o2  является контейнером в котором нет значения оно не определено
  val o3: Option[Int] = Option.empty[Int] // является контейнером в котором пустое значение
  val o4: Option[String] = Option("Take string")
//  val o5: Option[Int] = Option(null) // является контейнером для 0
  //new example with string
  o4 match {
    case Some(s) if(s==" ") => println("no string entered - empty space")
    case Some(s) if(s=="_") => println("no string entered")
    case Some(s) => println(s)
    case _ => println("no string entered")
  }
  // применяет контейнс к строке переданной в качестве агрумента
    o4.map { x =>
        println("This is string!")
        println(x.contains('a'))
      }

  val o1Value = o1.get//лучше не использовать иначе выдаст ошибку
  val o1ValueV2 = o2.getOrElse(2) //лучше исп-ть т.к. если передать о2 - даст 2
  println(o1Value)
  println(o1ValueV2)
  println(o3.isEmpty) // true if None
  println(o3.isDefined) // eq !isEmpty
  println(o3.nonEmpty) // eq isDefined
  println(o4.nonEmpty) //check if string is non empty

  println(o3.contains(1)) // Some(a) => true if 1 eq a -  проверяет содержится ли в опшн нужное значение

  println(o1.filter(_ > 0)) // Some() if f in filter return true; None if in option would be -1
  println(o1.filter(_ isValidShort) //new example - возр-т true None - это шорт
    println (o1.filterNot(_ < 0)) // Some() if f in filterNot return false; filter and leave values for which condition не выполняется
    println (o1.filterNot(_ isValidLong)) //new example - возв-т NOne поскольку 1 - это лонг
    println (o1.exists(_ > 1)) // true if f in exists return true внутри опшн нет значений больше 1
    println (1.forall(_ == 1))
  o1 match {// проверяет попадает ли значение о1 в один из этих матчей и обрабатывает их соот-но
    case Some(value) if value < 0 => s"!$value!".print
    case Some(value) => value.print
    case None => "None!".print
  }
//
//
  //Option(Option(1)) => Option(1)
  val optionOption = Option(Option("ha!"))
  optionOption.print //Some(Some(ha!))// опшн в опшне
  val optionOptionFlatten = optionOption.flatten
  optionOptionFlatten.print //Some(ha!) разворачивает на уровеь опшна

  val optionNone = Option(Option.empty[String])
  optionNone.print // Some(None)Извлекает контейнер с some(none)
  val optionNoneFlatten = optionNone.flatten
  optionNoneFlatten.print // None теперь уже извлечет none

  // если в some есть значение то оно применяется к функции в скобках;
  val o1Mapped = o1.map(_ * 10).map(_.toString) // eq o1.map(x => x * 10).map(x => x.toString)
  val o2Mapped = o3.map(_ * 10).map(_.toString)
  //
  println(o1Mapped)
  println(o2Mapped)
  //для каждого значения внутри скобок применить ф-ю, в данном случае принт, которую почему-то
  // не может проглотить мой компилятор
//  o1.foreach(_.print)// eq o1.foreach(x => x.print)

  o2.map { x =>//здесь операция прервется и вернется None
    "Look!".print
    x * 10
  }
  o2.foreach(_ => "Look!".print)


  //
  case class ClassWithOpt(id: Long, name: Option[String])

  val cwo = ClassWithOpt(1, Option("Urza"))
  def loadCWO: Option[ClassWithOpt] = Option(ClassWithOpt(1, Option("Urza")))
  //здесь флетмапа выцепляет some с именем внутри; Если посмотреть на сигнатуру метода flatMap,
  // то мы видим, что он принимает функцию, возвращающую option, а сам flatMap возвращает option
  val cwoNameOpt = loadCWO.flatMap(_.name)
  println(cwoNameOpt)


  val cwoNameOptV2 = for {
    c <- loadCWO
    name <- c.name
  } yield name


  o1.map { _ =>
    "1".print
    None
  }.flatMap { _ =>
    "2".print
    Option.empty[Int]
  }.map { _ =>
    "3".print
    3
  }.print

}


