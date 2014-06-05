
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(apiKeyNielsen: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hollywood Upcomming Movie success prediction using sentiment analysis</title>

    <!-- Bootstrap Core CSS -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Fonts -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    <!-- Custom Theme CSS -->
     <link href=""""),_display_(Seq[Any](/*22.19*/routes/*22.25*/.Assets.at("stylesheets/grayscale.css"))),format.raw/*22.64*/("""" media='screen' rel='stylesheet' type='text/css' />
    
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">
                    <img alt="Titli" src="/assets/images/logo.png">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">About</a>
                    </li>
                    
                    <li class="page-scroll">
                        <a href="#contact">Contact</a>
                    </li>
                    <li class="page-scroll">
                        <a href="/view">Start Here</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <section class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <img alt="Titli" src="/assets/images/logo.png" style="size: 400%">
                        <p class="intro-text">Hollywood Upcomming Movie success prediction using sentiment analysis</p>
                        <div class="page-scroll">
                            <a href="#about" class="btn btn-circle">
                                <i class="fa fa-angle-double-down animated"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="about" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>About Titli</h2>
                
                <p>Sentiment based decisions are affected by innumerable influences and are subjected to frequent changes. Titli - envisions to capture the butterfly effect, a flickering flight of a butterfly,  its germination capacity and all.The basic idea of  the application is to analyze popularity of a product (which may be books, movie, mobile apps, etc) from different social media by computing sentiment values from posts in those media. The popularity is measures by
sentiment value" of the product computed from the related posts obtained from social media.</p> <p>The sentiment value is then analyzed against the rank of the product in Neilsen's top-ten product list in the corresponding category to see
               if there is any gap between the market sentiment of the product and the sales figure from Neilsen.</p>
                              
                <ul class="list-inline banner-social-buttons">
                    <li><a href="/view" class="btn btn-default btn-lg"><span class="network-name">Start Here</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </section>


    <section id="contact" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Contact Team</h2>
                <p>Feel free to email us to provide some feedback or give us suggestions!</p>
                <ul class="list-inline banner-social-buttons">
                    <li><a href="mailto:sumanadak@gmail.com" class="btn btn-default btn-lg"><span class="network-name mailto">Email Us</span></a>
                    </li>
                </ul>
                
            </div>
        </div>
    </section>
    
    

    <div class="container">
        <hr>
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright (c) suman adak</p>
                </div>
            </div>
            <div class="row" style="float: right;"><span><i>This site is responsive.</i><br/> </span></div>
        </footer>
    </div>

    <!-- Core JavaScript Files -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

   
    <!-- Custom Theme JavaScript -->
    <script type="text/javascript" src=""""),_display_(Seq[Any](/*134.42*/routes/*134.48*/.Assets.at("javascripts/grayscale.js"))),format.raw/*134.86*/(""""></script>
    
    

</body>

</html>
"""))}
    }
    
    def render(apiKeyNielsen:String): play.api.templates.HtmlFormat.Appendable = apply(apiKeyNielsen)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (apiKeyNielsen) => apply(apiKeyNielsen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jun 05 11:36:23 IST 2014
                    SOURCE: /home/suman/my_project/MovieSentiment/app/views/index.scala.html
                    HASH: 8758a2a64f6354fa0440be58eaf51078b802a944
                    MATRIX: 774->1|891->24|1818->915|1833->921|1894->960|7068->6098|7084->6104|7145->6142
                    LINES: 26->1|29->1|50->22|50->22|50->22|162->134|162->134|162->134
                    -- GENERATED --
                */
            