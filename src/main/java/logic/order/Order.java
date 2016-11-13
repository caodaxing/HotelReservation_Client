package logic.order;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import logic.evaluation.EvaluationList;
import vo.EvaluationVO;
import vo.OrderVO;

public class Order {
	
	CreateOrder createOrder;
	EvaluationList evaluationlist;
//	CreditInfo credit;
	
	public ResultMessage undoOrder(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO getOrderInfo(String order_id){
		return null;
	}
	
	public ArrayList<EvaluationVO> getEvaluation(String order_id){
		return evaluationlist.show(order_id);
	}
	
	public ResultMessage judgeCredit(String user_id){
//		return credit.getCredit;
		return ResultMessage.SUCCESS;
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


