package vo;

public class PromotionVO {

	public String promotionID;
	public String promotionDescription;
	public double priceBenefit;
	
	/**
	 * @param promotionID 
	 * @param promotionDescription
	 * @param priceBenefit 优惠的价格（取价格差，如优惠了¥30）
	 */
	public PromotionVO(String promotionID, String promotionDescription, double priceBenefit) {
		this.promotionID = promotionID;
		this.promotionDescription = promotionDescription;
		this.priceBenefit = priceBenefit;
	}

}
