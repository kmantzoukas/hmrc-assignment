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

  def cost(shoppingCard: ShoppingCard): BigDecimal = {
    val (apples, oranges) = shoppingCard.items.partition {
      case Apple => true
      case Orange => false
    }
    (apples.size - (apples.size / 2)) * Apple.price + (oranges.size - (oranges.size / 3)) * Orange.price
  }
}