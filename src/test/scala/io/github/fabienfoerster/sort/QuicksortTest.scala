package io.github.fabienfoerster.sort

import org.scalatest._
import io.github.fabienfoerster.sort.Quicksort._

class QuicksortTest extends FlatSpec with Matchers{
  "A list with quicksort " should "return the sorted list" in {
    val list = List(9,8,7,2,1,9)
    val expected = List(1,2,7,8,9,9)

    list.quicksort should be (expected)
  }
}
