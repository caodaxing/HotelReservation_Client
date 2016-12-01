package vo;

/**
 * 搜索酒店返回的酒店信息的vo
 * 因为存在针对某个用户有没有预订过，所以单独分出来一个vo
 * @param hotelID  酒店id
 * @param hotelName 酒店名字
 * @param userID 用户id
 * @param hasBooked 是否预订过
 * @param star  星级
 * @param commentLevel 评分
 */
public class SearchedHotelVO {

	public String hotelID;
	public String hotelName;
	public String userID;
	public boolean hasBooked;
	public int star;
	public int commentLevel;
	
	public SearchedHotelVO(String hotelID, String hotelName, String userID, boolean hasBooked, int star,
			int commentLevel) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.userID = userID;
		this.hasBooked = hasBooked;
		this.star = star;
		this.commentLevel = commentLevel;
	}
}
