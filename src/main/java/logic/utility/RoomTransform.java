package logic.utility;

import Message.RoomType;
import po.RoomPO;
import vo.RoomVO;

/**
 * 提供了Room的VO、PO互相转换的方法
 * @author bcy
 *
 */
public class RoomTransform {

	//将RoomPO转化为VO
	public static RoomVO roomTransToVO(RoomPO po) {
		
		if(po == null) {
			return null;
		}
		return new RoomVO(po.getHotelId(), po.getRoomId(), RoomType.values()[po.getRoomType()],
				po.getPrice(), po.getNotEmptyTime(), po.getPictures());
	}
	
	//将RoomVO转化为PO
	public static RoomPO roomTransToPO(RoomVO vo) {
		if(vo == null) {
			return null;
		}
		
		return new RoomPO(vo.hotelId, vo.roomId, vo.roomType.ordinal(), vo.price,vo.notEmptyTime, vo.pictures);
	}
}