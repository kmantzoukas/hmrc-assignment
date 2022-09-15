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
    sc.items.foldRight(BigDecimal.valueOf(0.0)) {
      case (Apple, total) => Apple.price + total
      case (Orange, total) => Orange.price + total
    }
}
