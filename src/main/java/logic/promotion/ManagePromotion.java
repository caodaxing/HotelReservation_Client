package logic.promotion;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import dataDao.promotion.PromotionDao;
import logic.utility.PromotionTransform;
import logicService.promotion.ManagePromotionService;
import main.rmi.RemoteHelper;
import po.PromotionPO;
import vo.PromotionVO;

public class ManagePromotion implements ManagePromotionService, PromotionInfo{
	private PromotionDao promotionDao;
	private PromotionTransform promotionTrans;
	
	public ManagePromotion() {
		this.promotionTrans = new PromotionTransform();
		
		this.promotionDao = RemoteHelper.getInstance().getPromotionDao();
//		this.promotionDao = new PromotionDao_Stub();
	}

	@Override
	public ResultMessage addPromotion(PromotionVO vo) {
		
		if(vo != null) {
			
			//确定vo的id
			int num = 0;
			try {
				num = this.promotionDao.getPromotinoNum()+1;
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			if(vo.hotelID == null||vo.hotelID.equals("")) {
				vo.promotionID = "00000" +  String.format("%04d", num);
			} else {
				vo.promotionID = vo.hotelID +  String.format("%04d", num);
			}

			
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

	
	public PromotionVO getPromotion(String promotionID) {
		PromotionPO po = null;
		try {
			po = this.promotionDao.getPromotion(promotionID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po == null) {
			return null;
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

	@Override
	public ResultMessage deletePromotion(String promotionID) {
		try {
			if(this.promotionDao.deletePromotion(promotionID)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}

}
