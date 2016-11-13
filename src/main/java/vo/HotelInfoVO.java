package vo;

import javax.swing.ImageIcon;

public class HotelInfoVO {
	
	String hotelName;
	String hotelLocation;
	String briefing;
	String price;
	String evaluation;
	ImageIcon image;
	
	/**
	 * 酒店信息的VO类
	 * @param hotelName 酒店名称
	 * @param hotelLocation 酒店地址
	 * @param briefing 酒店简介
	 * @param price 酒店起始价格
	 * @param evaluation 过往用户的评价
	 * @param image 酒店图片
	 * @author Rukawa
	 */
	public HotelInfoVO(String hotelName, String hotelLocation, String briefing, String price, String evaluation, ImageIcon image){
		super();
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.briefing = briefing;
		this.price = price;
		this.evaluation = evaluation;
		this.image = image;
		
	}
}
