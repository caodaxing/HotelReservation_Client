package logic.picture;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

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
	
	/**
	 * 直接获得file对象
	 * @param data
	 * @param pictureName
	 * @return
	 */
	public static File bytesToImage(byte[] data,String pictureName) {
		
		if(data == null || pictureName == null) {
			return null;
		}
		
		File file = new File(pictureName);
		BufferedOutputStream stream = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fileOutputStream);
			stream.write(data);
			return file;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 直接获得java.awt.Image对象
	 * @param bytes
	 * @return
	 */
	public static Image bytesTImage(byte[] bytes) {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
		 
		ImageReader reader = (ImageReader) readers.next();
		Object source = bis;
		 
		ImageInputStream iis;
		Image image = null;
		try {
			iis = ImageIO.createImageInputStream(source);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			image = reader.read(0, param);
			return image;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
//	/**
//	 * 将从服务器端拿到的二进制流转换成image并保存与本地的download文件夹
//	 * @param data 从服务器端拿到的二进制流
//	 */
//	public static void bytesToImage(byte[] data , String hotelID , String pictureName) {
//		try {  
//            for (int i = 0; i < data.length; ++i) {  
//                if (data[i] < 0) {// 调整异常数据  
//                    data[i] += 256;  
//                }  
//            }  
//            String path = PictureHelper.class.getProtectionDomain().getCodeSource().getLocation().getFile();  
//            try{  
//                path = java.net.URLDecoder.decode(path, "UTF-8"); // 转换处理中文及空格  
//            }  
//            catch (java.io.UnsupportedEncodingException e){  
//            }  
//            path = path.substring(0, path.length()-4)+"download"+hotelID+"\\"+pictureName+".jpg";
//            OutputStream out = new FileOutputStream(path);  
//            out.write(data);  
//            out.flush();  
//            out.close();  
//        } catch (Exception e) {  
//        }
//	}
	
	
}
