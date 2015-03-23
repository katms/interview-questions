object Rotated {
	def main(args: Array[String]): Unit = {
		val a = Vector(1,2,3,4)
		val b = Vector(3,4,1,2)
	  	println(is_rotated(a,b)) //true
	  	
	  	val c = Vector(0,1,4,5) //false
	  	val d = Vector(2,3,4,1) //rotated 1
	  	
	  	println(is_rotated(a,c))
	}		
		
	
	def is_rotated(a: Vector[Int], b: Vector[Int]) = {
		def try_offset(offset: Int): Boolean = {
			
			def check_index(index: Int): Boolean = {
				if(index >= a.length) true
				else {
					val equals = a(index) == b((index+offset) % a.length)
					equals && check_index(index+1)
				}
			}
			check_index(0)
		}		
		try_offset(2)
	}
}