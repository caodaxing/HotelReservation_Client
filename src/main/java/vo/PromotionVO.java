package vo;

import java.util.HashMap;

import Message.PromotionType;

/**
 * @param promotionType
 * @param promotionID
 * @param hotelID
 * @param promotionName
 * @param discount
 * @param startTime
 * @param endTime
 * @param birthDay
 * @param cooperateBusiness
 * @param roomsAndDiscount
 * @param vipTradeAreaDiscount  用HashMap<String, Double[]> 来存 商圈，double数组下标表示会员等级，值表示折扣，保留两位小数
 * @param vipLevelDiscount  
 */
public class PromotionVO {
	public PromotionType promotionType;
	public String promotionID;
	public String hotelID;
	public String promotionName;
	public double discount;
	public String startTime;
	public String endTime; 
	public String birthDay;
	public String cooperateBusiness;
	public double[] roomsAndDiscount;
	public HashMap<String, Double[]> vipTradeAreaDiscount;
	public double[] vipLevelDiscount;
	
	/**
	 * 酒店特定时间优惠 promotionType.HOTEL_11_1
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param discount
	 * @param startTime 
	 * @param endTime
	 */
	public PromotionVO(String promotionID, String hotelID,  String promotionName,
			double discount,String startTime, String endTime) {
		this.promotionType = PromotionType.HOTEL_11_11;
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
		
		this.birthDay = null;
		this.cooperateBusiness = null;
		this.roomsAndDiscount = null;
		this.vipTradeAreaDiscount = null;
		this.vipLevelDiscount = null;
	}
	
	
	/**
	 * 酒店的合作企业优惠  PromotionType.HOTEL_COOPREATE_BUSINESS
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param discount
	 * @param cooperateBusiness
	 */
	public PromotionVO(String promotionID, String hotelID, String promotionName,
			double discount, String cooperateBusiness) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionType = PromotionType.HOTEL_COOPREATE_BUSINESS;
		this.promotionName = promotionName;
		this.discount = discount;
		this.cooperateBusiness = cooperateBusiness;
		
		this.startTime = null;
		this.endTime = null;
		this.birthDay = null;
		this.roomsAndDiscount = null;
		this.vipTradeAreaDiscount = null;
		this.vipLevelDiscount = null;
	}
	
	/**
	 * 酒店客户生日折扣 PromotionType.HOTEL_BIRTHDAY
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param discount
	 */
	public PromotionVO(String promotionID, String hotelID, String promotionName, double discount) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.promotionType = PromotionType.HOTEL_BIRTHDAY;
		
		this.startTime = null;
		this.endTime = null;
		this.cooperateBusiness = null;
		this.roomsAndDiscount = null;
		this.vipTradeAreaDiscount = null;
		this.vipLevelDiscount = null;
	}
	
	/**
	 * 酒店3间及以上预定特惠
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param roomsAndDiscount
	 */
	public PromotionVO(String promotionID, String hotelID, String promotionName, double[] roomsAndDiscount) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionType = PromotionType.HOTEL_3_ROOMS_OR_MORE;
		this.promotionName = promotionName;
		this.roomsAndDiscount = roomsAndDiscount;
		
		this.discount = 0;
		this.startTime = null;
		this.endTime = null;
		this.birthDay = null;
		this.cooperateBusiness = null;
		this.vipTradeAreaDiscount = null;
		this.vipLevelDiscount = null;
	}
	

	/**
	 * 网站特定时间优惠 PromotionType.WEB_11_11
	 * @param promotionID
	 * @param promotionName
	 * @param discount
	 * @param startTime
	 * @param endTime
	 */
	public PromotionVO(String promotionID,  String promotionName,double discount,
			String startTime, String endTime) {
		this.promotionType = PromotionType.WEB_11_11;
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
		
		this.hotelID = null;
		this.cooperateBusiness = null;
		this.roomsAndDiscount = null;
		this.vipTradeAreaDiscount = null;
		this.vipLevelDiscount = null;
	}
	
	
	/**
	 * 网站vip特定商圈优惠
	 * @param promotionID
	 * @param promotionName
	 * @param vipTradeAreaDiscount
	 */
	public PromotionVO(String promotionID, String promotionName,
			 HashMap<String, Double[]> vipTradeAreaDiscount) {
		this.promotionID = promotionID;
		this.promotionType = PromotionType.WEB_VIP_TRADINGAREA;
		this.promotionName = promotionName;
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
		
		this.discount = 0;
		this.startTime = null;
		this.endTime = null;
		this.cooperateBusiness = null;
		this.roomsAndDiscount = null;
		this.hotelID = null;
		this.birthDay = null;
		this.vipLevelDiscount = null;
	}
	
	/**
	 * 网站vip等级优惠
	 * @param promotionID
	 * @param promotionName
	 * @param vipLevelDiscount
	 */
	public PromotionVO(String promotionID, String promotionName, double[] vipLevelDiscount) {
		this.promotionID = promotionID;
		this.promotionType = PromotionType.WEB_VIP_LEVEL;
		this.promotionName = promotionName;
		this.vipLevelDiscount = vipLevelDiscount;
		
		this.birthDay = null;
		this.hotelID = null;
		this.discount = 0;
		this.startTime = null;
		this.endTime = null;
		this.cooperateBusiness = null;
		this.roomsAndDiscount = null;
		this.vipTradeAreaDiscount = null;
		
	}
}
