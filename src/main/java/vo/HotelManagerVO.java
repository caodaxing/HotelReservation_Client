package vo;

public class HotelManagerVO {
	
	String id;
	String name;
	String info;
	
	/**
	 * 酒店管理人员的VO类
	 * @param id 酒店管理人员id
	 * @param name 酒店管理人员姓名
	 * @param info 酒店管理人员信息
	 * @author Rukawa
	 */
	public HotelManagerVO(String id, String name, String info) {
		this.id = id ;
		this.name = name ;
		this.info = info ;
	}
	
}
