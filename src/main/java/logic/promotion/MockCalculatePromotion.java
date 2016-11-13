package logic.promotion;

import vo.OrderVO;

public class MockCalculatePromotion extends CalculatePromotion{
	
	public double calculate(OrderVO order){
		return 0;
	}
}
