package po;


public class HotelPO {
	String nameOfhotel;
	String tradingAreaOfHotel;
	int levelOfHotel;
	int priceOfhotel;
	String locationOfHotel;
	String discount;
	String introductionOfHotel;
	EvaluationPO evaluation;
	
	/**
	 * 
	 * @param nameOfhotel  酒店号
	 * @param tradingAreaOfHotel  商圈
	 * @param levelOfHotel   星级
	 * @param priceOfhotel   价格
	 * @param locationOfHotel  地址
	 * @param discount    酒店折扣
	 * @param introductionOfHotel 酒店简介
	 * @param evaluation     酒店评价
	 */
	public HotelPO(String nameOfhotel,String tradingAreaOfHotel,int levelOfHotel,int priceOfhotel,String locationOfHotel,String discount,String introductionOfHotel,EvaluationPO evaluation) {
		super();
		this.nameOfhotel=nameOfhotel;
		this.tradingAreaOfHotel=tradingAreaOfHotel;
		this.levelOfHotel=levelOfHotel;
		this.priceOfhotel=priceOfhotel;
		this.locationOfHotel=locationOfHotel;
		this.discount=discount;
		this.introductionOfHotel=introductionOfHotel;
		this.evaluation=evaluation;
	}
}
