package viewController;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import Message.ResultMessage;
import Message.RoomType;
import javafx.stage.Stage;
import logic.hotel.CheckHotel;
import logic.order.CreateOrder;
import logic.room.Room;
import logicService.hotel.CheckHotelService;
import logicService.hotel.SearchHotelService;
import logicService.order.CreateOrderService;
import logicService.room.RoomService;
import logicService.stub.HotelService_Stub;
import logicService.stub.OrderService_Stub;
import logicService.stub.RoomService_Stub;
import view.right.user.checkHotel.*;
import view.right.user.myOrder.OrderList;
import vo.EvaluationVO;
import vo.HotelSearchVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class UserCheckHotelController extends UserLeftController {
	
	//逻辑层接口
	CreateOrderService createOrderService;
	SearchHotelService searchHotelService;
	CheckHotelService checkHotelService;
	RoomService roomService;
	
	//控制的界面
	private EvaluationList evaluationListUI;
	private HistoryOrderList historyOrderListUI;
	private HotelInfo hotelInfoUI;
	private MakeOrder makeOrderUI;
	private RoomList roomListUI;
	private SearchResultList searchResultListUI;
	private SearchHotel searchHotelUI;
	private SuccessOrder successOrderUI;
	
	//同层跳转
	UserMyOrderController orderController;
	
	private ArrayList<HotelVO> hotelList;
	private String hotelID;
	private RoomType roomType;
	private String evaluationID;
	private ArrayList<EvaluationVO> evaluationList;
	private ArrayList<RoomVO> roomList;
	
	public UserCheckHotelController(Stage stage , String userID){
		
		this.stage = stage ;
		this.userID = userID;
		
		createOrderService = new CreateOrder();
		searchHotelService = new logic.hotel.SearchHotel();
		checkHotelService = new CheckHotel();
		roomService = new Room();
		
		//evaluationListUI = new EvaluationList(this);
		//historyOrderListUI = new HistoryOrderList(this);
		//hotelInfoUI = new HotelInfo(this);
		//makeOrderUI = new MakeOrder(this);
		//roomListUI = new RoomList(this);
		searchHotelUI = new SearchHotel(this);
		//searchResultListUI = new SearchResultList(this);
		//successOrderUI = new SuccessOrder(this);
		
		orderController = new UserMyOrderController(stage,userID);
	
	}
	
	public Stage getStage(){
		return stage;
	}
	
	/*
	 * 酒店评价列表界面
	 */
	public void setEvaluationListView(){
		setEvaluationList();
		evaluationListUI = new EvaluationList(this);
		evaluationListUI.setListValue();
		stage.setScene(evaluationListUI.getScene());
	}
	
	/*
	 * 查看评价详情
	 */
	public void setEvaluationView(){
		orderController.setOrderID(evaluationID);
		orderController.setEvaluationInfoView();
	}
	
	/*
	 * 用户历史订单界面
	 */
	public void setHistoryOrderListView(){
		setHistoryOrderList();
		HistoryOrderList hotelOrderList = new HistoryOrderList(this);
		hotelOrderList.setListValue();
		stage.setScene(hotelOrderList.getScene());
		stage.show();
	}
	
	/*
	 * 酒店详情界面
	 */
	public void setHotelInfoView(){
		roomType = null;
		evaluationID = null;
		orderID = null;
		
		hotelInfoUI = new HotelInfo(this);
		hotelInfoUI.setText();
		stage.setScene(hotelInfoUI.getScene());
	}
	
	public void setMakeOrderView(){
		makeOrderUI = new MakeOrder(this);
		if(roomType!=null){
			//若有房间类型则设定
			makeOrderUI.setRoomType(roomType);
		}
		stage.setScene(makeOrderUI.getScene());	
	}
	
	/*
	 * 酒店可用房间列表
	 */
	public void setRoomListView(){
		setRoomList();
		roomListUI = new RoomList(this);
		roomListUI.setListValue();
		stage.setScene(roomListUI.getScene());
	}
	
	/*
	 * 搜索酒店界面
	 */
	public void setSearchHotelView(){
		hotelList = null;
		hotelID = null;
		
		searchHotelUI = new SearchHotel(this);
		stage.setScene(searchHotelUI.getScene());	
	}
	
	/*
	 * 调用UserMyOrderController跳至对应订单界面
	 */
	public void setOrderView(){
		orderController.setOrderID(orderID);
		orderController.setOrderView();
	}
	
	/*
	 * 跳至搜索结果列表界面,清空evaluation,orderlist,roomlist
	 */
	public void setSearchResultListView() {
		evaluationList = null;
		orderList = null;
		roomList = null;
		hotelID = null;
		
		searchResultListUI = new SearchResultList(this);
		searchResultListUI.setListValue();
		stage.setScene(searchResultListUI.getScene());
	}

	/*
	 * 搜索酒店并跳转至酒店列表
	 */
	public void searchAndSetSearchHotelListView() {
		HotelSearchVO vo = searchHotelUI.getSearchVO();
		if(vo == null){
			return;
		}
		if(vo.startTime.equals("x")){
			return ;
		}
		if(vo.city.equals("") || vo.tradingArea.equals("")){
			showDialog("请输入酒店城市和商圈");
			return ;
		}
		hotelList = searchHotelService.search(vo);
		//若为空
		if(hotelList == null){
			showDialog("没有符合条件的酒店");
			return ;
		}
		//不为空则跳转
		setSearchResultListView();
		
	}

	/*
	 * 生成订单并跳至生成成功反馈界面，若不成功则不跳转
	 */
	public void makeOrderAndSetSuccessView(){
		OrderVO vo = makeOrderUI.getOrderVO();
		if(vo == null){
			return;
		}
		//再次检查orderVO是否有效
		if(!orderVOIsCorrect(vo)){
			if(vo.hotelID == null || vo.userID == null ){
				//hotelID或ID为空，系统错误，返回酒店列表重试
					showDialog("系统错误，请重试");
					setSearchResultListView();
					return ;
				}
			if(vo.startTime!="x"){
				showDialog("请输入有效值");
			}
			return;
		}
		
		//判断房间数量是否足够
		int remainNum = roomService.getRemainingRoomNums(hotelID, vo.roomType);
		if ( remainNum< vo.roomNum){
			showDialog("房间剩余数量不足，剩余数量为："+remainNum);
			return;
		}
		
		OrderVO newOrder= createOrderService.createOrder(vo);
		if(newOrder != null){
			showDialog("系统错误，请重试");
			return;
		}else{
			showDialog("预定成功");
			successOrderUI = new SuccessOrder(this,newOrder);
			stage.setScene(successOrderUI.getScene());
		}
	}
	
	private boolean orderVOIsCorrect(OrderVO vo){
		if( vo.roomType == null || vo.roomNum<1 || vo.startTime == "x" || vo.numOfPeople<1 || vo.hotelID == null || vo.userID == null ){
			return false;
		}
		return true;
	}
	
	//hotel
	public void setSortedList(HotelSearchCondition condition) {
		hotelList = searchHotelService.getSortedList(condition, hotelList);
	}
	
	public ArrayList<HotelVO> getHotelList() {
		return hotelList;
	}

	public void setHotelID(int row) {
		hotelID = hotelList.get(row).hoteID;
	}
	
	public HotelVO getHotelInfo() {
		return checkHotelService.getHotelnfo(hotelID);
	}
	
	/*
	 * 查看特定酒店是否预定过
	 * @param hotelID
	 * @return string"是"、"否"
	 */
	public String checkWeitherReserved(String hoteID) {
		String s = "否";
		ArrayList<HotelVO> list = searchHotelService.getBookedHotelList(userID);
		for(HotelVO h :list){
			if(hotelID == h.hoteID){
				s = "是";
				break;
			}
		}
		return s;
	}
	
	//evaluation
	private void setEvaluationList(){
		evaluationList = checkHotelService.getHotelEvaluations(hotelID);
	}
	
	public ArrayList<EvaluationVO> getEvaluationList() {
		return evaluationList;
	}
	
	public void setEvaluationID(int row){
		evaluationID = evaluationList.get(row).orderID;
	}	
	
	public void getEvaluationInfo(){
		orderService.getEvaluationInfo(evaluationID);
	}
	
	//room
	public void setRoomList(){
		roomList = roomService.getRoomList(hotelID);
	}

	public ArrayList<RoomVO> getRoomList(){
		return roomList;
	}
	
	public void setRoomType(int row){
		roomType = roomList.get(row).roomType;
	}

	//order
	private void setHistoryOrderList(){
		orderList = orderListService.filterSpecificUserHotelOrderList(userID, hotelID);
	}
	
	public void setOrderID(int row){
		orderID = orderList.get(row).orderId;
	}
	
	public String getHotelName(){
		return checkHotelService.getHotelnfo(hotelID).hotelName;
	}
	
	public String getHotelID(){
		return hotelID;
	}
	
	public String getHotelName(String hotelID){
		return checkHotelService.getHotelnfo(hotelID).hotelName;
	}
	
	public void setHistoryHotelListView(){
		hotelList = searchHotelService.getBookedHotelList(userID);
		setSearchResultListView();
	}
	
}
