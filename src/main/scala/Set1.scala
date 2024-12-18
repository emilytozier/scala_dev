
//Напишите функцию, которая принимает на вход два множества Set[Int] и возвращает их объединение в виде нового множества
object Set1 extends App {
  def combineSet(x: Set[Int], y: Set[Int]): Set[Int] = {
    x.++(y)
  }

  val s1 = Set(1, 2, 3)
  val s2 = Set(1, 2, 4, 3, 5, 5, 7, 9, 9)

  println(combineSet(s1, s2))
}

//Напишите функцию, которая принимает на вход множество Set[Int] и элемент, и возвращает новое множество, содержащее все элементы из исходного множества, кроме данного элемента
object Set2 extends App {
  def minusSet(x: Set[Int], y: Int): Set[Int] = {
    x - y
  }

  val s1 = Set(1, 2, 3)
  val s2 = 1

  println(minusSet(s1, s2))
}

//Напишите функцию, которая принимает на вход два Set[Int] и возвращает новое множество, содержащее только те элементы, которые присутствуют только в одном из исходных множеств
object Set3 extends App {
  def combineMinusSet(x: Set[Int], y: Set[Int]): Unit = {

    println(x.diff(y) ++ y.diff(x))
  }

  val s1 = Set(1, 2)
  val s2 = Set(1, 2, 7, 9)

  combineMinusSet(s1, s2)
}

//Напишите функцию, которая принимает Map[String, Option[Int]], и возвращает Map, где ключ - это строка, а значение - удвоенное значение из Option
object Set4 extends App {
  def map(x: Map[String, Option[Int]]): Map[String, Int] = {
    val mapmod: Map[String, Int] = x.collect { case (key, Some(value)) => (key, value) }

    mapmod.map { case (str, i) =>
      val newK = str
      val newV = i * i
      newK -> newV
    }

  }

  val map = Map[String, Option[Int]]("one" -> Some(1),
    "two" -> Some(2),
    "three" -> None)

  val yu: Map[String, Int] = map(map)
  println(yu)
}

//Напишите функцию, которая принимает на вход Map[String, Int] и возвращает новый Map, в котором все значения увеличены на 1
object Set5 extends App {
  def mapList1(x: Map[String, Int]): Map[String, Int] = {

    x.map { case (str, i) =>
      val newK = str
      val newV = i + 1
      newK -> newV
    }

  }

  val map = Map[String, Int]("one" -> 1,
    "two" -> 2,
    "three" -> 3)


  println(mapList1(map))
}

//Напишите функцию, которая принимает на вход Map[String, Int] и возвращает Map'ы, в первой ключи > 0, в другой < 0
object Set6 extends App {
  def mapList2(x: Map[String, Int]): Unit = {
    val moreNull = x.filter(_._2 > 0)
    val lessNull = x.filterNot(_._2 > 0)
    println(s"$moreNull" + " values more than null")
    println(s"$lessNull" + " values less than null")
  }

  val map = Map[String, Int]("one" -> -1,
    "two" -> 2,
    "three" -> 3)


  println(mapList2(map))
}

//Напишите функцию, которая принимает на вход два Map[String, Int] и возвращает новый Map, содержащий только те ключи, которые есть в обоих исходных Map, а значения складываются
object Set7 extends App {
  def mapList3(map1: Map[String, Int], map2: Map[String, Int]): Map[String, Int] = {
    val u: Map[String, Int] = map1 -- map2.keySet ++ map2 -- map1.keySet
    val v: Map[String, Int] = map1 ++ map2 -- u.keySet
    v.map { case (k, v) => k -> (v + map1.getOrElse(k, 0)) }

  }

  val map1 = Map[String, Int]("one" -> -1,
    "two" -> 2,
    "three" -> 3)

  val map2 = Map[String, Int]("one" -> -1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4)


  println(mapList3(map1, map2))
}

//Напишите функцию, которая принимает на вход два Map[String, Int] и возвращает новый Map, содержащий только те ключи, у которых значения равны

object Set8 extends App {
  def mapList(map1: Map[String, Int], map2: Map[String, Int]): Map[String, Int] = {
    val map3 = map1.keySet.intersect(map2.keySet)
    map1.filter { case (k, v) =>
      map3.contains(k) && map2.get(k).contains(v)
    }
  }

  val map1 = Map[String, Int]("-1" -> -1,
    "2" -> 2,
    "1" -> 1)

  val map2 = Map[String, Int]("-1" -> -1,
    "24" -> 2,
    "14" -> 1,
    "4" -> 4)

  println(mapList(map1, map2))
}

object MapAppV2 extends App {
  val m1: Map[String, Int] = Map("-1" -> -1, "2" -> 2, "1" -> 1)
  val m2: Map[String, Int] = Map("-1" -> -1, "1" -> 1, "2" -> 1)

  def eqValues(m1: Map[String, Int], m2: Map[String, Int]) = {
    val keysFromBothMaps = m1.keySet.intersect(m2.keySet)

    m1.filter { case (k, v) =>
        keysFromBothMaps.contains(k) && m2.get(k).contains(v)
      }
      .map { case (k, v) => v -> k }

    m1.foldLeft(Map.empty[Int, String]) { case (acc, (k, v)) =>
      if (keysFromBothMaps.contains(k) && m2.get(k).contains(v)) {
        acc ++ Map(v -> k)
      } else acc
    }
    //def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1
    val x = Option.empty[Int].toList.fold(1) { case (acc, e) =>
      ???
    }
    //def foldLeft[B](z: B)(op: (B, A) => B): B
    val x2 = Option.empty[Int].toList.foldLeft("1") { case (acc, e) =>
      ???
    }

    List(List(1)).fold(Iterable.empty[Int]) { case (acc, e) => ??? }
    List(List(1)).foldLeft(Iterable.empty[Int]) { case (acc, e) => ??? }

  }

  println(eqValues(m1, m2)) // Map(-1 -> -1, 1 -> 1)
}