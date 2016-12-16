package dataDao.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import Message.RoomType;
import dataDao.room.RoomDao;
import po.RoomPO;

public class RoomDao_Stub implements RoomDao {
	//00001hotel三人间第二天数量为0，标间数量为10， 单人间和三人间数量为5
	ArrayList<RoomPO> pos1 = new ArrayList<RoomPO>(); 
	
	//00002hotel标间数量为7， 单人间为10，套房为3， 三人间数量为9
	ArrayList<RoomPO> pos2 = new ArrayList<RoomPO>();
	
	//00002hotel标间数量为20， 单人间为30，大床房数量为10
	ArrayList<RoomPO> pos3 = new ArrayList<RoomPO>();
	
	public RoomDao_Stub() {
		
		int[] t1 = new int[30];
		for(int i=0; i<30; ++i) {
			t1[i] = 10;
		}
		this.pos1.add(new RoomPO("00001", RoomType.STANDARD_ROOM.ordinal(), 10, 500, t1));
		
		int[] t2 = new int[30];
		for(int i=0; i<30; ++i) {
			t2[i] = 5;
		}
		this.pos1.add(new RoomPO("00001",  RoomType.SINGLE_ROOM.ordinal(), 5, 250, t2));
		
		int[] t3 = new int[30];
		for(int i=0; i<30; ++i) {
			t3[i] = 5;
		}
		t3[1] = 0;
		this.pos1.add(new RoomPO("00001", RoomType.TRIPLE_ROOM.ordinal(), 5,  1200, t3));
		
		
		
		int[] t4 = new int[30];
		for(int i=0; i<30; ++i) {
			t4[i] = 7;
		}
		this.pos2.add(new RoomPO("00002", RoomType.STANDARD_ROOM.ordinal(), 7, 400, t4));
		
		int[] t5 = new int[30];
		for(int i=0; i<30; ++i) {
			t5[i] = 10;
		}
		this.pos2.add(new RoomPO("00002",  RoomType.SINGLE_ROOM.ordinal(), 10, 200, t5));
		
		int[] t6 = new int[30];
		for(int i=0; i<30; ++i) {
			t6[i] = 3;
		}
		this.pos2.add(new RoomPO("00002", RoomType.SUITE.ordinal(), 3, 1200, t6));
		
		int[] t7 = new int[30];
		for(int i=0; i<30; ++i) {
			t7[i] = 9;
		}
		this.pos2.add(new RoomPO("00002", RoomType.TRIPLE_ROOM.ordinal(), 9, 800, t7));

		
		
		int[] t8 = new int[30];
		for(int i=0; i<30; ++i) {
			t8[i] = 20;
		}
		this.pos3.add(new RoomPO("00003", RoomType.STANDARD_ROOM.ordinal(), 20, 400, t8));
		
		int[] t9 = new int[30];
		for(int i=0; i<30; ++i) {
			t9[i] = 30;
		}
		this.pos3.add(new RoomPO("00003", RoomType.SINGLE_ROOM.ordinal(), 30,  400, t9));
		
		int[] t10 = new int[30];
		for(int i=0; i<30; ++i) {
			t10[i] = 10;
		}
		this.pos3.add(new RoomPO("00003", RoomType.BIGBED_ROOM.ordinal(), 10, 1200, t10));
	}

	
	@Override
	public RoomPO getRoomInfo(String hotelId, int roomType) throws RemoteException {
		if(hotelId == "00001") {
			return pos1.get(2);
		} else if(hotelId == "00002") {
			return pos2.get(0);
		}
	
		return pos3.get(0);
	}
	

	public boolean addRoom(RoomPO roomPO) {
		return true;
	}

	public boolean updateRoom(RoomPO roomPO) {
		return true;
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		if(hotelId == "00001") {
			return pos1;
		} else if(hotelId == "00002") {
			return pos2;
		}
	
		return pos3;
	}

	

}
