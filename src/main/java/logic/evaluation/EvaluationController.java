package logic.evaluation;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.EvaluationVO;

public class EvaluationController {
	
	Evaluation evaluation;
	EvaluationList evaluationList;
	
	public EvaluationVO getEvaluationInfo (String orderId){
		return evaluation.getEvaluationInfo(orderId);
	}
	
	public ArrayList<EvaluationVO> getEvaluations (String hotelId){
		return evaluationList.getEvaluations(hotelId);
	}
	
	public ResultMessage evaluate (String orderId){
		return evaluation.evaluate(orderId);
	}
}
