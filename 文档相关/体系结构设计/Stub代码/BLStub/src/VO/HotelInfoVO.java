package VO;

import javax.swing.ImageIcon;

public class HotelInfoVO {
	String hotelName;
	String hotelLocation;
	String briefing;
	String price;
	String evaluation;
	ImageIcon image;
	public HotelInfoVO(String hotelName,String hotelLocation,String briefing,String price,String evaluation,ImageIcon image){
		super();
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.briefing = briefing;
		this.price = price;
		this.evaluation = evaluation;
		this.image = image;
		
	}
}
