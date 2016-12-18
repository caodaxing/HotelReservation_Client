package logic.picture;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.picture.PictureDao;
import logicService.picture.PictureService;
import main.rmi.RemoteHelper;

public class Picture implements PictureService {

	private PictureDao pictureDao;
	
	public Picture() {
		this.pictureDao = RemoteHelper.getInstance().getPictureDao();
	}

	@Override
	public String getUserImage(String userID) {
		String path = null;;
		try {
			byte[] bs = this.pictureDao.getUserImage(userID);
			//图片名就是用户名
			if(PictureHelper.bytesToImage(bs, userID)) {
				return userID;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> getHotelImage(String hotelID) {
		ArrayList<String> imagePaths = new ArrayList<String>();
		
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
			String path = hotelID+String.valueOf(i);
			if(PictureHelper.bytesToImage(imageByte.get(i), path)) {
				imagePaths.add(path);
			}
		}
		
		if(imagePaths.size() == 0) {
			return null;
		}
		
		return imagePaths;
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
