package org.hmrc

object ShoppingCardApplication {

  sealed trait ShoppingItem

  case object Apple extends ShoppingItem {
    val price: BigDecimal = 0.6
  }

  case object Orange extends ShoppingItem {
    val price: BigDecimal = 0.25
  }

  case class ShoppingCard(items: List[ShoppingItem])

  def cost(sc: ShoppingCard): BigDecimal =
    sc.items.foldRight((BigDecimal.valueOf(0.0), 0, 0)) {
      case (Apple, (total, numOfApples, numOfOranges)) =>
        (total + (if((numOfApples + 1) % 2 == 0 ) 0.0 else Apple.price), numOfApples + 1, numOfOranges)
      case (Orange, (total, numOfApples, numOfOranges)) =>
        (total + (if((numOfOranges + 1) % 3 == 0) 0.0 else Orange.price), numOfApples, numOfOranges + 1)
    }._1
}
