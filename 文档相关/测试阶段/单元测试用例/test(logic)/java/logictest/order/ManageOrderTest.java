package logictest.order;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import logic.order.ManageOrder;
import vo.OrderVO;

public class ManageOrderTest {

	private ManageOrder manageOrder;
	
	@Before
	public void setUp() {
		this.manageOrder = new ManageOrder();
	}
	
	@Test
	public void testGetWebDailyUnexecutedOrderList() {
		ArrayList<OrderVO> vos = this.manageOrder.getWebDailyUnexecutedOrderList();
		
		assertEquals(1, vos.size());
	}
	
	@Test
	public void testGetWebDailyAbnormalOrderList() {
		ArrayList<OrderVO> vos = this.manageOrder.getWebDailyAbnormalOrderList();
		
		assertEquals(1, vos.size());
	}

}
