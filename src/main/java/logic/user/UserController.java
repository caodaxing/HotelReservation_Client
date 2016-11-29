//package logic.user;
//
//
//import Message.Identity;
//import Message.ResultMessage;
//import logicService.ClientService;
//import vo.ClientVO;
//import vo.HotelManagerVO;
//import vo.HotelVO;
//import vo.VipVO;
//import vo.WebBusinessVO;
//
//public class UserController implements ClientService{
//	
//	private Client client;
//	private WebManager webManager;
//	
//	public UserController(String userID, Identity identity) {
//		this.createUser(userID ,identity);
//	}
//	
//	private void createUser(String userID, Identity identity) {
//		switch(identity) {
//		case CLIENT :
//			client = new Client(userID);
//			break;
//		case HOTELMANAGER :
//			break;
//		case WEBMANAGER :
//			webManager = new WebManager(userID);
//			break;
//		case WEBBUSSINESS :
//			break;
//		}
//	}
//
//	//client
//	@Override
//	public ClientVO getClientInfo(String user_ID){
//		if(client != null) {
//			return client.getClientInfo(user_ID);
//		} else {
//			return null;
//		}
//		
//	}
//	
//	public ResultMessage updateClientInfo(ClientVO new_userInfo){
//		return client.updateClientInfo(new_userInfo);
//	}
//	
//	public ResultMessage registerVIP(VipVO VIPInfo){
//		return client.registerVIP(VIPInfo);
//	}
//	
//	@Override
//	public boolean isVIP(String userID) {
//		return client.isVIP(userID);
//	}
//	
//	@Override
//	public VipVO getVipInfo(String userID) {
//		return client.getVipInfo(userID);
//	}
//
//	
//	
//	//webManager
//	public ResultMessage addHotel(HotelVO hotelVO){
//		return webManager.addHotel(hotelVO);
//	}
//	
//	public ResultMessage addHotelManager(HotelManagerVO hotelManager){
//		return webManager.addHotelManager(hotelManager);
//	}
//	
//	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessVO){
//		return webManager.addWebBusiness(webBusinessVO);
//	}
//	
//	
//	//hotelManager
//	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
//		return hotelManager.getHotelManagerInfo(hotel_ID);
//	}
//	
//	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo){
//		return hotelManager.updateHotelManagerInfo(hotelManagerInfo);
//	}
//	
//	//webBusiness
//	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
//		return webBusiness.getWebBusinessInfo(webBusiness_ID);
//	}
//	
//	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo){
//		return webBusiness.updateWebBusinessInfo(webBusinessInfo);
//	}
//
//	
//}
