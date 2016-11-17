package logictest.order;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.order.CreateOrder;
import logic.promotion.CalculatePromotion;
import logic.promotion.MockCalculatePromotion;
import logic.user.MockUser;
import logic.user.User;
import message.ResultMessage;
import vo.OrderVO;
import vo.RoomVO;
import vo.UserVO;

public class CreateOrderTest {

	/**
	 * 测试信用值不足时生成订单
	 * @author Mark.W
	 */
	@Test
	public void test1() {
		UserVO uservo = new UserVO("dddddd", "wyy", "13338031126", 0, null);
		CreateOrder createOrder = new CreateOrder(null);
		User user = new MockUser(uservo);
		assertEquals(createOrder.judgeCredit("dddddd"), ResultMessage.FAILURE);
	}
	
	/**
	 * 测试正常生成订单
	 * @author Mark.W
	 */
	@Test
	public void test2() {
		UserVO uservo = new UserVO("dddddd", "wyy", "13338031126", 1000, null);
		CalculatePromotion promotion = new MockCalculatePromotion();
		CreateOrder createOrder = new CreateOrder(promotion);
		User user = new MockUser(uservo);
		
		assertEquals(createOrder.judgeCredit("dddddd"), ResultMessage.SUCCESS);
		
		OrderVO order = new OrderVO("2-1611111112", "20161111", 
				new RoomVO(0,299,0,"1109"),"20161112", 1, 2, false, 299);
	
		assertEquals(promotion.calculate(order),  "299");
		
	}

}
