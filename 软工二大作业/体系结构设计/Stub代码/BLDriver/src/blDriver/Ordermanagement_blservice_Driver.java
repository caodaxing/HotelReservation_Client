package blDriver;

import client.businesslogicservice.OrderManagement_blservice;

public class Ordermanagement_blservice_Driver {
	public void drive(OrderManagement_blservice orderManagement_blservice){
		System.out.println("This is orderManagement_blservice_Driver");
		orderManagement_blservice.undoUnnormalOrder(12334567);
		orderManagement_blservice.executeOrder(12345678);
		orderManagement_blservice.supplyOrder(123456789);
		orderManagement_blservice.setOrderUnnormal(1234567890);
	}
}
