package logicService.stub;

import java.util.ArrayList;
import Message.CreditChange;
import Message.ResultMessage;
import logicService.CreditService;
import vo.CreditVO;

public class CreditService_Stub implements CreditService{
	
	public ResultMessage changeCredit(String user_ID, CreditChange change, int number) {
		return ResultMessage.FAILURE;
	}

	public int getCredit(String user_ID) {
		return 100;
	}

	public ArrayList<CreditVO> getHistoryList(String user_ID) {
		
		ArrayList<CreditVO> historyList = new ArrayList<CreditVO>();
		CreditVO credit1 = new CreditVO("100" , 50 , "2726skue");
		CreditVO credit2 = new CreditVO("260" , -40 , "slfie226");
		historyList.add(credit1);
		historyList.add(credit2);
		
		return historyList;
	}


	@Override
	public ResultMessage setVIPCredit() {
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getVIPCredit(String userId) {
		return 0;
	}
}
