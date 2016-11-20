package driver;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.EvaluationService;
import vo.EvaluationVO;

/**
 * EvaluationBLService 的 Driver
 * @author XueWang
 */
public class EvaluationDriver {
	
	public void drive(EvaluationService evaluationService){
		
		System.out.println("This is EvalationServiceDriver");
		
		EvaluationVO evaluation = evaluationService.getEvaluationInfo("2016112001");
		System.out.println("Evaluation is : " + evaluation );
		
		ArrayList<EvaluationVO> list = evaluationService.getEvaluations("119");
		for(EvaluationVO e :list){
			System.out.println(e);
		}
		
		ResultMessage result = evaluationService.evaluate("2016112002");
		if(result == ResultMessage.SUCCESS){
			System.out.println("Evaluate success");
		}else if(result == ResultMessage.FAILURE){
			System.out.println("Evaluate fail");
		}
		
	}
	
}
