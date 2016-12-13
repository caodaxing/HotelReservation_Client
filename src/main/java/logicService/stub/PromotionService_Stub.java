package logicService.stub;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import logicService.promotion.PromotionService;
import vo.PromotionVO;

public class PromotionService_Stub implements PromotionService {

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		return null;
	}

	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType) {
		
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType) {
		ArrayList<PromotionVO> promotionVO;
		if(promotionType == PromotionType.ALL){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p1 = new PromotionVO("111", "aaa", 0.9, "20161122", "20161223");
			PromotionVO p2 = new PromotionVO("222", "sss", 0.8, "20160708", "20171231");
			PromotionVO p3 = new PromotionVO("333", "ddd", 0.7, "20160203", "20160908");
			PromotionVO p4 = new PromotionVO("444", "fff", 0.6, "20161222", "20170909");
			PromotionVO p5 = new PromotionVO("555", "ggg", 0.5, "20160101", "20160202");
			PromotionVO p6 = new PromotionVO("666", "hhh", 0.4, "20160129", "20161223");
			promotionVO.add(p1);
			promotionVO.add(p2);
			promotionVO.add(p3);
			promotionVO.add(p4);
			promotionVO.add(p5);
			promotionVO.add(p6);
		}else if(promotionType == PromotionType.WEB_11_11){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p1 = new PromotionVO("111", "aaa", 0.9, "20161122", "20161223");
			PromotionVO p2 = new PromotionVO("222", "sss", 0.8, "20160708", "20171231");
			promotionVO.add(p1);
			promotionVO.add(p2);
		}else if(promotionType == PromotionType.WEB_VIP_LEVEL){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p3 = new PromotionVO("333", "ddd", 0.7, "20160203", "20160908");
			PromotionVO p4 = new PromotionVO("444", "fff", 0.6, "20161222", "20170909");
			promotionVO.add(p3);
			promotionVO.add(p4);
		}else{
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p5 = new PromotionVO("555", "ggg", 0.5, "20160101", "20160202");
			PromotionVO p6 = new PromotionVO("666", "hhh", 0.4, "20160129", "20161223");
			promotionVO.add(p5);
			promotionVO.add(p6);
		}
		return promotionVO;
	}

	
}
