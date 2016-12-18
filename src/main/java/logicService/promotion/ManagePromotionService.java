package logicService.promotion;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import vo.PromotionVO;

public interface ManagePromotionService {
	
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType);
	
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType);
	
	public ResultMessage addPromotion(PromotionVO promotionVO);
	
	public PromotionVO getPromotion(String promotionID);
	
	public ResultMessage deletePromotion(String promotionID);
	
}
