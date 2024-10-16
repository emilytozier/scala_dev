object TenDemo {
  def main(args: Array[String]) = {

    def factorial(n: Int): Int = {
      if (n <= 0) 1
      else n * factorial(n - 1)
    }

    println(factorial(10))

  }
  def factorialWithTailRecursion(n: Int): Int = {
    def loop(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n, 1)
  }
  println(factorialWithTailRecursion(10))



}

