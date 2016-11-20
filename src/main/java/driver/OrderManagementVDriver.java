package driver;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.OrderManagementService;
import vo.OrderVO;
import vo.RoomVO;

/**
 * OrderBLService 的 Driver
 * @author XueWang
 */
public class OrderManagementVDriver {
	
	public void drive(OrderManagementService orderManagementService){
		
		System.out.println("This is orderManagementServiceDriver");
		
		ArrayList<OrderVO> list0 = orderManagementService.getDailyOrderList();
		for(OrderVO o : list0){
			System.out.println(o);
		}
		
		RoomVO rvo = new RoomVO(1,2,3,"110");
		OrderVO ovo0 = new OrderVO("2016112001", "20161120" , rvo , "20161122", 1 , 2 , false , 200);
		ResultMessage result0 = orderManagementService.undoUnnormalOrder(ovo0);
		if(result0 == ResultMessage.SUCCESS){
			System.out.println("Undo success");
		}else if(result0 == ResultMessage.FAILURE){
			System.out.println("Undo fail");
		}else{
			System.out.println("Error");
		}
		
		ResultMessage result1 = orderManagementService.normalExecute("2016112001");
		if(result1 == ResultMessage.SUCCESS){
			System.out.println("Execute success");
		}else if(result1 == ResultMessage.FAILURE){
			System.out.println("Execute fail");
		}else{
			System.out.println("Error");
		}
		
		ResultMessage result2 = orderManagementService.autoSetUnnormal("2016112002");
		if(result2 == ResultMessage.SUCCESS){
			System.out.println("AutoSet success");
		}else if(result2 == ResultMessage.FAILURE){
			System.out.println("AutoSet fail");
		}else{
			System.out.println("Error");
		}
		
		ResultMessage result3 = orderManagementService.supplyOrder("2016112001");
		if(result3 == ResultMessage.SUCCESS){
			System.out.println("Supply success");
		}else if(result3 == ResultMessage.FAILURE){
			System.out.println("Supply fail");
		}else{
			System.out.println("Error");
		}
	
	}	

}
