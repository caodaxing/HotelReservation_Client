package logic.promotion;

import vo.OrderVO;

public class HotelDoubleElevenPromotion  implements Promotion{

	@Override
	public boolean judgePromotion(OrderVO orderVO) {
		return false;
	}

	@Override
	public double calculate() {
		return 0;
	}

}
