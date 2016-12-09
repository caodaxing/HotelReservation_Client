package logictest.promotion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.PromotionType;
import logic.promotion.ManagePromotion;
import vo.PromotionVO;

public class ManagePromotionTest {

	private ManagePromotion managePromotion;
	
	@Before
	public void setUp() {
		this.managePromotion = new ManagePromotion();
	}
	
	@Test
	public void testGetPromotion() {
		
		PromotionVO v = this.managePromotion.getPromotion("55555");
		
		assertEquals(PromotionType.WEB_11_11, v.promotionType);
		
		assertEquals(0.7, 0, v.discount);
	}

}
