package logicService.picture;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.scene.image.Image;

public interface PictureService {
	
	public String getUserImage(String userID);
	
	public ArrayList<String> getHotelImage(String hotelID);
	
	public ResultMessage saveUserImage(String userID, String imagePath);
	
	public ResultMessage saveHotelImage(String hotelID, String imagePath);
	
	Image getHeadImage(String userID);
}
