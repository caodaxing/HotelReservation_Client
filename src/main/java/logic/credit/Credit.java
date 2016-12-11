package logic.credit;

import Message.ResultMessage;
import dataDao.credit.CreditDao;
import dataDao.stub.CreditDao_Stub;
import logicService.credit.CreditService;

/**
 * 提供获取信用、设置和获取vip信用等级
 * @author bcy
 *
 */
public class Credit implements CreditInfo, CreditService{
	
	private CreditDao creditDao;
	
	public Credit() {
		this.creditDao = new CreditDao_Stub();
	}

	public int getCredit(String userID){
		return this.creditDao.getCredit(userID);					//该方法被其他包调用，不能访问成员变量获得。应该直接拉取数据库。
	}
	
	public ResultMessage setVIPCredit(int level, int credit_num){
		if(this.creditDao.setVIPCredit(level, credit_num)) {
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	public int getVIPCredit(int level){
		return this.getVIPCredit(level);
	}
	
}
