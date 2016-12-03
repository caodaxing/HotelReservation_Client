package logic.promotion;

import vo.OrderVO;

public class WebDoubleElevenPromotion implements Promotion{

	@Override
	public boolean judgePromotion(OrderVO orderVO) {
		return false;
	}

	@Override
	public double calculate() {
		return 0;
	}

}
