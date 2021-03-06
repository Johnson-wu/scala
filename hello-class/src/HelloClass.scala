import Element.elem

abstract class Element {
  def contents: Array[String]
  
  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    val contents = new Array[String](this.contents.length)

    //指令式写法
    //	  for(i <- 0 until this.contents.length)
    //	    contents(i) = this.contents(i) + that.contents(i)
    //	  new ArrayElement(contents)

    //函数式写法
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield {
        line1 + line2
      }
    )
  }

  override def toString = this.contents mkString "\n"

}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts

  final def demo() {
    println("ArrayElement's final method demo !")
  }
}

class Demo(s: String) extends ArrayElement(Array(s)) {
  //  override def demo(){
  //    
  //  }
}

//参数化字段
class ArrayElement2(
  val contents: Array[String] //重载并实现了contents抽象方法为字段
  ) extends Element {

}

class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def height: Int = 1
  override def width: Int = s.length
}

class UniformElement(
  ch: Char,
  override val height: Int,
  override val width: Int) extends Element {
  private val line = ch.toString() * width
//  def contents = Array.make(height, line)
  def contents = Array("")
}

//伴生对象
object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(s: String): Element = new LineElement(s)

  def elem(ch: Char, height: Int, width: Int): Element = new UniformElement(ch, height, width)
}

object HelloClass {

  def main(args: Array[String]): Unit = {
    //    val elem:Element = new ArrayElement(Array("1","2","3"))
    //    println(elem.contents,elem.height,elem.width)
    //    
    //    val elem2:Element = new ArrayElement2(Array("1","2","3"))
    //    println(elem2.contents,elem2.height,elem2.width)

   /* def curriedSum(x: Int, z: Int)(y: Int) = x + z + y
    //    val fun = (x:Int,z:Int)(y:Int) => curriedSum(_:Int,_:Int)(_:Int)
    //    val tmp1 = fun(1,2)
    val tmp = curriedSum(1, 2)_

    //    def curriedSum1(x: Int)(y: Int)(z:Int) = x + z + y
    //    val fun1 = curriedSum1(1)(_:Int)(_:Int)
    //    val fun2 = fun1(2,3)
    //    println(fun1)

    val arrAbove = elem(Array("1", "2")) above elem(Array("a", "b"))
    val arrBeside = elem(Array("1", "2")) beside elem(Array("a", "b"))
    println(arrAbove)
    println(arrBeside)*/
    BigInt.apply("123456789")

  }

}

//import Element.elem
//object Spiral {
//  val space = elem(" ")
//  val corner = elem("+")
//  def spiral(nEdges: Int, direction: Int): Element = {
//    if (nEdges == 1)
//      elem("+")
//    else {
//      val sp = spiral(nEdges - 1, (direction + 3) % 4)
//      def verticalBar = elem('|', 1, sp.height)
//      def horizontalBar = elem('-', sp.width, 1)
//      if (direction == 0)
//        (corner beside horizontalBar) above (sp beside space)
//      else if (direction == 1)
//        (sp above space) beside (corner above verticalBar)
//      else if (direction == 2)
//        (space beside sp) above (horizontalBar beside corner)
//      else
//        (verticalBar above corner) beside (space above sp)
//    }
//  }
//  def main(args: Array[String]) {
//    val nSides = 4
//    println(spiral(nSides, 0))
//  }
//}

