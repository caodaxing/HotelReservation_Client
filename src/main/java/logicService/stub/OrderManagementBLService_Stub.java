package logicService.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.orderManagement.ExecuteOrderService;
import vo.OrderVO;
import vo.RoomVO;

public class OrderManagementBLService_Stub implements ExecuteOrderService{

	public ArrayList<OrderVO> getDailyOrderList() {
		
//		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
//		OrderVO order1 = new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
//		OrderVO order2 = new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
//		List.add(order1);
//		List.add(order2);
//		
//		return List;
		return null;
	}

	public ResultMessage undoUnnormalOrder(OrderVO orderVO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage normalExecute(String order_id) {
		return ResultMessage.FAILURE;
	}

	public ResultMessage autoSetUnnormal(String order_id) {
		return ResultMessage.FAILURE;
	}

	public ResultMessage supplyOrder(String order_id) {
		return ResultMessage.FAILURE;
	}
	
}
