object Name {
  def unapply(input:String) = {
    val pos = input.indexOf(" ")
    if(pos == -1) None
    else Some(input.substring(0,pos),input.substring(pos+1))
  }
}

object Chapter11 extends App {
	val author = "wu jing"
	val Name(first,last) = author
	println(first,last)
	
}