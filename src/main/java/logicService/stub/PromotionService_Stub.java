package logicService.stub;

import java.util.ArrayList;
import java.util.HashMap;

import Message.PromotionType;
import Message.ResultMessage;
import logicService.promotion.PromotionService;
import vo.PromotionVO;

public class PromotionService_Stub implements PromotionService {

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType) {
		double[] d = {0.9,0.8};
		ArrayList<PromotionVO> promotionVO;
		if(promotionType == PromotionType.ALL){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p1 = new PromotionVO("111", "aaa", "ksjeiew", 0.9, "20161122", "20161223");
			PromotionVO p2 = new PromotionVO("222", "sss", "ksjeiew", 0.8, "20160708", "20171231");
			PromotionVO p3 = new PromotionVO("333", "ddd", "ksjeiew", 0.7, "20160203");
			PromotionVO p4 = new PromotionVO("444", "fff", "ksjeiew", 0.6);
			PromotionVO p5 = new PromotionVO("555", "ggg", "ksjeiew", 0.5);
			PromotionVO p6 = new PromotionVO("666", "hhh", "ksjeiew", d);
			promotionVO.add(p1);
			promotionVO.add(p2);
			promotionVO.add(p3);
			promotionVO.add(p4);
			promotionVO.add(p5);
			promotionVO.add(p6);
		}else if(promotionType == PromotionType.HOTEL_11_11){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p1 = new PromotionVO("111", "aaa", "ksjeiew", 0.9, "20161122", "20161223");
			PromotionVO p2 = new PromotionVO("222", "sss", "ksjeiew", 0.8, "20160708", "20171231");
			promotionVO.add(p1);
			promotionVO.add(p2);
		}else if(promotionType == PromotionType.HOTEL_3_ROOMS_OR_MORE){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p6 = new PromotionVO("666", "hhh", "ksjeiew", d);
			promotionVO.add(p6);
		}else if(promotionType == PromotionType.HOTEL_BIRTHDAY){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p4 = new PromotionVO("444", "fff", "ksjeiew", 0.6);
			PromotionVO p5 = new PromotionVO("555", "ggg", "ksjeiew", 0.5);
			promotionVO.add(p4);
			promotionVO.add(p5);
		}else{
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p3 = new PromotionVO("333", "ddd", "ksjeiew", 0.7, "20160203");
			promotionVO.add(p3);
		}
		return promotionVO;
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType) {
		HashMap<String, double[]> hash1 = new HashMap<String, double[]>();
		double[] d = {0.9,0.8};
		hash1.put("jsdk", d);
		HashMap<String, double[]> hash = new HashMap<String, double[]>();
		double[] d1 = {0.89,0.88};
		hash.put("ieuwoi", d1);
		ArrayList<PromotionVO> promotionVO;
		if(promotionType == PromotionType.ALL){
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p1 = new PromotionVO("111", "aaa", 0.9, "20161122", "20161223");
			PromotionVO p2 = new PromotionVO("222", "sss", 0.8, "20160708", "20171231");
			PromotionVO p3 = new PromotionVO("333", "ddd", d);
			PromotionVO p4 = new PromotionVO("444", "fff", d1);
			PromotionVO p5 = new PromotionVO("555", "ggg", hash);
			PromotionVO p6 = new PromotionVO("666", "hhh", hash1);
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
			PromotionVO p3 = new PromotionVO("333", "ddd", d);
			PromotionVO p4 = new PromotionVO("444", "fff", d1);
			promotionVO.add(p3);
			promotionVO.add(p4);
		}else{
			promotionVO = new ArrayList<PromotionVO>();
			PromotionVO p5 = new PromotionVO("555", "ggg", hash);
			PromotionVO p6 = new PromotionVO("666", "hhh", hash1);
			promotionVO.add(p5);
			promotionVO.add(p6);
		}
		return promotionVO;
	}

	
}
