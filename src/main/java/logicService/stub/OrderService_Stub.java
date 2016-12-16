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
import vo.PromotionVO;
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
		String[] s = {"9832","8924"};
		PromotionVO promotionVO = new PromotionVO("sdjoiew", "kjsfoiweo2", "skfioew", 0.9, "160205", "160207");
//		return new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
		return new OrderVO("12345","12345",RoomType.BIGBED_ROOM,s,2,"22","33","12345",OrderState.UNEXECUTED,3,true,333,222,promotionVO,"8","22","33","22","44");
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
		String[] room = {"0320", "8323", "2823"};
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		PromotionVO promotionVO = new PromotionVO("sdjoiew", "kjsfoiweo2", "skfioew", 0.9, "160205", "160207");
		
		if(condition == OrderListCondition.ALL_ORDERS){
//		RoomVO roomvo1 = new RoomVO("ks3322",RoomType.SINGLE_ROOM,330);
//		RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,922);
//		RoomVO roomvo3 = new RoomVO("kjsf333","5365",RoomType.BIGBED_ROOM,330);
//		RoomVO roomvo4 = new RoomVO("nnvdj33","8437",RoomType.BIGBED_ROOM,666);
//		RoomVO roomvo5 = new RoomVO("nvnjd","9843",RoomType.BIGBED_ROOM,330);
//		RoomVO roomvo6 = new RoomVO("mskoe22","0943",RoomType.BIGBED_ROOM,330);
//		RoomVO roomvo7 = new RoomVO("nxkse321","0039",RoomType.BIGBED_ROOM,637);
//		RoomVO roomvo8 = new RoomVO("nkskdk12","4647",RoomType.BIGBED_ROOM,843);
//		ArrayList<RoomVO> list = new ArrayList<>();
//		list.add(roomvo1);
//		list.add(roomvo2);
//		list.add(roomvo3);
//		list.add(roomvo4);
//		list.add(roomvo5);
//		list.add(roomvo6);
//		list.add(roomvo7);
//		list.add(roomvo8);
		
		OrderVO order1 = new OrderVO("267363HSHJ","161124000021103", RoomType.SINGLE_ROOM, room, 1, "161124", "161122","837JFD",OrderState.ABNORMAL, 2, false, 288, 228, promotionVO,"160204", "160205",null,null,null);
		OrderVO order2 = new OrderVO("7838738489","161124000021109", RoomType.STANDARD_ROOM, room, 2, "161124", "161125","sje44", OrderState.ABNORMAL, 2, false, 336, 258, promotionVO, "160727", "160729",null,null,null);
		OrderVO order3 = new OrderVO("sikenflks23","161124000021109", RoomType.BIGBED_ROOM, room, 1, "160304", "160308","sddj1", OrderState.UNEXECUTED, 2, false, 336, 258, promotionVO, "160204", "160205",null,null,null);
		OrderVO order4 = new OrderVO("vmdkjj2233","161124000021109", RoomType.BIGBED_ROOM, room, 1,"161124", "161125","ieuii", OrderState.UNEXECUTED, 2, false, 336, 258, null, "160204", "160205",null,null,null);
		OrderVO order5 = new OrderVO("0sjskeii0","161124000021109", RoomType.BIGBED_ROOM, room, 1, "161124", "161125","o3dkm", OrderState.UNDOED_ABNORMAL, 2, false, 336, 258, null, "160204", "160205",null,null,null);
		OrderVO order6 = new OrderVO("jske223","161124000021109", RoomType.SINGLE_ROOM, room, 1,"161124", "161125","sje44", OrderState.UNEXECUTED, 2, false, 336, 258, null, "160204", "160205",null,null,null);
		OrderVO order7 = new OrderVO("jsklsei","161124000021109",RoomType.BIGBED_ROOM, room, 2, "161124", "161125","klkse", OrderState.UNDOED_ABNORMAL, 2, false, 336, 258, null, "160204", "160205",null,null,null);
		OrderVO order8 = new OrderVO("jske223","161124000021109", RoomType.SINGLE_ROOM, room, 2, "161124", "161125","sje44", OrderState.EXECUTED, 2, false, 336, 258, null, "160204", "160205",null,null,null);
		List.add(order1);
		List.add(order2);
		List.add(order3);
		List.add(order4);
		List.add(order5);
		List.add(order6);
		List.add(order7);
		List.add(order8);
		}else if(condition == OrderListCondition.ABNORMALED){
//			RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.SINGLE_ROOM,330,null);
//			RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,922,null);
//			ArrayList<RoomVO> list = new ArrayList<>();
//			list.add(roomvo1);
//			list.add(roomvo2);
			OrderVO order1 = new OrderVO("267363HSHJ","161124000021103", RoomType.SINGLE_ROOM, room, 1, "161124", "161122","837JFD",OrderState.ABNORMAL, 2, false, 288, 228, promotionVO,"160204", "160205",null,null,"03999");
			OrderVO order2 = new OrderVO("7838738489","161124000021109", RoomType.STANDARD_ROOM, room, 2, "161124", "161125","sje44", OrderState.ABNORMAL, 2, false, 336, 258, promotionVO, "160727", "160729",null,null,"03999");
			List.add(order1);
			List.add(order2);
		}else if(condition == OrderListCondition.EXECUTED){
//			RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.SINGLE_ROOM,330,null);
//			RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,922,null);
//			RoomVO roomvo3 = new RoomVO("kjsf333","5365",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo4 = new RoomVO("nnvdj33","8437",RoomType.BIGBED_ROOM,666,null);
//			RoomVO roomvo5 = new RoomVO("nvnjd","9843",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo6 = new RoomVO("mskoe22","0943",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo7 = new RoomVO("nxkse321","0039",RoomType.BIGBED_ROOM,637,null);
//			RoomVO roomvo8 = new RoomVO("nkskdk12","4647",RoomType.BIGBED_ROOM,843,null);
//			ArrayList<RoomVO> list = new ArrayList<>();
//			list.add(roomvo1);
//			list.add(roomvo2);
//			list.add(roomvo3);
//			list.add(roomvo4);
//			list.add(roomvo5);
//			list.add(roomvo6);
//			list.add(roomvo7);
//			list.add(roomvo8);
			OrderVO order8 = new OrderVO("jske223","161124000021109", RoomType.BIGBED_ROOM, room, 2, "161124", "161125","sje44", OrderState.EXECUTED, 2, false, 336, 258, promotionVO, "160204", "160205",null,null,"03999");
			List.add(order8);
		}else if(condition == OrderListCondition.UNDO_UNEXECUTED){
//			RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.SINGLE_ROOM,330,null);
//			RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,922,null);
//			RoomVO roomvo3 = new RoomVO("kjsf333","5365",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo4 = new RoomVO("nnvdj33","8437",RoomType.BIGBED_ROOM,666,null);
//			RoomVO roomvo5 = new RoomVO("nvnjd","9843",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo6 = new RoomVO("mskoe22","0943",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo7 = new RoomVO("nxkse321","0039",RoomType.BIGBED_ROOM,637,null);
//			RoomVO roomvo8 = new RoomVO("nkskdk12","4647",RoomType.BIGBED_ROOM,843,null);
//			ArrayList<RoomVO> list = new ArrayList<>();
//			list.add(roomvo1);
//			list.add(roomvo2);
//			list.add(roomvo3);
//			list.add(roomvo4);
//			list.add(roomvo5);
//			list.add(roomvo6);
//			list.add(roomvo7);
//			list.add(roomvo8);
			OrderVO order8 = new OrderVO("jske223","161124000021109", RoomType.BIGBED_ROOM, room, 1, "161124", "161125","sje44", OrderState.UNDOED_UNEXECUTED, 2, false, 336, 258, promotionVO, "160204", "160205",null,null,"03999");
			List.add(order8);
		}else if(condition == OrderListCondition.UNEXECUTED){
//			RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.SINGLE_ROOM,330,null);
//			RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,922,null);
//			RoomVO roomvo3 = new RoomVO("kjsf333","5365",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo4 = new RoomVO("nnvdj33","8437",RoomType.BIGBED_ROOM,666,null);
//			RoomVO roomvo5 = new RoomVO("nvnjd","9843",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo6 = new RoomVO("mskoe22","0943",RoomType.BIGBED_ROOM,330,null);
//			RoomVO roomvo7 = new RoomVO("nxkse321","0039",RoomType.BIGBED_ROOM,637,null);
//			RoomVO roomvo8 = new RoomVO("nkskdk12","4647",RoomType.BIGBED_ROOM,843,null);
//			ArrayList<RoomVO> list = new ArrayList<>();
//			list.add(roomvo1);
//			list.add(roomvo2);
//			list.add(roomvo3);
//			list.add(roomvo4);
//			list.add(roomvo5);
//			list.add(roomvo6);
//			list.add(roomvo7);
//			list.add(roomvo8);
			OrderVO order8 = new OrderVO("jske223","161124000021109", RoomType.SINGLE_ROOM, room, 1,"161124", "161125","sje44", OrderState.UNEXECUTED, 2, false, 336, 258, promotionVO, "160209", "160210",null,null,"03999");
			List.add(order8);
		}
		
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
		
		String[] room = {"0320", "8323", "2823"};
		PromotionVO promotionVO = new PromotionVO("sdjoiew", "kjsfoiweo2", "skfioew", 0.9, "160205", "160207");
