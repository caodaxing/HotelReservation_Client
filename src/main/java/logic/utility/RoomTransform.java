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
		return new RoomVO(po.getHotelId(), po.getRoomId(), RoomType.values()[po.getRoomType()],
				po.getPrice(), po.isEmpty(), po.getPictures());
	}
	
	//将RoomVO转化为PO
	public static RoomPO roomTransToPO(RoomVO vo) {
		return new RoomPO(vo.hotelId, vo.roomId, vo.roomType.ordinal(), vo.price, vo.isEmpty, vo.pictures);
	}
}