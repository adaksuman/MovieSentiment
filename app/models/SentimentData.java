package models;

public class SentimentData {
	public String type;
	public String score;
	public String mixed;
	public String icon;
	
	public void generateIcon(){
		if(null!=score){
			score = String.valueOf(Math.round(((Double.parseDouble(score)+1)*50)));
		}else{
			score = "0";
		}
		if(null!=type){
			if (type.equalsIgnoreCase("positive")){
				this.icon = "icon-f-smiley";
			}else if (type.equalsIgnoreCase("neutral")){
				this.icon = "icon-f-smiley-neutral";
			}else if (type.equalsIgnoreCase("negative")){
				this.icon = "icon-f-smiley-sad";
			}
		}
	}
	
	public String getType() {
		return type;
	}
}
