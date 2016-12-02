package vo.promotion;

import java.util.ArrayList;

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
public class VipAndTradeAreaPromotionVO extends PromotionVO {

	public ArrayList<VipTradingAreaVO> vipTradeAreaDiscount;
	
	public VipAndTradeAreaPromotionVO(String promotionID,  
			ArrayList<VipTradingAreaVO> vipTradeAreaDiscount, String promotionName,
			double discount) {
		super(promotionID, PromotionType.WEB_VIP_TRADINGAREA, promotionName, discount);
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
	}
	
}