//		RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.BIGBED_ROOM,330,null);
//		RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,330,null);
//		ArrayList<RoomVO> list = new ArrayList<>();
//		list.add(roomvo1);
//		list.add(roomvo2);
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("267363HSHJ","161124000021109", RoomType.SINGLE_ROOM, room, 1,"161124", "161125","837JFD", OrderState.UNEXECUTED, 2, false, 288, 228, promotionVO, "160204", "160205",null,null,"03999");
		OrderVO order2 = new OrderVO("jske223","161124000021109", RoomType.SINGLE_ROOM, room, 1,"161124", "161125","sje44", OrderState.UNEXECUTED, 2, false, 336, 258, promotionVO, "160204", "160205",null,null,"03999");
		List.add(order1);
		List.add(order2);
		
		return List;
	}

	@Override
	public ArrayList<OrderVO> getWebDailyAbnormalOrderList() {
		String[] room = {"0320", "8323", "2823"};
		PromotionVO promotionVO = new PromotionVO("sdjoiew", "kjsfoiweo2", "skfioew", 0.9, "160205", "160207");
//		RoomVO roomvo1 = new RoomVO("ks3322","8373",RoomType.BIGBED_ROOM,330,null);
//		RoomVO roomvo2 = new RoomVO("skje233","2455",RoomType.BIGBED_ROOM,330,null);
//		ArrayList<RoomVO> list = new ArrayList<>();
//		list.add(roomvo1);
//		list.add(roomvo2);
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("267363HSHJ","161124000021109", RoomType.SINGLE_ROOM, room, 1,"161124", "161125","837JFD", OrderState.UNEXECUTED, 2, false, 288, 228, promotionVO, "160204", "160205",null,null,"03999");
		OrderVO order2 = new OrderVO("jske223","161124000021109",  RoomType.SINGLE_ROOM, room, 1, "161124", "161125","sje44", OrderState.UNEXECUTED, 2, false, 336, 258, promotionVO, "160204", "160205",null,null,"03999");
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
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkOut(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage normalExecute(String orderID, String[] roomID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage supplyOrder(String orderID, String[] roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage hacCheckOut(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
