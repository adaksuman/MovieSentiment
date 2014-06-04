package controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import models.Review;
import models.SentimentAnalysisDetails;
import models.SentimentDetails;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import play.*;
import play.mvc.*;

import views.html.*;

@SuppressWarnings({"deprecation", "unused"})
public class SentimentController extends Controller {

    public static Result index() {
    	String apikey = Play.application().configuration().getString("apikey");
        return ok(index.render(apikey));
    }
    
    public static Result sentiment() {
    	String apikey = Play.application().configuration().getString("apikey");
        return ok(views.html.Sentiment.sentiment.render(apikey));
    }
    
    public static Result preflight(String id){
    	response().setHeader(CONTENT_TYPE, "application/json");
    	return ok();
    }
    
    
    public static Result predictSentiment(String d1, String d2, String d3, String d4) throws ClientProtocolException, IOException{
		System.out.println("in predictSentiment...");
		StringBuffer response = new StringBuffer("{\"response\":\"");
		int count = 0;
		double data1 = 0.0;
		double data2 = 0.0;
		double data3 = 0.0;
		double data4 = 0.0;
		if(null!=d1 && !d1.isEmpty() && !d1.equalsIgnoreCase("-1") && !d1.equalsIgnoreCase("0")){
			data1 = Double.parseDouble(d1);
			count++;
		}
		if(null!=d2 && !d2.isEmpty() && !d2.equalsIgnoreCase("-1") && !d2.equalsIgnoreCase("0")){
			data2 = Double.parseDouble(d2);
			count++;
		}
		if(null!=d3 && !d3.isEmpty() && !d3.equalsIgnoreCase("-1") && !d3.equalsIgnoreCase("0")){
			data3 = Double.parseDouble(d3);
			count++;
		}
		if(null!=d4 && !d4.isEmpty() && !d4.equalsIgnoreCase("-1") && !d4.equalsIgnoreCase("0")){
			data4 = Double.parseDouble(d4);
			count++;
		}
		double data = (data1+data2+data3+data4)/count;
		String value = "/assets/images/avg.gif";
		if(data<50){
			value = "/assets/images/flop.gif";
		}else if(data>=50&& data<70){
			value = "/assets/images/avg.gif";
		}else if(data>=70){
			value = "/assets/images/hit.gif";
		}
		response.append(value);
		response.append("\"}");
		response().setContentType("application/json");
		return ok(response.toString());    	
    }
    
    
    public static Result average(String d1, String d2, String d3, String d4) throws ClientProtocolException, IOException{
    	System.out.println(d1+":"+d2+":"+d3+":"+d4);
		System.out.println("in average...");
		StringBuffer response = new StringBuffer("{\"response\":");
		int count = 0;
		double data1 = 0.0;
		double data2 = 0.0;
		double data3 = 0.0;
		double data4 = 0.0;
		if(null!=d1 && !d1.isEmpty() && !d1.equalsIgnoreCase("-1") && !d1.equalsIgnoreCase("0")){
			data1 = Double.parseDouble(d1);
			count++;
		}
		if(null!=d2 && !d2.isEmpty() && !d2.equalsIgnoreCase("-1") && !d2.equalsIgnoreCase("0")){
			data2 = Double.parseDouble(d2);
			count++;
		}
		if(null!=d3 && !d3.isEmpty() && !d3.equalsIgnoreCase("-1") && !d3.equalsIgnoreCase("0")){
			data3 = Double.parseDouble(d3);
			count++;
		}
		if(null!=d4 && !d4.isEmpty() && !d4.equalsIgnoreCase("-1") && !d4.equalsIgnoreCase("0")){
			data4 = Double.parseDouble(d4);
			count++;
		}
		double data = (data1+data2+data3+data4)/count;
		String value = String.valueOf(data);
		response.append(value);
		response.append("}");
		response().setContentType("application/json");
		return ok(response.toString());    	
    }
    
