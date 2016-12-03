package logic.promotion;

import vo.OrderVO;

public class WebVipTradingAreaPromotion implements Promotion {

	@Override
	public boolean judgePromotion(OrderVO orderVO) {
		return false;
	}

	@Override
	public double calculate() {
		return 0;
	}

}
