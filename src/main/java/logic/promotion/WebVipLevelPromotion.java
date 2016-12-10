package logic.promotion;

import java.util.ArrayList;

import logic.user.Client;
import logic.user.ClientVipInfo;
import logic.utility.DataFormat;
import vo.OrderVO;
import vo.PromotionVO;
import vo.VipVO;

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
	private ClientVipInfo clientVip;
	
	/**
	 * @param promotionID
	 * @param promotionName
	 * @param vipLevelDiscount
	 */
	public WebVipLevelPromotion(String promotionID, String promotionName, double[] vipLevelDiscount) {
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.vipLevelDiscount = vipLevelDiscount;
		this.clientVip = new Client();
	}

	@Override
	public boolean judgePromotion(OrderVO vo) {
		if(this.clientVip.isVIP(vo.userID)) {
			return true;
		}
		
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		
		VipVO v = this.clientVip.getVipInfo(vo.userID);
		int level = v.level;
		
		double discount = 0;
		if(level < this.vipLevelDiscount.length) {
			discount = this.vipLevelDiscount[level];
		} else {
			discount = this.vipLevelDiscount[this.vipLevelDiscount.length-1];
		}
		
		vo.afterPrice = DataFormat.getInstance().formatDouble(vo.beforePrice * discount);
		
		if(vo.promotions == null) {
			vo.promotions = new ArrayList<PromotionVO>();
		}
		vo.promotions.add(this.changeToVO());
		
		return vo;
	}
	
	@Override
	public PromotionVO changeToVO() {
		return new PromotionVO(this.promotionID, this.promotionName, this.vipLevelDiscount);
	}
	
	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

}
