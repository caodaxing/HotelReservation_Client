package logic.hotel;

import java.util.ArrayList;

import vo.EvaluationVO;

public class HotelTest {

	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
//		System.out.println(hotel.getPromotion("ppp").promotionName);
//		System.out.println(hotel.getHotelnfo("123").hotelName);
		ArrayList<EvaluationVO> evaluationVOs = hotel.getHotelEvaluations("123");
		for (EvaluationVO evaluationVO : evaluationVOs) {
			System.out.println(evaluationVO.evaluationContent);
		}
	}
}
