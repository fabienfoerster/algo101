package io.github.fabienfoerster.sort

object Quicksort {
  implicit class ListWithQuicksort[A](l: List[A])(implicit ev: A => Ordered[A]) {
    def quicksort: List[A] = {

      def sort(l: List[A]): List[A] = l match {
        case Nil => Nil
        case a :: Nil => List(a)
        case a :: t => sort(t.filter(x => x <= a)) ::: List(a) ::: sort(t.filter(x => x > a))
      }
      sort(l)

    }
  }

}
