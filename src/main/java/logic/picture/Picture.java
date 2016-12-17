package logic.picture;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.picture.PictureDao;
import javafx.scene.image.Image;
import logicService.picture.PictureService;
import main.rmi.RemoteHelper;

public class Picture implements PictureService {

	private PictureDao pictureDao;
	
	
	public Picture() {
		this.pictureDao = RemoteHelper.getInstance().getPictureDao();
	}

	@Override
	public Image getUserImage(String userID) {
//		byte[] bs = this.pictureDao.getUserImage(userID);
		
		return null;
	}

	@Override
	public ArrayList<Image> getHotelImage(String hotelID) {
		ArrayList<Image> images = new ArrayList<Image>();
		
		return null;
	}

	@Override
	public ResultMessage saveUserImage(String userID, String imagePath) {
		byte[] bs = PictureHelper.imageToBytes(imagePath);

		try {
			if(this.pictureDao.saveUserImage(bs, userID)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public ResultMessage saveHotelImage(String hotelID, String imagePath) {
		byte[] bs = PictureHelper.imageToBytes(imagePath);
		
		try {
			if(this.pictureDao.saveHotelImage(bs, hotelID, imagePath)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}

}
