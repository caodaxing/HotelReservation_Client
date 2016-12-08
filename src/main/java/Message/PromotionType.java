package Message;

//0:所有promotion 1:酒店生日折扣 2:酒店三间及以上预定特惠 3:酒店合作企业特惠 4:酒店双11(特定期间特惠) 
//5:网站双11(特定期间优惠) 6:网站vip不同商圈不同优惠 7:网站VIP不同等级不同优惠
public enum PromotionType {
	ALL,
	
	HOTEL_BIRTHDAY, 
	HOTEL_3_ROOMS_OR_MORE,
	HOTEL_COOPREATE_BUSINESS, 
	HOTEL_11_11,
	
	WEB_11_11,
	WEB_VIP_TRADINGAREA,
	WEB_VIP_LEVEL;

}
