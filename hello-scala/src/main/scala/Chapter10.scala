trait Logger {
  def log(msg:String)
}

trait TimeStampLogger extends Logger {
  abstract override def log(msg:String) {
	  super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends TimeStampLogger {
  abstract override def log(msg:String) {
	  super.log(msg)
  }
}

class Chapter10 {

}