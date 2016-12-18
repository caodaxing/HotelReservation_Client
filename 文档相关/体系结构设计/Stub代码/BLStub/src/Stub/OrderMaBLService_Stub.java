package Stub;

import java.util.ArrayList;

import Interface.OrderManagementBLService;
import VO.OrderVO;
import VO.ResultMessage;
import VO.RoomVO;

public class OrderMaBLService_Stub implements OrderManagementBLService{
	public ResultMessage undoUnnormalOrder (int orderId) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage executeOrder (int orderId) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage supplyOrder (int orderId){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage setOrderUnnormal (int orderId){
		return ResultMessage.SUCCESS;
	}
}
