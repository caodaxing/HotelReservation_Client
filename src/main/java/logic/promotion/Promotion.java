package logic.promotion;

import java.util.HashMap;

/**
 * hotelPromotion 和 webpromotion的抽象接口
 * @author Mark.W
 *
 */
public interface Promotion {

	public HashMap<String, String> setPromotion(String promotionid, String webPromotion);
	
	public HashMap<String, String> addPromotion(String promtionid, String content);
	
	public HashMap<String, String> deletePromotion(String promtionid);
	
	public HashMap<String, String> updatePromotion(String promtionid, String content);
	
	public double calculate();
}
