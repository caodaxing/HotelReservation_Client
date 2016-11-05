package logic.orderManagement;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.OrderVO;

public class OrderManagementController {
	ExecuteOrder executeOrder;
	ManageDailyOrders manageDailyOrder;
	ManageOrder manageOrder;
	
	public ArrayList<OrderVO> getDailyOrderList(){
		return manageDailyOrder.getDailyOrderList();
	}
	
	public ResultMessage undoUnnormalOrder(String order_id){
		return manageOrder.undoUnnormalOrder(order_id);
	}
	
	public ResultMessage normalExecute(String order_id){
		return executeOrder.normalExecute(order_id);
	}
	
	public ResultMessage autoSetUnnormal(String order_id){
		return executeOrder.autoSetUnnormal(order_id);
	}
	
	public ResultMessage supplyOrder(String order_id){
		return executeOrder.supplyOrder(order_id);
	}
}
