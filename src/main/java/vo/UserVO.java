package vo;

import java.util.ArrayList;

public class UserVO {
	
	String id;
	String name,contact;
	public int credit;
	ArrayList<OrderVO> orderVO;
	
	/**
	 * 客户的VO类
	 * @param id 客户Id
	 * @param name 客户姓名
	 * @param contact 客户联系方式
	 * @param credit 信用值
	 * @param orderVO 订单的VO类
	 * @author Rukawa
	 */
	public UserVO(String id, String name, String contact, int credit, ArrayList<OrderVO> orderVO) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.credit = credit;
		this.orderVO = orderVO;
	}
}
