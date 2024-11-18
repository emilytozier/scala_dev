import scala.util.{Failure, Success}

object SixLectionEither extends App{
  case class ClassWithOpt(id: Long, name: Option[String])

  val cwo = ClassWithOpt(1, Option("Urza"))

  def loadCWO: Option[ClassWithOpt] = Option(ClassWithOpt(1, Option("Urza")))
//в этом примере переменной присваивается цикл фор который вызывает метод loadCWO и присвавает с создаваемый в этом
//методе опшн, а name параметр этого объекта
  val cwoNameOptV2 = for {
    c <- loadCWO
    name <- c.name
  } yield name
  println(cwoNameOptV2)//Some(Urza)
    //тоже самое только кратко
  val cwoNameOptV3 = for {
    ClassWithOpt(_, n) <- loadCWO
    name <- n
  } yield name

  println(cwoNameOptV3)//Some(Urza)
 //my example

  case class UserOpt(name: Option[String], age: Int)
//this list wiil be filtered to obtain only users older 30 and younger 40
  val userBase = List(
    UserOpt(Option("Travis"), 28),
    UserOpt(Option("Kelly"), 33),
    UserOpt(Option("Jennifer"), 44),
    UserOpt(Option("Dennis"), 23))

  val thirtySomethings =
    for {userOpt <- userBase if userOpt.age >= 30 && userOpt.age < 40}
      yield userOpt.name // т. е. добавить результат к списку

  thirtySomethings.foreach(println) // выводит "kelly"

//default trait в котором прописывается базовая реализация методов флетмеп, меп, филтер...
// реализация предусматривает 2 варианта, - если А приходит пустая и не пустая
  trait ForCompSupport[A] {
//если а не пустая, получаем значение, преобразуем  в  В
    def flatMap[B](f: A => ForCompSupport[B]): ForCompSupport[B] =
      if (isEmpty) ForCompSupportTestEmpty[B]() else f(this.get)

    def map[B](f: A => B): ForCompSupport[B] =
      if (isEmpty) ForCompSupportTestEmpty[B]() else ForCompSupportTest(f(this.get))

    // eq filter))
    def withFilter(p: A => Boolean): ForCompSupport[A] =
      if (isEmpty || p(this.get)) this else ForCompSupportTestEmpty[A]()

    def isEmpty: Boolean = this == ForCompSupportTestEmpty[A]()

    def get: A
  }

  object ForCompSupport extends App {
    def apply[A](i: A): ForCompSupport[A] = if (i == null) ForCompSupportTestEmpty() else ForCompSupportTest(i)
  }
//обрабатывает случай когда гет делается на пустом значении
  case class ForCompSupportTestEmpty[A]() extends ForCompSupport[A] {
    override def get: A = throw new Exception("ForCompSupportTestEmpty !!!")
  }

  case class ForCompSupportTest[A](i: A) extends ForCompSupport[A] {
    override def get: A = i
  }

  object ForCompSupportTestAAA extends App {
      val x1_1 = ForCompSupport(null)
      val x1_2 = ForCompSupport("111")
      println(x1_1)
      println(x1_2)

    val fcst = ForCompSupportTest(2).map { i => i * i }
    val fcstStr = ForCompSupportTest("1")

    val x = for {
      x <- fcst
      if x > 2
      x1 <- fcstStr
    } yield x + x1
    println(x)
  }
//
  import scala.util.Try

  case class Id(id: Int)

  def mayBeThrowException: Try[Id] = Try {
   // Id(1) //if we leaave exception then method returns excetion even if ID(1)
    throw new Exception("exception")//if we comment exception then method returns isSuccess=true
  }

  mayBeThrowException match {
    case Failure(exception) =>
      println(exception.getMessage)
    case Success(value) =>
      println(value)
  }
  val isSuccess = mayBeThrowException.isSuccess
  val isFailure = mayBeThrowException.isFailure
  println(isFailure)//print true
  println(isSuccess)//print false

 //my example - transfer int to double, why exception is not catched?
  def modify(num: Int): Option[Double] =
    try {
      val double = num.toDouble
      Some(double)
    } catch {
      case e: Exception =>
        None
    }


//another way of writing modify, still not catched
//  def modify(num: Int): Try[Double] =
//    Try(num.toDouble)


  println(modify(1234)) // Option[Int] = Some(1234)
  println(modify(-3)) // Option[Int] = Some(-1)
 // println(modify(0/0))

  //в modify должен быть передан параметр, модифиц 4 иначе выдает 0
  val withGetOrElse = modify(4).getOrElse(Option(0.0))
  //returns doubleValue; Some(5.0), тип проверила опшн дабл alt+enter
  val withMap = modify(5).map(_.doubleValue)
  println(withMap)
 //этот метод выкидывает ava.lang.Exception: exception
  def mayBeThrowExceptionV2: Try[Id] = Try {
    //throw new Exception("exception")
    Id(1)
  }
  println("withmapFail")
//mayThrowexceptionV2  мы подстраховыались на случай если mayBeThrowException выкинет исключение, если такое - то withMapFail отображает Success(Failure(java.lang.Exception: exception))
  val withMapFail = mayBeThrowException
    .map(id => id.id)
    .map(_ => mayBeThrowExceptionV2)
  println(withMapFail)
  //разница в том что здесь печатается Success(Failure(java.lang.Exception: exception))
  val withMap1 = mayBeThrowException.map(_ => mayBeThrowExceptionV2)
  println(withMap1)
    //здесь печатаестя без обертки в виде трая Failure(java.lang.Exception: exception)
  val withFlatMap = mayBeThrowException.flatMap(_ => mayBeThrowExceptionV2)
  println(withFlatMap)


