package logic.promotion;

import vo.OrderVO;

public class MockCalculatePromotion extends CalculatePromotion{
	double price;
	
	public MockCalculatePromotion (double p){
		p = price;
	}
	
	public double calculate(OrderVO order){
		return 0;
	}
}
