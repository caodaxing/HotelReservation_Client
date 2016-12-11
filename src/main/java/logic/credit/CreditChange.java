package logic.credit;

import java.util.ArrayList;
import java.util.Iterator;

import Message.CreditChangeType;
import Message.ResultMessage;
import dataDao.credit.CreditDao;
import dataDao.stub.CreditDao_Stub;
import logic.user.Client;
import logic.user.UpdateClientVip;
import logic.utility.CreditTransform;
import logicService.credit.CreditChangeService;
import po.CreditHistoryPO;
import vo.CreditChangeVO;

/**
 * 提供修改信用、获取信用记录的方法
 * @author bcy
 *
 */
public class CreditChange implements CreditChangeService, CreditChangeInfo {
	
	private CreditDao creditDao;
	private UpdateClientVip updateVip;
	private int[] low = new int[3];
	private int[] high = new int[3]; 
	private int[] lev = new int[3];
	
	public CreditChange() {
		this.updateVip = new Client();
		this.initTable();
		
		creditDao = new CreditDao_Stub();
	}

	private void initTable() {
		int level1 = this.creditDao.getVIPCredit(1);
		int level2 = this.creditDao.getVIPCredit(2);
		int level3 = this.creditDao.getVIPCredit(3);
		
		low[0] = 0;
		low[1] = level1;
		low[2] = level2;
		
		high[0] = level1;
		high[1] = level2;
		high[2] = level3;
		
		lev[0] = 1;
		lev[1] = 2;
		lev[2] = 3;
	}
	
	public ResultMessage changeCredit(CreditChangeVO vo){
		Credit credit = new Credit();
		
		if(vo == null || vo.userID == null || vo.time == null ||
				vo.orderID == null || vo.action == null ){
			return ResultMessage.FAILURE;
		}
		
		int nowCredit = credit.getCredit(vo.userID)+vo.cerditChange;
		
		CreditHistoryPO po = new CreditHistoryPO(vo.userID, vo.time, vo.orderID, 
				vo.action.ordinal(), vo.cerditChange, nowCredit);
		
		if(creditDao.changeCredit(po)) {
			this.judgeVipLevelChange(vo.userID, nowCredit);
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	//表驱动,根据信用址更改用户vip信息
	private void judgeVipLevelChange(String userID, int nowCredit) {
		int level = 0;
		
		for(int i=0; i< low.length; ++i) {
			if(nowCredit >= low[i] && nowCredit <= high[i]) {
				level = this.lev[i];
			}
		}
		
		this.updateVip.updateClientVip(userID, level);
	}
	
	public ArrayList<CreditChangeVO> getCreditHistory(String userID){
		ArrayList<CreditHistoryPO> historyPOList = creditDao.getCreditHistory(userID);
		ArrayList<CreditChangeVO> historyVOList = new ArrayList<>();
		
		for (Iterator<CreditHistoryPO> iterator = historyPOList.iterator(); iterator.hasNext();) {
			CreditHistoryPO creditHistoryPO = (CreditHistoryPO) iterator.next();
			
			historyVOList.add(CreditTransform.creditTransToVO(creditHistoryPO));
		}
		
		return historyVOList;
	}
	
	public ResultMessage rechargeCredit(CreditChangeVO vo){
		Credit credit = new Credit();
		
		if(vo == null || vo.userID == null || vo.time == null || vo.action !=CreditChangeType.RECHARGE_CREDIT ){
			return ResultMessage.FAILURE;
		}
		
		int nowCredit = credit.getCredit(vo.userID)+vo.cerditChange;
		
		CreditHistoryPO po = new CreditHistoryPO(vo.userID, vo.time, vo.orderID, vo.action.ordinal(), vo.cerditChange, nowCredit);
		
		if(creditDao.changeCredit(po)) {
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE; 
		
	}
}
