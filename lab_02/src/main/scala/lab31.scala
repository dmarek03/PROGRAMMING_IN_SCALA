@main def ex01_2(): Unit =
    try
        println("Opening the file...")
        val inFile = scala.io.Source.fromFile("src/main/scala/logins.txt")
        for line <- inFile.getLines do println(line)
        println("Closing the file...")
        inFile.close
    catch
        case ex: java.io.FileNotFoundException =>
            println(ex.getMessage)


@main def ex01_3(): Unit =
    try
        println("Opening the file...")
        val inFile = scala.io.Source.fromFile("src/main/scala/logins.txt")
        for (line <- inFile.getLines) println(line)
        val x = 100 / inFile.getLines.length
        println("Closing the file...")
        inFile.close
    catch
        case ex: java.io.FileNotFoundException =>
            println(ex.getMessage)


def readFile(fileName: String): Unit = try
    println("Opening the file...")
    val inFile = scala.io.Source.fromFile(fileName)
    try
        for line <- inFile.getLines do println(line)
        val x = 100 / inFile.getLines.length
    finally
        println("Closing the file...")
        inFile.close
catch
    case ex: java.io.FileNotFoundException =>
        println(ex.getMessage)
    case ex: Throwable =>
        println("Default exception handler: " + ex.getMessage)

@main def ex01_4(): Unit =
    readFile("src/main/scala/logins.txt")