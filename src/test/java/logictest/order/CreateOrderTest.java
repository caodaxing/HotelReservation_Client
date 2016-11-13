package logictest.order;

import org.junit.Test;

import logic.order.CreateOrder;
import vo.OrderVO;
import vo.RoomVO;

public class CreateOrderTest {

	@Test
	public void test1() {
		CreateOrder createOrder = new CreateOrder();
		
	}
	
	@Test
	public void test2() {
		
		OrderVO ordervo = new OrderVO("201611111112", "20161111",
				new RoomVO(0, 299, 0, "1010"), "20161112", 0, 2, false);
		CreateOrder createOrder = new CreateOrder();
		
	}

}
