package vo;

public class EvaluationVO {
	
	String evaContent;//∆¿º€ƒ⁄»›
	String hotelID;
	String orderID;
	int star;//æ∆µÍ–«º∂
	
	public EvaluationVO(String evaContent, String hotelID, String orderID, int star) {
		super();
		this.evaContent = evaContent;
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.star = star;
	}
}
