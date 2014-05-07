package objsets
import org.scalatest.FunSuite

object test {

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }                                               //> asSet: (tweets: objsets.TweetSet)Set[objsets.Tweet]

  def size(set: TweetSet): Int = asSet(set).size  //> size: (set: objsets.TweetSet)Int

  val set1 = new Empty                            //> set1  : objsets.Empty = objsets.Empty@1cc3210
	val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = objsets.NonEmpty@142f66f
	val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = objsets.NonEmpty@e98812
	val c = new Tweet("c", "c body", 7)       //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
	val d = new Tweet("d", "d body", 9)       //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
	val set4c = set3.incl(c)                  //> set4c  : objsets.TweetSet = objsets.NonEmpty@1e48fa7
	val set4d = set3.incl(d)                  //> set4d  : objsets.TweetSet = objsets.NonEmpty@935862
	val set5 = set4c.incl(d)                  //> set5  : objsets.TweetSet = objsets.NonEmpty@18f9ba9
 

  //should be 4
  //size(set4c.union(set4d))
   
  //should be 1
	//size(set5.filter(tw => tw.user == "a"))
                                         
  //should be 2
	//size(set5.filter(tw => tw.retweets == 20))
	
	//should be 20
	//set5.mostRetweeted.retweets
	
	//should be 20, 20, 9, 7
	//set5.descendingByRetweet.foreach( t => println(t.retweets))
	val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
                                                  //> google  : List[String] = List(android, Android, galaxy, Galaxy, nexus, Nexus
                                                  //| )
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")
                                                  //> apple  : List[String] = List(ios, iOS, iphone, iPhone, ipad, iPad)
  
  //google.contains("ios")
  //google.contains("android")
  
  
}