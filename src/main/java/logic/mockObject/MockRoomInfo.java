package logic.mockObject;

import Message.RoomType;
import logic.room.RoomInfo;

public class MockRoomInfo implements RoomInfo{


	@Override
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String t) {
		return 0;
	}

	@Override
	public double getRoomPrice(String hotelID, RoomType roomType) {
		return 0;
	}

	@Override
	public double getHotelLowestPrice(String hotelID) {
		return 0;
	}

}
