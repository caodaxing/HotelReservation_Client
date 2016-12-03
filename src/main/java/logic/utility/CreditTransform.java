package logic.utility;

import Message.CreditChangeType;
import po.CreditHistoryPO;
import vo.CreditChangeVO;

/**
 * 提供了credit的vo、po相互转换的方法
 * @author bcy
 *
 */
public class CreditTransform {

	//将CreditHistorypo转化为vo
	public static CreditChangeVO creditTransToVO(CreditHistoryPO po) {
		return new CreditChangeVO(po.getUserID(), po.getTime(), po.getOrderID(), 
				CreditChangeType.values()[po.getAction()], po.getCerditChange());
	}
	
	//将CreditChangeVO转化为po
	public static CreditHistoryPO creditTransToPO(CreditChangeVO vo) {
		return new CreditHistoryPO(vo.userID, vo.time, vo.orderID, vo.action.ordinal(), vo.cerditChange, vo.nowCredit);
	}
}
