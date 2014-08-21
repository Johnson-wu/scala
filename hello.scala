import scala.io.Source

/*if(args.length > 0) {
	for(line <- Source.fromFile(args(0)).getLines)
		println(line.length + "" + line)
}
else
	Console.err.println("Please enter the filename !")*/

def widthOfLength(s:String) = s.length.toString.length

if(args.length > 0) {
	var lines = Source.fromFile(args(0)).getLines.toList
	var longestLine = lines.reduceLeft(
			(a,b) => if(a.length > b.length) a else b
		)

	var maxlength = widthOfLength(longestLine)

	for(line <- lines) {
		var numSpace = maxlength - widthOfLength(line)
		var numFinal = " " * numSpace + line.length + "| "
		println(numFinal + line)
	}
}
else
	Console.err.println("Please enter filename!")