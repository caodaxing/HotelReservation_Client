package logic.credit;

/**
 * 为order包的CreateOrder提供的接口，拿到credit值，判断能否生成订单
 * @author Mark.W
 */
public interface CreditInfo {
	
	public int getCredit(String userID);

}