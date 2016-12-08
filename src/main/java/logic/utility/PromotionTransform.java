package logic.utility;

import java.util.ArrayList;

import Message.PromotionType;
import po.PromotionPO;
import vo.PromotionVO;

public class PromotionTransform {

	public ArrayList<PromotionVO> promotionListTransToVO(ArrayList<PromotionPO> pos) {
		if(pos == null) {
			return null;
		}
		
		ArrayList<PromotionVO> vos = new ArrayList<PromotionVO>();
		for(int i=0; i<pos.size(); ++i) {
			vos.add(this.promotionTransToVO(pos.get(i)));
		}
		
		return vos;
	}
	
	public PromotionPO promotionTransToVO(PromotionVO vo) {
		if(vo == null) {
			return null;
		}
		
		return new PromotionPO(vo.promotionType.ordinal(), vo.promotionID, vo.hotelID, 
				vo.promotionName, vo.discount, vo.startTime, vo.endTime, vo.birthDay, 
				vo.cooperateBusiness, vo.roomsAndDiscount, vo.vipTradeAreaDiscount, vo.vipLevelDiscount);
	}
	
	public PromotionVO promotionTransToVO(PromotionPO po) {
		PromotionVO vo = null;
		
		switch(PromotionType.values()[po.getPromotionType()]) {
		case HOTEL_BIRTHDAY :
			vo = this.tranToHotelBirthDayVO(po);
			break;
		case HOTEL_3_ROOMS_OR_MORE:
			vo = this.tranToHotelThreeRoomsVO(po);
			break;
		case HOTEL_COOPREATE_BUSINESS:
			vo = this.tranToHotelBusinessVO(po);
			break;
		case HOTEL_11_11 :
			vo = this.tranToHotelDoubleElevenVO(po);
			break;
		case WEB_11_11 :
			vo = this.tranToWebDoubleElevenVO(po);
			break;
		case WEB_VIP_TRADINGAREA :
			vo = this.tranToWebVipTradingAreaVO(po);
			break;
		case WEB_VIP_LEVEL:
			vo = this.tranToWebVipLevelaVO(po);
			break;
		default:
			break;
		}
		
		return vo;
	}

	private PromotionVO tranToHotelBirthDayVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getHotelID(), po.getPromotionName(), 
				po.getBirthDay(), po.getDiscount());
	}

	private PromotionVO tranToHotelThreeRoomsVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getHotelID(), po.getPromotionName(),
				po.getRoomsAndDiscount());
	}

	private PromotionVO tranToHotelBusinessVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getHotelID(), po.getPromotionName(),
				po.getDiscount(), po.getCooperateBusiness());
	}

	private PromotionVO tranToHotelDoubleElevenVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getHotelID(),po.getPromotionName(),
				po.getDiscount(), po.getStartTime(), po.getEndTime());
	}

	private PromotionVO tranToWebDoubleElevenVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getPromotionName(), po.getDiscount(), po.getStartTime(), po.getEndTime());
	}

	private PromotionVO tranToWebVipTradingAreaVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getPromotionName(), po.getVipTradeAreaDiscount());
	}

	private PromotionVO tranToWebVipLevelaVO(PromotionPO po) {
		return new PromotionVO(po.getPromotionID(), po.getPromotionName(), po.getVipLevelDiscount());
	}

}
