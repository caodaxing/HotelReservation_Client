package logic.credit;

import Message.ResultMessage;
import vo.CreditChangeVO;

public interface CreditChangeInfo {
	
	public ResultMessage changeCredit(CreditChangeVO vo);
	
}
