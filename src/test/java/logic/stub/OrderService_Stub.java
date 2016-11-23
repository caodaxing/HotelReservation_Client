package logic.stub;

import java.util.ArrayList;

import Message.CreditChange;
import Message.OrderListCondition;
import Message.ResultMessage;
import logicService.OrderService;
import vo.OrderVO;
import vo.RoomVO;

public class OrderService_Stub implements OrderService {

	public OrderVO createOrder(OrderVO o) {
		// TODO Auto-generated method stub
		
		return new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
	}

	public ResultMessage undoOrder(String order_id) {
		// TODO Auto-generated method stub
		
		return ResultMessage.FAILURE;
	}

	public OrderVO getOrderInfo(String order_id) {
		// TODO Auto-generated method stub
		
		return new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
	}

	public String getEvaluation(String order_id) {
		// TODO Auto-generated method stub
		
		String evaluation = "房间很整洁，好评！！";
		return evaluation;
	}

	public ResultMessage judgeCredit(String user_id) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage changeCredit(String user_id, CreditChange change, int number) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}

	public ArrayList<OrderVO> filterList(String userID, OrderListCondition condition) {
		// TODO Auto-generated method stub
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
		OrderVO order2 = new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
		List.add(order1);
		List.add(order2);
		
		return List;
	}
	
}
