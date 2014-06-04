package models;

public class Rating {
	public String critics_rating;
	public String critics_score;
	public String critics_score_point;
	public String audience_rating;
	public String audience_score;
	public String criticIcon;
	public String audienceIcon;

	public void generateIcon(){
		if(null!=critics_score){
			if (Integer.parseInt(critics_score)>=85 && Integer.parseInt(critics_score)<=100){
				this.criticIcon = "icon-f-smiley-grin";
			}else if (Integer.parseInt(critics_score)>=70 && Integer.parseInt(critics_score)<85){
				this.criticIcon = "icon-f-smiley";
			}else if (Integer.parseInt(critics_score)>=55 && Integer.parseInt(critics_score)<70){
				this.criticIcon = "icon-f-smiley-neutral";
			}else if (Integer.parseInt(critics_score)>=40 && Integer.parseInt(critics_score)<55){
				this.criticIcon = "icon-f-smiley-sad";
			}else if (Integer.parseInt(critics_score)<40 && Integer.parseInt(critics_score)>=0){
				this.criticIcon = "icon-f-smiley-sad-blue";
			}
			if(Integer.parseInt(critics_score)<0){
				critics_score_point = "NA";
			}else{
				critics_score_point = critics_score;
			}
		}

		if(null!=audience_score){
			if (Integer.parseInt(audience_score)>=85 && Integer.parseInt(audience_score)<=100){
				this.audienceIcon = "icon-f-smiley-grin";
			}else if (Integer.parseInt(audience_score)>=70 && Integer.parseInt(audience_score)<85){
				this.audienceIcon = "icon-f-smiley";
			}else if (Integer.parseInt(audience_score)>=55 && Integer.parseInt(audience_score)<70){
				this.audienceIcon = "icon-f-smiley-nutral";
			}else if (Integer.parseInt(audience_score)>=40 && Integer.parseInt(audience_score)<55){
				this.audienceIcon = "icon-f-smiley-sad";
			}else if (Integer.parseInt(audience_score)<40 && Integer.parseInt(audience_score)>=0){
				this.audienceIcon = "icon-f-smiley-sad-blue";
			}
		}
	}
}
