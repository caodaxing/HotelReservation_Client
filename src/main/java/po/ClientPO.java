package po;

import java.util.ArrayList;

public class ClientPO {
	
	String nameOfUser;
	String phoneNumber;
	String credit;
	OrderPO orderPO;
	ArrayList<String> recordOfHotel;
	
	/**
	 * 客户的PO类
	 * @param nameOfUser 客户姓名
	 * @param phoneNumber 客户手机号
	 * @param credit 客户信用
	 * @param orderPO 订单的PO类
	 * @param recordOfHotel 预订酒店历史纪录
	 * @author Rukawa
	 */ 
	public ClientPO(String nameOfUser,String phoneNumber,String credit,OrderPO orderPO,ArrayList<String> recordOfHotel) {
		super();
		this.nameOfUser=nameOfUser;
		this.phoneNumber=phoneNumber;
		this.credit=credit;
		this.orderPO=orderPO;
	}
}
