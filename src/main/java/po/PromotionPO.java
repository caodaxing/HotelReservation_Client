package po;

import java.util.HashMap;

/**
 * @param promotionType  //0:所有promotion 1:酒店生日折扣 2:酒店三间及以上预定特惠 3:酒店合作企业特惠 4:酒店双11(特定期间特惠) 
						//5:网站双11(特定期间优惠) 6:网站vip不同商圈不同优惠 7:网站VIP不同等级不同优惠
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
public class PromotionPO {
	private int promotionType;
	private String promotionID;
	private String hotelID;
	private String promotionName;
	private double discount;
	private String startTime;
	private String endTime; 
	private String birthDay;
	private String cooperateBusiness;
	private double[] roomsAndDiscount;
	private HashMap<String, Double[]> vipTradeAreaDiscount;
	private double[] vipLevelDiscount;
	
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
	 * @param vipTradeAreaDiscount
	 * @param vipLevelDiscount
	 */
	public PromotionPO(int promotionType, String promotionID, String hotelID, String promotionName,
			double discount, String startTime, String endTime, String birthDay, String cooperateBusiness,
			double[] roomsAndDiscount, HashMap<String, Double[]> vipTradeAreaDiscount, double[] vipLevelDiscount) {
		this.promotionType = promotionType;
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.birthDay = birthDay;
		this.cooperateBusiness = cooperateBusiness;
		this.roomsAndDiscount = roomsAndDiscount;
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
		this.vipLevelDiscount = vipLevelDiscount;
	}
	
	public int getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(int promotionType) {
		this.promotionType = promotionType;
	}

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getCooperateBusiness() {
		return cooperateBusiness;
	}

	public void setCooperateBusiness(String cooperateBusiness) {
		this.cooperateBusiness = cooperateBusiness;
	}

	public double[] getRoomsAndDiscount() {
		return roomsAndDiscount;
	}

	public void setRoomsAndDiscount(double[] roomsAndDiscount) {
		this.roomsAndDiscount = roomsAndDiscount;
	}

	public HashMap<String, Double[]> getVipTradeAreaDiscount() {
		return vipTradeAreaDiscount;
	}

	public void setVipTradeAreaDiscount(HashMap<String, Double[]> vipTradeAreaDiscount) {
		this.vipTradeAreaDiscount = vipTradeAreaDiscount;
	}

	public double[] getVipLevelDiscount() {
		return vipLevelDiscount;
	}

	public void setVipLevelDiscount(double[] vipLevelDiscount) {
		this.vipLevelDiscount = vipLevelDiscount;
	}

}