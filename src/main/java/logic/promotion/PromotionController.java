package logic.promotion;

import java.util.HashMap;

public class PromotionController {
	HotelPromotion hotelPro;
	WebPromotion webPro;
	
	public HashMap<String,String> hotelSetPromotion(String promotionid,String hotelPromotion){
		return hotelPro.setPromotion(promotionid, hotelPromotion);
	}
	public String hotelGetPromotion(String promtionid){
		return hotelPro.getPromotion(promtionid);
	}
	public HashMap<String,String> hotelAddPromotion(String promtionid,String content){
		return hotelPro.addPromotion(promtionid, content);
	}
	public HashMap<String,String> hotelDeletePromotion(String promtionid){
		return hotelPro.deletePromotion(promtionid);
	}
	public HashMap<String,String> hotelUpdatePromotion(String promtionid,String content){
		return hotelPro.updatePromotion(promtionid, content);
	}
	public HashMap<String,String> webSetPromotion(String promotionid,String webPromotion){
		return webPro.setpromotion(promotionid, webPromotion);
	}
	public String webGetPromotion(String promotionid){
		return webPro.getromotion(promotionid);
	}
	public HashMap<String,String> webAddPromotion(String promtionid,String content){
		return webPro.addpromotion(promtionid, content);
	}
	public HashMap<String,String> webDeletePromotion(String promtionid){
		return webPro.deletepromotion(promtionid);
	}
	public HashMap<String,String> webUpdatePromotion(String promtionid,String content){
		return webPro.updatepromotion(promtionid, content);
	}
	
}
