package vo.promotion;

import Message.PromotionType;

/**
 * @param promotionID
 * @param promotionType
 * @param promotionName
 * @param discount
 * @param cooperateBusiness
 * @param startTime
 * @param endTime
 */
public class WebPromotionVO extends PromotionVO {

	public String cooperateBusiness;
	public String startTime;
	public String endTime;
	
	public WebPromotionVO(String promotionID, PromotionType promotionType,
			String promotionName, double discount,
			String cooperateBusiness, String startTime, String endTime) {
		super(promotionID, promotionType, promotionName, discount);
		this.cooperateBusiness = cooperateBusiness;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
}
