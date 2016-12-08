package logic.utility;

import java.util.ArrayList;

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


	public ArrayList<EvaluationVO> evalutionListTransToVO(ArrayList<EvaluationPO> pos) {
		if(pos == null) {
			return null;
		}
	
		ArrayList<EvaluationVO> vos = new ArrayList<EvaluationVO>();
		
		for(int i=0; i<pos.size(); ++i) {
			vos.add(this.evalutionTransToVO(pos.get(i)));
		}
		
		return vos;
	}
}
