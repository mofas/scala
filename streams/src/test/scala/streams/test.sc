package streams


import Bloxorz._
import Bloxorz.Level1._

object test {
  
  
  
  
  //println(Level0.level)
  
  // Should be Pos(1,2)
  //println(Level0.startPos)
	// Should be Pos(1,3)
  //println(Level0.goal)
  
  
  
	// Should be Pos(1,1)
  //println(Level1.startPos)
	// Should be Pos(4,7)
  //println(Level1.goal)
  
  
	// TEST neighborsWithHistory
  //val nextSet = neighborsWithHistory(Block(Pos(1,1),Pos(1,1)), List(Left,Up))
  // Should be (Block(Pos(1,2),Pos(1,3)),List(Right, Left, Up))
  //nextSet(0)
  // Should be (Pos(2,1),Pos(3,1)),List(Down, Left, Up))
  //nextSet(1)
  
  // Should be Stream((Block(Pos(2,1),Pos(3,1)),List(Down, Left, Up)), ?)
  /**
  Level1.newNeighborsOnly(
	  Set(
	    (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
	    (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
	  ).toStream,
	  Set(Block(Pos(1,2),Pos(1,3)), Block(Pos(1,1),Pos(1,1)))
	)
	**/
	
	
	
	val Level0PathFromStart = Level0.pathsFromStart.toList
                                                  //> (head,(Block(Pos(1,2),Pos(1,2)),List()))
                                                  //| (newNeightbors,Stream((Block(Pos(2,2),Pos(3,2)),List(Down)), ?))
                                                  //| (pathList,Stream((Block(Pos(1,2),Pos(1,2)),List()), ?))
                                                  //| ==============================
                                                  //| (head,(Block(Pos(2,2),Pos(3,2)),List(Down)))
                                                  //| (newNeightbors,Stream((Block(Pos(2,3),Pos(3,3)),List(Right, Down)), ?))
                                                  //| (pathList,Stream((Block(Pos(2,2),Pos(3,2)),List(Down))))
                                                  //| ==============================
                                                  //| (head,(Block(Pos(2,3),Pos(3,3)),List(Right, Down)))
                                                  //| (newNeightbors,Stream((Block(Pos(1,3),Pos(1,3)),List(Up, Right, Down)), ?))
                                                  //| 
                                                  //| (pathList,Stream((Block(Pos(2,3),Pos(3,3)),List(Right, Down))))
                                                  //| ==============================
                                                  //| (head,(Block(Pos(1,3),Pos(1,3)),List(Up, Right, Down)))
                                                  //| (newNeightbors,Stream())
                                                  //| (pathList,Stream((Block(Pos(1,3),Pos(1,3)),List(Up, Right, Down))))
                                                  //| ==============================
                                                  //| Level0PathFromStart  : List[(streams.Bloxorz.Level0.Block, List[streams.Blox
                                                  //| orz.Level0.Move])] = List((Bl
                                                  //| Output exceeds cutoff limit.
	// Should be Block(Pos(1,2),Pos(1,2))
	Level0PathFromStart(0)._1                 //> res0: streams.Bloxorz.Level0.Block = Block(Pos(1,2),Pos(1,2))
	// Should be Block(Pos(2,2),Pos(3,2))
	Level0PathFromStart(1)._1                 //> res1: streams.Bloxorz.Level0.Block = Block(Pos(2,2),Pos(3,2))
	// Should be Block(Pos(2,3),Pos(3,3))
	Level0PathFromStart(2)._1                 //> res2: streams.Bloxorz.Level0.Block = Block(Pos(2,3),Pos(3,3))
	// Should be Block(Pos(1,3),Pos(1,3))
	Level0PathFromStart(3)._1                 //> res3: streams.Bloxorz.Level0.Block = Block(Pos(1,3),Pos(1,3))
	
	// Should be List(Up, Right, Down)
	Level0.pathsToGoal.toList(0)._2           //> res4: List[streams.Bloxorz.Level0.Move] = List(Up, Right, Down)
	
	// Should be List(Up, Right, Down)
	Level0.solution                           //> res5: List[streams.Bloxorz.Level0.Move] = List(Up, Right, Down)
  
  
}