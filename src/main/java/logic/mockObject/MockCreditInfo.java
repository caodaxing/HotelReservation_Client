package logic.mockObject;

import logic.credit.CreditInfo;

public class MockCreditInfo implements CreditInfo{

	@Override
	public int getCredit(String userID) {
		return 0;
	}

}
