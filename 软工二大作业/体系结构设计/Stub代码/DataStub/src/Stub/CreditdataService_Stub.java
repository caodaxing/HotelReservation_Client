package Stub;

import Interface.CreditDataService;
import PO.CreditPO;
import PO.ResultMessage;

public class CreditdataService_Stub implements CreditDataService{
	public ResultMessage add(CreditPO po) {
		return ResultMessage.Add_Success;
	}
	
	public ResultMessage modify(CreditPO po) {
		return ResultMessage.Modify_Success;
	}
	
	public CreditPO find(String userId) {
		return new CreditPO("Bcy", 100, null);
	}
}
