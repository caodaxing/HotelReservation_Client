package logic.order;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import vo.OrderVO;

public class Order {
	
	CreateOrder createOrder;
//	EvaluationInfo evaluation;
//	CreditInfo credit;
	
	public ResultMessage undoOrder(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO getOrderInfo(String order_id){
		return null;
	}
	
	public String getEvaluation(String order_id){
//		return evaluation.getEvaluatino(order_id);
		return null;
	}
	
	public int getCredit(String user_id){
//		return credit.getCredit;
		return 0;
	}
	
	public ResultMessage changeCredit(String user_id, CreditChange change, int number){
		return ResultMessage.SUCCESS;
	}
	
	public ArrayList<Order> getOrderList(String user_id){
		return null;
	}
	
	public OrderVO createOrder(OrderVO order){
		return createOrder.createOrder(order);
	}
	
}


