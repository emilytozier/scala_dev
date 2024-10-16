object Sevendemo {
  def main(args: Array[String]) = {
    var num:BigInt=0
    var evenOdd:String=""
    print("Enter number: ")
    num= scala.io.StdIn.readInt()
    evenOdd = if (num==0) "NULL" else if (num>0) "POSITIVE" else "NEGATIVE"
    println("Number is "+evenOdd)
  }

}