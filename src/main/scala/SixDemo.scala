
object SixDemo {
  def main(args: Array[String]) = {
    print("Enter number: ")
    val num= scala.io.StdIn.readInt()
    val evenOdd = if (num%2==0) "EVEN" else "ODD"
    println("Number is "+evenOdd)
    }

  }


