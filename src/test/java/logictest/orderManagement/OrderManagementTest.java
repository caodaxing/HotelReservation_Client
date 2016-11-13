package logictest.orderManagement;

import static org.junit.Assert.*;
import org.junit.Test;

import Message.CreditChange;
import Message.ResultMessage;
import logic.credit.MockCredit;
import logic.orderManagement.ExecuteOrder;
import logic.orderManagement.ManageOrder;
import logic.room.MockRoom;
import vo.OrderVO;
import vo.RoomVO;

public class OrderManagementTest {

	@Test
	/**
	 * @author bcy
	 * 测试补登异常订单
	 */
	public void testUndoUnnormalOrder() {
		RoomVO roomVO=new RoomVO(0, 888, 0, "0001_1101");
		OrderVO orderVO=new OrderVO("2016111300001", "2016/11/13 15:00", roomVO, "2016/11/14  8:00", 0, 2, false, 888);
		ManageOrder manageOrder=new ManageOrder(null);
		ExecuteOrder execute=new ExecuteOrder(null, null);
		execute.autoSetUnnormal("2016111300001");
		MockRoom room=new MockRoom();
		room.updateRoomInfo(roomVO);
		MockCredit credit=new MockCredit();
		credit.changeCredit("伟大的源哥哥", CreditChange.DECREASE, 888);
		
		assertEquals(ResultMessage.SUCCESS, manageOrder.undoUnnormalOrder(orderVO));
		assertEquals(-888, credit.getCredit("伟大的源哥哥"));
	}

}
