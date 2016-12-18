package vo;

/**
 * @param orderID 订单id
 * @param commentLevel 评分 （保留一位小数）
 * @param evaluationContent 评价内容
 */
public class EvaluationVO {
	
	public String orderID;
	public double commentLevel;
	public String evaluationContent = "";
	
	public EvaluationVO(String orderID, double commentLevel, String evaluationContent) {
		this.orderID = orderID;
		this.commentLevel = commentLevel;
		
		if(evaluationContent == null) {
			this.evaluationContent = "";
		} else {
			this.evaluationContent = evaluationContent;
		}
	}
	
	
	
}
