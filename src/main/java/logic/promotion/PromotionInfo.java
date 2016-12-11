package logic.promotion;

import vo.PromotionVO;


/**
 * 给order提供的接口 获取促销信息
 * @author Mark.W
 *
 */
public interface PromotionInfo {

	public PromotionVO getPromotion(String promotionID);
	
}
