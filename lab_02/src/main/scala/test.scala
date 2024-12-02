package  p1 {
    class C1 {
        private [this] val a1 = 1
        override  def equals(other: Any): Boolean = other match{
            case that: C1 =>(this.a1 == that.a1)
            case _ => false
        }
    }
}

//package p1 {
//    class A1
//    package p2 {class A21; class A22}
//}
//
//class A {new p2.A21}
//
//object  Appl extends App{
//    import p1.p2.{A22=>_}
//    new A21
//    new A22
//}