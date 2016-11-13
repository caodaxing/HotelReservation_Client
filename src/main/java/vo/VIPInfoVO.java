package vo;

public class VIPInfoVO {
	
	String typeOfVIP;
	String levelOfVIP;
	
	/**
	 * 客户VIP的VO类
	 * @param typeOfVIP VIP的类型
	 * @param levelOfVIP VIP的等级
	 * @author Rukawa
	 */
	public VIPInfoVO(String typeOfVIP,String levelOfVIP){
		super();
		this.typeOfVIP = typeOfVIP;
		this.levelOfVIP = levelOfVIP;
	}
}
