package patmat

import patmat.Huffman._

object test {
  
     
  //  should be List(('a', 2), ('b', 1))
  times(List('a', 'b', 'a'))
  
  //  should be List((a,2), (b,2), (c,1))
  times(List('a', 'b', 'c', 'a', 'b'))
  
  //  should be List(Leaf('e',1), Leaf('t',2), Leaf('x',3))
  makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)))
    
  //  should be List(Fork(Leaf(e,1),Leaf(t,2),List(e,t),3), Leaf(x,3))
  combine(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))))
  
  
  //  should be List(Fork(Leaf(e,1),Leaf(t,2),List(e,t),3), Leaf(x,4))
  combine(List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4)))
                                                  
  
  val treesList = until(singleton, combine)(combine(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)))))
 	//  should be 6
  weight(treesList(0))
  //  should be List(e, t, x)
  chars(treesList(0))
  
	val treesList2 = createCodeTree(List('a','c','b','c','b','b','a','a','d','a'))
  //  should be 10
  weight(treesList2)
	//  should be List(a, b, c, d)
	chars(treesList2)
	
	//  should be List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
	decodedSecret
	
	val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
	// should be List(a, b)
	decode(t1, encode(t1)("ab".toList))
	// should be List(b, a, a, a, b)
	decode(t1, encode(t1)("baaab".toList))
	
	// should be List((a,List(0)), (b,List(1)))
	convert(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5))
	
	
	val t2 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
	// should be List(a, b)
	decode(t2, quickEncode(t2)("ab".toList))
	// should be List(b, a, a, a, b)
	decode(t2, quickEncode(t2)("baaab".toList))
}