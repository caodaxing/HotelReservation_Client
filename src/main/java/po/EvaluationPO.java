package po;

public class EvaluationPO {
	
	String numberOfOrder;
	String hotelId;
	String evaluation;
	double numberOfStars;
	
	/**
	 * 评价的PO类
	 * @param numberOfOrder 订单号
	 * @param hotelId 酒店id
	 * @param evaluation 评价信息
	 * @param numberOfStars 酒店星级
	 * @author Rukawa
	 */
	public EvaluationPO(String numberOfOrder,String hotelId,String evaluation,double numberOfStars) {
		super();
		this.numberOfOrder=numberOfOrder;
		this.hotelId=hotelId;
		this.evaluation=evaluation;
		this.numberOfStars=numberOfStars;
	}
}
