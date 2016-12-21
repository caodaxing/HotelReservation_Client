package logic.credit;

import Message.ResultMessage;
import vo.CreditChangeVO;

/**
 * 给order包的ExecuteOrder提供的接口，在执行订单时更新信用记录
 * @author Mark.W
 *
 */
public interface CreditChangeInfo {
	
	public ResultMessage changeCredit(CreditChangeVO vo);
	
}
