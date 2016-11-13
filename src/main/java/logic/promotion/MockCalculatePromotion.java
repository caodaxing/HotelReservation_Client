package logic.promotion;

import vo.OrderVO;
/**
 * Mock类计算order价格
 * @author Rukawa
 *
 */
public class MockCalculatePromotion extends CalculatePromotion{
	
	public double calculate(OrderVO order){
		return 0;
	}
}
