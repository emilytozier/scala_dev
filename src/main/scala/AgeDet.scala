object AgeDet extends App{

  //  def main(args: Array[String]) = {
  def isOld(et: Option[Int]): String = {
    et match {
      case Some(value) if value < 13 => "Kid"
      case Some(value) if (value > 13 && value < 30) => "Teenage"
      case Some(value) if (value > 30 && value < 70) => "Grown up"
      case Some(value) if (value > 70 && value < 100) => "Old man"
      case Some(value) if (value > 100) => "Not eligible"
      case None => "None!"
    }
  }


  val obj1 = Option(56)
  val obj2 = Option(2)

  val x = isOld(obj2)
  println(x)

}

