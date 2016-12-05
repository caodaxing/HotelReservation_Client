package logic.mockObject;

import Message.ResultMessage;
import logic.credit.CreditChangeInfo;
import vo.CreditChangeVO;

public class MockCreditChangeInfo implements CreditChangeInfo {

	@Override
	public ResultMessage changeCredit(CreditChangeVO vo) {
		return ResultMessage.SUCCESS;
	}

}
