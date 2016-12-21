package logicService.picture;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.scene.image.Image;

/**
 * 处理图片接口
 * @author Mark.W
 *
 */
public interface PictureService {
	

	/**
	 * 获取用户头像图片
	 * @param userID
	 * @return
	 */
	Image getHeadImage(String userID);
	
	/**
	 * 获取酒店图片的路径
	 * @param hotelID
	 * @return
	 */
	public ArrayList<Image> getHotelImage(String hotelID);
	
	/**
	 * 保存用户图片
	 * @param userID
	 * @param imagePath
	 * @return
	 */
	public ResultMessage saveUserImage(String userID, String imagePath);
	
	/**
	 * 保存酒店图片
	 * @param hotelID
	 * @param imagePath
	 * @return
	 */
	public ResultMessage saveHotelImage(String hotelID, String imagePath);
	
}
