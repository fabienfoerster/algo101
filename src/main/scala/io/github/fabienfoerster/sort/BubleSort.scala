package io.github.fabienfoerster.sort

object BubleSort {

  implicit class ListWithBubbleSort[A <% Ordered[A]](l: List[A]) {
    def sortBubble :List[A] = {
      def sort(list:List[A],toSort:List[A],sorted:List[A]): List[A] = toSort match {
        case Nil => if (list.isEmpty) sorted else sort(Nil,list,sorted)
        case h1 :: Nil => sort(Nil,list,h1 :: sorted)
        case h1 :: h2 :: t => if (h1 > h2) sort(list :+ h2,h1 :: t, sorted) else sort(list :+ h1, h2::t,sorted )
      }
      sort(Nil,l,Nil)
    }

    }

  }
