package vo;

import java.util.ArrayList;

public class UserVO {
	
	String id;
	String name,contact;
	public int credit;
	ArrayList<OrderVO> orderVO;
	
	public UserVO(String id, String name, String contact, int credit, ArrayList<OrderVO> orderVO) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.credit = credit;
		this.orderVO = orderVO;
	}
}
