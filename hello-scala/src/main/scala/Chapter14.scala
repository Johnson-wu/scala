//将java的Properties转换成scala的映射
import scala.collection.JavaConversions.propertiesAsScalaMap

object Chapter14 extends App {
	for((k,v) <- System.getProperties() if v != "")
	  println(k + "===>" + v)
}