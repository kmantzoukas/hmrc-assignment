package org.hmrc

object ShoppingCardApplication {

  sealed trait ShoppingItem {
    val price: BigDecimal
  }

  case object Apple extends ShoppingItem {
    override val price: BigDecimal = 0.6
  }

  case object Orange extends ShoppingItem {
    override val price: BigDecimal = 0.25
  }

  case class ShoppingCard(items: List[ShoppingItem])

  def discount(size: Int, price: BigDecimal, numberOfItemsFree: Int) = (size / numberOfItemsFree) * price

  def appleDiscount(size: Int) = discount(size, Apple.price, 2)

  def orangeDiscount(size: Int) = discount(size, Orange.price, 3)

  def cost(sc: ShoppingCard, applyDiscount: Boolean = false): BigDecimal = {
   sc.items
     .groupMap(identity)(_.price).view.mapValues(prices => (prices.size, prices.sum))
     .foldRight(BigDecimal.valueOf(0.0)){
      case ((itemType, (numberOfItemsPerType, costOfItemsPerType)), total: BigDecimal) => itemType match {
        case Apple => total + (costOfItemsPerType - (if(applyDiscount) appleDiscount(numberOfItemsPerType) else 0.0))
        case Orange => total + (costOfItemsPerType - (if(applyDiscount) orangeDiscount(numberOfItemsPerType) else 0.0))
      }
    }
  }
}