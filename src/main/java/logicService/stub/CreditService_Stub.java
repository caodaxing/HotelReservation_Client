package logicService.stub;

import Message.ResultMessage;
import logicService.credit.CreditService;

public class CreditService_Stub implements CreditService{
	
	
	public int getCredit(String user_ID) {
		return 100;
	}

	@Override 
	public ResultMessage setVIPCredit(int level, int credit_num) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getVIPCredit(int level) {
		return 0;
	}
}
