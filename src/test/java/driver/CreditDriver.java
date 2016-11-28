package driver;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import logicService.CreditService;
import vo.CreditVO;

/**
 * CreditBLService 的 Driver
 * @author XueWang
 */
public class CreditDriver {
	
	public void drive(CreditService creditService){
		
		System.out.println("This is CreditServiceDriver");
	
		ResultMessage result0 = creditService.changeCredit("123", CreditChange.INCREASEE, 100);
		if(result0 == ResultMessage.FAILURE){
			System.out.println("CreditChange fail");
		}else if(result0 == ResultMessage.SUCCESS){
			System.out.println("CreditChange success");
		}
		
		int credit = creditService.getCredit("123");
		System.out.println("Credit is " + credit);
		
		ArrayList<CreditVO> list = creditService.getHistoryList("123");
		for(CreditVO c:list){
			System.out.println(c);
		}
		
		ResultMessage result1 = creditService.setVIPCredit();
		if(result1 == ResultMessage.SUCCESS){
			System.out.println("SetVIPCredit success");
		}else if(result1 == ResultMessage.FAILURE){
			System.out.println("SetVIPCredit fail");
		}else{
			System.out.println("Error");
		}
		
	}

}
