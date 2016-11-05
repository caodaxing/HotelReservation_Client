package logic.credit;

public class MockCredit extends Credit{
	int credit;
	int VIPCredit;
	
	public MockCredit (){
		this.credit = 0;
		this.VIPCredit = 100;
	}
	
	int getCredit(String uer_ID){
		return credit;
	}
	
	int getVIPCredit(){
		return VIPCredit;
	}
	
}
