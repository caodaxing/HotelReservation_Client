package logictest.room;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import Message.RoomType;
import logic.room.UpdateRoom;

public class UpdateRoomTest {

	private UpdateRoom updateRoom;
	
	@Before
	public void setUp() {
		this.updateRoom = new UpdateRoom();
	}
	
	@Test
	public void testUpdateRoomInSpecificTime1() {
		assertEquals(ResultMessage.SUCCESS, this.updateRoom.updateRoomInSpecificTime("00001", RoomType.BIGBED_ROOM, -2, "2016-12-18 00:00:00"));
	}
	
	@Test
	public void testUpdateRoomInSpecificTime2() {
		
		assertEquals(ResultMessage.SUCCESS, this.updateRoom.updateRoomInSpecificTime("00002", RoomType.STANDARD_ROOM, 3, "2016-12-16 00:00:00"));
	}
	
	@Test
	public void testUpdateRoom1() {
		
		assertEquals(ResultMessage.SUCCESS, this.updateRoom.updateRoom("00001", RoomType.BIGBED_ROOM, -2));
	}
	
	@Test
	public void testUpdateRoom2() {
		
		assertEquals(ResultMessage.FAILURE, this.updateRoom.updateRoom("00002", RoomType.BIGBED_ROOM, -10));
	}

}
