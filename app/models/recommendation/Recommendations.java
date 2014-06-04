package models.recommendation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings({"deprecation"})
public class Recommendations {
	public static Recommendations reco = null;
	public List<MovieDetails> recommendations = new ArrayList<MovieDetails>();
	public List<String> ageCodes = new ArrayList<String>();
	public List<String> advertiseSites = new ArrayList<String>();
	public String nationalTVURL;
	public String siteURL;
	
	public String getNationalTVURL(String q) throws Exception {
		return nationalTVURL.replace("<q>", java.net.URLEncoder.encode(q, "UTF-8"));
	}
	
	public String getSiteURL(String q) throws Exception {
		return siteURL.replace("<q>", java.net.URLEncoder.encode(q, "UTF-8"));
	}
	
	public void listTVData(String apikey) throws Exception {
		System.out.println("In listTVData...");
		HttpClient client = new DefaultHttpClient();
		ObjectMapper mapper = new ObjectMapper();
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromTB;
		HttpGet request = null;
		JsonNode actualObj = null;
		Iterator<JsonNode> listObjs = null;
		TVDetail tvDetails = null;
		for(String ageCode:Recommendations.reco.ageCodes){
			String url = getNationalTVURL(ageCode);
			System.out.println("Invoking url:"+url);
			request = new HttpGet(url);
			request.setHeader("Accept", "application/json");
			request.setHeader("Apikey", apikey);
			responseH = client.execute(request);
			entity = responseH.getEntity();
			dataFromTB = EntityUtils.toString(entity);
			actualObj = mapper.readTree(dataFromTB);
			listObjs = actualObj.path("NationalTVRanking").path("Programs").elements();
			while(listObjs.hasNext()){
				tvDetails = new TVDetail();
				actualObj = listObjs.next();
				tvDetails.originator = actualObj.path("Originator").asText();
				tvDetails.programName = actualObj.path("ProgramName").asText();
				tvDetails.totalDuration = actualObj.path("TotalDuration").asText();
				for(MovieDetails movieDetails:Recommendations.reco.recommendations){
					for(Viewer viewer:movieDetails.viewers){
						if(viewer.code.equalsIgnoreCase(ageCode)){
							viewer.tvDetails.add(tvDetails);
						}
					}
				}
			}
		}
	}

	public void listSiteData(String apikey) throws Exception {
		System.out.println("In listSiteData...");
		HttpClient client = new DefaultHttpClient();
		ObjectMapper mapper = new ObjectMapper();
		HttpResponse responseH;
		HttpEntity entity;
		String dataFromTB;
		HttpGet request = null;
		JsonNode actualObj = null;
		Iterator<JsonNode> listObjs = null;
		List<String> advertisePortal;
		for(String advertiseSite:Recommendations.reco.advertiseSites){
			String url = getSiteURL(advertiseSite);
			System.out.println("Invoking url:"+url);
			request = new HttpGet(url);
			request.setHeader("Accept", "application/json");
			request.setHeader("Apikey", apikey);
			responseH = client.execute(request);
			entity = responseH.getEntity();
			dataFromTB = EntityUtils.toString(entity);
			actualObj = mapper.readTree(dataFromTB);
			listObjs = actualObj.path("NetUsage").get(0).path("WebsiteCategory").get(0).path("WebSiteInfo").elements();
			advertisePortal = new ArrayList<String>();
			while(listObjs.hasNext()){
				advertisePortal.add(listObjs.next().path("WebsiteBrand").asText());
			}
			for(MovieDetails movieDetails:Recommendations.reco.recommendations){
				if(movieDetails.advertiseSite.equalsIgnoreCase(advertiseSite)){
					movieDetails.advertisePortal = advertisePortal;
				}
			}
		}
	}
}
