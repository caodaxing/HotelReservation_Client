package factories;

import logic.promotion.Promotion;
import po.PromotionPO;

public class PromotionFactory {
	
	public Promotion createPromotion(PromotionPO po) {
		
		Promotion result = null;
		
		switch(po.getPromotionType()) {
		case 1 :
			result = this.createHotelBirthdayPromotion(po);
			break;
		case 2 :
			result = this.createHotelThreeRoomsPromotion(po);
			break;
		case 3 :
			result = this.createHotelBusinessPromotion(po);
			break;
		case 4 :
			result = this.createHotelDoubelElevenPromotion(po);
			break;
		case 5 :
			result = this.createWebDoubleElevenPromotion(po);
			break;
		case 6 :
			result = this.createWebVipTradingAreaPromotion(po);
			break;
		case 7 :
			result = this.createWebVipLevelPromotion(po);
			break;
		default :
System.out.println("PromotionFactory.createPromotion参数异常");
			break;
		}
		
		return result;
	}

	private Promotion createWebVipLevelPromotion(PromotionPO po) {
		
		
		return null;
	}

	private Promotion createWebVipTradingAreaPromotion(PromotionPO po) {
		return null;
	}

	private Promotion createWebDoubleElevenPromotion(PromotionPO po) {
		return null;
	}

	private Promotion createHotelDoubelElevenPromotion(PromotionPO po) {
		return null;
	}

	private Promotion createHotelBusinessPromotion(PromotionPO po) {
		return null;
	}

	private Promotion createHotelThreeRoomsPromotion(PromotionPO po) {
		return null;
	}

	private Promotion createHotelBirthdayPromotion(PromotionPO po) {
		
		return null;
	}
}
