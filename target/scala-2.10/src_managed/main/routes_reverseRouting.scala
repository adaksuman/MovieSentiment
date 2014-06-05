// @SOURCE:/home/suman/my_project/MovieSentiment/conf/routes
// @HASH:d6afda5be449fccd741d11d296043579ce6be174
// @DATE:Thu Jun 05 11:36:21 IST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:21
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:21
class ReverseAssets {
    

// @LINE:21
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseSentimentController {
    

// @LINE:18
def preflight(id:String): Call = {
   Call("OPTIONS", _prefix + { _defaultPrefix } + "view/" + implicitly[PathBindable[String]].unbind("id", id))
}
                                                

// @LINE:9
def movieSentiment(q:String, r:String, c:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/movies" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)), Some(implicitly[QueryStringBindable[String]].unbind("r", r)), Some(implicitly[QueryStringBindable[String]].unbind("c", c)))))
}
                                                

// @LINE:8
def upcmngMovieSentiment(q:String, r:String, c:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/upcMovies" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)), Some(implicitly[QueryStringBindable[String]].unbind("r", r)), Some(implicitly[QueryStringBindable[String]].unbind("c", c)))))
}
                                                

// @LINE:11
def predictSentiment(d1:String, d2:String, d3:String, d4:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/prdct" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("d1", d1)), Some(implicitly[QueryStringBindable[String]].unbind("d2", d2)), Some(implicitly[QueryStringBindable[String]].unbind("d3", d3)), Some(implicitly[QueryStringBindable[String]].unbind("d4", d4)))))
}
                                                

// @LINE:14
def listUpCmngMvs(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/listUpCmng")
}
                                                

// @LINE:13
def geAttentions(rate:String, rank:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/getAttention" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rate", rate)), Some(implicitly[QueryStringBindable[String]].unbind("rank", rank)))))
}
                                                

// @LINE:15
def getAnalysisGraphFromTW(q:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/getAnalytics" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
}
                                                

// @LINE:16
def getAnalyticsGraphFromTopsy(q:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/getTPSAnalytics" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:12
def average(d1:String, d2:String, d3:String, d4:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view/average" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("d1", d1)), Some(implicitly[QueryStringBindable[String]].unbind("d2", d2)), Some(implicitly[QueryStringBindable[String]].unbind("d3", d3)), Some(implicitly[QueryStringBindable[String]].unbind("d4", d4)))))
}
                                                

// @LINE:7
def sentiment(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "view")
}
                                                
    
}
                          
}
                  


// @LINE:21
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:21
class ReverseAssets {
    

// @LINE:21
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseSentimentController {
    

// @LINE:18
def preflight : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.preflight",
   """
      function(id) {
      return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + "view/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:9
def movieSentiment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.movieSentiment",
   """
      function(q,r,c) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/movies" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("r", r), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("c", c)])})
      }
   """
)
                        

// @LINE:8
def upcmngMovieSentiment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.upcmngMovieSentiment",
   """
      function(q,r,c) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/upcMovies" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("r", r), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("c", c)])})
      }
   """
)
                        

// @LINE:11
def predictSentiment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.predictSentiment",
   """
      function(d1,d2,d3,d4) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/prdct" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d1", d1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d2", d2), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d3", d3), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d4", d4)])})
      }
   """
)
                        

// @LINE:14
def listUpCmngMvs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.listUpCmngMvs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/listUpCmng"})
      }
   """
)
                        

// @LINE:13
def geAttentions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.geAttentions",
   """
      function(rate,rank) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/getAttention" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rate", rate), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rank", rank)])})
      }
   """
)
                        

// @LINE:15
def getAnalysisGraphFromTW : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.getAnalysisGraphFromTW",
   """
      function(q) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/getAnalytics" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
      }
   """
)
                        

// @LINE:16
def getAnalyticsGraphFromTopsy : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.getAnalyticsGraphFromTopsy",
   """
      function(q) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/getTPSAnalytics" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:12
def average : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.average",
   """
      function(d1,d2,d3,d4) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view/average" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d1", d1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d2", d2), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d3", d3), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("d4", d4)])})
      }
   """
)
                        

// @LINE:7
def sentiment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SentimentController.sentiment",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "view"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:21
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:21
class ReverseAssets {
    

// @LINE:21
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseSentimentController {
    

// @LINE:18
def preflight(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.preflight(id), HandlerDef(this, "controllers.SentimentController", "preflight", Seq(classOf[String]), "OPTIONS", """""", _prefix + """view/$id<.+>""")
)
                      

// @LINE:9
def movieSentiment(q:String, r:String, c:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.movieSentiment(q, r, c), HandlerDef(this, "controllers.SentimentController", "movieSentiment", Seq(classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """view/movies""")
)
                      

// @LINE:8
def upcmngMovieSentiment(q:String, r:String, c:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.upcmngMovieSentiment(q, r, c), HandlerDef(this, "controllers.SentimentController", "upcmngMovieSentiment", Seq(classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """view/upcMovies""")
)
                      

// @LINE:11
def predictSentiment(d1:String, d2:String, d3:String, d4:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.predictSentiment(d1, d2, d3, d4), HandlerDef(this, "controllers.SentimentController", "predictSentiment", Seq(classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """view/prdct""")
)
                      

// @LINE:14
def listUpCmngMvs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.listUpCmngMvs(), HandlerDef(this, "controllers.SentimentController", "listUpCmngMvs", Seq(), "GET", """""", _prefix + """view/listUpCmng""")
)
                      

// @LINE:13
def geAttentions(rate:String, rank:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.geAttentions(rate, rank), HandlerDef(this, "controllers.SentimentController", "geAttentions", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """view/getAttention""")
)
                      

// @LINE:15
def getAnalysisGraphFromTW(q:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.getAnalysisGraphFromTW(q), HandlerDef(this, "controllers.SentimentController", "getAnalysisGraphFromTW", Seq(classOf[String]), "GET", """""", _prefix + """view/getAnalytics""")
)
                      

// @LINE:16
def getAnalyticsGraphFromTopsy(q:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.getAnalyticsGraphFromTopsy(q), HandlerDef(this, "controllers.SentimentController", "getAnalyticsGraphFromTopsy", Seq(classOf[String]), "GET", """""", _prefix + """view/getTPSAnalytics""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.index(), HandlerDef(this, "controllers.SentimentController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:12
def average(d1:String, d2:String, d3:String, d4:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.average(d1, d2, d3, d4), HandlerDef(this, "controllers.SentimentController", "average", Seq(classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """view/average""")
)
                      

// @LINE:7
def sentiment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SentimentController.sentiment(), HandlerDef(this, "controllers.SentimentController", "sentiment", Seq(), "GET", """""", _prefix + """view""")
)
                      
    
}
                          
}
        
    