package Stub;

import Interface.EvaluationDataService;
import PO.AccountPO;
import PO.EvaluationPO;
import PO.ResultMessage;

public class EvaluationDataService_Stub implements EvaluationDataService {

	public ResultMessage add(EvaluationPO po) {
		return ResultMessage.Add_Success;
	}
	
	public ResultMessage modify(String id) {
		return ResultMessage.Modify_Success;
	}
	
	public ResultMessage delete(String id) {
		return ResultMessage.Delete_Success;
	}
	
	public EvaluationPO get(int order_id){
		return new EvaluationPO("123", "234", "非常棒！环境很好下次还要来！", 5);
	}
}
