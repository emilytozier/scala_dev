 object Fruit extends App{
   trait Fruit {

     val code: String

     override def toString: String = s"$code"
   }

   class Apple(val code: String) extends Fruit

   class GalaApple(code: String) extends Apple(code)

   class GreenApple(code: String) extends Apple(code)
   class RedApple(code: String) extends GalaApple(code)


   class Store[-T] {
    // def sell(fruit: T): Unit = println(s"sell $fruit")
     def sell[T <: Fruit](fruit: T): Unit = println(s"sell $fruit")

   }

   val store: Store[GalaApple] = new Store[Apple]

   store.sell(new Apple("Apple-4135"))
   store.sell(new GalaApple("GalaApple-4133"))
   store.sell(new GreenApple("GreenApple-3344"))
   store.sell(new RedApple("GreenApple-3344"))

 }
