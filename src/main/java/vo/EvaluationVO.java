package vo;

public class EvaluationVO {
	
	String evaContent;
	String hotelID;
	String orderID;
	int star;
	
	/**
	 * 评价的VO类
	 * @param evaContent 评价内容
	 * @param hotelID 酒店Id
	 * @param orderID 订单Id
	 * @param star 用户星级
	 * @author Rukawa
	 */
	public EvaluationVO(String evaContent, String hotelID, String orderID, int star) {
		super();
		this.evaContent = evaContent;
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.star = star;
	}
}
