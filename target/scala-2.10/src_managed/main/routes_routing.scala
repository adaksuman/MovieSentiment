// @SOURCE:/home/suman/my_project/MovieSentiment/conf/routes
// @HASH:d6afda5be449fccd741d11d296043579ce6be174
// @DATE:Thu Jun 05 11:36:21 IST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_SentimentController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_SentimentController_sentiment1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view"))))
        

// @LINE:8
private[this] lazy val controllers_SentimentController_upcmngMovieSentiment2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/upcMovies"))))
        

// @LINE:9
private[this] lazy val controllers_SentimentController_movieSentiment3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/movies"))))
        

// @LINE:11
private[this] lazy val controllers_SentimentController_predictSentiment4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/prdct"))))
        

// @LINE:12
private[this] lazy val controllers_SentimentController_average5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/average"))))
        

// @LINE:13
private[this] lazy val controllers_SentimentController_geAttentions6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/getAttention"))))
        

// @LINE:14
private[this] lazy val controllers_SentimentController_listUpCmngMvs7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/listUpCmng"))))
        

// @LINE:15
private[this] lazy val controllers_SentimentController_getAnalysisGraphFromTW8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/getAnalytics"))))
        

// @LINE:16
private[this] lazy val controllers_SentimentController_getAnalyticsGraphFromTopsy9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/getTPSAnalytics"))))
        

// @LINE:18
private[this] lazy val controllers_SentimentController_preflight10 = Route("OPTIONS", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view/"),DynamicPart("id", """.+""",false))))
        

// @LINE:21
private[this] lazy val controllers_Assets_at11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.SentimentController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view""","""controllers.SentimentController.sentiment()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/upcMovies""","""controllers.SentimentController.upcmngMovieSentiment(q:String, r:String, c:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/movies""","""controllers.SentimentController.movieSentiment(q:String, r:String, c:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/prdct""","""controllers.SentimentController.predictSentiment(d1:String, d2:String, d3:String, d4:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/average""","""controllers.SentimentController.average(d1:String, d2:String, d3:String, d4:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/getAttention""","""controllers.SentimentController.geAttentions(rate:String, rank:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/listUpCmng""","""controllers.SentimentController.listUpCmngMvs()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/getAnalytics""","""controllers.SentimentController.getAnalysisGraphFromTW(q:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/getTPSAnalytics""","""controllers.SentimentController.getAnalyticsGraphFromTopsy(q:String)"""),("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view/$id<.+>""","""controllers.SentimentController.preflight(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_SentimentController_index0(params) => {
   call { 
        invokeHandler(controllers.SentimentController.index(), HandlerDef(this, "controllers.SentimentController", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_SentimentController_sentiment1(params) => {
   call { 
        invokeHandler(controllers.SentimentController.sentiment(), HandlerDef(this, "controllers.SentimentController", "sentiment", Nil,"GET", """""", Routes.prefix + """view"""))
   }
}
        

// @LINE:8
case controllers_SentimentController_upcmngMovieSentiment2(params) => {
   call(params.fromQuery[String]("q", None), params.fromQuery[String]("r", None), params.fromQuery[String]("c", None)) { (q, r, c) =>
        invokeHandler(controllers.SentimentController.upcmngMovieSentiment(q, r, c), HandlerDef(this, "controllers.SentimentController", "upcmngMovieSentiment", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """view/upcMovies"""))
   }
}
        

// @LINE:9
case controllers_SentimentController_movieSentiment3(params) => {
   call(params.fromQuery[String]("q", None), params.fromQuery[String]("r", None), params.fromQuery[String]("c", None)) { (q, r, c) =>
        invokeHandler(controllers.SentimentController.movieSentiment(q, r, c), HandlerDef(this, "controllers.SentimentController", "movieSentiment", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """view/movies"""))
   }
}
        

// @LINE:11
case controllers_SentimentController_predictSentiment4(params) => {
   call(params.fromQuery[String]("d1", None), params.fromQuery[String]("d2", None), params.fromQuery[String]("d3", None), params.fromQuery[String]("d4", None)) { (d1, d2, d3, d4) =>
        invokeHandler(controllers.SentimentController.predictSentiment(d1, d2, d3, d4), HandlerDef(this, "controllers.SentimentController", "predictSentiment", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """view/prdct"""))
   }
}
        

// @LINE:12
case controllers_SentimentController_average5(params) => {
   call(params.fromQuery[String]("d1", None), params.fromQuery[String]("d2", None), params.fromQuery[String]("d3", None), params.fromQuery[String]("d4", None)) { (d1, d2, d3, d4) =>
        invokeHandler(controllers.SentimentController.average(d1, d2, d3, d4), HandlerDef(this, "controllers.SentimentController", "average", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """view/average"""))
   }
}
        

// @LINE:13
case controllers_SentimentController_geAttentions6(params) => {
   call(params.fromQuery[String]("rate", None), params.fromQuery[String]("rank", None)) { (rate, rank) =>
        invokeHandler(controllers.SentimentController.geAttentions(rate, rank), HandlerDef(this, "controllers.SentimentController", "geAttentions", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """view/getAttention"""))
   }
}
        

// @LINE:14
case controllers_SentimentController_listUpCmngMvs7(params) => {
   call { 
        invokeHandler(controllers.SentimentController.listUpCmngMvs(), HandlerDef(this, "controllers.SentimentController", "listUpCmngMvs", Nil,"GET", """""", Routes.prefix + """view/listUpCmng"""))
   }
}
        

// @LINE:15
case controllers_SentimentController_getAnalysisGraphFromTW8(params) => {
   call(params.fromQuery[String]("q", None)) { (q) =>
        invokeHandler(controllers.SentimentController.getAnalysisGraphFromTW(q), HandlerDef(this, "controllers.SentimentController", "getAnalysisGraphFromTW", Seq(classOf[String]),"GET", """""", Routes.prefix + """view/getAnalytics"""))
   }
}
        

// @LINE:16
case controllers_SentimentController_getAnalyticsGraphFromTopsy9(params) => {
   call(params.fromQuery[String]("q", None)) { (q) =>
        invokeHandler(controllers.SentimentController.getAnalyticsGraphFromTopsy(q), HandlerDef(this, "controllers.SentimentController", "getAnalyticsGraphFromTopsy", Seq(classOf[String]),"GET", """""", Routes.prefix + """view/getTPSAnalytics"""))
   }
}
        

// @LINE:18
case controllers_SentimentController_preflight10(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.SentimentController.preflight(id), HandlerDef(this, "controllers.SentimentController", "preflight", Seq(classOf[String]),"OPTIONS", """""", Routes.prefix + """view/$id<.+>"""))
   }
}
        

// @LINE:21
case controllers_Assets_at11(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     