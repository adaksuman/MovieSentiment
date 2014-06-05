
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object notFoundPage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.15*/("""
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Sample 404 page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <style type="text/css">
      .center """),format.raw/*9.15*/("""{"""),format.raw/*9.16*/("""text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;"""),format.raw/*9.113*/("""}"""),format.raw/*9.114*/("""
    </style>
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    
</head>
<body style="">
	<div class="container">
  <div class="row">
    <div class="span12">
      <div class="hero-unit center">
          <h1>Page Not Found <small><font face="Tahoma" color="red">Error 404</font></small></h1>
          <br>
          <p>The page you requested could not be found</p>
          <a href="/" class="btn btn-large btn-info"><i class="icon-home icon-white"></i> Take Me Home</a>
        </div>
        <br>
      
       <!--   <a href="#" class="btn btn-danger btn-large"><i class="icon-share icon-white"></i> Take Me There...</a> -->
        
        <!-- By ConnerT HTML & CSS Enthusiast -->  
    </div>
  </div>
</div>

</body></html>
"""))}
    }
    
    def render(url:String): play.api.templates.HtmlFormat.Appendable = apply(url)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (url) => apply(url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jun 05 11:36:23 IST 2014
                    SOURCE: /home/suman/my_project/MovieSentiment/app/views/notFoundPage.scala.html
                    HASH: 6a5cb6ec55497cc99b1f49919556652a753f7839
                    MATRIX: 781->1|888->14|1252->351|1280->352|1405->449|1434->450
                    LINES: 26->1|29->1|37->9|37->9|37->9|37->9
                    -- GENERATED --
                */
            