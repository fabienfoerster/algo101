package io.github.fabienfoerster.sort

import scala.annotation.tailrec

object InsertionSort {
  implicit class ListWithInsertionSort[A](l : List[A])(implicit ev: A => Ordered[A]) {
    def sortInsertion: List[A] = {
      @tailrec
      def sort(sorted: List[A],toSort: List[A]): List[A] = {
        if (toSort.isEmpty) sorted
        else sorted match {
          case Nil => sort(List(toSort.head),toSort.tail)
          case _ => sort(insert(toSort.head,sorted),toSort.tail)
        }
      }

      // we can use partition to insert the element because the list is already sorted
      def insert(e:A,list:List[A]):List[A] = {
        val (left,right) = list.partition(i => i <= e)
        left ::: (e :: right)
      }
      sort(Nil,l)
    }
  }
}
