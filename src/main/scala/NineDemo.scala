object NineDemo {
  def main(args: Array[String]) = {

    println("mult tableau 5:");
    for (i <- 1 until 11) {
      println(s"$i*5 = "+ i*5);
    }
    println("mult tableau 10:");
    for (i <- 1 until 11) {
      println(s"$i*10 = "+ i*5);
    }
  }

}
