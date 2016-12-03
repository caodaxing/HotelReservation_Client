package logicService.promotion;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import vo.PromotionVO;

public interface PromotionService {
	
	public ArrayList<PromotionVO> getPromotions(PromotionType promotionTypes);
	
	public ResultMessage addPromotion(PromotionVO promotionVO);
	
	public PromotionVO getPromotion(String promotionID);
	
}
