package logic.utility;

import Message.PromotionType;
import po.PromotionPO;
import vo.PromotionVO;

public class PromotionTransform {

	public PromotionVO promotionTransToVO(PromotionPO po) {
		PromotionVO vo = null;
		
		switch(PromotionType.values()[po.getPromotionType()]) {
		case HOTEL_BIRTHDAY :
			break;
		case HOTEL_3_ROOMS_OR_MORE:
			break;
		case HOTEL_COOPREATE_BUSINESS:
			break;
		case HOTEL_11_11 :
			break;
		case WEB_11_11 :
			break;
		case WEB_VIP_TRADINGAREA :
			break;
		case WEB_VIP_LEVEL:
			break;
		default:
			
			break;
		}
		
		return vo;
	}

	public PromotionPO promotionTransToVO(PromotionVO vo) {
		if(vo == null) {
			return null;
		}
		
		return new PromotionPO(vo.promotionType.ordinal(), vo.promotionID, vo.hotelID, 
				vo.promotionName, vo.discount, vo.startTime, vo.endTime, vo.birthDay, 
				vo.cooperateBusiness, vo.roomsAndDiscount, vo.vipTradeAreaDiscount, vo.vipLevelDiscount);
	}
}
