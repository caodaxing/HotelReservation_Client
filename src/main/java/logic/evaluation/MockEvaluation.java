package logic.evaluation;

import vo.EvaluationVO;

public class MockEvaluation extends Evaluation{
	EvaluationVO evaluationInfo;
	public MockEvaluation (EvaluationVO eva){
		eva = evaluationInfo;
	}
	public EvaluationVO getEvaluationInfo(){
		return evaluationInfo;
	}
}
