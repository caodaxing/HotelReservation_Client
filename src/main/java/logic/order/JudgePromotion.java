package logic.order;

import message.ResultMessage;
import vo.OrderVO;

public interface JudgePromotion {
	public ResultMessage judge(OrderVO order);
}
