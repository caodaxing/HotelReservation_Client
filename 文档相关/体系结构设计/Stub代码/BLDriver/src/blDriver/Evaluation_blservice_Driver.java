package blDriver;

import client.businesslogicservice.Evaluation_blservice;

public class Evaluation_blservice_Driver {
	public void drive(Evaluation_blservice evaluation_blservice){
		System.out.println("This is evaluation_blservice_Driver");
		evaluation_blservice.getEvaluationInfo(1234567);
		evaluation_blservice.getEvaluations("123");
		evaluation_blservice.evaluate(12345678);
	}
}
