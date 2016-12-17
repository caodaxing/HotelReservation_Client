package logic.credit;

import java.rmi.RemoteException;

import Message.ResultMessage;
import dataDao.credit.CreditDao;
import dataDao.stub.CreditDao_Stub;
import logicService.credit.CreditService;

/**
 * 提供获取信用、设置和获取vip信用等级
 * @author bcy
 */
public class Credit implements CreditInfo, CreditService{
	
	public static int INIT_CREDIT_NUM = 1000;
	private CreditDao creditDao;
	
	public Credit() {
		this.creditDao = new CreditDao_Stub();
	}

	public int getCredit(String userID){
		int cre = 0;
		try {
			cre =  this.creditDao.getCredit(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return cre;					
	}
	
	public ResultMessage setVIPCredit(int level, int credit_num){
		try {
			if(this.creditDao.setVIPCredit(level, credit_num)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}
	
	public int getVIPCredit(int level){
		int vipcre = 0;
		try {
			vipcre =  this.creditDao.getVIPCredit(level);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return vipcre;
	}
	
}
