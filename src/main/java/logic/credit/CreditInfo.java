package logic.credit;

/**
 * 为order提供的调用的接口，拿到credit值
 * @author Mark.W
 *
 */
public interface CreditInfo {
	
	public int getCredit(String user_ID);

}