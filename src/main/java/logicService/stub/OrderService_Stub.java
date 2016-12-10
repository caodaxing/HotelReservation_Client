package logicService.stub;

import java.util.ArrayList;

import Message.CreditChangeType;
import Message.OrderListCondition;
import Message.ResultMessage;
import logicService.order.OrderService;
import vo.EvaluationVO;
import vo.OrderVO;
import vo.RoomVO;

public class OrderService_Stub implements OrderService {

	public OrderVO createOrder(OrderVO o) {
//		return new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
		return null;
	}

	public ResultMessage undoOrder(String order_id) {
		return ResultMessage.SUCCESS;
	}

	public OrderVO getOrderInfo(String order_id) {
//		return new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
		return null;
	}

	public String getEvaluation(String order_id) {
		String evaluation = "房间很整洁，好评！！";
		return evaluation;
	}

	public ResultMessage judgeCredit(String user_id) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage changeCredit(String user_id, CreditChangeType change, int number) {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<OrderVO> filterList(String userID, OrderListCondition condition) {
//		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
//		OrderVO order1 = new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
//		OrderVO order2 = new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
//		List.add(order1);
//		List.add(order2);
//		
//		return List;
		return null;
	}
	

	public EvaluationVO getEvaluationInfo(String orderId) {
		return null;
//		return new EvaluationVO("房间很乱，差评！！", "00102", "161222001021033", 0);
	}


	public ResultMessage evaluate(String orderId) {
		return ResultMessage.SUCCESS;
	}

	
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
		return ResultMessage.SUCCESS;
	}

	public ResultMessage autoSetUnnormal(String order_id) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage supplyOrder(String order_id) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage evaluate(EvaluationVO evaluation) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
