package logic.promotion;

import java.util.HashMap;

/**
 * 修改返回网站促销策略
 * @author Rukawa
 *
 */
public class WebPromotion implements Promotion, PromotionInfo {
	
	/**
	 * 设置网站促销策略
	 * @param promotionid 促销策略名称
	 * @param hotelPromotion 网站促销策略内容
	 * @return 促销策略列表
	 * @author Rukawa
	 */
	public HashMap<String, String> setPromotion(String promotionid, String webPromotion){
		return null;
	}
	
	/**
	 * 获取网站促销策略
	 * @param promtionid 促销策略名称
	 * @return 该促销策略的内容
	 * @author Rukawa
	 */
	public String getPromotion(String promtionid){
		return null;
	}
	
	/**
	 * 添加网站促销策略
	 * @param promtionid 促销策略名称
	 * @param content 促销策略内容
	 * @return 当前促销策略列表
	 * @author Rukawa
	 */
	public HashMap<String, String> addPromotion(String promtionid, String content){
		return null;
	}
	
	/**
	 * 删除网站促销策略
	 * @param promtionid 促销策略名称
	 * @return 当前促销策略列表
	 * @author Rukawa
	 */
	public HashMap<String, String> deletePromotion(String promtionid){
		return null;
	}
	
	/**
	 * 更改网站促销策略
	 * @param promtionid 促销策略名称
	 * @param content 促销策略内容
	 * @return 当前促销策略列表
	 * @author Rukawa
	 */
	public HashMap<String, String> updatePromotion(String promtionid, String content){
		return null;
	}
	
	/**
	 * 计算促销策略打折之后的价格
	 * @return 折扣后价格
	 * @author Rukawa
	 */
	public double calculate() {
		return 0;
	}
}
