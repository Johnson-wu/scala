object FileOperCP_9 extends App {
	import scala.io.Source
//	val file = Source.fromFile("E:\\GitHub\\scala\\hello-scala\\src\\main\\scala\\FileMatcher.scala")
//	val lines = file.getLines	// lines 只可使用一次，用完内容就清空或者是io通道关闭了
	
//	println(lines.length)
	
//	for(line <- lines)
//	  println(line.mkString)
	
//	val arr = lines.toArray
//	println(arr.length)
	
//	println(lines.mkString("<<<","\n",">>>"))
	
//	val iter = lines.buffered
//	while(iter.hasNext) {
//		println(iter.head)	// head只取值，游标不下移
//		println(iter.next)	// next取值，并游标下移
//	}
	 
//	val list = Array("1","2","3")
//	val newList = for(a <- list) yield {a.toDouble}
//	for(n <- newList) 
//		println(n)
//		
//	val newList2 = list.map(_.toDouble)	//这里的map并不是生成一个map对象
//	for(n <- newList2)
//	  println(n)
	
//	val age = readInt()
//	println(age)
	
//	val source1 = Source.fromURL("http://www.baidu.com","utf-8")
//	println(source1.mkString)
//	val source2 = Source.fromString("hello world !")
//	println(source2.mkString)
//	val source3 = Source.stdin
//	println(source3.mkString)
	
	//scala 没有读取二进制的方法，所以要引用java的相关包
//	import java.io.File
//	import java.io.FileInputStream
//	import java.io._
//	val file = new File("E:\\GitHub\\scala\\hello-scala\\src\\main\\scala\\test.jpg")
//	val in = new FileInputStream(file)
//	val bytes = new Array[Byte](file.length.toInt)
//	in.read(bytes)
//	bytes.foreach(println)
//	println(bytes)
//	in.close()
	//该方法只能读取文本文件 ，所以读取二进制报错
//	val file = Source.fromFile("E:\\GitHub\\scala\\hello-scala\\src\\main\\scala\\test.jpg")
//	println(file.mkString)
	//scala只有内建的读取文本文件的方法，而没有写文本文件的方法
//	import java.io.PrintWriter
//	val file = new PrintWriter("E:\\GitHub\\scala\\hello-scala\\src\\main\\scala\\number.txt")
//	for(i <- 1 to 10) {
////	  file.write(i) //为什么write方法写入的是乱码？
//	  file.println(i)	//是将文本文件当控制台，把内容打在文件里面
//	}
//	file.close()
//	val quantity = 20.0; val price = 200.5
//	file.printf("%6d %10.2f", quantity, price)	
	
	//遍历文件夹,scala没有“正式的”访问文件夹的方法
//	import java.io.File
//	def subdirs(dir:File):Iterator[File] = {
//	  val children = dir.listFiles.filter(_.isDirectory)
//	  children.toIterator ++ children.toIterator.flatMap(subdirs(_))
//	}
//	val file = new File("E:\\CloudMusic")
//	for(f <- subdirs(file)) 
//	  println(f)
	
	
	//与shell交互
//	import sys.process._
//	"dir" !		//windows 命令不可用？
	
	
	// Regex
//	val numPattern = "[0-9]+".r
//	for(item <- numPattern.findAllIn("99 total bottles, 50 empty bottles"))
//		println(item)
//	val matches = numPattern.findAllIn("99 total bottles, 50 empty bottles").toArray
//	for(item <- matches) 
//		println(item)
		
//	val numPattern2 = """\s+[0-9]+\s+\[a-z]+""".r
//	for(item <- numPattern2.findAllIn("99 total bottles, 50 \\empty bottles"))
//		println(item)
	
	val numItemPattern = "([0-9]+) ([a-z]+)".r
	val numItemPattern(num, word) = "99 bottles"
	println(num,word)
	for(numItemPattern(num,word) <- numItemPattern.findAllIn("99 total bottles, 50 empty bottles"))
		println(num,word)
	for(item <- numItemPattern.findAllIn("99 total bottles, 50 empty bottles"))
		println(item)
	  
}