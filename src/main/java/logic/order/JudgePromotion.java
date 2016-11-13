package logic.order;

import Message.ResultMessage;
import vo.OrderVO;

public interface JudgePromotion {
	public ResultMessage judge(OrderVO order);
}