    public static Result listUpCmngMvs() throws ClientProtocolException, IOException{
		System.out.println("in listUpCmngMvs...");
		HttpGet request;
		HttpClient client = new DefaultHttpClient();
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromTW;
		request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?page_limit=50&country=us&apikey=z8rxdetexfhgdb3tubhwy4cd");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromTW = EntityUtils.toString(entity);
		response().setContentType("application/json");
		return ok(dataFromTW);    	
    }
    
    public static Result geAttentions(String rate, String rank) throws ClientProtocolException, IOException{
		System.out.println("in geAttensions...");
		StringBuffer response = new StringBuffer("{\"response\":\"");
		String value = "/assets/images/neutral.png";
		if(null!=rank && !rank.isEmpty() && !rank.contains("NA")){
			double rated = Double.parseDouble(rate);
			double rankd = Double.parseDouble(rank);
			if((rated < 30 && rankd > 7) || (rated > 70 && rankd < 4) || (rated <= 70 && rated >= 30 && rankd >= 4 && rankd<=7)){
				value = "/assets/images/neutral.png";
			}else if((rated > 30 && rankd > 7) || (rated > 70 && rankd >= 4)){
				value = "/assets/images/up.jpg";
			}else if((rated < 30 && rankd < 7) || (rated < 70 && rankd <= 4)){
				value = "/assets/images/down.jpg";
			}
		}else{
			double rated = Double.parseDouble(rate);
			if(rated<=35){
				value = "/assets/images/down.jpg";
			}else if(rated>35 && rated<70){
				value = "/assets/images/neutral.png";
			}else if(rated>=70){
				value = "/assets/images/up.jpg";
			}
		}
		response.append(value);
		response.append("\"}");
		response().setContentType("application/json");
		return ok(response.toString()); 	
    }
    
