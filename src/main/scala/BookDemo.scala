//Создайте класс "Книга" с полями "заголовок", "автор" и "год издания". // далее все что в "" - переводить на англ, тут на русском для облегчения восприятия
//Переопределите в нем метод toString.
//Создайте companion object для класса "Книга", в котором будет метод createBook, принимающий "название", "автора" и "год выпуска", и возвращающий объект Book с этими значениями. Создайте таким образом экземпляр Book и выведите его в консоль.
object BookDemo {
  class Book(val name: String, val author: String, val year: Int) {
    override def toString: String = s"(name $name, author $author, year $year)"
  }
  
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
