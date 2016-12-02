package vo.promotion;

/**
 * 用于保存不同商圈不同会员等级不同折扣的信息 
 * @author Mark.W
 * @param vipLevel
 * @param tradingArea
 * @param discount
 */
public class VipTradingAreaVO {
	
	public int vipLevel;
	public String tradingArea;
	public double discount;
	
	public VipTradingAreaVO(int vipLevel, String tradingArea, double discount) {
		super();
		this.vipLevel = vipLevel;
		this.tradingArea = tradingArea;
		this.discount = discount;
	}

}
