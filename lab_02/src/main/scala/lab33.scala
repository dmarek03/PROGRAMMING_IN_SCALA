//package p1:
//
//    class A1T:
//        new A1T
//        new A1B
////---
//package p2:
//
//    import p1.A1T
//
//    class A2T:
//        new A2B
//        new A1T
//        new A1B
//    //---
//    package p3:
//        class A3:
//            new A2T
//            // new A2B
//            new A1T
//    // new A1B
//    //---
//    class A2B
////---
//class A1B {new A1T}
//
//@main def ex02_4(): Unit =
//    new p1.A1T
//    new p1.A1B
//    new p1.p2.A2T
//    new p1.p2.A2B
//    new p1.p2.p3.A3