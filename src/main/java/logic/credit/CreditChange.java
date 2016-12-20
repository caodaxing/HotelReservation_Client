package logic.credit;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.CreditChangeType;
import Message.ResultMessage;
import dataDao.credit.CreditDao;
import logic.user.Client;
import logic.user.UpdateClientVip;
import logic.utility.CreditTransform;
import logicService.credit.CreditChangeService;
import main.rmi.RemoteHelper;
import po.CreditHistoryPO;
import vo.CreditChangeVO;

/**
 * 提供修改信用、获取信用记录的方法
 * @author bcy
 */
public class CreditChange implements CreditChangeService, CreditChangeInfo {
	
	private CreditDao creditDao;
	private UpdateClientVip updateVip;
	private int[] low = new int[4];
	private int[] high = new int[4]; 
	private int[] lev = new int[4];
	
	public CreditChange() {
		this.updateVip = new Client();
		creditDao = RemoteHelper.getInstance().getCreditDao();
//		creditDao = new CreditDao_Stub();
	}

	public ResultMessage changeCredit(CreditChangeVO vo){
		Credit credit = new Credit();
		
		if(vo == null || vo.userID == null || vo.time == null || vo.action == null ){
			return ResultMessage.FAILURE;
		}
		
		int nowCredit = 0;
		
		if(vo.action != CreditChangeType.INIT_CREDIT) {
			if(vo.action == CreditChangeType.RECHARGE_CREDIT) {
				vo.cerditChange = vo.cerditChange * 100;
				nowCredit = credit.getCredit(vo.userID)+vo.cerditChange;
			} else {
				nowCredit = credit.getCredit(vo.userID)+vo.cerditChange;
			}
		} else {
			nowCredit = Credit.INIT_CREDIT_NUM;
		}
		
		CreditHistoryPO po = new CreditHistoryPO(vo.userID, vo.time, vo.orderID, 
				vo.action.ordinal(), vo.cerditChange, nowCredit);
		
		try {
			if(creditDao.changeCredit(po)) {
			
				//如果是第一次更改那么就不用判断信用值
				if(po.getAction() != CreditChangeType.INIT_CREDIT.ordinal()) {
					this.judgeVipLevelChange(vo.userID, nowCredit);
				}
				
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}
	
	//表驱动,根据信用址更改用户vip信息
	private void judgeVipLevelChange(String userID, int nowCredit) {
		this.initTable();
		
		int level = 0;
		
		for(int i=0; i< low.length; ++i) {
			if(nowCredit >= low[i] && nowCredit < high[i]) {
				level = this.lev[i] + 1;
				break;
			}
			
			if(i == low.length -1) {
				if(nowCredit >= low[i]) {
					level = this.lev[i] + 1;
				}
			}
		}
		
		boolean updateSuccess = this.updateVip.updateClientVip(userID, level);
		
		if(!updateSuccess) {
			System.out.println("logic.credit.creditchange.judgeVipLevelChange更新vip等级失败");
		} 
	}
	
	
	private void initTable() {
		
		int level1 = 0;
		int level2 = 0;
		int level3 = 0;
		
		try {
			level1 = this.creditDao.getVIPCredit(2);
			level2 = this.creditDao.getVIPCredit(3);
			level3 = this.creditDao.getVIPCredit(4);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		low[0] = 0;
		low[1] = level1;
		low[2] = level2;
		low[3] = level3;
		
		high[0] = level1;
		high[1] = level2;
		high[2] = level3;
		high[3] = 0;
		
		lev[0] = 0;
		lev[1] = 1;
		lev[2] = 2;
		lev[3] = 3;
	}
	
	
	
	public ArrayList<CreditChangeVO> getCreditHistory(String userID){
		ArrayList<CreditHistoryPO> historyPOList = null;
		try {
			historyPOList = creditDao.getCreditHistory(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(historyPOList == null) {
			return null;
		}
		
		ArrayList<CreditChangeVO> historyVOList = new ArrayList<CreditChangeVO>();
		
		for (int i=0; i<historyPOList.size(); ++i) {
			CreditHistoryPO creditHistoryPO = historyPOList.get(i);
			
			historyVOList.add(CreditTransform.creditTransToVO(creditHistoryPO));
		}
		
		return historyVOList;
	}
	
	public ResultMessage rechargeCredit(CreditChangeVO vo){
		vo.action = CreditChangeType.RECHARGE_CREDIT;
		return this.changeCredit(vo);
	}
}
