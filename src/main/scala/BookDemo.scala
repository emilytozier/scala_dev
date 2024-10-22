object BookDemo {
  class Book(val name: String, val author: String, val year: Int)
  object Book {
    def createBook(name: String, author: String, year: Int): Book = new Book(name, author, year)
    def infoBook(name: String, author: String, year: Int): String = {
      new Book(name, author, year)
      s"Book name [$name], author [$author], year [$year]"
    }

  }

  def main(args: Array[String]) {

    val pbook1 = Book.createBook("Dracula","Bram Stoker", 1975)
    val pbook2 = Book.createBook("It", "Stephen King", 1985) //
    val pbook3 = Book.infoBook("Dracula","Bram Stoker", 1975)
    val pbook4 = Book.infoBook("It", "Stephen King", 1985) //
    println(pbook1) //
    println(pbook2)
    println(pbook3) //
    println(pbook4)
  }

}
