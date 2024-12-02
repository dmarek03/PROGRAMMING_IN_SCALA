import scala.annotation.tailrec

def checkPredicate(
    pred: Boolean,
    predAsString: String,
    prefix: String = "Checking if "
                  ): Unit =

    if (pred) println(prefix + predAsString + ": OK")
    else println(prefix + predAsString + ":Fail")


def sumArrayIter(elems: Array[Int]): Int = {
    var sum = 0
    for(i <- elems) sum += i
    sum
}

def sumArrayRec1(i: Int, elems: Array[Int]):Int =
    if( i < elems.length) elems(i) + sumArrayRec1(i+1, elems)
    else 0


def sumArrayRec2(elems: Array[Int]): Int =
    val size = elems.size
    def goFrom(i:Int):Int =
        if(i < size) elems(i) + goFrom(i+1)
        else 0

    goFrom(0)


def sumSqArrayIter(elems: Array[Int]):Int =
    var sqSum = 0
    for (i <- elems) sqSum += i*i
    sqSum


def sumSqArrayRec1(i: Int, elems: Array[Int]): Int =
    if(i < elems.length) elems(i)*elems(i) + sumSqArrayRec1(i+1, elems)
    else 0


def sumSqArrayRec2(elems: Array[Int]):Int =
    val size  = elems.size

    def goFrom(i:Int):Int =
        if(i < size) elems(i)*elems(i) + goFrom(i+1)
        else 0

    goFrom(0)



def maxIter(elems: Array[Int]): Int =
    var max: Int = elems(0)
    for(i <- elems) if (i > max) max = i
    max


@tailrec
def maxRec1(i: Int, maxEl: Int, elems: Array[Int]): Int =
    if(i< elems.length) maxRec1(i+1, math.max(elems(i), maxEl), elems)
    else maxEl


def maxRec2(elems: Array[Int]): Int =
    val size = elems.size
    @tailrec
    def goFrom(i:Int, maxEl:Int, size:Int): Int =
        if( i < size) goFrom(i+1, math.max(elems(i), maxEl), size)
        else maxEl

    goFrom(0, elems(0), size)


@main def ex42_01(): Unit =
    val aiTo5 = (1 to 5).toArray
    println("Testing with a1To5 = " + aiTo5.mkString("Array(",",",")..."))
    val expectResult = 15
    val expectResult2 = 55

    checkPredicate(
        sumArrayIter(aiTo5) == expectResult,
        "sumArrayIter(0, a1To5) == " +  expectResult

    )

    checkPredicate(
        sumArrayRec1(0, aiTo5) == expectResult,
        "sumArrayRec1(0, a1To5) == " + expectResult

    )

    checkPredicate(
        sumArrayRec2(aiTo5) == expectResult,
        "sumArrayRec2(a1To5) == " + expectResult

    )


    checkPredicate(
        sumSqArrayIter(aiTo5) == expectResult2,
        "sumSqArrayIter(a1To5) == " + expectResult2

    )

    checkPredicate(
        sumSqArrayRec1(0, aiTo5) == expectResult2,
        "sumSqArrayRec1(0, a1To5) == " + expectResult2

    )
    checkPredicate(
        sumSqArrayRec2(aiTo5) == expectResult2,
        "sumSqArrayRec2(a1To5) == " + expectResult2

    )


@main def ex42_02(): Unit =
    val arr1 = Array(3, 12, 43, 4, 10)
    println(
        "Testing with arr1 = " +
            arr1.mkString("Array(", ", ", ") ...")
    )
    val expectResult = 43
    checkPredicate(
        maxIter(arr1) == expectResult,
        "maxIter(arr1) == " + expectResult
    )
    checkPredicate(
        maxRec1(0, arr1(0), arr1) == expectResult,
        "maxRec1(0, arr1(0), arr1) == " + expectResult
    )
    checkPredicate(
        maxRec2(arr1) == expectResult,
        "maxRec2(arr1) == " + expectResult
    )