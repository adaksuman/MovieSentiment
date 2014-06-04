import java.io.File;
import java.util.Iterator;

import models.SentimentDetails;
import models.recommendation.Recommendations;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import play.Application;
import play.GlobalSettings;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.SimpleResult;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import play.*;
import play.mvc.*;

import views.html.*;

@SuppressWarnings({"deprecation"})
public class Global extends GlobalSettings {
	
	 public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
	        return Promise.<SimpleResult>pure(Controller.internalServerError(notFoundPage.render(request.uri())));
	    }
	 
	 public Promise<SimpleResult> onHandlerNotFound(RequestHeader request) {
	        return Promise.<SimpleResult>pure(Controller.notFound(notFoundPage.render(request.uri())
	        ));
	    }
	 public Promise<SimpleResult> onBadRequest(RequestHeader request, String error) {
	        return Promise.<SimpleResult>pure(Controller.badRequest("Don't try to hack the URI!"));
	    }
	
	@Override
	public void onStart(Application app){
		System.out.println("Start application....");
		String id = "";
		StringBuffer response = null;
    	ObjectMapper mapper = new ObjectMapper();
    	String apiKey = "";
		try {
			HttpClient client = new DefaultHttpClient();
			HttpResponse responseH;
			HttpEntity entity;
			String dataFromRT;
			apiKey = app.configuration().getString("apikey");
			HttpGet request = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?page_limit=50&country=us&apikey=z8rxdetexfhgdb3tubhwy4cd");
			responseH = client.execute(request);
			entity = responseH.getEntity();
			dataFromRT = EntityUtils.toString(entity);
			JsonNode actualObj = mapper.readTree(dataFromRT);
			Iterator<JsonNode> listObjs = actualObj.path("movies").elements();
			while(listObjs.hasNext()){
				response = new StringBuffer();
				JsonNode firstElemnt = listObjs.next();	
				id = firstElemnt.path("id").asText();
				response.append("\"rank\":\"").append("NA").append("\",");
				response.append("\"id\":\"").append(firstElemnt.path("id").asText()).append("\",");
				response.append("\"mpaaRating\":\"").append(firstElemnt.path("mpaa_rating").asText()).append("\",");
				response.append("\"movieName\":\"").append(firstElemnt.path("title").asText()).append("\",");
				response.append("\"synopsis\":\"").append(validateSpectialCase(firstElemnt.path("synopsis").asText())).append("\",");
				response.append("\"poster\":\"").append(firstElemnt.path("posters").path("profile").asText()).append("\",");
				response.append("\"rating\":").append(firstElemnt.path("ratings")).append(",");
				SentimentDetails.sentiments.put(id, response.toString());
			}
			
			String recodata = FileUtils.readFileToString(new File("./conf/recommendation.json"));
			Recommendations.reco = new Gson().fromJson(recodata, Recommendations.class);
			Recommendations.reco.listTVData(apiKey);
			Recommendations.reco.listSiteData(apiKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Application started....");
	}

	private static String validateSpectialCase(String asText) {
		return asText.replaceAll("'", "").replaceAll("\"", "\\\\\"").replace("\n", "");
	}
	
	@Override
	public void onStop(Application app) {
		
	}
}
