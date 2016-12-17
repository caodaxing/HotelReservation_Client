package dataDao.picture;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PictureDao extends Remote {
	
	public byte[] getHotelImage(String hotelID, String pictureName) throws RemoteException;
	
	public boolean saveHotelImage(byte[] bs , String hotelID ,String pictureName) throws RemoteException;
	
	public byte[] getUserImage(String userID, String pictureName) throws RemoteException;
	
	public boolean saveUserImage(byte[] bs , String userID) throws RemoteException;

}
