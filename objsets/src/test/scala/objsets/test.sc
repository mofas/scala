package objsets
import org.scalatest.FunSuite

object test {

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  val set1 = new Empty
	val set2 = set1.incl(new Tweet("a", "a body", 20))
	val set3 = set2.incl(new Tweet("b", "b body", 20))
	val c = new Tweet("c", "c body", 7)
	val d = new Tweet("d", "d body", 9)
	val set4c = set3.incl(c)
	val set4d = set3.incl(d)
	val set5 = set4c.incl(d)
 

  //should be 4
  size(set4c.union(set4d))
   
  //should be 1
	size(set5.filter(tw => tw.user == "a"))
                                         
  //should be 2
	size(set5.filter(tw => tw.retweets == 20))
	
	//should be 20
	set5.mostRetweeted.retweets
	
	//should be 20, 20, 9, 7
	set5.descendingByRetweet.foreach( t => println(t.retweets))
	val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")
  
  //google.contains("ios")
  //google.contains("android")
  
  
  def existIn(list : List[String]) : Tweet => Boolean = {
    tweet: Tweet => list.exists(keyword => tweet.text.contains(keyword))
  }

  lazy val googleTweets: TweetSet = TweetReader.allTweets.filter(existIn(google))
  lazy val appleTweets: TweetSet = TweetReader.allTweets.filter(existIn(apple))

  /**
   * A list of all tweets mentioning a keyword from either apple or google,
   * sorted by the number of retweets.
   */
  lazy val trending: TweetList = googleTweets.union(appleTweets).descendingByRetweet

  // Print the trending tweets
  GoogleVsApple.trending foreach println
  
  wq wq
}