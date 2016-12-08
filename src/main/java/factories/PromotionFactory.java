package factories;

import Message.PromotionType;
import logic.promotion.HotelBirthdayPromotion;
import logic.promotion.HotelBusinessPromotion;
import logic.promotion.HotelDoubleElevenPromotion;
import logic.promotion.HotelThreeRoomsPromotion;
import logic.promotion.Promotion;
import logic.promotion.WebDoubleElevenPromotion;
import logic.promotion.WebVipLevelPromotion;
import logic.promotion.WebVipTradingAreaPromotion;
import logic.utility.Time;
import po.PromotionPO;

public class PromotionFactory {
	
	public Promotion createPromotion(PromotionPO po) {
		
		if(po == null) {
			return null;
		}
		
		Promotion result = null;
		
		switch(PromotionType.values()[po.getPromotionType()]) {
		case HOTEL_BIRTHDAY :
			result = this.createHotelBirthdayPromotion(po);
			break;
		case HOTEL_3_ROOMS_OR_MORE:
			result = this.createHotelThreeRoomsPromotion(po);
			break;
		case HOTEL_COOPREATE_BUSINESS:
			result = this.createHotelBusinessPromotion(po);
			break;
		case HOTEL_11_11 :
			result = this.createHotelDoubleElevenPromotion(po);
			break;
		case WEB_11_11 :
			result = this.createWebDoubleElevenPromotion(po);
			break;
		case WEB_VIP_TRADINGAREA :
			result = this.createWebVipTradingAreaPromotion(po);
			break;
		case WEB_VIP_LEVEL:
			result = this.createWebVipLevelPromotion(po);
			break;
		default:
System.out.println("PromotionFactory.createPromotion参数异常");
			break;
		}
		
		return result;
	}

	private Promotion createWebVipLevelPromotion(PromotionPO po) {
		return new WebVipLevelPromotion(po.getPromotionID(), po.getPromotionName(), po.getVipLevelDiscount());
	}

	private Promotion createWebVipTradingAreaPromotion(PromotionPO po) {
		return new WebVipTradingAreaPromotion(po.getPromotionID(), po.getPromotionName(), po.getVipTradeAreaDiscount());
	}

	private Promotion createWebDoubleElevenPromotion(PromotionPO po) {
		return new WebDoubleElevenPromotion(po.getPromotionID(), po.getPromotionName(), 
				po.getDiscount(), new Time(po.getStartTime()), new Time(po.getEndTime()));
	}

	private Promotion createHotelDoubleElevenPromotion(PromotionPO po) {
		return new HotelDoubleElevenPromotion(po.getPromotionID(), po.getHotelID(),
				po.getPromotionName(), po.getDiscount(),new Time(po.getStartTime()), new Time(po.getEndTime()));
	}

	private Promotion createHotelBusinessPromotion(PromotionPO po) {
		return new HotelBusinessPromotion(po.getPromotionID(), po.getHotelID(),
				po.getPromotionName(), po.getDiscount(), po.getCooperateBusiness());
	}

	private Promotion createHotelThreeRoomsPromotion(PromotionPO po) {
		return new HotelThreeRoomsPromotion(po.getPromotionID(), po.getHotelID(),
				po.getPromotionName(), po.getRoomsAndDiscount());
	}

	private Promotion createHotelBirthdayPromotion(PromotionPO po) {
		return new HotelBirthdayPromotion(po.getPromotionID(), po.getHotelID(), 
				po.getPromotionName(), new Time(po.getBirthDay()), po.getDiscount());
	}
}
