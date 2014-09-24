object Chapter13 extends App {
  
	def sum1(ls:List[Int]):Int = {
	  if(ls==Nil) 0
	  else ls.head + sum1(ls.tail)
	}
	
	val ls = 5::4::3::2::1::Nil
	
//	println(sum1(ls),ls.sum)
	
	def sum2(ls:List[Int]):Int = ls match {
	  case Nil => 0
	  case h::t => h + sum2(t)
	}
//	println(sum2(ls),ls.sum)

	val lst = List(1,2,3,4,5).foldLeft("")(_ + _)
//	println(lst.toString())
	
	//不明白怎么用的？也不明白用途是什么？
//	val str = "asdfghjghlwrettyuiyuio"
//	val strm = str.toStream
//	println(strm)
//	println(strm(5))
//	println(strm.tail)
//	println(str(2))
//	println(strm.tail)
	
//	for(i <- 0 until 100) print(i + " ")
//	println()
	//.par并行运算
//	for(i <- (0 until 100).par) print(i + " ")
}