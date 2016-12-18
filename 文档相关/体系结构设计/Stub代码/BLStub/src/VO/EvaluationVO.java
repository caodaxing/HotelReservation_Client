package VO;

public class EvaluationVO {
	
	String evaContent;
	String hotelID;
	String orderID;
	int star;
	
	public EvaluationVO(String evaContent, String hotelID, String orderID, int star) {
		super();
		this.evaContent = evaContent;
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.star = star;
	}
}
