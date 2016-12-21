package logicService.promotion;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import vo.PromotionVO;

/**
 * 管理promotion的接口
 * @author Mark.W
 *
 */
public interface ManagePromotionService {
	
	/**
	 * 获取酒店促销策略
	 * @param hotelID
	 * @param promotionType
	 * @return
	 */
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType);
	
	/**
	 * 获取网站促销策略
	 * @param promotionType
	 * @return
	 */
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType);
	
	/**
	 * 添加促销策略
	 * @param promotionVO
	 * @return ResultMessage
	 */
	public ResultMessage addPromotion(PromotionVO promotionVO);
	
	/**
	 * 获取促销策略信息
	 * @param promotionID
	 * @return
	 */
	public PromotionVO getPromotion(String promotionID);
	
	/**
	 * 删除促销策略
	 * @param promotionID
	 * @return ResultMessage
	 */
	public ResultMessage deletePromotion(String promotionID);
	
}
