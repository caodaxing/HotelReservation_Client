package logicService.stub;

import java.util.ArrayList;
import Message.ResultMessage;
import logicService.EvaluationService;
import vo.EvaluationVO;

public class EvaluationService_Stub implements EvaluationService{

	public EvaluationVO getEvaluationInfo(String orderId) {
		// TODO Auto-generated method stub
		
		return new EvaluationVO("房间很乱，差评！！", "00102", "161222001021033", 0);
	}

	public ArrayList<EvaluationVO> getEvaluations(String hotelId) {
		// TODO Auto-generated method stub
		
		ArrayList<EvaluationVO> List = new ArrayList<EvaluationVO>();
		EvaluationVO evaluation1 = new EvaluationVO("房间很乱，差评！！", "00102", "161222001021033", 0);
		EvaluationVO evaluation2 = new EvaluationVO("房间整洁，好评！", "01729", "161127017290403", 3);
		List.add(evaluation1);
		List.add(evaluation2);
		
		return List;
	}

	public ResultMessage evaluate(String orderId) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}
	
}
