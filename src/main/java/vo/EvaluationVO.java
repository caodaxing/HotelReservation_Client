package vo;

/**
 * 评价的VO类
 * @param star 用户星级
 * @param evaContent 评价内容
 * @param hotelID 酒店Id
 * @param orderID 订单Id
 * @author Rukawa
 */
public class EvaluationVO {
	
	public int star;
	public String evaContent;
	public String hotelID;
	public String orderID;
	
	public EvaluationVO(int star, String evaContent, String hotelID, String orderID) {
		this.evaContent = evaContent;
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.star = star;
	}
}
