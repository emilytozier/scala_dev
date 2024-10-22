object OptionWord extends App {

  //  def main(args: Array[String]) = {
  def isClass(et: Option[String]): String = {

    if (et.exists(_.contains("Class"))) s"Word is here" else s"Word is not here"
  }


  val obj = Option("Case Class Study")

  val x = isClass(obj)
  println(x)


}
