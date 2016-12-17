package logic.picture;

import java.io.File;
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
		File f = null;
		try {
			byte[] bs = this.pictureDao.getUserImage(userID);
			//图片名就是用户名
			f = PictureHelper.bytesToImage(bs, userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public ArrayList<Image> getHotelImage(String hotelID) {
		ArrayList<Image> images = new ArrayList<Image>();
		ArrayList<byte[]> imageByte = null;
		try {
			imageByte = this.pictureDao.getHotelImage(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(imageByte == null) {
			return null;
		}
		
		for(int i=0; i<imageByte.size(); ++i) {
//			images.add(PictureHelper.bytesToImage(imageByte.get(i), String.valueOf(i)));
		}
		
		
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
