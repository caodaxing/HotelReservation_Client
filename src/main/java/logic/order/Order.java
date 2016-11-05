package logic.order;

import Message.CreditChange;
import Message.ResultMessage;
import vo.OrderVO;

public class Order {
	
	public ResultMessage undoOrder(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO getOrderInfo(String order_id){
		return null;
	}
	
	public String getEvaluation(String order_id){
		return null;
	}
	
	public int getCredit(String user_id){
		return 0;
	}
	
	public ResultMessage changeCredit(String user_id, CreditChange change, int number){
		return ResultMessage.SUCCESS;
	}
}


