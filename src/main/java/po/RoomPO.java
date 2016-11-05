package po;

import java.awt.Image;
import java.util.ArrayList;

public class RoomPO {
	String kindOfRoom;
	int priceOfRoom;
	boolean isEmpty;
	int numberOfRoom;
	ArrayList<Image> pictureOfRoom;
	
	public RoomPO(String kindOfRoom,int priceOfRoom,boolean isEmpty,int numberOfRoom,ArrayList<Image> pictureOfRoom) {
		super();
		this.kindOfRoom=kindOfRoom;
		this.priceOfRoom=priceOfRoom;
		this.isEmpty=isEmpty;
		this.numberOfRoom=numberOfRoom;
		this.pictureOfRoom=pictureOfRoom;
	}
}
