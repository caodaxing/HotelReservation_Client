package vo;

import Message.RoomType;

/**
 * @param orderID 订单id
<<<<<<< HEAD
<<<<<<< HEAD
 * @param commentLevel 评分 （保留一位小数）
=======
=======
>>>>>>> origin/master
 * @param orderId 房间类型 
 * @param checkInTime 入住时间
 * @param commentLevel 评分
>>>>>>> origin/master
 * @param evaluationContent 评价内容
 */
public class EvaluationVO {
	
	public String orderID;
	public double commentLevel;
	public String evaluationContent;
	
	public EvaluationVO(String orderID, double commentLevel, String evaluationContent) {
		this.orderID = orderID;
		this.commentLevel = commentLevel;
		this.evaluationContent = evaluationContent;
	}
	
	
	
}
