package blDriver;

import client.businesslogicservice.Order_blservice;
import client.vo.OrderVO;

public class Order_blservice_Driver {
	public void drive(Order_blservice order_blservice , OrderVO order){
		System.out.println("This is order_blservice_Driver");
		order_blservice.getOrderList(12345,0);
		order_blservice.getOrderInfo(1234567);
		order_blservice.undoOrder(1234567);
		order_blservice.generateOrder(order);
	}
}
