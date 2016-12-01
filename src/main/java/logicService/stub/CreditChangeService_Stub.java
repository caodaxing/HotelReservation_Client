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

	public ResultMessage changeCredit(CreditChangeVO creditChangeVO) {
		return ResultMessage.FAILURE;
	}

	public ArrayList<CreditChangeVO> getHistoryList(String user_ID) {
		
//		ArrayList<CreditChangeVO> historyList = new ArrayList<CreditChangeVO>();
//		CreditChangeVO credit1 = new CreditChangeVO("100" , 50 , "2726skue");
//		CreditChangeVO credit2 = new CreditChangeVO("260" , -40 , "slfie226");
//		historyList.add(credit1);
//		historyList.add(credit2);
//		
//		return historyList;
		return null;
	}

}
