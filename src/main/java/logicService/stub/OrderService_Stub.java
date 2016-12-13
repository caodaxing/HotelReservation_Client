package logicService.stub;

import java.util.ArrayList;

import Message.CreditChangeType;
import Message.OrderListCondition;
import Message.OrderState;
import Message.ResultMessage;
import Message.RoomType;
import logicService.order.CreateOrderService;
import logicService.order.ExecuteOrderService;
import logicService.order.ManageOrderService;
import logicService.order.OrderListService;
import logicService.order.OrderService;
import vo.EvaluationVO;
import vo.OrderVO;
import vo.RoomVO;

public class OrderService_Stub implements OrderService,CreateOrderService,ExecuteOrderService,ManageOrderService,OrderListService {

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
		return new EvaluationVO("161222001021033", 3.0, "房间很乱，差评！！");
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
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition condition) {
		return null;
	}

	@Override
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition) {
		// TODO Auto-generated method stub
		RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.SINGLE_ROOM,330,null,null);
		RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,330,null,null);
		ArrayList<RoomVO> list = new ArrayList<>();
		list.add(roomvo1);
		list.add(roomvo2);
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("267363HSHJ","161124000021103", "161124", "161122","837JFD",list, OrderState.UNEXECUTED, 2, false, 288, 228, null, null,null,null,null);
		OrderVO order2 = new OrderVO("jske223","161124000021109", "161124", "161125","sje44",list, OrderState.UNEXECUTED, 2, false, 336, 258, null, null,null,null,null);
		List.add(order1);
		List.add(order2);
		
		return List;
	}

	@Override
	public ArrayList<OrderVO> filterSpecificUserHotelOrderList(String userID, String hotelId) {
		return null;
	}

	@Override
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllCredit) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> getWebDailyUnexecutedOrderList() {
		
		RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.BIGBED_ROOM,330,null,null);
		RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,330,null,null);
		ArrayList<RoomVO> list = new ArrayList<>();
		list.add(roomvo1);
		list.add(roomvo2);
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("267363HSHJ","161124000021109", "161124", "161125","837JFD",list, OrderState.UNEXECUTED, 2, false, 288, 228, null, null,null,null,null);
		OrderVO order2 = new OrderVO("jske223","161124000021109", "161124", "161125","sje44",list, OrderState.UNEXECUTED, 2, false, 336, 258, null, null,null,null,null);
		List.add(order1);
		List.add(order2);
		
		return List;
	}

	@Override
	public ArrayList<OrderVO> getWebDailyAbnormalOrderList() {
		RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.BIGBED_ROOM,330,null,null);
		RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,330,null,null);
		ArrayList<RoomVO> list = new ArrayList<>();
		list.add(roomvo1);
		list.add(roomvo2);
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("267363HSHJ","161124000021109", "161124", "161125","837JFD",list, OrderState.UNEXECUTED, 2, false, 288, 228, null, null,null,null,null);
		OrderVO order2 = new OrderVO("jske223","161124000021109", "161124", "161125","sje44",list, OrderState.UNEXECUTED, 2, false, 336, 258, null, null,null,null,null);
		List.add(order1);
		List.add(order2);
		
		return List;
	}

	@Override
	public boolean judgeCreditCanCreateOrder(String user_id) {
		return false;
	}

	@Override
	public ResultMessage undoUnexecutedOrder(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
}
