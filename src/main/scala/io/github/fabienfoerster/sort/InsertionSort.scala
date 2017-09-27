package io.github.fabienfoerster.sort

import scala.annotation.tailrec

object InsertionSort {
  implicit class ListWithInsertionSort[A <% Ordered[A]](l : List[A]) {
    def sortInsertion: List[A] = {
      @tailrec
      def sort(sorted: List[A],toSort: List[A]): List[A] = {
        if (toSort.isEmpty) sorted
        else sorted match {
          case Nil => sort(List(toSort.head),toSort.tail)
          case _ => sort(insert(toSort.head,Nil,sorted),toSort.tail)
        }
      }

      @tailrec
      def insert(e:A,left:List[A],right:List[A]):List[A] = right match {
        case Nil => left :+ e
        case h1 :: t if h1 < e => insert(e,left :+ h1,t)
        case h1 ::t => left ::: (e :: right)
      }
      sort(Nil,l)
    }
  }
}
