package Stub;

import java.util.Date;

import VO.ResultMessage;
import VO.VIPInfoVO;

public class PromotionBLService_Stub {
	
	public VIPInfoVO justVIP(ResultMessage userstate , String username){
		return new VIPInfoVO("普通会员","3星会员");
	}
	
	public  double VIPdiscount(ResultMessage userstate , String username , String tradingarea , Date date , int number){
		return 0.15;
	}
}
