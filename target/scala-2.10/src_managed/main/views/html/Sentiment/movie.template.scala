
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
object movie extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[SentimentAnalysisDetails,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(details: SentimentAnalysisDetails):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.37*/("""
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Movie Sentiment Analytics</title>

    <!-- Bootstrap core CSS -->
    <link href=""""),_display_(Seq[Any](/*12.18*/routes/*12.24*/.Assets.at("stylesheets/bootstrap/bootstrap.css"))),format.raw/*12.73*/("""" media='screen' rel='stylesheet' type='text/css' />
    <link href=""""),_display_(Seq[Any](/*13.18*/routes/*13.24*/.Assets.at("stylesheets/bootstrap/bootstrap.responsive.css"))),format.raw/*13.84*/("""" media='screen' rel='stylesheet' type='text/css' />
    <link href=""""),_display_(Seq[Any](/*14.18*/routes/*14.24*/.Assets.at("stylesheets/bootstrap/docs.min.css"))),format.raw/*14.72*/("""" media='screen' rel='stylesheet' type='text/css' />
    <link href=""""),_display_(Seq[Any](/*15.18*/routes/*15.24*/.Assets.at("stylesheets/bootstrap/portfolio-item.css"))),format.raw/*15.78*/("""" media='screen' rel='stylesheet' type='text/css' />
    <link href=""""),_display_(Seq[Any](/*16.18*/routes/*16.24*/.Assets.at("stylesheets/bootstrap/delta.main.css"))),format.raw/*16.74*/("""" media='screen' rel='stylesheet' type='text/css' />
    <link href=""""),_display_(Seq[Any](/*17.18*/routes/*17.24*/.Assets.at("stylesheets/bootstrap/font-awesome.css"))),format.raw/*17.76*/("""" media='screen' rel='stylesheet' type='text/css' />
    <style type="text/css">
    	img """),format.raw/*19.10*/("""{"""),format.raw/*19.11*/("""
			max-width: 100%;
			width: auto\9;
			height: auto;
			vertical-align: middle;
			border: 0;
			ms-interpolation-mode: bicubic;
			"""),format.raw/*26.4*/("""}"""),format.raw/*26.5*/("""
    </style>
    <link rel="stylesheet" href="http://bootstrap-fugue.azurewebsites.net/css/bootstrap-fugue-min.css"/>
    <script type="text/javascript" src=""""),_display_(Seq[Any](/*29.42*/routes/*29.48*/.Assets.at("javascripts/jquery/delta.js"))),format.raw/*29.89*/(""""></script>
</head>

<body style="">
<script type="text/javascript" async src="http://www.google-analytics.com/ga.js"></script>
    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/">MovieSentiment</a>
                <a class="navbar-brand" href="/view">Search Movies</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">

            <div class="col-lg-12">
            
                <h1 class="page-header">"""),_display_(Seq[Any](/*65.42*/details/*65.49*/.movieName)),format.raw/*65.59*/("""
                <br/>
                <small>Category: """),_display_(Seq[Any](/*67.35*/details/*67.42*/.category)),format.raw/*67.51*/("""</small>
                  <!--  <br/><small>Nielsen Rank # """),_display_(Seq[Any](/*68.53*/details/*68.60*/.rank)),format.raw/*68.65*/(""" </small> -->
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-5">
                <img class="img-responsive" src=""""),_display_(Seq[Any](/*75.51*/details/*75.58*/.poster)),format.raw/*75.65*/("""">
            </div>
            <div class="col-md-7">
                <h3>Movie Synopsis</h3>
                <p>"""),_display_(Seq[Any](/*79.21*/details/*79.28*/.synopsis)),format.raw/*79.37*/("""</p>
                <div class="row">
                <div class="col-md-6">
	                <h4>&nbsp;&nbsp;&nbsp;&nbsp;Aggregate Sentiment Score </h4>
	                <div id="pi-over-chart-gauge" style="min-width: 250px; max-width: 250px; height: 250px; margin: 0 auto">
						<center>
                	<div id="loader_id_2">
						<img src=""""),_display_(Seq[Any](/*86.18*/routes/*86.24*/.Assets.at("images/ajax-loader.gif"))),format.raw/*86.60*/("""" alt="Loading....">
					</div>
					</center>
					</div>
					</div>
					
					<div id="movie-rank-ind" class="col-md-6" style="display: none;">
	                <h4>Social Sentiment Indicator with Nielsen Rank</h4>
	                	<span id="replace-icon"></span>
	                	<center>
		                	<div id="loader_id_61">
								<img src=""""),_display_(Seq[Any](/*97.20*/routes/*97.26*/.Assets.at("images/ajax-loader.gif"))),format.raw/*97.62*/("""" alt="Loading....">
							</div>
						</center>
					</div>
					
					<div id="movie-status-ind" class="col-md-6" style="display: none;">
	                <h4>Movie Success Prediction based on Sentiment Analysis</h4>
	                	<div id="case" style="display: none;">Movie is likely to be: <center><span id="replace-type"></span></center></div>
	                	<br/>
	                	<center>
		                	<div id="loader_id_62">
								<img src=""""),_display_(Seq[Any](/*108.20*/routes/*108.26*/.Assets.at("images/ajax-loader.gif"))),format.raw/*108.62*/("""" alt="Loading....">
							</div>
						</center>
					</div>
					
                </div>
                
                	<div class="col-md-6">
	                <h4><a href="https://twitter.com">Tweets</a> Sentiment Score </h4>
	                <div id="pi-chart-gauge" >
		                
						<div id="score-point" style="display: none;">
						
						<ul>
              		
                  			 	 <li>Score:&nbsp;&nbsp;<legend>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b  style="color: purple;" id="replace"></b></legend><span style="float:right;font-size: 8px;">Powered By:&nbsp;&nbsp;<a href="http://www.topsy.com/">Topsy</a></span></li>
                  			  	
              			  </ul>
              			 </div>
              			 
					</div>
					
					</div>
					
					
					<div class="col-md-6">
	                <h4><a href="http://www.rottentomatoes.com/">Rotten Tomatoes</a> Review Score</h4>
	                <div id="pi-chart-gauge-rtapi" style="padding: 0px; position: relative;">
		                
		                	 <ul>
                    			<li>Sentiment Polarity:&nbsp;&nbsp;<b>"""),_display_(Seq[Any](/*138.63*/details/*138.70*/.sentiment.getType())),format.raw/*138.90*/("""</b>&nbsp;&nbsp;<span><i class=""""),_display_(Seq[Any](/*138.123*/details/*138.130*/.sentiment.icon)),format.raw/*138.145*/(""""></i></span></li>
                  			 	 <li>Score:&nbsp;&nbsp;<legend>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style="color: purple;">"""),_display_(Seq[Any](/*139.136*/details/*139.143*/.sentiment.score)),format.raw/*139.159*/("""</b></legend><span style="float: right;font-size: 8px;">Powered By:&nbsp;&nbsp;<a href="http://www.alchemyapi.com/">AlchemyAPI</a></span></li>
                  			  	
              			  </ul>
						
					</div>
					<br/>
					 
					</div>
					
                
            
            	<h4>&nbsp;&nbsp;&nbsp;<a href="http://www.rottentomatoes.com/">Rotten Tomatoes</a> Critic Score</h4>
            	<div class="col-md-6">
            			<ul>
                    		<li>Critics Rating:&nbsp;&nbsp;<b>"""),_display_(Seq[Any](/*153.58*/details/*153.65*/.rating.critics_rating)),format.raw/*153.87*/("""</b>&nbsp;&nbsp;<span><i class=""""),_display_(Seq[Any](/*153.120*/details/*153.127*/.rating.criticIcon)),format.raw/*153.145*/(""""></i></span></li>
                    		<li>Score:&nbsp;&nbsp;<legend>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b  style="color: purple;">"""),_display_(Seq[Any](/*154.177*/details/*154.184*/.rating.critics_score_point)),format.raw/*154.211*/("""</b></legend></li>
                    	</ul>
                    	</div>
                    	<h4>&nbsp;&nbsp;&nbsp;<a href="http://www.rottentomatoes.com/">Rotten Tomatoes</a> Audience Score</h4>
                    	<div class="col-md-6">
                    	<ul>
                   			<li>Audience Rating:&nbsp;&nbsp;<b>"""),_display_(Seq[Any](/*160.59*/details/*160.66*/.rating.audience_rating)),format.raw/*160.89*/("""</b>&nbsp;&nbsp;<span><i class=""""),_display_(Seq[Any](/*160.122*/details/*160.129*/.rating.audienceIcon)),format.raw/*160.149*/(""""></i></span></li>
                    		<li>Score:&nbsp;&nbsp;<legend>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b  style="color: purple;">"""),_display_(Seq[Any](/*161.207*/details/*161.214*/.rating.audience_score)),format.raw/*161.236*/("""</b></legend></li>
                		</ul>
                		</div>
            
            
           
		</div>
			
        </div>
         <div class="row">
            <div class="col-md-5">
                <h3><a title="" class="tip-top" href="javascript:void(0)" onclick="$('.analytics-toggle').toggle('slow');" data-original-title="View all posts"> Tweets graph on last 30 days </a> </h3>
                
                <div class="chart analytics analytics-toggle" style="padding: 0px; position: relative;">
                	<center>
                	<br/>
                	<br/>
                	<br/>
                	<br/>
                	<div id="loader_id_3">
						<img src=""""),_display_(Seq[Any](/*181.18*/routes/*181.24*/.Assets.at("images/ajax-loader.gif"))),format.raw/*181.60*/("""" alt="Loading....">
					</div>
					</center>
                </div>
            </div>
            
            <div class="col-md-5">
                <h3><a title="" class="tip-top" href="javascript:void(0)" onclick="$('.graph-toggle').toggle('slow');" data-original-title="View all posts"> Detailed sentiment score graph </a> </h3>
                
                <div class="chart graph graph-toggle" style="padding: 0px; position: relative;">
                	<center>
                	<br/>
                	<br/>
                	<br/>
                	<br/>
                	<div id="loader_id_1">
						<img src=""""),_display_(Seq[Any](/*197.18*/routes/*197.24*/.Assets.at("images/ajax-loader.gif"))),format.raw/*197.60*/("""" alt="Loading....">
					</div>
					</center>
                </div>
            </div>
            
            
            </div>
            
            <div class="row">
            <div class="col-md-12">
            	<br/>
            	<br/>
            	<button style="float: right;" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal">Market Strategy Recommendation</button>
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog modal-lg">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						        <h4 class="modal-title" id="myModalLabel">Recommendation</h4>
						      </div>
						      <div class="modal-body">
						        <ul class="nav nav-pills">
  									<li class="active"><a href="#viewers" data-toggle="tab">Viewers Category</a></li>
 									<li><a href="#adChannels" data-toggle="tab">Broadcast Channels</a></li>
  									<li><a href="#adSites" data-toggle="tab">Broadcast Sites</a></li>
								</ul>
								<div class="tab-content">
  									<div class="tab-pane active" id="viewers">
  										<div class="bs-callout bs-callout-info">
		  									<ul>
												"""),_display_(Seq[Any](/*228.14*/for(bufferViewer <- details.reco.bufferViewers) yield /*228.61*/ {_display_(Seq[Any](format.raw/*228.63*/("""
													<li>
														<span> """),_display_(Seq[Any](/*230.23*/bufferViewer)),format.raw/*230.35*/(""" </span>
													</li>
												""")))})),format.raw/*232.14*/("""	
											</ul>
										</div>
										<div class="bs-callout bs-callout-warning">
											<span><u>Note</u>: """),_display_(Seq[Any](/*236.32*/details/*236.39*/.reco.bufferAge.toString())),format.raw/*236.65*/("""</span>
										</div>
  									</div>
  									<div class="tab-pane" id="adChannels">
										<div class="bs-callout bs-callout-warning">
											<ul>
												"""),_display_(Seq[Any](/*242.14*/for(buf <- details.reco.bufferChnls) yield /*242.50*/ {_display_(Seq[Any](format.raw/*242.52*/("""
													<li>
														<span> Channel : <b>"""),_display_(Seq[Any](/*244.36*/buf)),format.raw/*244.39*/("""</b> </span>
														<ul>
															"""),_display_(Seq[Any](/*246.17*/for(prog <- details.reco.map.get(buf)) yield /*246.55*/ {_display_(Seq[Any](format.raw/*246.57*/("""
																<li><span> <a>"""),_display_(Seq[Any](/*247.32*/prog)),format.raw/*247.36*/("""</a> </span></li>
															""")))})),format.raw/*248.17*/("""	
														</ul>
													</li>
												""")))})),format.raw/*251.14*/("""	
											</ul>
										</div>
  									</div>
  									<div class="tab-pane" id="adSites">
  									
  									<div class="bs-callout bs-callout-danger">
  										<ul>
												"""),_display_(Seq[Any](/*259.14*/for(buf <- details.reco.bufferSites) yield /*259.50*/ {_display_(Seq[Any](format.raw/*259.52*/("""
													<li>
														<span> <a>"""),_display_(Seq[Any](/*261.26*/buf)),format.raw/*261.29*/("""</a> </span>
													</li>
												""")))})),format.raw/*263.14*/("""	
											</ul>
											</div>
  									</div>
								</div>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-primary" data-dismiss="modal">Done</button>
						      </div>
						    </div>
						  </div>
						</div>
            </div>
            </div>
            
        <div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Movie Poster</h3>
            </div>
			"""),_display_(Seq[Any](/*283.5*/for(mov <- details.relatedPosters) yield /*283.39*/ {_display_(Seq[Any](format.raw/*283.41*/("""
	            <div class="col-sm-3 col-xs-6">
	                <img class="img-responsive portfolio-item" src=""""),_display_(Seq[Any](/*285.67*/mov/*285.70*/.poster)),format.raw/*285.77*/("""" title=""""),_display_(Seq[Any](/*285.87*/mov/*285.90*/.name)),format.raw/*285.95*/("""">
	            </div>
            """)))})),format.raw/*287.14*/("""


        </div>
        
       
        
        <!-- Start -->
        <div class="row">
        <div class="span5">
        <div class="widget-box">
						<div class="widget-title"><span class="icon"><i class="icon-file"></i></span><h5><a title="" class="tip-top" href="javascript:void(0)" onclick="$('.tweets-toggle').toggle('slow');" data-original-title="View all posts"> Related Tweets </a></h5><span title="" class="label label-info tip-left" data-original-title="10 total posts">10</span></div>
						<div class="widget-content nopadding">
							<ul class="recent-posts">
							"""),_display_(Seq[Any](/*301.9*/for(tweet <- details.tweets) yield /*301.37*/ {_display_(Seq[Any](format.raw/*301.39*/("""
								<li class="tweets-toggle" style="display: none;">
									<div class="user-thumb">
										<img width="40" height="40" alt="User" src=""""),_display_(Seq[Any](/*304.56*/tweet/*304.61*/.url)),format.raw/*304.65*/("""">
									</div>
									<div class="article-post">
										<span class="user-info"> By: """),_display_(Seq[Any](/*307.41*/tweet/*307.46*/.name)),format.raw/*307.51*/(""" </span>
										<p>
											<a href="javascript:void(0)">"""),_display_(Seq[Any](/*309.42*/tweet/*309.47*/.tweet)),format.raw/*309.53*/("""</a>
										</p>
									
									<a class="btn btn-danger btn-mini" href="javascript:void(0)" data-placement="left" data-original-title="Delete"><i class="icon-remove"></i></a>	
									</div>
								</li>
							""")))})),format.raw/*315.9*/("""
									
							</ul>
						</div>
					</div>
			</div>
		
			<div class="span6">
        		<div class="widget-box">
						<div class="widget-title"><span class="icon"><i class="icon-file"></i></span><h5><a title="" class="tip-top" href="javascript:void(0)" onclick="$('.posts-toggle').toggle('slow');" data-original-title="View all posts"> Related Posts from Rotten Tomatoes </a></h5><span title="" class="label label-info tip-left" data-original-title="total posts">"""),_display_(Seq[Any](/*324.353*/details/*324.360*/.reviews.size())),format.raw/*324.375*/("""</span></div>
						<div class="widget-content nopadding">
							<ul class="recent-posts">
							"""),_display_(Seq[Any](/*327.9*/for(review <- details.reviews) yield /*327.39*/ {_display_(Seq[Any](format.raw/*327.41*/("""
								<li class="posts-toggle" style="display: none;">
									<div class="user-thumb">
										<img width="40" height="40" alt="User" src=""""),_display_(Seq[Any](/*330.56*/review/*330.62*/.url)),format.raw/*330.66*/("""">
									</div>
									<div class="article-post">
										<span class="user-info"> By: """),_display_(Seq[Any](/*333.41*/review/*333.47*/.critic)),format.raw/*333.54*/(""" on """),_display_(Seq[Any](/*333.59*/review/*333.65*/.date)),format.raw/*333.70*/(""" at """),_display_(Seq[Any](/*333.75*/review/*333.81*/.publication)),format.raw/*333.93*/(""" </span>
										<p>
											<a href="javascript:void(0)">"""),_display_(Seq[Any](/*335.42*/review/*335.48*/.quote)),format.raw/*335.54*/("""</a>
										</p>
									
										<a class="btn btn-danger btn-mini" href="javascript:void(0)" data-placement="left" data-original-title="Delete"><i class="icon-remove"></i></a>	
									</div>
								</li>
							""")))})),format.raw/*341.9*/("""	
							</ul>
						</div>
				</div>
			</div>
				
			</div>
        <!-- Stop -->
        
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">Similar Movies</h3>
            </div>
			"""),_display_(Seq[Any](/*354.5*/for(relMov <- details.relatedMovies) yield /*354.41*/ {_display_(Seq[Any](format.raw/*354.43*/("""
	            <div class="col-sm-3 col-xs-6">
	                <a href="/view/movies?q="""),_display_(Seq[Any](/*356.43*/relMov/*356.49*/.name)),format.raw/*356.54*/("""&r=NA&c=">
	                    <img class="img-responsive portfolio-item" src=""""),_display_(Seq[Any](/*357.71*/relMov/*357.77*/.poster)),format.raw/*357.84*/("""" title=""""),_display_(Seq[Any](/*357.94*/relMov/*357.100*/.name)),format.raw/*357.105*/("""">
	                </a>
	            </div>
            """)))})),format.raw/*360.14*/("""


        </div>
    </div>
    <!-- /.container -->

    <div class="container">
        <hr>
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright (c) suman adak 2014</p>
                </div>
            </div>
            <div class="row" style="float: right;"><span><i>This site is responsive.</i><br/></span></div>
        </footer>
    </div>
    <!-- /.container -->

    <!-- JavaScript -->
    <script src=""""),_display_(Seq[Any](/*381.19*/routes/*381.25*/.Assets.at("javascripts/jquery/jquery-1.10.2.js"))),format.raw/*381.74*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*382.16*/routes/*382.22*/.Assets.at("javascripts/jquery/bootstrap.js"))),format.raw/*382.67*/("""" type="text/javascript"></script>
	
	<script src="http://code.highcharts.com/highcharts.js" type="text/javascript"></script>
	<script src="http://code.highcharts.com/highcharts-more.js" type="text/javascript"></script>
	<script src="http://code.highcharts.com/modules/exporting.js" type="text/javascript"></script>
    <script>
      var movieName = """"),_display_(Seq[Any](/*388.25*/details/*388.32*/.movieName)),format.raw/*388.42*/("""";
      var score;
      $.ajax("""),format.raw/*390.14*/("""{"""),format.raw/*390.15*/("""
    	 url: '/view/getAnalytics?q='+movieName,
    	 type: 'GET',
    	 success: function(e)"""),format.raw/*393.27*/("""{"""),format.raw/*393.28*/("""
    		 var plotBand = ["""),format.raw/*394.24*/("""{"""),format.raw/*394.25*/(""" 
                 from: 0,
                 to: 33,
                 color: 'rgba(68, 170, 213, 0.1)',
                 label: """),format.raw/*398.25*/("""{"""),format.raw/*398.26*/("""
                     text: 'Rotten',
                     style: """),format.raw/*400.29*/("""{"""),format.raw/*400.30*/("""
                         color: '#606060'
                     """),format.raw/*402.22*/("""}"""),format.raw/*402.23*/("""
                 """),format.raw/*403.18*/("""}"""),format.raw/*403.19*/("""
             """),format.raw/*404.14*/("""}"""),format.raw/*404.15*/(""", """),format.raw/*404.17*/("""{"""),format.raw/*404.18*/("""
                 from: 33,
                 to: 50,
                 color: 'rgba(0, 0, 0, 0)',
                 label: """),format.raw/*408.25*/("""{"""),format.raw/*408.26*/("""
                     text: 'Good',
                     style: """),format.raw/*410.29*/("""{"""),format.raw/*410.30*/("""
                         color: '#606060'
                     """),format.raw/*412.22*/("""}"""),format.raw/*412.23*/("""
                 """),format.raw/*413.18*/("""}"""),format.raw/*413.19*/("""
             """),format.raw/*414.14*/("""}"""),format.raw/*414.15*/(""", """),format.raw/*414.17*/("""{"""),format.raw/*414.18*/("""
                 from: 50,
                 to: 70,
                 color: 'rgba(68, 170, 213, 0.1)',
                 label: """),format.raw/*418.25*/("""{"""),format.raw/*418.26*/("""
                     text: 'Fresh',
                     style: """),format.raw/*420.29*/("""{"""),format.raw/*420.30*/("""
                         color: '#606060'
                     """),format.raw/*422.22*/("""}"""),format.raw/*422.23*/("""
                 """),format.raw/*423.18*/("""}"""),format.raw/*423.19*/("""
             """),format.raw/*424.14*/("""}"""),format.raw/*424.15*/(""", """),format.raw/*424.17*/("""{"""),format.raw/*424.18*/(""" 
                 from: 70,
                 to: 100,
                 color: 'rgba(0, 0, 0, 0)',
                 label: """),format.raw/*428.25*/("""{"""),format.raw/*428.26*/("""
                     text: 'Cheer',
                     style: """),format.raw/*430.29*/("""{"""),format.raw/*430.30*/("""
                         color: '#606060'
                     """),format.raw/*432.22*/("""}"""),format.raw/*432.23*/("""
                 """),format.raw/*433.18*/("""}"""),format.raw/*433.19*/("""
             """),format.raw/*434.14*/("""}"""),format.raw/*434.15*/("""];
    		 $('#loader_id_1').hide();
    		 $('#score-point').show();
    		 score = Math.round(e.sentiment_score);
    		 $('#replace').html(Math.round(e.sentiment_score));
    		 var series = [];
    		 var sentimentScore = [];
    		 var mentions = [];
    		 for(var ind=0;ind<e.datas.length;ind++)"""),format.raw/*442.47*/("""{"""),format.raw/*442.48*/("""
    			 sentimentScore.push(e.datas[ind].sentiment_score);
    			 mentions.push(e.datas[ind].mentions);
        	 """),format.raw/*445.11*/("""}"""),format.raw/*445.12*/("""
    		 series.push("""),format.raw/*446.20*/("""{"""),format.raw/*446.21*/("""name:'sentiment', data:sentimentScore"""),format.raw/*446.58*/("""}"""),format.raw/*446.59*/(""");
    		 //series.push("""),format.raw/*447.22*/("""{"""),format.raw/*447.23*/("""name:'mentions', data:mentions"""),format.raw/*447.53*/("""}"""),format.raw/*447.54*/(""");
    		 var dateTimeUTC = new Date();
    		 dateTimeUTC.setDate(dateTimeUTC.getDate() - 60);
    		 plotData( 'graph', 'Sentiment Score By Topsy', 'Score out of 100', 'Sentiment', series, plotBand, 86400000, dateTimeUTC.getTime());
    		 callAvg();
    	 """),format.raw/*452.7*/("""}"""),format.raw/*452.8*/(""",
    	 error: function(e)"""),format.raw/*453.25*/("""{"""),format.raw/*453.26*/("""
    		 $('#loader_id_1').hide();
    		
    	 """),format.raw/*456.7*/("""}"""),format.raw/*456.8*/("""
      """),format.raw/*457.7*/("""}"""),format.raw/*457.8*/(""");

     
      $.ajax("""),format.raw/*460.14*/("""{"""),format.raw/*460.15*/("""
     	 url: '/view/getTPSAnalytics?q='+movieName,
     	 type: 'GET',
     	 success: function(e)"""),format.raw/*463.28*/("""{"""),format.raw/*463.29*/("""
     		 $('#loader_id_3').hide();
     		 var series = [];
    		 var tweet = [];
    		 for(var ind=0;ind<e.response.histogram.length;ind++)"""),format.raw/*467.60*/("""{"""),format.raw/*467.61*/("""
    			 tweet.push(e.response.histogram[ind]);
        	 """),format.raw/*469.11*/("""}"""),format.raw/*469.12*/("""
    		 var plotBand = [];
    		 series.push("""),format.raw/*471.20*/("""{"""),format.raw/*471.21*/("""name:'Tweets', data:tweet"""),format.raw/*471.46*/("""}"""),format.raw/*471.47*/(""");
    		 var dateUTC = new Date();
    		 dateUTC.setDate(dateUTC.getDate() - 30);
    		 plotData ( 'analytics', 'No. of Tweets By Topsy', '', 'Tweets', series, plotBand, 86400000, dateUTC.getTime());
     	 """),format.raw/*475.8*/("""}"""),format.raw/*475.9*/(""",
     	 error: function(e)"""),format.raw/*476.26*/("""{"""),format.raw/*476.27*/("""
     		 $('#loader_id_3').hide();
     	 """),format.raw/*478.8*/("""}"""),format.raw/*478.9*/("""
       """),format.raw/*479.8*/("""}"""),format.raw/*479.9*/(""");

      function callAvg()"""),format.raw/*481.25*/("""{"""),format.raw/*481.26*/("""
    	  var data = '"""),_display_(Seq[Any](/*482.21*/details/*482.28*/.sentiment.score)),format.raw/*482.44*/("""'
    	  if(data=='')"""),format.raw/*483.20*/("""{"""),format.raw/*483.21*/("""
    		  data = '0';
    	  """),format.raw/*485.8*/("""}"""),format.raw/*485.9*/("""
    	  var type = '"""),_display_(Seq[Any](/*486.21*/details/*486.28*/.movieType)),format.raw/*486.38*/("""';
    	  if(type=='upcmg')"""),format.raw/*487.25*/("""{"""),format.raw/*487.26*/("""
    		  $('#movie-status-ind').show();
        	  $.ajax("""),format.raw/*489.19*/("""{"""),format.raw/*489.20*/("""
        		  url: '/view/prdct?d1='+data+'&d2="""),_display_(Seq[Any](/*490.47*/details/*490.54*/.rating.audience_score)),format.raw/*490.76*/("""&d3="""),_display_(Seq[Any](/*490.81*/details/*490.88*/.rating.critics_score)),format.raw/*490.109*/("""&d4='+score,
        	      type: 'GET',
        	      success: function(e)"""),format.raw/*492.36*/("""{"""),format.raw/*492.37*/("""
        	      	$('#loader_id_62').hide();
        	      	$('#case').show();
        	      	$('#replace-type').html('<img class="img-responsive" style="height:75px;" src='+e.response+'>');
        	      """),format.raw/*496.16*/("""}"""),format.raw/*496.17*/(""",
        	      error: function(e)"""),format.raw/*497.34*/("""{"""),format.raw/*497.35*/("""
        	    	  $('#loader_id_62').hide();
            	  """),format.raw/*499.16*/("""}"""),format.raw/*499.17*/("""
              """),format.raw/*500.15*/("""}"""),format.raw/*500.16*/(""");
       	  """),format.raw/*501.11*/("""}"""),format.raw/*501.12*/("""else"""),format.raw/*501.16*/("""{"""),format.raw/*501.17*/("""
       		$('#movie-rank-ind').show();
          """),format.raw/*503.11*/("""}"""),format.raw/*503.12*/("""
      $.ajax("""),format.raw/*504.14*/("""{"""),format.raw/*504.15*/("""
      	 url: '/view/average?d1='+data+'&d2="""),_display_(Seq[Any](/*505.45*/details/*505.52*/.rating.audience_score)),format.raw/*505.74*/("""&d3="""),_display_(Seq[Any](/*505.79*/details/*505.86*/.rating.critics_score)),format.raw/*505.107*/("""&d4='+score,
      	 type: 'GET',
      	 success: function(e)"""),format.raw/*507.29*/("""{"""),format.raw/*507.30*/("""
      		$('#loader_id_2').hide();
      		loadChartForSentiment('pi-over-chart-gauge', 'Score', e.response, '');
      		var rank = """"),_display_(Seq[Any](/*510.22*/details/*510.29*/.rank)),format.raw/*510.34*/("""";
      		if(rank)"""),format.raw/*511.17*/("""{"""),format.raw/*511.18*/("""
          		if(type=='movie')"""),format.raw/*512.30*/("""{"""),format.raw/*512.31*/("""
	      		$.ajax("""),format.raw/*513.17*/("""{"""),format.raw/*513.18*/("""
	          		url:'/view/getAttention?rate='+e.response+'&rank="""),_display_(Seq[Any](/*514.64*/details/*514.71*/.rank)),format.raw/*514.76*/("""',
	          		type: 'GET',
	          		success: function(e)"""),format.raw/*516.34*/("""{"""),format.raw/*516.35*/("""
	          			$('#loader_id_61').hide();
	          			$('#replace-icon').html('<img class="img-responsive" style="height:250px;" src='+e.response+'>');
	          		"""),format.raw/*519.14*/("""}"""),format.raw/*519.15*/(""",
	          		error: function(e)"""),format.raw/*520.32*/("""{"""),format.raw/*520.33*/("""
	          			$('#loader_id_61').hide();
	              	"""),format.raw/*522.17*/("""}"""),format.raw/*522.18*/("""
	          	"""),format.raw/*523.13*/("""}"""),format.raw/*523.14*/(""");
          		"""),format.raw/*524.13*/("""}"""),format.raw/*524.14*/("""
      		"""),format.raw/*525.9*/("""}"""),format.raw/*525.10*/("""else"""),format.raw/*525.14*/("""{"""),format.raw/*525.15*/("""
      			$('#loader_id_61').hide();
      			$('#replace-icon').html('<img class="img-responsive" style="height:250px;" src="/assets/images/neutral.png">');
          	"""),format.raw/*528.12*/("""}"""),format.raw/*528.13*/("""
      	 """),format.raw/*529.9*/("""}"""),format.raw/*529.10*/(""",
      	 error: function(e)"""),format.raw/*530.27*/("""{"""),format.raw/*530.28*/("""
      		 $('#loader_id_2').hide();
      	 """),format.raw/*532.9*/("""}"""),format.raw/*532.10*/("""
        """),format.raw/*533.9*/("""}"""),format.raw/*533.10*/(""");
      """),format.raw/*534.7*/("""}"""),format.raw/*534.8*/("""
      var doc = document.documentElement;
      doc.setAttribute('data-useragent', navigator.userAgent);
      
    </script>
<script>
  $(function () """),format.raw/*540.17*/("""{"""),format.raw/*540.18*/("""
    $('#myTab a:last').tab('show')
  """),format.raw/*542.3*/("""}"""),format.raw/*542.4*/(""")
</script>


</body>
</html>
"""))}
    }
    
    def render(details:SentimentAnalysisDetails): play.api.templates.HtmlFormat.Appendable = apply(details)
    
    def f:((SentimentAnalysisDetails) => play.api.templates.HtmlFormat.Appendable) = (details) => apply(details)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jun 05 11:36:23 IST 2014
                    SOURCE: /home/suman/my_project/MovieSentiment/app/views/Sentiment/movie.scala.html
                    HASH: 8e420aab9ab10d4178d9fc5724f8e653de2ac119
                    MATRIX: 802->1|931->36|1282->351|1297->357|1368->406|1474->476|1489->482|1571->542|1677->612|1692->618|1762->666|1868->736|1883->742|1959->796|2065->866|2080->872|2152->922|2258->992|2273->998|2347->1050|2465->1140|2494->1141|2656->1276|2684->1277|2880->1437|2895->1443|2958->1484|4310->2800|4326->2807|4358->2817|4451->2874|4467->2881|4498->2890|4595->2951|4611->2958|4638->2963|4856->3145|4872->3152|4901->3159|5054->3276|5070->3283|5101->3292|5486->3641|5501->3647|5559->3683|5954->4042|5969->4048|6027->4084|6532->4552|6548->4558|6607->4594|7828->5778|7845->5785|7888->5805|7959->5838|7977->5845|8016->5860|8208->6014|8226->6021|8266->6037|8808->6542|8825->6549|8870->6571|8941->6604|8959->6611|9001->6629|9234->6824|9252->6831|9303->6858|9666->7184|9683->7191|9729->7214|9800->7247|9818->7254|9862->7274|10125->7499|10143->7506|10189->7528|10920->8222|10936->8228|10995->8264|11658->8890|11674->8896|11733->8932|13140->10302|13204->10349|13245->10351|13323->10392|13358->10404|13432->10445|13590->10566|13607->10573|13656->10599|13869->10775|13922->10811|13963->10813|14054->10867|14080->10870|14165->10918|14220->10956|14261->10958|14330->10990|14357->10994|14424->11028|14511->11082|14745->11279|14798->11315|14839->11317|14920->11361|14946->11364|15024->11409|15542->11891|15593->11925|15634->11927|15783->12039|15796->12042|15826->12049|15873->12059|15886->12062|15914->12067|15983->12103|16610->12694|16655->12722|16696->12724|16881->12872|16896->12877|16923->12881|17055->12976|17070->12981|17098->12986|17199->13050|17214->13055|17243->13061|17497->13283|18007->13755|18025->13762|18064->13777|18200->13877|18247->13907|18288->13909|18472->14056|18488->14062|18515->14066|18647->14161|18663->14167|18693->14174|18735->14179|18751->14185|18779->14190|18821->14195|18837->14201|18872->14213|18973->14277|18989->14283|19018->14289|19273->14512|19549->14752|19602->14788|19643->14790|19768->14878|19784->14884|19812->14889|19930->14970|19946->14976|19976->14983|20023->14993|20040->14999|20069->15004|20160->15062|20683->15548|20699->15554|20771->15603|20858->15653|20874->15659|20942->15704|21332->16057|21349->16064|21382->16074|21444->16107|21474->16108|21595->16200|21625->16201|21678->16225|21708->16226|21865->16354|21895->16355|21990->16421|22020->16422|22113->16486|22143->16487|22190->16505|22220->16506|22263->16520|22293->16521|22324->16523|22354->16524|22504->16645|22534->16646|22627->16710|22657->16711|22750->16775|22780->16776|22827->16794|22857->16795|22900->16809|22930->16810|22961->16812|22991->16813|23148->16941|23178->16942|23272->17007|23302->17008|23395->17072|23425->17073|23472->17091|23502->17092|23545->17106|23575->17107|23606->17109|23636->17110|23788->17233|23818->17234|23912->17299|23942->17300|24035->17364|24065->17365|24112->17383|24142->17384|24185->17398|24215->17399|24545->17700|24575->17701|24720->17817|24750->17818|24799->17838|24829->17839|24895->17876|24925->17877|24978->17901|25008->17902|25067->17932|25097->17933|25384->18192|25413->18193|25468->18219|25498->18220|25573->18267|25602->18268|25637->18275|25666->18276|25718->18299|25748->18300|25875->18398|25905->18399|26076->18541|26106->18542|26193->18600|26223->18601|26298->18647|26328->18648|26382->18673|26412->18674|26650->18884|26679->18885|26735->18912|26765->18913|26835->18955|26864->18956|26900->18964|26929->18965|26986->18993|27016->18994|27074->19015|27091->19022|27130->19038|27180->19059|27210->19060|27266->19088|27295->19089|27353->19110|27370->19117|27403->19127|27459->19154|27489->19155|27576->19213|27606->19214|27690->19261|27707->19268|27752->19290|27794->19295|27811->19302|27856->19323|27961->19399|27991->19400|28227->19607|28257->19608|28321->19643|28351->19644|28439->19703|28469->19704|28513->19719|28543->19720|28585->19733|28615->19734|28648->19738|28678->19739|28756->19788|28786->19789|28829->19803|28859->19804|28941->19849|28958->19856|29003->19878|29045->19883|29062->19890|29107->19911|29198->19973|29228->19974|29400->20109|29417->20116|29445->20121|29493->20140|29523->20141|29582->20171|29612->20172|29658->20189|29688->20190|29789->20254|29806->20261|29834->20266|29925->20328|29955->20329|30151->20496|30181->20497|30243->20530|30273->20531|30360->20589|30390->20590|30432->20603|30462->20604|30506->20619|30536->20620|30573->20629|30603->20630|30636->20634|30666->20635|30864->20804|30894->20805|30931->20814|30961->20815|31018->20843|31048->20844|31120->20888|31150->20889|31187->20898|31217->20899|31254->20908|31283->20909|31464->21061|31494->21062|31560->21100|31589->21101
                    LINES: 26->1|29->1|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|54->26|54->26|57->29|57->29|57->29|93->65|93->65|93->65|95->67|95->67|95->67|96->68|96->68|96->68|103->75|103->75|103->75|107->79|107->79|107->79|114->86|114->86|114->86|125->97|125->97|125->97|136->108|136->108|136->108|166->138|166->138|166->138|166->138|166->138|166->138|167->139|167->139|167->139|181->153|181->153|181->153|181->153|181->153|181->153|182->154|182->154|182->154|188->160|188->160|188->160|188->160|188->160|188->160|189->161|189->161|189->161|209->181|209->181|209->181|225->197|225->197|225->197|256->228|256->228|256->228|258->230|258->230|260->232|264->236|264->236|264->236|270->242|270->242|270->242|272->244|272->244|274->246|274->246|274->246|275->247|275->247|276->248|279->251|287->259|287->259|287->259|289->261|289->261|291->263|311->283|311->283|311->283|313->285|313->285|313->285|313->285|313->285|313->285|315->287|329->301|329->301|329->301|332->304|332->304|332->304|335->307|335->307|335->307|337->309|337->309|337->309|343->315|352->324|352->324|352->324|355->327|355->327|355->327|358->330|358->330|358->330|361->333|361->333|361->333|361->333|361->333|361->333|361->333|361->333|361->333|363->335|363->335|363->335|369->341|382->354|382->354|382->354|384->356|384->356|384->356|385->357|385->357|385->357|385->357|385->357|385->357|388->360|409->381|409->381|409->381|410->382|410->382|410->382|416->388|416->388|416->388|418->390|418->390|421->393|421->393|422->394|422->394|426->398|426->398|428->400|428->400|430->402|430->402|431->403|431->403|432->404|432->404|432->404|432->404|436->408|436->408|438->410|438->410|440->412|440->412|441->413|441->413|442->414|442->414|442->414|442->414|446->418|446->418|448->420|448->420|450->422|450->422|451->423|451->423|452->424|452->424|452->424|452->424|456->428|456->428|458->430|458->430|460->432|460->432|461->433|461->433|462->434|462->434|470->442|470->442|473->445|473->445|474->446|474->446|474->446|474->446|475->447|475->447|475->447|475->447|480->452|480->452|481->453|481->453|484->456|484->456|485->457|485->457|488->460|488->460|491->463|491->463|495->467|495->467|497->469|497->469|499->471|499->471|499->471|499->471|503->475|503->475|504->476|504->476|506->478|506->478|507->479|507->479|509->481|509->481|510->482|510->482|510->482|511->483|511->483|513->485|513->485|514->486|514->486|514->486|515->487|515->487|517->489|517->489|518->490|518->490|518->490|518->490|518->490|518->490|520->492|520->492|524->496|524->496|525->497|525->497|527->499|527->499|528->500|528->500|529->501|529->501|529->501|529->501|531->503|531->503|532->504|532->504|533->505|533->505|533->505|533->505|533->505|533->505|535->507|535->507|538->510|538->510|538->510|539->511|539->511|540->512|540->512|541->513|541->513|542->514|542->514|542->514|544->516|544->516|547->519|547->519|548->520|548->520|550->522|550->522|551->523|551->523|552->524|552->524|553->525|553->525|553->525|553->525|556->528|556->528|557->529|557->529|558->530|558->530|560->532|560->532|561->533|561->533|562->534|562->534|568->540|568->540|570->542|570->542
                    -- GENERATED --
                */
            