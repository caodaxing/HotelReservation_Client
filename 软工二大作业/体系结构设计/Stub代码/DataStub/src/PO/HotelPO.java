package PO;

import java.util.ArrayList;

public class HotelPO {
	String nameOfhotel;
	String tradingAreaOfHotel;
	int levelOfHotel;
	int priceOfhotel;
	String locationOfHotel;
	String discount;
	String introductionOfHotel;
	EvaluationPO evaluation;
	
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
