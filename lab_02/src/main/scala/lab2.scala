import scala.annotation.targetName

class Person(val id: String, val givenName: String, var surname: String):
    def name():String = givenName + " " + surname

object Application:
    def main(args: Array[String]): Unit =
        val jk = new Person("1234567890", "Jan", "Kowalski")
        println(jk.givenName)

@main def ex03(): Unit =
    val jk = new Person("1234567890", "Jan", "Kowalski")
    println(jk.givenName)

class Int2DVec private (val x: Int, val y: Int):
    // Auxiliary constructors
//    def this() = // NOT! def this(): Unit =
//        this(0, 0)
//        println("Creating Int2DVec(0,0)")
//
//    def this(prototype: Int2DVec) =
//        this(prototype.x, prototype.y)
//        println("Copy-constructor working")


    @targetName("+")
    def +(other: Int2DVec) = new Int2DVec(x + other.x, y + other.y)
    @targetName("unary_-")
    def unary_- = new Int2DVec(-x, -y)
    @targetName("-")
    def -(other: Int2DVec) = new Int2DVec(x-other.x, y-other.y)
    @targetName("*")
    def *(other: Int2DVec): Int = x * other.x + y*other.y

    override def toString: String = "(" + x.toString + "," + y.toString + ")"

object Int2DVec:
    def apply(x: Int, y: Int) = new Int2DVec(x, y)

    def apply() = new Int2DVec(0, 0)

    def apply(prototype: Int2DVec) = new Int2DVec(prototype.x, prototype.y)
@main def ex05(): Unit =
    val v1 =  Int2DVec(1, 4) // pre-scala3 way
    val v2 = Int2DVec(10, 20) // ! note: no "new" (see Scala 3: universal apply methods)
    val v3 = v1 + v2
    val v4 = -v2
    val v5 = v2-v1
    val product = v1*v2
    println(v3)
    println(v4)
    println(v5)
    println(product)

@main def ex06(): Unit =
    val v1 = Int2DVec(1, 2)
    val v2 = Int2DVec(10, 20)

@main def ex08(): Unit =
    val v1 = Int2DVec(1, 2)
    val v2 = Int2DVec(10, 20)
    val v3 = v1 + v2
    val v4 = -v2
    println(v3)
    println(v4)
    println(Int2DVec())
    println(Int2DVec(v1 + v1 + v2))


