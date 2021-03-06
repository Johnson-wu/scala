class Rational(n: Int, d: Int) {
  println("Created " + n + "/" + d)
  println("Created 2 " + n + "/" + d)

  def Rational(n: Int, d: Int, x: Int) {
    def testMethod(x: Int) = {
      println("testMethod")
    }
  }

  def testMethod(x: Int) = {
    println("testMethod")
  }
}

import scala.io.Source

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) = filesMatching(_.endsWith(query))

  def filesContaining(query: String) = filesMatching(_.contains(query))

  def filesRegex(query: String) = filesMatching(_.matches(query))

  def processFile(filename: String, width: Int) {
    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(filename, width, line)
  }
  private def processLine(filename: String, width: Int, line: String) {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }

  def main(args: Array[String]): Unit = {
    val li = filesEnding(".bat")
    filesHere.foreach(println)
    li.foreach(println)
    println("hi list")

    val ra = new Rational(1, 2)
    /*ra.testMethod(1)*/

    /*var line = ""
    line = readLine()
    while ((line = readLine()) != "fgh") // 不起作用
      println("Read: " + line)*/

    /*def fileLines(file: java.io.File) =
      scala.io.Source.fromFile(file).getLines.toList
    def grep(pattern: String) =
      for {
        filee <- filesHere
        if filee.getName.endsWith(".scala")
        line <- fileLines(filee)
        trimed = line.trim
        if trimed.matches(pattern)
      } println(filee + ": " + trimed)
    grep(".*gcd.*")*/

    val bo = (x: Int) => x > 0
    def boo(x: Int) = x > 0
    println(boo(2))
    println(bo(2))

    def f(): Int = try { 1; return 2 } finally { return 3 }
    println(f())

    def f2(): Int =
      try { return 1; 2 } finally { 3 }
    println(f2())

    def makeRowSeq(row: Int) =
      for (col <- 1 to 10) yield {
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
      }
    // 以字串形式返回一行乘法表
    def makeRow(row: Int) = makeRowSeq(row).mkString
    // 以字串形式返回乘法表，每行记录占一行字串
    def multiTable() = {
      val tableSeq = // 行记录字串的序列
        for (row <- 1 to 10)
          yield makeRow(row)
      tableSeq.mkString("\n")
    }

    println(multiTable())

    /*val argsx = List("10",".")
    val width = argsx(0).toInt
    for (arg <- argsx.drop(1))
      processFile(arg, width)*/

    var more = 1

    val addMore = (x: Int) => x + more

    println(addMore(10))
    
    more = 2
    println(addMore(10))
    
    def boom(x: Int): Int =
    	if (x == 0) throw new Exception("boom!")
    	else 1 + boom(x - 1)
    	
    println(boom(3))
    
    val matcher = (x:String,y:String) => (_:String).endsWith(_:String)
    matcher("x","y")
    
    val matchers = (_:String).endsWith(_:String)
    	
  }

}