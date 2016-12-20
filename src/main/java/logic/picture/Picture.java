package logic.picture;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Message.ResultMessage;
import dataDao.picture.PictureDao;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import logicService.picture.PictureService;
import main.rmi.RemoteHelper;

public class Picture implements PictureService {

	private PictureDao pictureDao;
	
	public Picture() {
		this.pictureDao = RemoteHelper.getInstance().getPictureDao();
	}

	@Override
	public String getUserImage(String userID) {
//		String path = null;
//		
//		try {
//			byte[] bs = this.pictureDao.getUserImage(userID);
//			
//			//图片名就是用户名
//			String temp = PictureHelper.bytesToImage(bs, userID);
//			if(temp != null) {
//				return temp;
//			}
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return null;
		return "/head/游客头像.png";
	}

	@Override
	public ArrayList<String> getHotelImage(String hotelID) {
		ArrayList<String> imagePaths = new ArrayList<String>();
		
//		ArrayList<byte[]> imageByte = null;
//		try {
//			imageByte = this.pictureDao.getHotelImage(hotelID);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		
//		if(imageByte == null) {
//			return null;
//		}
//		
//		for(int i=0; i<imageByte.size(); ++i) {
//			String path = hotelID+String.valueOf(i);
//			imagePaths.add(PictureHelper.bytesToImage(imageByte.get(i), path));
//		}
//		
//		if(imagePaths.size() == 0) {
//			return null;
//		}
//		
//		return imagePaths;
		
		imagePaths.add("/hotelImage/index.jpg");
		imagePaths.add("/hotelImage/index1.jpg");
		imagePaths.add("/hotelImage/index2.jpg");
		imagePaths.add("/hotelImage/index3.jpg");
		
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

	@Override
	public Image getHeadImage(String userID) {
		Image image = null;
		try {
			byte[] bs = pictureDao.getUserImage(userID);
			ByteArrayInputStream stream = new ByteArrayInputStream(bs);
			BufferedImage image2 = ImageIO.read(stream);
			image = SwingFXUtils.toFXImage(image2, new WritableImage(10, 10));
			return image;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
