package logic.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.OrderManagementService;
import vo.OrderVO;

public class OrderManagementBLService_Stub implements OrderManagementService{

	public ArrayList<OrderVO> getDailyOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage undoUnnormalOrder(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage normalExecute(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage autoSetUnnormal(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage supplyOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}
//	public ResultMessage undoUnnormalOrder (int orderId) {
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage executeOrder (int orderId) {
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage supplyOrder (int orderId){
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage setOrderUnnormal (int orderId){
//		return ResultMessage.SUCCESS;
//	}
}
