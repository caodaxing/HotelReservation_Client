package logic.promotion;

import java.util.HashMap;

import logic.hotel.CheckHotel;
import logic.hotel.HotelTradingAreaInfo;
import logic.user.Client;
import logic.user.ClientVipInfo;
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
	private ClientVipInfo clientVip;
	private HotelTradingAreaInfo getHotelTradingAreaInfo;
	
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
		this.clientVip = new Client();
		this.getHotelTradingAreaInfo = new CheckHotel();
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
		
		if(l >= dis.length) {
			discount = dis[dis.length-1];
		} else {
			discount = dis[l];
		}
		
		if(discount != 0) {
			double temp = vo.beforePrice * discount;
			
			if(temp < vo.afterPrice) {
				vo.afterPrice = DataFormat.getInstance().formatDouble(temp);
				vo.promotion = this.changeToVO();
			}
		}
		
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
