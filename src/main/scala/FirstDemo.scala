object FirstDemo {
  def main(args: Array[String]) = {
    val addMult = (x: Int) => s"Number $x "+ "square " + {x * x}
    println(addMult(1)) 
    println(addMult(5)) 
    println(addMult(534))
  }
}

