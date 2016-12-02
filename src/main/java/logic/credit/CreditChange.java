package logic.credit;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.credit.CreditChangeService;
import po.CreditHistoryPO;
import vo.CreditChangeVO;

public class CreditChange implements CreditChangeService{
	
	private String clientID;
	
	public CreditChange(String clientID) {
		this.clientID = clientID;
	}

	public ResultMessage changeCredit(CreditChangeVO vo){
		return ResultMessage.FAILURE;
	}
	
	public ArrayList<CreditChangeVO> getHistoryList(String userID){
		return null;
	}
	
	public CreditHistoryPO tranToPO(CreditChangeVO vo){
		CreditHistoryPO po = new CreditHistoryPO(vo.userID, vo.time, vo.orderID, vo.action, vo.cerditChange, vo.nowCredit);
	}
}
