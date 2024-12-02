import scala.concurrent.ExecutionContext.Implicits.global
import java.util.concurrent.Executors
import java.util.concurrent.Flow.Publisher
import scala.collection.mutable.ListBuffer
import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success, Try}
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, DurationInt}
//Напишите функцию, которая принимает список строк и возвращает список Future, каждый из которых содержит длину соответствующей строки
object FutureApp extends App{

  def inInt(str: List[String]): List[Future[Int]] =  {
    str.map(s => Future(s.length))  }


  val str11 = List("one", "tw555o", "three")
  println(inInt(str11))

}

//Напишите функцию, которая принимает список Future[Int] и возвращает Future[Int], представляющий сумму всех значений в этих Future
object FutureApp2 extends App{
  val listofFutures = List(
    Future(1),
    Future(2),
    Future(3)
  )
  def inFuture(int: List[Future[Int]]): Future[Int] =  {
    Future.sequence(int).map(_.sum)
  }

  println(Await.result(inFuture(listofFutures), Duration.Inf))


}
//Напишите функцию, которая принимает список Future[String] и возвращает Future[List[String]], содержащий все значения из исходного списка, преобразованные в верхний регистр
object FutureApp3 extends App{
  val listofFutures = List(
    Future("str"),
    Future("fg"),
    Future("hgfd")
  )
  def inList(str: List[Future[String]]): Future[List[String]] =  {
    Future.sequence(str)
  }
  val someOperationOnFuture: Future[List[String]] = inList(listofFutures).map(_.map(_.toUpperCase()))

  println(Await.result(someOperationOnFuture, Duration.Inf))


}
//Напишите функцию, которая асинхронно вызывает две функции, возвращающие Future[Int], и выводит на экран результат их суммы

object FutureApp4 extends App {
  val reOkay: Future[Int] = Future {
    println("Мы еще не начали считать")
    Thread.sleep(Random.nextInt(2000))
    println("ща начнем")
    111*56
  }
  val reNeOkay: Future[Int] = Future {
    println("Мы еще не начали считать")
    Thread.sleep(Random.nextInt(1000))
    println("опанцы а мы уже посчитались!")
    3+2
  }


  Await.result(for {result1 <- reOkay; result2 <- reNeOkay} yield (println( result1+ result2)), Duration.Inf)

}


