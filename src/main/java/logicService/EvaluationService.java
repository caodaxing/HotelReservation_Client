package logicService;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.EvaluationVO;

public interface EvaluationService {
	
	public EvaluationVO getEvaluationInfo (String orderId);
	
	public ArrayList<EvaluationVO> getEvaluations (String hotelId);
	
	public ResultMessage evaluate (String orderId);
}
