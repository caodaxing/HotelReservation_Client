package logicService.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.credit.CreditChangeService;
import vo.CreditChangeVO;

public class CreditChangeService_Stub implements CreditChangeService{
	
	private String clientID;
	
	public CreditChangeService_Stub(String clientID) {
		super();
		this.clientID = clientID;
	}

	public ResultMessage rechargeCredit(CreditChangeVO creditChangeVO) {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<CreditChangeVO> getCreditHistory(String userID) {
		return null;
	}

}
