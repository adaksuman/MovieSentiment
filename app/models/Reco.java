package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import models.recommendation.MovieDetails;
import models.recommendation.Recommendations;
import models.recommendation.TVDetail;
import models.recommendation.Viewer;

public class Reco {
	public List<MovieDetails> movies = new ArrayList<MovieDetails>();
	public Set<String> bufferSites = new HashSet<String>();
	public Set<String> bufferChnls = new HashSet<String>();
	public Map<String, Set<String>> map = new HashMap<String, Set<String>>();
	public Set<String> bufferViewers = new HashSet<String>();
	public StringBuffer bufferAge = new StringBuffer();

	public void shortMovieTypes(String category) {
		StringTokenizer stringTokenizer = new StringTokenizer(category, ",");
		String token;
		while(stringTokenizer.hasMoreElements()){
			token = (String) stringTokenizer.nextElement();
			for(MovieDetails movie:Recommendations.reco.recommendations){
				if(movie.movieType.equalsIgnoreCase(token)){
					movies.add(movie);
				}
			}
		}
	}
	
	public void createReco() {
		for(MovieDetails movieDetails:movies){
			bufferSites.addAll(movieDetails.advertisePortal);
			for(Viewer viewer:movieDetails.viewers){
				if(!bufferViewers.contains(viewer.type)){
					bufferViewers.add(viewer.type);
					bufferAge.append(viewer.type+":("+viewer.ageRange+")").append(",");
				}
				for(TVDetail tvDetail:viewer.tvDetails){
					bufferChnls.add(tvDetail.originator);
					putProgram(tvDetail.originator,tvDetail.programName);
				}
			}
		}
		bufferAge.delete(bufferAge.length()-1, bufferAge.length());
	}

	private void putProgram(String originator, String programName) {
		if(map.containsKey(originator)){
			map.get(originator).add(programName);
		}else{
			Set<String> dataList = new HashSet<String>();
			dataList.add(programName);
			map.put(originator, dataList);
		}
	}
}
