package models.recommendation;

import java.util.ArrayList;
import java.util.List;


public class Viewer {
	public String type;
	public String ageRange;
	public String code;
	public List<TVDetail> tvDetails = new ArrayList<TVDetail>();
	
	public String getType(){
		return type;
	}
}
