package PO;

import java.util.ArrayList;

public class ClientPO {
	String nameOfUser;
	String phoneNumber;
	String credit;
	OrderPO orderPO;
	ArrayList<String> recordOfHotel;
	
	public ClientPO(String nameOfUser,String phoneNumber,String credit,OrderPO orderPO,ArrayList<String> recordOfHotel) {
		super();
		this.nameOfUser=nameOfUser;
		this.phoneNumber=phoneNumber;
		this.credit=credit;
		this.orderPO=orderPO;
	}
}
