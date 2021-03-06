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
 * @param cooperateBusiness
 * @param roomsAndDiscount
 * @param vipTradeAreaDiscount  用HashMap<String, Double[]> 来存 商圈，double数组下标(不包括0，0号位置用0填充)表示会员等级，值表示折扣，保留两位小数
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
	public String cooperateBusiness;
	public double[] roomsAndDiscount;
	public HashMap<String, double[]> vipTradeAreaDiscount;
	public double[] vipLevelDiscount;
	
	
	/**
	 *  酒店特定时间优惠 promotionType.HOTEL_11_1
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
		this.discount = discount;
		
		if(startTime == null) {
			this.startTime = "";
		} else {
			this.startTime = startTime;
		}
		
		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}
		
		if(endTime == null) {
			this.endTime = "";
		} else {
			this.endTime = endTime;
		}
		
		
		this.cooperateBusiness = "";
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
		this.discount = discount;
		
		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}
		
		if(cooperateBusiness == null) {
			this.cooperateBusiness = "";
		} else {
			this.cooperateBusiness = cooperateBusiness;
		}
		
		this.startTime = "";
		this.endTime = "";
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
		this.discount = discount;
		this.promotionType = PromotionType.HOTEL_BIRTHDAY;
		
		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}		
		
		this.startTime = "";
		this.endTime = "";
		this.cooperateBusiness = "";
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
		this.roomsAndDiscount = roomsAndDiscount;
		
		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}
		
		this.discount = 0;
		this.startTime = "";
		this.endTime = "";
		this.cooperateBusiness = "";
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
	public PromotionVO(String promotionID,  String promotionName, double discount,
			String startTime, String endTime) {
		this.promotionType = PromotionType.WEB_11_11;
		this.promotionID = promotionID;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
		
		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}
		
		this.hotelID = "";
		this.cooperateBusiness = "";
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
			 HashMap<String, double[]> vipTradeAreaDiscount) {
		this.promotionID = promotionID;
		this.promotionType = PromotionType.WEB_VIP_TRADINGAREA;
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
		

		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}
		
		this.discount = 0;
		this.startTime = "";
		this.endTime = "";
		this.cooperateBusiness = "";
		this.roomsAndDiscount = null;
		this.hotelID = "";
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
		this.vipLevelDiscount = vipLevelDiscount;

		if(promotionName == null) {
			this.promotionName = "";
		} else {
			this.promotionName = promotionName;
		}
		
		this.hotelID = "";
		this.discount = 0;
		this.startTime = "";
		this.endTime = "";
		this.cooperateBusiness = "";
		this.roomsAndDiscount = null;
		this.vipTradeAreaDiscount = null;
		
	}
}
