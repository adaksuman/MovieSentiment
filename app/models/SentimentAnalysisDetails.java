package models;

import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysisDetails {
	public String movieType;
	public String rank;
	public String nielsenCategory;
	public String mpaaRating;
	public String category;
	public String id;
	public String movieName;
	public String synopsis;
	public String poster;
	public Rating rating;
	public String topsyScore;
	public SentimentData sentiment;
	public List<Poster> relatedPosters = new ArrayList<Poster>();
	public List<RelatedMovie> relatedMovies = new ArrayList<RelatedMovie>();
	public List<Review> reviews = new ArrayList<Review>();
	public List<Tweet> tweets = new ArrayList<Tweet>();
	public Reco reco;
	
	public void generateRecomendation(){
		reco = new Reco();
		reco.shortMovieTypes(this.category);
		reco.createReco();
	}
}
