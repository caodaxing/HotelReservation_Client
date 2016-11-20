package driver;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import logicService.OrderService;
import vo.EvaluationVO;
import vo.OrderVO;
import vo.RoomVO;

/**
 * OrderBLService 的 Driver
 * @author XueWang
 */
public class OrderDriver {
	
	public void drive(OrderService orderService){
		
		System.out.println("This is orderServiceDriver");
		
		RoomVO rvo = new RoomVO(1,2,3,"110");
		OrderVO ovo0 = new OrderVO("2016112001", "20161120" , rvo , "20161122", 1 , 2 , false , 200);
		OrderVO ovo1 = orderService.createOrder(ovo0);
		System.out.println(ovo1);
		
		ResultMessage result0 = orderService.undoOrder("2016112002");
		if(result0 == ResultMessage.SUCCESS){
			System.out.println("Undo success");
		}else if(result0 == ResultMessage.FAILURE){
			System.out.println("Undo fail");
		}else{
			System.out.println("Error");
		}
		
		OrderVO ovo2 = orderService.getOrderInfo("2016112001");
		System.out.println(ovo2);
		
		String evo = orderService.getEvaluation("2016112001");
		System.out.println(evo);
		
		ResultMessage result1 = orderService.judgeCredit("123");
		if(result1 == ResultMessage.SUCCESS){
			System.out.println("Judge success");
		}else if(result1 == ResultMessage.FAILURE){
			System.out.println("Judge fail");
		}else{
			System.out.println("Error");
		}
		
		ResultMessage result2 = orderService.changeCredit("123", CreditChange.INCREASEE, 123);
		if(result2 == ResultMessage.SUCCESS){
			System.out.println("CreditChange success");
		}else if(result2 == ResultMessage.FAILURE){
			System.out.println("CreditChange fail");
		}else{
			System.out.println("Error");
		}
		
		ArrayList<OrderVO> list = orderService.filterList();
		for(OrderVO o :list){
			System.out.println(o);
		}
		
	}
	
}
