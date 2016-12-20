package logic.picture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javafx.scene.image.Image;

public class PictureHelper {

	/**
	 * 将给定的本地图片路径转为byte[]数组来传输
	 * @param fileName 本地图片路径
	 * @return
	 */
	public static byte[] imageToBytes(String fileName) {
		if(fileName == null) {
			return null;
		}
		
		 InputStream in = null;  
	        byte[] data = null;
	        try {  
	            in = new FileInputStream(fileName);  
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
	   
			return data;
	}
	
	
	public static Image imageToByte(byte[]data,String pictureName) {
		if (data==null||pictureName==null||pictureName.equals("")) {
			return null
		}
		return null;
	}
//	/**
//	 * 直接获得file对象
//	 * @param data
//	 * @param pictureName
//	 * @return
//	 */
//	public static File bytesToImage(byte[] data,String pictureName) {
//		
//		if(data == null || pictureName == null) {
//			return null;
//		}
//		
//		File file = new File(pictureName);
//		BufferedOutputStream stream = null;
//		try {
//			FileOutputStream fileOutputStream = new FileOutputStream(file);
//			stream = new BufferedOutputStream(fileOutputStream);
//			stream.write(data);
//			return file;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
//	
//	/**
//	 * 直接获得java.awt.Image对象
//	 * @param bytes
//	 * @return
//	 */
//	public static Image bytesTImage(byte[] bytes) {
//		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
//		 
//		ImageReader reader = (ImageReader) readers.next();
//		Object source = bis;
//		 
//		ImageInputStream iis;
//		Image image = null;
//		try {
//			iis = ImageIO.createImageInputStream(source);
//			reader.setInput(iis, true);
//			ImageReadParam param = reader.getDefaultReadParam();
//			image = reader.read(0, param);
//			return image;
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		return null;
//	}
	
}
