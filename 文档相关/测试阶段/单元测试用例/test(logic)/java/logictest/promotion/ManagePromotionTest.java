package logictest.promotion;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.PromotionType;
import Message.ResultMessage;
import logic.promotion.ManagePromotion;
import vo.PromotionVO;

public class ManagePromotionTest {

	private ManagePromotion managePromotion;
	
	@Before
	public void setUp() {
		this.managePromotion = new ManagePromotion();
	}
	
	@Test
	public void testAddPromotion() {
		
		PromotionVO v = new PromotionVO(null, "QWZK", 0.9, "2016-11-30 00:00:00", "2016-12-01 00:00:00");
		
		assertEquals(ResultMessage.SUCCESS, this.managePromotion.addPromotion(v));
		
	}
	
	@Test
	public void testGetPromotion() {
		
		PromotionVO v = this.managePromotion.getPromotion("55555");
		
		assertEquals(PromotionType.WEB_11_11, v.promotionType);
		
		assertEquals(0.7,  v.discount,0);
	}

}
