
class MusicInstrument


object MusicInstrument {
  def apply(productionYear: Int) = new MusicInstrument

  case class Guitar(productionYear: Int) extends MusicInstrument

  case class Piano(productionYear: Int) extends MusicInstrument
  
  def main(args: Array[String]) {

    var guitar = Guitar.apply(2024)
    println(guitar)
  }
}




