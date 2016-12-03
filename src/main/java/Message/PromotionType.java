package Message;

public enum PromotionType {
	ALL(0),
	
	HOTEL_BIRTHDAY(1), 
	HOTEL_3_ROOMS_OR_MORE(2),
	HOTEL_COOPREATE_BUSINESS(3), 
	HOTEL_11_11(4),
	
	WEB_11_11(5),
	WEB_VIP_TRADINGAREA(6),
	WEB_VIP_LEVEL(7);
	
	
	private int index;
	
	private PromotionType(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

}
