package forcomp

import Anagrams._

object test {

	// Should be List(('a', 1), ('b', 1), ('c', 1), ('d', 1)
  wordOccurrences("abcd")                         //> res0: forcomp.Anagrams.Occurrences = List((a,1), (b,1), (c,1), (d,1))
  
  // Should be List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1)
  wordOccurrences("Robert")                       //> res1: forcomp.Anagrams.Occurrences = List((b,1), (e,1), (o,1), (r,2), (t,1))
                                                  //| 
  
  // Should be List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 1))
 	sentenceOccurrences(List("abcd", "e"))    //> res2: forcomp.Anagrams.Occurrences = List((a,1), (b,1), (c,1), (d,1), (e,1))
                                                  //| 
 	
 	// Should be List((a,1), (b,1), (f,1), (o,2), (r,1))
 	sentenceOccurrences(List("foo", "bar"))   //> res3: forcomp.Anagrams.Occurrences = List((a,1), (b,1), (f,1), (o,2), (r,1))
                                                  //| 
 
 	// Should be Some(List(ate, eat, tea))
 	dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1)))
                                                  //> res4: Option[List[forcomp.Anagrams.Word]] = Some(List(ate, eat, tea))
 	
 	// Should be List("married", "admirer")
 	wordAnagrams("married")                   //> res5: List[forcomp.Anagrams.Word] = List(admirer, married)
 	
 	// Should be List(parley, pearly, player, replay)
 	wordAnagrams("player")                    //> res6: List[forcomp.Anagrams.Word] = List(parley, pearly, player, replay)
  
  //combinations(Nil)
  combinations(List(('a', 2), ('b', 2)))          //> res7: List[forcomp.Anagrams.Occurrences] = List(List(), List((b,1)), List((b
                                                  //| ,2)), List((a,1)), List((a,2)), List((a,1), (b,1)), List((a,2), (b,1)), List
                                                  //| ((a,1), (b,2)), List((a,2), (b,2)))
  
  //Should be List((a,1), (d,1), (l,1))
  subtract(List(('a', 1), ('d', 1), ('l', 1), ('r', 1)), List(('r', 1)))
                                                  //> res8: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1))

  // Should be List(List())
	sentenceAnagrams(List())                  //> res9: List[forcomp.Anagrams.Sentence] = List(List())


 
 	sentenceAnagrams(List("Yes", "man"))      //> res10: List[forcomp.Anagrams.Sentence] = List(List(my, en, as), List(my, as,
                                                  //|  en), List(my, sane), List(my, Sean), List(yes, man), List(en, my, as), List
                                                  //| (en, as, my), List(men, say), List(as, my, en), List(as, en, my), List(say, 
                                                  //| men), List(man, yes), List(sane, my), List(Sean, my))
  sentenceAnagrams(List("Linux", "rulez"))        //> res11: List[forcomp.Anagrams.Sentence] = List(List(Zulu, Lin, Rex), List(Zu
                                                  //| lu, nil, Rex), List(Zulu, Rex, Lin), List(Zulu, Rex, nil), List(null, Uzi, 
                                                  //| Rex), List(null, Rex, Uzi), List(Uzi, null, Rex), List(Uzi, Rex, null), Lis
                                                  //| t(Lin, Zulu, Rex), List(Lin, Rex, Zulu), List(nil, Zulu, Rex), List(nil, Re
                                                  //| x, Zulu), List(Linux, rulez), List(Rex, Zulu, Lin), List(Rex, Zulu, nil), L
                                                  //| ist(Rex, null, Uzi), List(Rex, Uzi, null), List(Rex, Lin, Zulu), List(Rex, 
                                                  //| nil, Zulu), List(rulez, Linux))
                                


 
 
 
 
 
 
 
 
  
}