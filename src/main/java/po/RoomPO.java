package po;

import java.awt.Image;
import java.util.ArrayList;

public class RoomPO {
	String kindOfRoom;
	int priceOfRoom;
	boolean isEmpty;
	int numberOfRoom;
	ArrayList<Image> pictureOfRoom;
	
	/**
	 * @param kindOfRoom 房间种类
	 * @param priceOfRoom 房间价格
	 * @param isEmpty 是否空房
	 * @param numberOfRoom 房间数量
	 * @param pictureOfRoom 房间图片
	 */
	public RoomPO(String kindOfRoom,int priceOfRoom,boolean isEmpty,int numberOfRoom,ArrayList<Image> pictureOfRoom) {
		super();
		this.kindOfRoom=kindOfRoom;
		this.priceOfRoom=priceOfRoom;
		this.isEmpty=isEmpty;
		this.numberOfRoom=numberOfRoom;
		this.pictureOfRoom=pictureOfRoom;
	}
}
