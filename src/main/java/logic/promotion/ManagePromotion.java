package logic.promotion;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import dataDao.promotion.PromotionDao;
import dataDao.stub.PromotionDao_Stub;
import logic.utility.PromotionTransform;
import logicService.promotion.PromotionService;
import po.PromotionPO;
import vo.PromotionVO;

public class ManagePromotion implements PromotionService, PromotionInfo{
	private PromotionDao promotionDao;
	private PromotionTransform promotionTrans;
	
	public ManagePromotion() {
		this.promotionDao = new PromotionDao_Stub();
		
		this.promotionTrans = new PromotionTransform();
	}

	@Override
	public ResultMessage addPromotion(PromotionVO vo) {
		if(vo != null) {
			PromotionPO po = this.promotionTrans.promotionTransToPO(vo);
			
			try {
				if(this.promotionDao.addPromotion(po)) {
					return ResultMessage.SUCCESS;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public PromotionVO getPromotion(String promotionID) {
		PromotionPO po = null;
		try {
			po = this.promotionDao.getPromotion(promotionID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.promotionTrans.promotionTransToVO(po);
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType) {
		
		ArrayList<PromotionPO> pos = null;
		try {
			pos = this.promotionDao.getHotelPromotions(hotelID, promotionType.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return this.promotionTrans.promotionListTransToVO(pos);
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType) {
		ArrayList<PromotionPO> pos = null;
		try {
			pos = this.promotionDao.getWebPromotions(promotionType.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return this.promotionTrans.promotionListTransToVO(pos);
	}

}
