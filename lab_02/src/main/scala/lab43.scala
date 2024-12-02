def sumArrayRec3(elems: Array[Int]): Int =
    def goFrom(i: Int, size: Int, elms: Array[Int]): Int =
        if (i < size) elms(i) + goFrom(i + 1, size, elms)
        else 0
    goFrom(0, elems.length, elems)

@main def ex43_01(): Unit =
    println("sumArrayRec3 = " + sumArrayRec3((0 until 30000).toArray))
