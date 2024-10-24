object LogAny {
  println("INIT LogAny")
  trait LogAny
  def log(any: Any): Unit = println(s"INFO: $any")

  case class Error(r: String) extends LogAny

  case class Warn(r: String) extends LogAny

  case class Info(r: String) extends LogAny

  def logInt(log: LogAny): Unit = {
    log match {
      case Error(r) =>
        println(Console.RED + s"Error: ${r}")
      case Warn(r) =>
        println(Console.YELLOW + s"Warn: ${r}")
      case Info(r) =>
        println(Console.GREEN + s"Info: ${r}")
      case _ =>
        "unknown figure"
    }
  }

  def main (args: Array[String]) {

    val er = Error("Can't divide by zero")
    val warn = Warn("You concat string and number")
    val info = Info("Input is deleted")

    println(logInt(er)) //
    println(logInt(warn))
    println(logInt(info)) //
    
  }
}