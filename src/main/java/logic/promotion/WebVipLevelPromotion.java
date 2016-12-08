package logic.promotion;

import vo.OrderVO;
import vo.PromotionVO;

/**
 * 网站vip等级优惠
 * @param promotionID
 * @param promotionName
 * @param vipLevelDiscount
 */
public class WebVipLevelPromotion  implements Promotion{
	
	private String promotionID;
	private String promotionName;
	private double[] vipLevelDiscount;
	
	/**
	 * @param promotionID
	 * @param promotionName
	 * @param vipLevelDiscount
	 */
	public WebVipLevelPromotion(String promotionID, String promotionName, double[] vipLevelDiscount) {
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.vipLevelDiscount = vipLevelDiscount;
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
