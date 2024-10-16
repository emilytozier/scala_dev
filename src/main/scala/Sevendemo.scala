object Sevendemo {
  def main(args: Array[String]) = {
    print("Enter number: ")
    val input = scala.io.StdIn.readLine()
    if (input.isBlank) {
      println("Number is blank")
    } else {
      val bi = BigInt(input)
      val evenOdd = if (bi == 0) "zero" else if (bi > 0) "POSITIVE" else "NEGATIVE"
      println("Number is " + evenOdd)
    }
  }
}

