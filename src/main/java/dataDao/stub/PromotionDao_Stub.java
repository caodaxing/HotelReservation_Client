package dataDao.stub;

import java.util.ArrayList;
import java.util.HashMap;

import Message.PromotionType;
import dataDao.promotion.PromotionDao;
import po.PromotionPO;

public class PromotionDao_Stub implements PromotionDao {


	public PromotionPO getPromotion(String promotionID) {
		return new PromotionPO(PromotionType.WEB_11_11.ordinal(), "55555", null, "网站双11折扣", 
				0.70, null, null, null, null, null, null);
	}

	public boolean addPromotion(PromotionPO promotionPO) {
		return true;
	}

	public boolean updatePromotion(PromotionPO promotionPO) {
		return true;
	}

	@Override
	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType) {

		ArrayList<PromotionPO> pos = new ArrayList<PromotionPO>();
		
		PromotionPO p1 = new PromotionPO(PromotionType.HOTEL_11_11.ordinal(), "11111", "00001", "酒店双11折扣", 
				0.70, "2016-11-11 00:00:00", "2016-11-12 00:00:00", null, null, null, null);
		
		double[] rooms = {0.9, 0.8};
		PromotionPO p2 = new PromotionPO(PromotionType.HOTEL_3_ROOMS_OR_MORE.ordinal(), "22222", "00001", "酒店三间房间及以上", 
				0, null, null, null, rooms, null, null);
		
		PromotionPO p3 = new PromotionPO(PromotionType.HOTEL_BIRTHDAY.ordinal(), "33333", "00001", "酒店客户生日折扣", 
				0.90, null, null, null, null, null, null);
		
		PromotionPO p4 = new PromotionPO(PromotionType.HOTEL_COOPREATE_BUSINESS.ordinal(), "44444", "00001", "酒店合作企业优惠", 
				0.70, null, null, "南京大学", null, null, null);
		
		pos.add(p1);
		pos.add(p2);
		pos.add(p3);
		pos.add(p4);
		
		return pos;
	}

	@Override
	public ArrayList<PromotionPO> getWebPromotions(int promotionType) {

		ArrayList<PromotionPO> pos = new ArrayList<PromotionPO>();	
		
		PromotionPO p1 = new PromotionPO(PromotionType.WEB_11_11.ordinal(), "55555", null, "网站双11折扣", 
				0.70, "2016-11-11 00:00:00", "2016-11-12 00:00:00", null, null, null, null);
		
		double[] vipLevel = {0, 0.80};
		PromotionPO p2 = new PromotionPO(PromotionType.WEB_VIP_LEVEL.ordinal(), "666666", null, "网站vip等级折扣", 
				0, null, null, null, null, null, vipLevel);
		
		HashMap<String, double[]> vipTrading = new 	HashMap<String, double[]>();
		double[] d1 = {0, 0.80}; 
		double[] d2 = {0, 1, 0.70}; 
		double[] d3 = {0, 0.8, 0.50}; 
		vipTrading.put("鼓楼区", d1);
		vipTrading.put("栖霞区", d2);
		vipTrading.put("江宁区", d3);
		PromotionPO p3 = new PromotionPO(PromotionType.WEB_VIP_TRADINGAREA.ordinal(), "666666", null, "网站vip等级商圈折扣", 
				0, null, null, null, null, vipTrading, null);
		
		pos.add(p1);
		pos.add(p2);
		pos.add(p3);
		
		return pos;
	}


}
