package logic.credit;

import java.util.ArrayList;
import java.util.Iterator;

import Message.ResultMessage;
import dataDao.CreditDao;
import dataDao.stub.CreditDao_Stub;
import logic.utility.CreditTransform;
import logicService.credit.CreditChangeService;
import po.CreditHistoryPO;
import vo.CreditChangeVO;

public class CreditChange implements CreditChangeService{
	
	private String clientID;
	private CreditDao creditDao;
	
	public CreditChange(String clientID) {
		this.clientID = clientID;
		creditDao = new CreditDao_Stub();
	}

	public ResultMessage changeCredit(CreditChangeVO vo){
		Credit credit = new Credit();
		if(vo == null || vo.userID == null || vo.time == null ||
				vo.orderID == null || vo.action == null ){
			return ResultMessage.FAILURE;
		}
		int nowCredit = credit.getCredit(vo.userID)+vo.cerditChange;
		CreditHistoryPO po = new CreditHistoryPO(vo.userID, vo.time, vo.orderID, vo.action.ordinal(), vo.cerditChange, nowCredit);
		creditDao.changeCredit(po);
		return ResultMessage.FAILURE;
	}
	
	public ArrayList<CreditChangeVO> getCreditHistory(String userID){
		ArrayList<CreditHistoryPO> historyPOList = creditDao.getCreditHistory(userID);
		ArrayList<CreditChangeVO> historyVOList = new ArrayList<>();
		for (Iterator<CreditHistoryPO> iterator = historyPOList.iterator(); iterator.hasNext();) {
			CreditHistoryPO creditHistoryPO = (CreditHistoryPO) iterator.next();
			historyVOList.add(CreditTransform.creditTransToVO(creditHistoryPO));
		}
		return historyVOList;
	}
	
}
