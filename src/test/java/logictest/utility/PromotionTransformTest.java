package logictest.utility;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import Message.PromotionType;
import logic.utility.PromotionTransform;
import po.PromotionPO;
import vo.PromotionVO;

public class PromotionTransformTest {

	private PromotionTransform promotionTransform;
	
	@Before
	public void setUp(){
		this.promotionTransform = new PromotionTransform();
	}
	
	@Test
	public void testPromotionTransToVO1() {
		PromotionPO p1 = new PromotionPO(PromotionType.HOTEL_11_11.ordinal(), "11111", "00001", "酒店双11折扣", 
				0.70, "2016-11-11 00:00;00", "2016-11-12 00:00:00", null, null, null, null);
		
		double[] rooms = {0.9, 0.8};
		PromotionPO p2 = new PromotionPO(PromotionType.HOTEL_3_ROOMS_OR_MORE.ordinal(), "22222", "00001", "酒店三间房间及以上", 
				0, null, null, null, rooms, null, null);
		
		PromotionPO p3 = new PromotionPO(PromotionType.HOTEL_BIRTHDAY.ordinal(), "33333", "00001", "酒店客户生日折扣", 
				0.90, null, null, null, null, null, null);
		
		PromotionPO p4 = new PromotionPO(PromotionType.HOTEL_COOPREATE_BUSINESS.ordinal(), "44444", "00001", "酒店合作企业优惠", 
				0.70, null, null, "南京大学", null, null, null);
		
		PromotionPO p5 = new PromotionPO(PromotionType.WEB_11_11.ordinal(), "55555", null, "网站双11折扣", 
				0.70, "2016-11-11 00:00:00", "2016-11-12 00:00:00", null, null, null, null);
		
		double[] vipLevel = {0, 0.80};
		PromotionPO p6 = new PromotionPO(PromotionType.WEB_VIP_LEVEL.ordinal(), "666666", null, "网站vip等级折扣", 
				0, null, null, null, null, null, vipLevel);
		
		HashMap<String, double[]> vipTrading = new 	HashMap<String, double[]>();
		double[] d1 = {0, 0.80}; 
		double[] d2 = {0, 1, 0.70}; 
		double[] d3 = {0, 0.8, 0.50}; 
		vipTrading.put("鼓楼区", d1);
		vipTrading.put("栖霞区", d2);
		vipTrading.put("江宁区", d3);
		PromotionPO p7 = new PromotionPO(PromotionType.WEB_VIP_TRADINGAREA.ordinal(), "666666", null, "网站vip等级商圈折扣", 
				0, null, null, null, null, vipTrading, null);
		
		ArrayList<PromotionPO> pos = new ArrayList<PromotionPO>();
		
		pos.add(p1);
		pos.add(p2);
		pos.add(p3);
		pos.add(p4);
		pos.add(p5);
		pos.add(p6);
		pos.add(p7);
	
		ArrayList<PromotionVO> vos = this.promotionTransform.promotionListTransToVO(pos);
		
		assertEquals(7, vos.size());
		
		assertEquals("11111", vos.get(0).promotionID);
		assertEquals(2, vos.get(1).roomsAndDiscount.length);
		assertEquals(0.9, 0,  vos.get(2).discount);
		assertEquals("南京大学", vos.get(3).cooperateBusiness);
		assertEquals("2016-11-11 00:00:00", vos.get(4).startTime);
		assertEquals(0.8, 0,  vos.get(5).vipLevelDiscount[1]);
		assertEquals(0.50, 0, vos.get(6).vipTradeAreaDiscount.get("江宁区")[2]);
		
	}
	
}