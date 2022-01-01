package serverworker;

public class UserProbability 
{
	private String fullname = "";
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getProbability_score() {
		return probability_score;
	}
	public void setProbability_score(double probability_score) {
		this.probability_score = probability_score;
	}
	private String id = "";
	private double probability_score = 0;
}
