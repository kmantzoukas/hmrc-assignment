package org.hmrc

import org.hmrc.ShoppingCardApplication._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class ShoppingCardApplicationTest extends AnyFlatSpec with Matchers{

  "The cost for an empty list of items" should "be 0.0" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List.empty[ShoppingItem])
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 0.0

    actual mustBe expected
  }

  "The cost function" should "throw a NullPointerException when called with null input" in {
    the [NullPointerException] thrownBy cost(null)
  }

  "The cost of 2 apples when discount is applied" should "be 0.6" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 0.6

    actual mustBe expected
  }

  "The cost of 4 apples when discount is applied" should "be 1.2" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple, Apple, Apple))
    // When
    val actual = cost(input)
    // Then
    val expected: BigDecimal = 1.2

    actual mustBe expected
  }

  "The cost of 3 oranges when discount is applied" should "be 0.5" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Orange, Orange, Orange))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 0.5

    actual mustBe expected
  }

  "The cost of 3 apples and 3 oranges when discount is applied" should "be 1.7" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple, Apple, Orange, Orange, Orange))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 1.7

    actual mustBe expected
  }

}