    public static Result upcmngMovieSentiment(String q, String r, String c) {
    	StringBuffer response = new StringBuffer("{");
    	ObjectMapper mapper = new ObjectMapper();
    	StringBuffer quote = new StringBuffer();
    	StringBuffer relatedMovBuf = new StringBuffer("\"relatedMovies\":[");
    	StringBuffer relatedPosterBuf = new StringBuffer("\"relatedPosters\":[");
    	StringBuffer quoteTwt = new StringBuffer("\"tweets\":[");
    	SentimentAnalysisDetails details = null;
    	HttpClient client = new DefaultHttpClient();
    	String id = r;
    	try {
    		System.out.println("start");
    		
    		response.append(SentimentDetails.sentiments.get(id));
			//id = getDeatilsFromRT(q, "NA", response, mapper, client);
    		
    		getTypeOfMovie(id, response, mapper, client);
        	
			getReviewFromRT(response, mapper, quote, client, id);
        	
			getRelaetedMovieFromRT(response, mapper, relatedMovBuf, client, id);
			
        	getPosterFromRT(response, mapper, relatedPosterBuf, client, id);
        	
			getTweetsFromTW(q, response, mapper, quoteTwt, client);
			
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	response.append("}");
    	details = new Gson().fromJson(response.toString(), SentimentAnalysisDetails.class);
    	details.movieType = "upcmg";
    	details.rating.generateIcon();
    	details.sentiment.generateIcon();
    	details.generateRecomendation();
    	createRandomDP(details);
    	return ok(views.html.Sentiment.movie.render(details));
    	//response().setContentType("application/json"); return ok(response.toString());
    }
    
    private static void getTypeOfMovie(String id, StringBuffer response,
			ObjectMapper mapper, HttpClient client) throws ClientProtocolException, IOException {
		System.out.println("in getTypeOfMovie...");
		HttpGet request;
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromRT;
		JsonNode actualObj;
		request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/movies/"+id+".json?apikey=z8rxdetexfhgdb3tubhwy4cd");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromRT = EntityUtils.toString(entity);
		actualObj = mapper.readTree(dataFromRT);
		Iterator<JsonNode> list = actualObj.path("genres").elements();
		response.append("\"category\":\"");
		while (list.hasNext()){
			response.append(list.next().asText()).append(",");
		}
		response.delete(response.length()-1, response.length());
		response.append("\",");
		
	}

	public static Result movieSentiment(String q, String r, String c) {
    	StringBuffer response = new StringBuffer("{");
    	ObjectMapper mapper = new ObjectMapper();
    	StringBuffer quote = new StringBuffer();
    	StringBuffer relatedMovBuf = new StringBuffer("\"relatedMovies\":[");
    	StringBuffer relatedPosterBuf = new StringBuffer("\"relatedPosters\":[");
    	StringBuffer quoteTwt = new StringBuffer("\"tweets\":[");
    	SentimentAnalysisDetails details = null;
    	HttpClient client = new DefaultHttpClient();
    	String id = "";
    	try {
    		System.out.println("start");
    		
			id = getDeatilsFromRT(q, r, response, mapper, client);
			getTypeOfMovie(id, response, mapper, client);
			getReviewFromRT(response, mapper, quote, client, id);
        	
			getRelaetedMovieFromRT(response, mapper, relatedMovBuf, client, id);
			
        	getPosterFromRT(response, mapper, relatedPosterBuf, client, id);
        	
			getTweetsFromTW(q, response, mapper, quoteTwt, client);
			
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	response.append("}");
    	details = new Gson().fromJson(response.toString(), SentimentAnalysisDetails.class);
    	details.movieType = "movie";
    	details.rating.generateIcon();
    	details.nielsenCategory = c;
    	details.sentiment.generateIcon();
    	details.generateRecomendation();
    	createRandomDP(details);
    	return ok(views.html.Sentiment.movie.render(details));
    	//response().setContentType("application/json"); return ok(response.toString());
    }

	private static void createRandomDP(SentimentAnalysisDetails details) {
		List<Review> rvws = details.reviews;
		Random random = new Random();
		for(Review review:rvws){
			review.url = "/SocialSentiment/assets/stylesheets/images/male/avatar"+String.valueOf(Math.abs(random.nextInt()%2))+".png"; 
		}
	}

	public static Result getAnalyticsGraphFromTopsy(String q)
	throws UnsupportedEncodingException, IOException,
	ClientProtocolException, JsonProcessingException {
		System.out.println("in getAnalyticsGraphFromTopsy...");
		HttpGet request;
		HttpClient client = new DefaultHttpClient();
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromTW;
		request = new HttpGet("http://otter.topsy.com/searchhistogram.js?q="+java.net.URLEncoder.encode(q, "UTF-8")+"%20Movie&slice=86400&period=30&count_method=citation&call_timestamp=1395039141072&apikey=09C43A9B270A470B8EB8F2946A9369F3");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromTW = EntityUtils.toString(entity);
		response().setContentType("application/json");
		return ok(dataFromTW);
	}
	
	public static Result getAnalysisGraphFromTW(String q)
			throws UnsupportedEncodingException, IOException,
			ClientProtocolException, JsonProcessingException {
		System.out.println("in getAnalysisGraphFromTW...");
		HttpGet request;
		ObjectMapper mapper = new ObjectMapper();
		HttpClient client = new DefaultHttpClient();
		StringBuffer tmpData = new StringBuffer();
		HttpResponse responseH;
		HttpEntity entity;
		JsonNode actualObj;
		String dataFromTW;
		request = new HttpGet("http://api.topsy.com/v2/metrics/sentiment.json?q="+java.net.URLEncoder.encode(q,"UTF-8")+"%20Movie&mintime="+"1369845301"+"&maxtime="+"1370031701"+"&slice=3600&include_mentions=1&apikey=09C43A9B270A470B8EB8F2946A9369F3");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromTW = EntityUtils.toString(entity);
		actualObj = mapper.readTree(dataFromTW);
		
		tmpData.append("{\"peak\":").append(actualObj.path("response").path("results").get(1).path("stats").path("peak")).append(",");
		tmpData.append("\"sentiment_score\":\"").append(actualObj.path("response").path("results").get(1).path("stats").path("average").path("sentiment_score").asText()).append("\",");
		tmpData.append("\"datas\":").append(actualObj.path("response").path("results").get(1).path("data"));
		tmpData.append("}");
		response().setContentType("application/json");
		return ok(tmpData.toString());
	}

	private static void getTweetsFromTW(String q, StringBuffer response,
			ObjectMapper mapper, StringBuffer quoteTwt, HttpClient client)
			throws UnsupportedEncodingException, IOException,
			ClientProtocolException, JsonProcessingException {
		System.out.println("in getTweetsFromTW...");
		StringBuffer quote;
		HttpGet request;
		HttpResponse responseH;
		HttpEntity entity;
		JsonNode actualObj;
		Iterator<JsonNode> listObjs;
		request = new HttpGet("http://api.topsy.com/v2/content/tweets.json?q="+java.net.URLEncoder.encode(q,"UTF-8")+"%20Movie&limit=10&type=tweet&language=en&apikey=09C43A9B270A470B8EB8F2946A9369F3");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		String dataFromTW = EntityUtils.toString(entity);
		actualObj = mapper.readTree(dataFromTW);
		listObjs = actualObj.path("response").path("results").path("list").elements();
		quote = new StringBuffer();
		while(listObjs.hasNext()){
			actualObj = listObjs.next();
			quoteTwt.append("{\"name\":\"").append(actualObj.path("author").path("name").asText()).append("\",\"tweet\":\"").append(validateSpectialCase(actualObj.path("tweet").path("text").asText())).append("\",");
			quoteTwt.append("\"url\":\"").append(validateSpectialCase(actualObj.path("tweet").path("user").path("profile_image_url_https").asText()));
			quoteTwt.append("\"},");
			quote.append(actualObj.path("tweet").path("text").asText());
		}
		quoteTwt.delete(quoteTwt.length()-1, quoteTwt.length());
		quoteTwt.append("]");
		response.append(",").append(quoteTwt.toString());
	}

	private static void getPosterFromRT(StringBuffer response,
			ObjectMapper mapper, StringBuffer relatedPosterBuf,
			HttpClient client, String id) throws IOException,
			ClientProtocolException, JsonProcessingException {
		System.out.println("in getPosterFromRT...");
		HttpGet request;
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromRT;
		JsonNode actualObj;
		Iterator<JsonNode> listObjs;
		boolean isRmv;
		request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/movies/"+id+"/clips.json?limit=4&apikey=z8rxdetexfhgdb3tubhwy4cd");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromRT = EntityUtils.toString(entity);
		actualObj = mapper.readTree(dataFromRT);
		    		
		listObjs = actualObj.path("clips").elements();
		int count =0;
		isRmv = false;
		while(listObjs.hasNext()){
			actualObj = listObjs.next();
			relatedPosterBuf.append("{\"name\":\"").append(actualObj.path("title").asText()).append("\",");
			relatedPosterBuf.append("\"poster\":\"").append(actualObj.path("thumbnail").asText()).append("\"},");
			count++;
			if(count==4){
				break;
			}
			isRmv = true;
		}
		if(isRmv){
			relatedPosterBuf.delete(relatedPosterBuf.length()-1, relatedPosterBuf.length());
		}
		relatedPosterBuf.append("]");
		response.append(",").append(relatedPosterBuf.toString());
	}

	private static void getRelaetedMovieFromRT(StringBuffer response,
			ObjectMapper mapper, StringBuffer relatedMovBuf, HttpClient client,
			String id) throws IOException, ClientProtocolException,
			JsonProcessingException {
		System.out.println("in getRelaetedMovieFromRT...");
		HttpGet request;
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromRT;
		JsonNode actualObj;
		Iterator<JsonNode> listObjs;
		request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/movies/"+id+"/similar.json?limit=4&apikey=z8rxdetexfhgdb3tubhwy4cd");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromRT = EntityUtils.toString(entity);
		actualObj = mapper.readTree(dataFromRT);
		    		
		listObjs = actualObj.path("movies").elements();
		boolean isRmv = false;
		while(listObjs.hasNext()){
			actualObj = listObjs.next();
			relatedMovBuf.append("{\"name\":\"").append(actualObj.path("title").asText()).append("\",");
			relatedMovBuf.append("\"id\":\"").append(actualObj.path("id").asText()).append("\",");
			relatedMovBuf.append("\"critics_consensus\":\"").append(actualObj.path("critics_consensus").asText()).append("\",");
			relatedMovBuf.append("\"poster\":\"").append(actualObj.path("posters").path("profile").asText()).append("\"},");
			isRmv = true;
		}
		if(isRmv){
			relatedMovBuf.delete(relatedMovBuf.length()-1, relatedMovBuf.length());
		}
		relatedMovBuf.append("]");
		response.append(",").append(relatedMovBuf.toString());
	}

	private static void getReviewFromRT(StringBuffer response,
			ObjectMapper mapper, StringBuffer quote, HttpClient client,
			String id) throws Exception {
		System.out.println("in getReviewFromRT...");
		HttpGet request;
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromRT;
		JsonNode actualObj;
		request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/movies/"+id+"/reviews.json?review_type=top_critic&page_limit=50&country=us&apikey=z8rxdetexfhgdb3tubhwy4cd");
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromRT = EntityUtils.toString(entity);
		actualObj = mapper.readTree(dataFromRT);
		response.append("\"reviews\":").append(actualObj.path("reviews"));
		
		Iterator<JsonNode> listObjs = actualObj.path("reviews").elements();
		while(listObjs.hasNext()){
			actualObj = listObjs.next();
			quote.append(actualObj.path("quote").asText());
		}
		
		getSentiment(quote.toString(),client, mapper, response);
	}

	private static void getSentiment(String q, HttpClient client, ObjectMapper mapper, StringBuffer response)throws Exception {
		System.out.println("in getSentiment..");
		HttpPost request;
		HttpResponse responseH;
		String dataFromRT;
		HttpEntity entity;
		request = new HttpPost("http://access.alchemyapi.com/calls/text/TextGetTextSentiment?apikey=230b68d452ce9453b46995a63db6e1b934bc5c11&text="+java.net.URLEncoder.encode(q,"UTF-8")+"&outputMode=json");
		
		responseH = client.execute(request);
		entity = responseH.getEntity();
		dataFromRT = EntityUtils.toString(entity);
		JsonNode actualObj = mapper.readTree(dataFromRT);
		if(actualObj.hasNonNull("docSentiment")){
			response.append(",\"sentiment\":").append(actualObj.path("docSentiment"));
		}else{
			response.append(",\"sentiment\":").append("{}");
		}
	}

	private static String getDeatilsFromRT(String q, String r,
			StringBuffer response, ObjectMapper mapper, HttpClient client)
			throws UnsupportedEncodingException, IOException,
			ClientProtocolException, JsonProcessingException {
		System.out.println("in getDeatilsFromRT...");
		String id = "";
		HttpGet request;
		HttpResponse responseH;
		request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/movies.json?q="+java.net.URLEncoder.encode(q,"UTF-8")+"&page_limit=10&page=1&apikey=z8rxdetexfhgdb3tubhwy4cd");
		responseH = client.execute(request);
		HttpEntity entity = responseH.getEntity();
		String dataFromRT = EntityUtils.toString(entity);
		JsonNode actualObj = mapper.readTree(dataFromRT);
		JsonNode firstElemnt = actualObj.path("movies").elements().next();
		id = firstElemnt.path("id").asText();
		
		response.append("\"rank\":").append(r).append(",");
		response.append("\"id\":\"").append(firstElemnt.path("id").asText()).append("\",");
		response.append("\"mpaaRating\":\"").append(firstElemnt.path("mpaa_rating").asText()).append("\",");
		response.append("\"movieName\":\"").append(firstElemnt.path("title").asText()).append("\",");
		response.append("\"synopsis\":\"").append(validateSpectialCase(firstElemnt.path("synopsis").asText())).append("\",");
		response.append("\"poster\":\"").append(firstElemnt.path("posters").path("original").asText()).append("\",");
		response.append("\"rating\":").append(firstElemnt.path("ratings")).append(",");
		return id;
	}

	private static String validateSpectialCase(String asText) {
		return asText.replaceAll("'", "").replaceAll("\"", "\\\\\"").replace("\n", "");
	}
}
