object Rotated {
	def main(args: Array[String]): Unit = {
		val a = Vector(1,2,3,4)
		val b = Vector(3,4,1,2)
	  	val c = Vector(0,1,4,5)
	  	val d = Vector(2,3,4,1)
	  	val e = Vector(2,3)
	  	
	  	println(is_rotated(a,b)) //true
	  	println(is_rotated(a,c)) //false
	  	println(is_rotated(a,d)) //true
	  	println(is_rotated(a,e)) //false
	}		
		
	
	def is_rotated[T](a: IndexedSeq[Int], b: IndexedSeq[Int]) = {
		def iterate(combine: (Boolean, Boolean) => Boolean, zero: Boolean)(fn: Int => Boolean, limit: Int => Boolean) = {
			def iter(n: Int): Boolean = {
				if(limit(n)) zero
				else combine(fn(n), iter(n+1))
			}
			iter(0)
		}
		
		def limit(n: Int) = n >= a.length
		
		def check_all(offset: Int): Boolean = iterate(_ && _, true)(i => a(i) == b((i+offset) % b.length), limit)
		
		iterate(_ || _, false)((check_all(_)), limit)
	}
}