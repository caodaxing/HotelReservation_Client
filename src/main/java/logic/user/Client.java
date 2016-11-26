package logic.user;

import java.util.ArrayList;

import Message.ResultMessage;
import logic.credit.Credit;
import vo.ClientVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.VIPInfoVO;

/**
 * 管理客户信息的类
 * @author Xue.W
 */
public class Client{
	
	private String userID;
	private String orderID;
	private ClientVO clientVO;
	private Credit creditInfo;
	
	public Client(){}	
	
	/**
	 * User的构造函数
	 * @param clientVO 传入的客户资料信息
	 * @author Xue.W
	 */
	public Client(ClientVO clientVO){
		this.clientVO = clientVO; 
	}
	
	/**
	 * 获得用户信息
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户信息
	 * @author Xue.W
	 */
	public ClientVO getClientInfo (String user_ID){
		return null;
	}
	
	/**
	 * 修改用户信息
	 * @param  userInfo 传入的用户信息
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public ResultMessage updateUserInfo(ClientVO userInfo){
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 注册会员
	 * @param VIPInfo 传入的注册会员信息
	 * @return 返回是否注册成功
	 * @author Xue.W
	 */
	public ResultMessage setVIP(VIPInfoVO VIPInfo){
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 获得注册会员资料
	 * @param user_ID 传入的用户ID信息
	 * @return 返回会员资料信息
	 * @author Xue.W
	 */
	public VIPInfoVO getVIPInfo(String user_ID){
		return null;
	}
	
	/**
	 * 获得用户历史酒店信息
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户历史酒店列表
	 * @author Xue.W
	 */
	public ArrayList<HotelVO> getHistoryHotels(String user_ID){
		return null;
	}
	
	/**
	 * 获得信用信息
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户信用
	 * @author Xue.W
	 */
	public int getCredit(){
		return creditInfo.getCredit(userID);
	}
	
	/**
	 * 获得VIP升级信用值
	 * @return 返回升级所需信用
	 * @author Xue.W
	 */
	public int getVIPCredit(){
		return creditInfo.getVIPCredit();
	}
	
	/**
	 * 获得订单信息
	 * @param orderID 传入的订单ID信息
	 * @return 返回订单信息
	 * @author Xue.W
	 */
	public OrderVO getOrderInfo(String orderID){
		return null;
	}
	
}
