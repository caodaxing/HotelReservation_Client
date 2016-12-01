package vo;

import Message.RoomType;

/**
 * @param hotelID 酒店id
 * @param orderID 订单id
 * @param roomType 房间类型 
 * @param checkInTime 入住时间
 * @param commentLevel 评分
 * @param evaluationContent 评价内容
 */
public class EvaluationVO {
	
	public String hotelID;
	public String orderID;
	public RoomType roomType;
	public String checkInTime;
	public int commentLevel;
	public String evaluationContent;
	
	public EvaluationVO(String hotelID, String orderID, RoomType roomType, String checkInTime, int commentLevel,
			String evaluationContent) {
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.roomType = roomType;
		this.checkInTime = checkInTime;
		this.commentLevel = commentLevel;
		this.evaluationContent = evaluationContent;
	}
	
	
	
}
