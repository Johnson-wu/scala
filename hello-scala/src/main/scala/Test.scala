object Test {
	def main(args:Array[String]):Unit = {
	  
	  //Annoymous Subclass : 匿名子类不能再扩展父类主构造器的参数
	  val annoyClass = new Person("Fred") {	    
	    //因为父类有toString方法，当子类也定义同名方法时，override必须加上。(易违约基类问题规则)
	    override def toString:String = "My name is Fred !"
	      
	    def greeting = "Hello world ! " + toString
	  }
	       
	  println(annoyClass.greeting)
	  
	  
	  //implement abstract class : don't need "override" keyword
	  val abstractClass = new Animal(){
		  val id = 1
		  var name = "abstract animal"
	  }
	  
	  val item1 = new Item("apple",100.5)
	  val item2 = Item("apple",100.5)
	  val item3 = Item("orange",120)
	  println(item1.equals(item2))
	  println(item1.equals(item3))
	  println(item1==item2,item1==item3)
	  item1.printHash
	  
	  Item.test
	  
	  item1.printHash
	}
}

class Person(val name:String) {
	private var age = 0
  
}

abstract class Animal {
	val id : Int
	var name : String
}

class Cat(val id:Int, var name:String) extends Animal {

}

class Tiger(val id:Int) extends Animal{
	var name = "Tiger Woods"
}

class Item(var description:String, val price:Double) {
  
  final override def equals(other:Any) = {
	  val that = other.asInstanceOf[Item]
	  if (that == null) false
	  else this.description == that.description && this.price == that.price
  }
  
  def printHash:Unit = {
	  println(this.description.hashCode())
	  Item.test
  }
  
}

class Test(val id:Int) {
	val name:String = "object extends with"
	  
    def printTest(arg:String):Unit = {
	  println("Test : " + arg)
	}
}

trait Test1{
  
}

//Class Item's companion object
object Item extends Test(1) with Test1 {
  
  def apply(description:String,price:Double) = {
    new Item(description,price)
  }
  
  def test:Unit = {
    println(name) 
    printTest("object call extends Class's method")
  }
}
