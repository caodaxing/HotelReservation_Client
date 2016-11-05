package po;

public class EvaluationPO {
	String numberOfOrder;
	String hotelId;
	String evaluation;
	double numberOfStars;
	
	public EvaluationPO(String numberOfOrder,String hotelId,String evaluation,double numberOfStars) {
		super();
		this.numberOfOrder=numberOfOrder;
		this.hotelId=hotelId;
		this.evaluation=evaluation;
		this.numberOfStars=numberOfStars;
	}
}
