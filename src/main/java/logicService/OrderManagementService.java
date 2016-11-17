package logicService;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.OrderVO;

public interface OrderManagementService {
	
	public ArrayList<OrderVO> getDailyOrderList();
	
	public ResultMessage undoUnnormalOrder(OrderVO orderVO);
	
	public ResultMessage normalExecute(String order_id);
	
	public ResultMessage autoSetUnnormal(String order_id);
	
	public ResultMessage supplyOrder(String order_id);
	
}
