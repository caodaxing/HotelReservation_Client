package logic.order;

import vo.OrderVO;

public class MockOrder extends Order{
	
	String orderid;
	
	public MockOrder(String orderid){
		super();
		this.orderid = orderid;
	}
	
	public OrderVO getOrderInfo(String Id) {
		
		System.out.println("getOrderInfo(String userid)方法已经调用");
		
		return null;
	}
	
}
