package logic.utility;

import po.EvaluationPO;
import vo.EvaluationVO;

public class EvaluationTransform {

	public EvaluationPO evalutionTransToPO(EvaluationVO vo){
		
		if(vo == null) {
			return null;
		}
		
		return new EvaluationPO(vo.orderID, vo.commentLevel, vo.evaluationContent);
	}
	
	
	public EvaluationVO evalutionTransToVO(EvaluationPO po){
		
		if(po == null) {
			return null;
		}
		
		return new EvaluationVO(po.getOrderID(), po.getCommentLevel(), po.getEvaluationContent());
	}
}
