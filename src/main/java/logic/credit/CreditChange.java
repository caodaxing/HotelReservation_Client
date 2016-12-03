package logic.credit;

import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.CreditDao;
import dataDao.stub.CreditDao_Stub;
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
	
	public ArrayList<CreditChangeVO> getHistoryList(String userID){
		return null;
	}
	
}
