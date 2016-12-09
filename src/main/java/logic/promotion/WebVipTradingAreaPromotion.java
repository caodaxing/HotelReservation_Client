package logic.promotion;

import java.util.ArrayList;
import java.util.HashMap;

import logic.hotel.GetHotelTradingAreaInfo;
import logic.mockObject.MockGetClientVipInfo;
import logic.mockObject.MockGetHotelTradingArea;
import logic.user.GetClientVipInfo;
import logic.utility.DataFormat;
import vo.OrderVO;
import vo.PromotionVO;
import vo.VipVO;

/**
 * 网站vip特定商圈优惠
 * @param promotionID
 * @param promotionName
 * @param vipTradeAreaDiscount
 */
public class WebVipTradingAreaPromotion implements Promotion {

	private String promotionID;
	private String promotionName;
	private HashMap<String, double[]> vipTradeAreaDiscount;
	private GetClientVipInfo clientVip;
	private GetHotelTradingAreaInfo getHotelTradingAreaInfo;
	
	/**
	 * @param promotionID
	 * @param promotionName
	 * @param vipTradeAreaDiscount
	 */
	public WebVipTradingAreaPromotion(String promotionID, String promotionName,
			HashMap<String, double[]> vipTradeAreaDiscount) {
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
		this.clientVip = new MockGetClientVipInfo();
		this.getHotelTradingAreaInfo = new MockGetHotelTradingArea();
	}

	@Override
	public boolean judgePromotion(OrderVO vo) {
		if(this.clientVip.isVIP(vo.userID)) {
			String area = this.getHotelTradingAreaInfo.getHotelTradingArea(vo.hotelID);
			
			if(this.vipTradeAreaDiscount.containsKey(area)) {
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		
		double discount = 0;
		VipVO v = this.clientVip.getVipInfo(vo.userID);
		int l = v.level;

		String area = this.getHotelTradingAreaInfo.getHotelTradingArea(vo.hotelID);
		
		double[] dis = this.vipTradeAreaDiscount.get(area);
		
		if(l > dis.length) {
			discount = dis[dis.length-1];
		} else {
			discount = dis[l];
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
		return new PromotionVO(this.promotionID, this.promotionName, this.vipTradeAreaDiscount);
	}
	
	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}
}
