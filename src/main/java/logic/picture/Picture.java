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

/**
 * 处理与数据库传输图片的接口，与其他逻辑分开。
 * @author Mark.W
 *
 */
public class Picture implements PictureService {

	private PictureDao pictureDao;
	
	public Picture() {
		this.pictureDao = RemoteHelper.getInstance().getPictureDao();
	}


	@Override
	public ArrayList<Image> getHotelImage(String hotelID) {
		ArrayList<Image> hotelImages = new ArrayList<Image>();
		try {
			ArrayList<byte[]> datas = pictureDao.getHotelImage(hotelID);
			if (datas==null) {
				return null;
			}
			for (byte[] bs : datas) {
				Image image = PictureHelper.byteToImage(bs);
				hotelImages.add(image);
			}
			return hotelImages;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public Image getHeadImage(String userID) {
		byte[] bs;
		try {
			bs = pictureDao.getUserImage(userID);
			return PictureHelper.byteToImage(bs);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
