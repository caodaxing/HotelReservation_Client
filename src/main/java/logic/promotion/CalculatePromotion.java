package logic.promotion;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.PromotionType;
import dataDao.promotion.PromotionDao;
import dataDao.stub.PromotionDao_Stub;
import factories.PromotionFactory;
import po.PromotionPO;
import vo.OrderVO;
/**
 * 根据促销策略计算价格
 * @author Rukawa
 *
 */
public class CalculatePromotion implements CalculationPromotionInfo{
	
	private ArrayList<Promotion> promotions = new ArrayList<Promotion>();
	private PromotionDao promotionDao;
	private PromotionFactory promotionFactory;
	
	public CalculatePromotion() {
		this.promotionFactory = new PromotionFactory();
		
		this.promotionDao = new PromotionDao_Stub();
	}

	/**
	 * 计算订单折扣后的价格
	 * @param order 订单的VO类
	 * @return 折扣后订单价格
	 * @author Rukawa
	 */
	public OrderVO calculatePromotion(OrderVO order){
		if(order == null) {
			return null;
		}

//System.out.println(order.beforePrice);
//System.out.println(order.orderId);

		this.promotions.clear();
		//清除原先的promotion,以防止promotion有添加或者改动不一致的现象
		
		this.initWebPromotions();
		this.initHoteLPromotions(order.hotelID);
	
		for(int i=0; i<this.promotions.size(); ++i) {
			Promotion p = this.promotions.get(i);
			if(p.judgePromotion(order)) {
				order = p.calculate(order);
			}
		}
		
		return order;
	}
	
	private void initWebPromotions() {
		ArrayList<PromotionPO> pos = null;
		try {
			pos = this.promotionDao.getWebPromotions(PromotionType.ALL.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null) {
			return;
		}
		
		for(int i=0; i<pos.size(); ++i) {
			this.promotions.add(this.promotionFactory.createPromotion(pos.get(i)));
		}
	}

	private void initHoteLPromotions(String hotelID) {
		ArrayList<PromotionPO> pos = null;
		try {
			pos = this.promotionDao.getHotelPromotions(hotelID,PromotionType.ALL.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null) {
			return;
		}
		
		for(int i=0; i<pos.size(); ++i) {
			this.promotions.add(this.promotionFactory.createPromotion(pos.get(i)));
		}
	}
	
}
