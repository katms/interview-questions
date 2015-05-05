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
	  	
	  	println(is_rotated(Vector(1,2,1,2), Vector(2,1))) //false
	}
		
	//returns true if b is a rotation of a
	def is_rotated[T](a: IndexedSeq[Int], b: IndexedSeq[Int]): Boolean = {
		(a.length == b.length) && ((0 until a.length) exists (o => (0 until a.length) forall (i => a(i) == b((i+o) % b.length))))
	}
}