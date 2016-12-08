package logic.promotion;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import dataDao.promotion.PromotionDao;
import dataDao.stub.PromotionDao_Stub;
import logic.utility.PromotionTransform;
import logicService.promotion.PromotionService;
import po.PromotionPO;
import vo.PromotionVO;

public class ManagePromotion implements PromotionService{
	private PromotionDao promotionDao;
	private PromotionTransform promotionTrans;
	
	public ManagePromotion() {
		this.promotionDao = new PromotionDao_Stub();
		this.promotionTrans = new PromotionTransform();
	}

	@Override
	public ResultMessage addPromotion(PromotionVO vo) {
		if(vo != null) {
			PromotionPO po = this.promotionTrans.promotionTransToVO(vo);
			
			if(this.promotionDao.addPromotion(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public PromotionVO getPromotion(String promotionID) {
		PromotionPO po = this.promotionDao.getPromotion(promotionID);
		return this.promotionTrans.promotionTransToVO(po);
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType) {
		
		ArrayList<PromotionPO> pos = this.promotionDao.getHotelPromotions(hotelID, promotionType.ordinal());
		
		return this.promotionTrans.promotionListTransToVO(pos);
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType) {
		ArrayList<PromotionPO> pos = this.promotionDao.getWebPromotions(promotionType.ordinal());
		
		return this.promotionTrans.promotionListTransToVO(pos);
	}

}
