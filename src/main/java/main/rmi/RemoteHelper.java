package main.rmi;

import java.rmi.Remote;

import dataDao.account.AccountDao;
import dataDao.credit.CreditDao;
import dataDao.hotel.HotelDao;
import dataDao.order.OrderDao;
import dataDao.order.OrderListDao;
import dataDao.promotion.PromotionDao;
import dataDao.room.RoomDao;
import dataDao.user.ClientDao;
import dataDao.user.HotelManagerDao;
import dataDao.user.WebBusinessDao;

public class RemoteHelper {
	
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();

	public static RemoteHelper getInstance() {
		return remoteHelper;
	}

	private RemoteHelper() {
	}

	public void setRemote(Remote remote) {
		this.remote = remote;
	}

	public AccountDao getAccountDao() {
		return (AccountDao) remote;
	}

	public CreditDao getCreditDao() {
		return (CreditDao) remote;
	}

	public HotelDao getHotelDao() {
		return (HotelDao) remote;
	}

	public OrderDao getOrderDao() {
		return (OrderDao) remote;
	}

	public OrderListDao getOrderListDao() {
		return (OrderListDao) remote;
	}

	public PromotionDao getPromotionDao() {
		return (PromotionDao) remote;
	}

	public RoomDao getRoomDao() {
		return (RoomDao) remote;
	}

	public ClientDao getClientDao() {
		return (ClientDao) remote;
	}

	public HotelManagerDao getHotelManagerDao() {
		return (HotelManagerDao) remote;
	}

	public WebBusinessDao getWebBusinessDao() {
		return (WebBusinessDao) remote;
	}
	
}
