package logic.orderManagement;

import Message.ResultMessage;

public class ExecuteOrder {
	
	UpdateRoom updateRoom;
	
	public ResultMessage normalExecute(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage autoSetUnnormal(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage supplyOrder(String order_id){
		return ResultMessage.SUCCESS;
	}
}
