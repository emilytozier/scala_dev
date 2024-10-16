
object SixDemo {
  def main(args: Array[String]) = {
    var num:Int=0
    var evenOdd:String=""
    print("Enter number: ")
    num= scala.io.StdIn.readInt()
    evenOdd = if (num%2==0) "EVEN" else "ODD"
    println("Number is "+evenOdd)
    }

  }


