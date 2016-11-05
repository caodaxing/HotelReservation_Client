package logic.credit;

public class MockCredit extends Credit{
	int credit;
	int VIPCredit;
	
	public MockCredit (){
		this.credit = 0;
		this.VIPCredit = 100;
	}
	
	public int getCredit(String uer_ID){
		return credit;
	}
	
	public int getVIPCredit(){
		return VIPCredit;
	}
	
}
