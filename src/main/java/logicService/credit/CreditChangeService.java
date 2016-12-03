package logicService.credit;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.CreditChangeVO;

/**
 * 有关用户信用改变的处理
 * @author Mark.W
 */
public interface CreditChangeService {
	
	/**
	 * 改变信用值
	 * @param creditChangeVO 传入的用户信用修改信息，包括信用充值等等
	 * @return 返回是否修改成功
	 * @author Mark.W
	 */
	public ResultMessage changeCredit(CreditChangeVO creditChangeVO);
	
	/**
	 * 获得用户历史信用记录
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户历史信用记录列表
	 * @author Xue.W
	 */
	public ArrayList<CreditChangeVO> getCreditHistory(String userID);
	
}
