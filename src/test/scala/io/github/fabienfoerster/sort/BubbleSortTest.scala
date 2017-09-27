package io.github.fabienfoerster.sort

import org.scalatest._
import io.github.fabienfoerster.sort.BubleSort._

class BubbleSortTest extends FlatSpec with Matchers {

  "A collection sorted with buble io.github.fabienfoerster.sort" should "return the collection sorted" in {

    val list = List(5,9,1,3,2,4,7,8,6)
    val expected  = List(1,2,3,4,5,6,7,8,9)

    list.sortBubble should be (expected)
  }

  it should "return empty collection if the collection is Empty" in {
    val list:List[Int] = List()
    val expected = List()

    list.sortBubble should be (expected)
  }



}
