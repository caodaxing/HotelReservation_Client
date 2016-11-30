//package driver;
//
//import java.util.HashMap;
//
//import logicService.PromotionService;
//
///**
// * PromotionBLService 的 Driver
// * @author XueWang
// */
//public class PromotionDriver {
//
//	public void drive(PromotionService promotionService){
//		
//		System.out.println("This is promotionServiceDriver");
//	
//		HashMap<String , String> hashmap0 = promotionService.hotelSetPromotion("001", "双十一优惠");
//		System.out.println(hashmap0);
//	
//		String s = promotionService.hotelGetPromotion("001");
//		System.out.println(s);
//		
//		HashMap<String , String> hashmap1 = promotionService.hotelAddPromotion("002", "双十二优惠"); 
//		System.out.println(hashmap1);
//		
//		HashMap<String , String> hashmap2 = promotionService.hotelUpdatePromotion("002", "双十优惠");
//		System.out.println(hashmap2);
//		
//		HashMap<String , String> hashmap3 = promotionService.hotelDeletePromotion("002");
//		System.out.println(hashmap3);
//		
//		HashMap<String , String> hashmap4 = promotionService.webSetPromotion("101", "生日优惠");
//		System.out.println(hashmap4);
//		
//		String s1 = promotionService.webGetPromotion("101");
//		System.out.println(s1);
//		
//		HashMap<String , String> hashmap5 = promotionService.webAddPromotion("102" , "VIP优惠");
//		System.out.println(hashmap5);
//		
//		HashMap<String , String> hashmap6 = promotionService.webDeletePromotion("101");
//		System.out.println(hashmap6);
//		
//		HashMap<String , String> hashmap7 = promotionService.webUpdatePromotion("102", "VIP优惠二");
//		System.out.println(hashmap7);
//		
//	}
//
//}
