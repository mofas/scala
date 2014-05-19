package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }
  
  test("times function") {    
    assert(times(List('a', 'b', 'a')) === List(('a', 2), ('b', 1)))     
    assert(times(List('a', 'b', 'c', 'a', 'b')) === List(('a',2), ('b',2), ('c',1)))    
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
      
  test("until function") {
    val treesList = until(singleton, combine)(combine(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)))))
    assert(weight(treesList(0)) === 6)
    assert(chars(treesList(0)) === List('e', 't', 'x'))
    
    val treesList2 = createCodeTree(List('a','c','b','c','b','b','a','a','d','a'))
    assert(weight(treesList2) === 10)
  assert(chars(treesList2).contains('a'))
  assert(chars(treesList2).contains('b'))
  assert(chars(treesList2).contains('c'))
  assert(chars(treesList2).contains('d'))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode") {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
  assert(decode(t1, encode(t1)("ab".toList)) === List('a', 'b')) 
  assert(decode(t1, encode(t1)("baaab".toList)) === List('b', 'a', 'a', 'a', 'b'))
  }
  
  test("convert function") {
  assert(convert(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)) === List(('a',List(0)), ('b',List(1))))
  }
    
  test("quickEncode function") {
  val t2 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
  assert(decode(t2, quickEncode(t2)("ab".toList)) === List('a', 'b'))
  assert(decode(t2, quickEncode(t2)("baaab".toList)) === List('b', 'a', 'a', 'a', 'b'))
  }

  test("decodedSecret function") {
    assert(decodedSecret === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }
}
