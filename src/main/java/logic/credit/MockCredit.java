package logic.credit;

/**
 * Credit的mock类
 * @author Xue.W
 */
public class MockCredit extends Credit{
	private String clientID;
	int credit;
	int VIPCredit;
	
	public MockCredit(String clientID) {
		super(clientID);
	}

	public int getCredit(String uer_ID){
		return credit;
	}
	
	public int getVIPCredit(){
		return VIPCredit;
	}
	
}
