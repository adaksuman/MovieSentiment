
package views.html.Sentiment

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
object sentiment extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(apiKeyNielsen: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""
<!DOCTYPE html>
<html>
	<head>
		 <title>Titli - Sentiment based marketing strategy</title>
	
		<link href=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("stylesheets/typeahead/search.css"))),format.raw/*7.68*/("""" media='screen' rel='stylesheet' type='text/css' />
		<link href=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("stylesheets/bootstrap/bootstrap.css"))),format.raw/*8.71*/("""" media='screen' rel='stylesheet' type='text/css' />
    <link href=""""),_display_(Seq[Any](/*9.18*/routes/*9.24*/.Assets.at("stylesheets/bootstrap/bootstrap.responsive.css"))),format.raw/*9.84*/("""" media='screen' rel='stylesheet' type='text/css' />
	<style type="text/css">
		#footer """),format.raw/*11.11*/("""{"""),format.raw/*11.12*/("""
			position:absolute;
			bottom:0;
			left:0;
		"""),format.raw/*15.3*/("""}"""),format.raw/*15.4*/("""
	</style>
		<script src=""""),_display_(Seq[Any](/*17.17*/routes/*17.23*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*17.68*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*18.17*/routes/*18.23*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*18.65*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*19.17*/routes/*19.23*/.Assets.at("javascripts/sessvars.js"))),format.raw/*19.60*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*20.17*/routes/*20.23*/.Assets.at("javascripts/hogan-2.0.0.js"))),format.raw/*20.63*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*21.17*/routes/*21.23*/.Assets.at("javascripts/typeahead.js"))),format.raw/*21.61*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*22.17*/routes/*22.23*/.Assets.at("javascripts/search.js"))),format.raw/*22.58*/("""" type="text/javascript"></script>
	</head>

	<body style="background-color: #222">
	 <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">
            
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    
                </button>
                <a class="navbar-brand" href="/">MovieSentiment</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
               
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<div class="container">
	    	<div class="well">
				<div id="inputdiv" class="search search-nielsen">
					<h1 class="title">Search Movie</h1>
					<div class="sentiment">
						<ul class="nav nav-pills">
							<li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<!--	<li class="active" id="li_movie"><a href="javascript:void(0)" onclick="changePosition('div_movie','li_movie', 'movies')">Nielsen Top Ten</a></li> -->
							<li id="li_books"><a href="javascript:void(0)" onclick="changePosition('div_books','li_books','upcMovies')">Upcoming Hollywood Movies</a></li>
						</ul>
						<br/>
						<div id="div_movie">
							<input id="textbox" class="typeahead movies" type="text" name="movieName" placeholder="Movie Name" value="">
						</div>
						<div id="div_books" hidden="true">
							<input id="textbox" class="typeahead upcMovies" type="text" name="upcMovies" placeholder="Upcoming Movie Name" value="">
						</div>
												
						<div id="loader_id" hidden="true">
							<img src=""""),_display_(Seq[Any](/*74.19*/routes/*74.25*/.Assets.at("images/ajax-loader.gif"))),format.raw/*74.61*/("""" alt="Loading....">
							<br/>
							<span>Analyzing data from various social media...</span>
						</div>
					</div>
				</div>
			</div>
  			
		</div>
		
		<div class="container">
        <hr>
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p style="color: white;size: 12px;float: left;">Copyright (c) Suman Adak 2014</p>
                </div>
            </div>
            <div class="row" style="float: right;color: white;size: 12px;"><span><i>This site is responsive.</i><br/></span></div>
        </footer>
    </div>
		
	</body>
	
	<script>
		$(document).ready(function() """),format.raw/*99.32*/("""{"""),format.raw/*99.33*/("""
			sessvars.apiKeyNielsen = """"),_display_(Seq[Any](/*100.31*/apiKeyNielsen)),format.raw/*100.44*/("""";
			if(null==sessvars.movies)"""),format.raw/*101.29*/("""{"""),format.raw/*101.30*/("""
				sessvars.movies = [];
			"""),format.raw/*103.4*/("""}"""),format.raw/*103.5*/("""
			console.log(sessvars.apiKeyNielsen);
			$('#loader_id').show();
			loadTypeahead('movies');
		"""),format.raw/*107.3*/("""}"""),format.raw/*107.4*/(""");
	</script>
	<script>
		var prevBarId = "div_movie";
		var prevListId = "li_movie";
		function changePosition(barId, listId, type)"""),format.raw/*112.47*/("""{"""),format.raw/*112.48*/("""
			$('#'+prevBarId).hide();
			$('#'+prevListId).removeClass('active');
			$('#'+barId).show();
			$('#'+listId).addClass('active');
			prevBarId = barId;
			prevListId = listId;
			console.log(type);
			$('#loader_id').show();
			loadTypeahead(type);
		"""),format.raw/*122.3*/("""}"""),format.raw/*122.4*/("""
	</script>
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
                    SOURCE: /home/suman/my_project/MovieSentiment/app/views/Sentiment/sentiment.scala.html
                    HASH: 55f30c2f507e2d6ae445f7089f09093dbd7e6881
                    MATRIX: 788->1|905->24|1050->134|1064->140|1131->186|1234->254|1248->260|1318->309|1423->379|1437->385|1518->445|1634->533|1663->534|1739->583|1767->584|1830->611|1845->617|1912->662|1999->713|2014->719|2078->761|2165->812|2180->818|2239->855|2326->906|2341->912|2403->952|2490->1003|2505->1009|2565->1047|2652->1098|2667->1104|2724->1139|5098->3477|5113->3483|5171->3519|5846->4166|5875->4167|5943->4198|5979->4211|6039->4242|6069->4243|6127->4273|6156->4274|6282->4372|6311->4373|6472->4505|6502->4506|6785->4761|6814->4762
                    LINES: 26->1|29->1|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|102->74|102->74|102->74|127->99|127->99|128->100|128->100|129->101|129->101|131->103|131->103|135->107|135->107|140->112|140->112|150->122|150->122
                    -- GENERATED --
                */
            