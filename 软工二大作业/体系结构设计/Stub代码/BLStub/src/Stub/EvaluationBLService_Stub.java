package Stub;

import java.util.ArrayList;

import Interface.EvaluationBLService;
import VO.EvaluationVO;
import VO.ResultMessage;

public class EvaluationBLService_Stub implements EvaluationBLService{
	public EvaluationVO getEvaluationInfo (int orderId) {
		return new EvaluationVO("舒服，实惠", "rj211", "124143", 5);
	}
	
	public ArrayList<EvaluationVO> getEvaluations (String hotelId) {
		ArrayList<EvaluationVO> evaluations = new ArrayList<EvaluationVO>();
		evaluations.add(new EvaluationVO("舒服，实惠", "rj211", "124143", 5));
		evaluations.add(new EvaluationVO("床睡的很舒服", "glht111", "124143", 4));
		return evaluations;
	}
	
	public ResultMessage evaluate (int orderId) {
		return ResultMessage.SUCCESS;
	}
}
