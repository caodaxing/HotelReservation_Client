package po;

/**
 * @param promotionID 促销ID
 * @param name 促销名称
 * @param hotelID 酒店ID
 * @param isWeb 是否为网站促销策略
 * @author bcy
 *
 */
public class PromotionPO {
	private String promotionID;
	private String name;
	private String hotelID;
	private boolean isWeb;
	
	public PromotionPO(String promotionID,String name,String hotelID,boolean isWeb) {
		this.promotionID=promotionID;
		this.name=name;
		this.hotelID=hotelID;
		this.isWeb=isWeb;
	}

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public boolean isWeb() {
		return isWeb;
	}

	public void setWeb(boolean isWeb) {
		this.isWeb = isWeb;
	}
	
	
}
