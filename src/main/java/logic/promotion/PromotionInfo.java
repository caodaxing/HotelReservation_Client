package logic.promotion;

import vo.PromotionVO;


/**
 * 给hotel提供的接口 获取酒店信息
 * @author Mark.W
 *
 */
public interface PromotionInfo {

	public PromotionVO getPromotion(String promotionID);
	
}
