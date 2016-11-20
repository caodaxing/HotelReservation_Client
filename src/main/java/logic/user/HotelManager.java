package logic.user;

import Message.ResultMessage;
import vo.HotelManagerVO;

/**
 * 管理酒店工作人员信息的类
 * @author Xue.W
 */
public class HotelManager {
	
	HotelManagerVO hmv ;
	
	public HotelManager (HotelManagerVO hmv){
		this.hmv = hmv;
	}
	
	public HotelManager(){
		
	}
	
	/**
	 * 新增酒店工作人员
	 * @param hotel_ID 传入的酒店（酒店工作人员）ID信息
	 * @param hotelManagerVO 传入的酒店工作人员信息
	 * @return 返回是否新增成功
	 * @author Xue.W
	 */
	public ResultMessage addHotelManagerInfo(HotelManagerVO hotelManager , String hotel_ID){
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 获得酒店工作人员信息
	 * @param hotel_ID 传入的酒店ID信息
	 * @return 返回酒店工作人员信息
	 * @author Xue.W
	 */
	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
		return null;
	}
	
	/**
	 * 修改酒店工作人员信息
	 * @param hotel_ID 传入的酒店ID信息
	 * @param hotelManagerInfo 传入的酒店工作人员信息
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo , String hotel_Id){
		return ResultMessage.FAILURE;
	}
	
}
