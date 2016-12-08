package logic.promotion;

import vo.OrderVO;
import vo.PromotionVO;

/**
 * 所有promotion类的抽象接口 策略模式
 * @author Mark.W
 *
 */
public interface Promotion {

	public boolean judgePromotion(OrderVO orderVO);
	
	public OrderVO calculate(OrderVO vo);
	
	public PromotionVO changeToVO();
}
