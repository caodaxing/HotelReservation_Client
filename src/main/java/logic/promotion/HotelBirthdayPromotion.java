package logic.promotion;

import vo.OrderVO;

/**
 * 修改返回网站促销策略
 * @author Rukawa
 *
 */
public class HotelBirthdayPromotion implements Promotion {
	

	@Override
	public boolean judgePromotion(OrderVO orderVO) {
		return false;
	}

	@Override
	public double calculate() {
		return 0;
	}
}
