package logicService.promotion;

import java.util.HashMap;

import vo.PromotionVO;

public interface PromotionService {
	
	public PromotionVO getPromotionInfo(String promotionID);
	
	public HashMap<String, String> hotelSetPromotion(String promotionid, String hotelPromotion);
	
	public String hotelGetPromotion(String promtionid);
	
	public HashMap<String, String> hotelAddPromotion(String promtionid, String content);
	
	public HashMap<String, String> hotelDeletePromotion(String promtionid);
	
	public HashMap<String, String> hotelUpdatePromotion(String promtionid, String content);
	
	public HashMap<String, String> webSetPromotion(String promotionid, String webPromotion);
	
	public String webGetPromotion(String promotionid);
	
	public HashMap<String, String> webAddPromotion(String promtionid, String content);
	
	public HashMap<String, String> webDeletePromotion(String promtionid);
	
	public HashMap<String, String> webUpdatePromotion(String promtionid, String content);
	
}
