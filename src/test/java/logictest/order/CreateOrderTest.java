package logictest.order;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import logic.credit.CreditInfo;
import logic.credit.MockCredit;
import logic.order.CreateOrder;
import logic.promotion.CalculatePromotion;
import logic.promotion.JudgePromotion;
import logic.promotion.MockCalculatePromotion;
import logic.user.MockClient;
import logic.user.Client;
import vo.OrderVO;
import vo.RoomVO;
import vo.ClientVO;

public class CreateOrderTest {

	private JudgePromotion promotion;
	private CreateOrder createOrder;
	private CreditInfo credit;
	
	@Before
	public void setUp(){
		promotion = new MockCalculatePromotion();
		credit = new MockCredit(0, 2);
		createOrder = new CreateOrder(promotion, credit);
		
	}
	
	/**
	 * 测试信用值不足时生成订单
	 * @author Mark.W
	 */
	@Test
	public void testCreateOrder1() {
		assertEquals(createOrder.judgeCredit("dddddd"), ResultMessage.FAILURE);
	}
	
	/**
	 * 测试正常生成订单
	 * @author Mark.W
	 */
	@Test
	public void testCreateOrder2() {
		createOrder = new CreateOrder(promotion, new MockCredit(100, 2));
		
		assertEquals(createOrder.judgeCredit("dddddd"), ResultMessage.SUCCESS);
		
		OrderVO order = new OrderVO("2-1611111112", "20161111", 
				new RoomVO(0,299,0,"1109"), "20161112", 1, 2, false, 299);
		
		assertEquals(promotion.calculate(order),  "2s79");
	}

}
