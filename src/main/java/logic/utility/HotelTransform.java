package logic.utility;

import po.HotelPO;
import vo.HotelVO;

/**
 * 提供了Hotel的VO、PO互相转换的方法
 * @author bcy
 *
 */
public class HotelTransform {
	
	/**
	 * 将HotelVO转换为HotelPO
	 * @param HotelVO
	 * @return HotelPO
	 */
	public static HotelPO hotelTransToPO(HotelVO vo) {
		if(vo == null) {
			return null;
		}
		
		return new HotelPO(vo.hoteID, vo.hotelName, vo.city,vo.tradingArea, vo.locationOfHotel, vo.evaluationGrades,
				vo.levelOfHotel, vo.introduction, vo.facilities, vo.picturesName,  vo.bussiness);
	}
	
	/**
	 * 将HotelPO转换为HotelVO
	 * @param HotelPO
	 * @return HotelVO
	 */
	public static HotelVO hotelTransToVO(HotelPO po) {
		if(po == null) {
			return null;
		}
		
		return new HotelVO(po.getHoteID(), po.getHotelName(), po.getCity(),po.getTradingArea(), 
				po.getLocationOfHotel(), po.getEvaluationGrades(),po.getLevelOfHotel(), po.getIntroduction(), 
				po.getFacilities(), po.getPicturesName(), po.getBussiness());
	}

}
