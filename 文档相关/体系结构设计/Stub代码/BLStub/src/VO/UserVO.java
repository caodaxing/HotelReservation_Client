package VO;

import java.util.ArrayList;

public class UserVO {
	
	long id;
	String name,contact;
	int credit;
	ArrayList<OrderVO> orderVO;
	
	public UserVO(long id, String name, String contact, int credit, ArrayList<OrderVO> orderVO) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.credit = credit;
		this.orderVO = orderVO;
	}
}
