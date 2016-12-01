package logic.credit;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.credit.CreditChangeService;
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
}
