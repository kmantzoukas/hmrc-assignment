package org.hmrc

import org.hmrc.ShoppingCardApplication._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class ShoppingCardApplicationTest extends AnyFlatSpec with Matchers{

  "The cost of 2 oranges" should "be 0.5" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Orange, Orange))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 0.5

    actual mustBe expected
  }

  "The cost or 2 apples" should "be 1.2" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 1.2

    actual mustBe expected
  }

  "The cost of 2 apples and 2 oranges" should "be 1.7" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple, Orange, Orange))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 1.7

    actual mustBe expected
  }

  "The cost of 3 apples and 1 orange" should "be 2.05" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List(Apple, Apple, Orange, Apple))
    // When
    val actual: BigDecimal = cost(input)
    // Then
    val expected: BigDecimal = 2.05

    actual mustBe expected
  }

  "The cost of an empty list of items" should "be 0.0" in {

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
    val actual: BigDecimal = cost(input, applyDiscount = true)
    // Then
    val expected: BigDecimal = 0.6

    actual mustBe expected
  }

  "The cost of 4 apples when discount is applied" should "be 1.2" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple, Apple, Apple))
    // When
    val actual = cost(input, applyDiscount = true)
    // Then
    val expected: BigDecimal = 1.2

    actual mustBe expected
  }

  "The cost of 3 oranges when discount is applied" should "be 0.5" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Orange, Orange, Orange))
    // When
    val actual: BigDecimal = cost(input, applyDiscount = true)
    // Then
    val expected: BigDecimal = 0.5

    actual mustBe expected
  }

  "The cost of 3 apples and 3 oranges when discount is applied" should "be 1.7" in {

    // Given
    val input: ShoppingCard = ShoppingCard(List[ShoppingItem](Apple, Apple, Apple, Orange, Orange, Orange))
    // When
    val actual: BigDecimal = cost(input, applyDiscount = true)
    // Then
    val expected: BigDecimal = 1.7

    actual mustBe expected
  }
}