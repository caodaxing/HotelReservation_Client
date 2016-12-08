package logic.promotion;

import java.util.HashMap;

import vo.OrderVO;
import vo.PromotionVO;

/**
 * 网站vip特定商圈优惠
 * @param promotionID
 * @param promotionName
 * @param vipTradeAreaDiscount
 */
public class WebVipTradingAreaPromotion implements Promotion {

	private String promotionID;
	private String promotionName;
	private HashMap<String, Double[]> vipTradeAreaDiscount;
	
	/**
	 * @param promotionID
	 * @param promotionName
	 * @param vipTradeAreaDiscount
	 */
	public WebVipTradingAreaPromotion(String promotionID, String promotionName,
			HashMap<String, Double[]> vipTradeAreaDiscount) {
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
	}

	@Override
	public boolean judgePromotion(OrderVO orderVO) {
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		return null;
	}
	
	@Override
	public PromotionVO changeToVO() {
		return null;
	}
	
	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}
}
