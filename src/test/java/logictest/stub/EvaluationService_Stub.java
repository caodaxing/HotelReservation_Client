package logictest.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.EvaluationService;
import vo.EvaluationVO;

public class EvaluationService_Stub implements EvaluationService{

	public EvaluationVO getEvaluationInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EvaluationVO> getEvaluations(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage evaluate(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
//	public EvaluationVO getEvaluationInfo (int orderId) {
//		return new EvaluationVO("舒服，实惠", "rj211", "124143", 5);
//	}
//	
//	public ArrayList<EvaluationVO> getEvaluations (String hotelId) {
//		ArrayList<EvaluationVO> evaluations = new ArrayList<EvaluationVO>();
//		evaluations.add(new EvaluationVO("舒服，实惠", "rj211", "124143", 5));
//		evaluations.add(new EvaluationVO("床睡的很舒服", "glht111", "124143", 4));
//		return evaluations;
//	}
//	
//	public ResultMessage evaluate (int orderId) {
//		return ResultMessage.SUCCESS;
//	}
}