  val filteredFail = mayBeThrowException.filter(_.id != 0)
 // filteredFail.print // Failure(java.lang.Exception: exception)
  val filteredSuc = mayBeThrowExceptionV2.filter(_.id != 0)
 // filteredSuc.print //Success(Id(1))
  val filteredFailByFilter = mayBeThrowExceptionV2.filter(_.id == 0)
 // filteredFailByFilter.print //Failure(java.util.NoSuchElementException: Predicate does not hold for Id(1))
//  Функция
//  , переданная в foreach
//  , выполняется только в том случае
//  , если Try содержит Success

 // mayBeThrowException.foreach(println(_.id)) // do nothing
 // mayBeThrowExceptionV2.foreach(_.id.print) // 1
  //recover -
//  если значение, на котором был вызван метод recover, завершится успешно, будет возвращён результат Success
 //   при исключении, будет вызвана функция в recover, результат которой будет обернут в Success

  val recoverFail = mayBeThrowException.map(_.id.toString).recover { case _ =>
    "fail!"
  }
  println(recoverFail) //Success(fail!) - чтобы увидеть оба результата меняем результат выполнения  mayBeThrowException

  val recoverSuc = mayBeThrowExceptionV2.map(_.id.toString).recover { case _ =>
    "fail!"
  }
  println(recoverSuc) //Success(1)


  def mayBeThrowExceptionV3(id: Id): Try[Id] = Try {
    Id(id.id + 1)
  }

  val res1 = mayBeThrowExceptionV2.flatMap(mayBeThrowExceptionV3)
  println(res1) // Success(Id(2))
 //cначала сюда попадает id возвращенный из mayBeThrowExceptionV2 как параметр для mayBeThrowExceptionV3 дальше в mayBeThrowExceptionV3- прибавл-ся 1
  val res2 = for {
    id1 <- mayBeThrowExceptionV2
    id2 <- mayBeThrowExceptionV3(id1)
  } yield id2
  println(res2) // Success(Id(2))

}
//От Either наследуют всего два класса: Left и Right
//Если значение Either[A, B] содержит значение типа A,
//тогда Either содержит Left, иначе оно содержит значение типа B обёрнутое в класс Right
//Но по соглашению Left отвечает за ошибки/исключения,
//а Right — за успешно вычисленное значение
object Either extends App {
  def getInfoFromUrl(url: String): Either[String, Int] =
    if (url.isEmpty) Left("Empty url!")
    else Right(42)
  //here result gets into right
  val res1 = getInfoFromUrl("AAA")
  println(res1) // Right(42)
  //here into left
  val res2 = getInfoFromUrl("")
  println(res2) // Left(Empty url!)

  //returns Empty Url!
  getInfoFromUrl("") match {
    case Left(er) => println(er)
    case Right(value) => println(value)
  }

 //either можно мапить
  val res3 = getInfoFromUrl("BBB").map(_.toLong)
  println(res3)
  println("------")
  val res4 = getInfoFromUrl("").map(_.toLong)
  println(res4)

  getInfoFromUrl("AAA").right
  getInfoFromUrl("BBB").left
  getInfoFromUrl("").left

  //здесь выбираем что в случае если выпало left (в последнем случае) - оборачиваем строку в !!!
  getInfoFromUrl("AAA").right.map(i => i + 1) // eq getInfoFromUrl("AAA").map(_ + 1)
  getInfoFromUrl("BBB").left.map(s => s"!!! $s !!!") //s: String
  getInfoFromUrl("").left.map(s => s"!!! $s !!!") //s: String

  //Для either есть метод flatMap, работает он так:
  val res6 = getInfoFromUrl("AAA").flatMap { x =>
    getInfoFromUrl("BBB").map { y =>
      x + y
    }
  }

  println("__!!!")
  println(res6)
  //В этом примере тип res6 будет равен Either[String, Int], но вернется только x+y=84
  //если бы изначально у нас был map, то мы бы получили вложенный either

  //Можно переписать пример с flatMap через фор, будет тоже самое

  val res8 = for {
    x <- getInfoFromUrl("AAA")
    y <- getInfoFromUrl("BBB")
  } yield x + y

  println(res8)

//Some(42)
  val toOptSome = getInfoFromUrl("sss").toOption
  println(toOptSome)
  //None
  val toOptNone = getInfoFromUrl("").toOption
  println(toOptNone)

  //В целом, either в основном используется для обработки ошибок,
  //там где обычного Try недостаточно
  //Либо в обработке коллекций, если в какой-то момент что-то может пойти не так,
  //но при этом не возникает ошибка,
  //исключающая дальнейшую обработку элементов коллекции

  //Предположим, у нас есть какая-то персональная информация
  //
   case class PersonalInfo(id: Long, contractNumber: String, phone: String)

  val infos = List(
    PersonalInfo(1, "42", "99"),
    PersonalInfo(2, "", "1"),
    PersonalInfo(3, "24", ""),
    PersonalInfo(4, "11", "22")
  )
//save ifo into DB
def insertToDB(pi: PersonalInfo): Unit = println(s"Insert to DB: $pi")
//Теперь, допустим, мы хотим сохранить только тех,
  //у кого не пустой контракт и есть номер телефона.
  //И после обработки списка, нам нужно понять кого мы сохранили, а кого нет

  //здесь отсеяли тех у кого не нулевой телефон и контракт и их добавили в базу и в Right, на сотальных метод InsertToDB не вызывали, а залогировали
val res = infos.map {
  case pi: PersonalInfo if pi.contractNumber.isEmpty =>
    Left(s"$pi => contractNumber isEmpty")
  case pi: PersonalInfo if pi.phone.isEmpty =>
    Left(s"$pi => phone isEmpty")
  case pi =>
    insertToDB(pi)
    Right(pi.id)
}

  res.foreach(println(_))


}