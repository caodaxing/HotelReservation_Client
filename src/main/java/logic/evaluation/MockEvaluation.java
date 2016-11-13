package logic.evaluation;

import vo.EvaluationVO;

/**
 * 评价的Mock类
 * @author Rukawa
 *
 */
public class MockEvaluation extends Evaluation{
	
	EvaluationVO evaluationInfo;
	
	/**
	 * 评价Mock类返回评价信息
	 * @param eva
	 * @author Rukawa
	 */
	public MockEvaluation (EvaluationVO eva){
		eva = evaluationInfo;
	}
	
	/**
	 * 获取酒店评价信息
	 * @return 酒店评价信息的VO类
	 * @author Rukawa
	 */
	public EvaluationVO getEvaluationInfo(){
		return evaluationInfo;
	}
}
