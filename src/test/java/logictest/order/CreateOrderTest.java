package logictest.order;

import org.junit.Test;

import logic.order.CreateOrder;
import logic.order.MockCreateOrder;
import logic.user.MockUser;
import logic.user.User;
import vo.OrderVO;
import vo.RoomVO;
import vo.UserVO;

public class CreateOrderTest {

	@Test
	public void test1() {
		UserVO uservo = new UserVO("dddddd", "wyy", "13338031126", 100, null);
		CreateOrder createOrder = new MockCreateOrder();
		User user = new MockUser(uservo);
		createOrder.judgeCredit("zyddsb");
//		asssertEquals()
	}
	
	@Test
	public void test2() {
		
		OrderVO ordervo = new OrderVO("201611111112", "20161111",
				new RoomVO(0, 299, 0, "1010"), "20161112", 0, 2, false);
		CreateOrder createOrder = new CreateOrder();
		
	}

}
