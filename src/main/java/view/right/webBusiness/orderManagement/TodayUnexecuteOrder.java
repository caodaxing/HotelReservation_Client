package view.right.webBusiness.orderManagement;

import java.util.ArrayList;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import logicService.order.ManageOrderService;
import logicService.stub.OrderService_Stub;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBOrderManagementController;
import viewController.WebBusinessLeftController;
import vo.OrderVO;

/**
 * 网站营销人员界面_订单管理_今日未执行订单
 * @author XueWang
 *
 */
public class TodayUnexecuteOrder {
	
	private WebBusinessLeftController controller;
	private WBOrderManagementController wbcontroller;
	private ManageOrderService manageOrderService;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TableView<Person> tableView;
	
	TableColumn<Person, Boolean> checkBox;
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> hotel;
	TableColumn<Person, String> userId;
	TableColumn<Person, String> lastExecuteTime;
	TableColumn<Person, Button> operation;
	
	private ObservableList<Person> data;
	private Button check;
	ArrayList<OrderVO> orderList;
	
	public TodayUnexecuteOrder(WebBusinessLeftController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		manageOrderService = new OrderService_Stub();
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加文本框
		setList();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setList(){
		
		//创建列表对象
		tableView = new TableView<Person>();
		tableView.setEditable(false);

		//添加列表内容
				
		//添加列
		checkBox = new TableColumn<>("");
	    checkBox.setCellFactory(CheckBoxTableCell.forTableColumn(checkBox));
		checkBox.setCellValueFactory(new PropertyValueFactory<>("choose"));
		checkBox.setEditable(true);
		checkBox.setMinWidth(100);
		
		orderId = new TableColumn<>("订单号");
		orderId.setCellValueFactory(new PropertyValueFactory<>("orderid"));
		orderId.setMinWidth(100);
		
		hotel = new TableColumn<>("酒店");
		hotel.setCellValueFactory(new PropertyValueFactory<>("hotel"));
		hotel.setMinWidth(100);
		
		userId = new TableColumn<>("用户ID");
		userId.setCellValueFactory(new PropertyValueFactory<>("userid"));
		userId.setMinWidth(100);
		
		lastExecuteTime = new TableColumn<>("最晚执行时间");
		lastExecuteTime.setCellValueFactory(new PropertyValueFactory<>("lastexecutetime"));
		lastExecuteTime.setMinWidth(100);
		
//		operation= new TableColumn<>("操作");
//		operation.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation"));
//		operation.setMinWidth(100);
		
		initialData();
		tableView.setItems(data);
		tableView.getColumns().addAll(checkBox, orderId, hotel, userId, lastExecuteTime);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public void initialData(){
		boolean result = false;
		data = FXCollections.observableArrayList();
		orderList = new ArrayList<OrderVO>();
		orderList = manageOrderService.getWebDailyUnexecutedOrderList();
		for(int i=0;i<orderList.size();i++){
			data.add(new Person(orderList.get(i).orderId, orderList.get(i).hotelID, orderList.get(i).userID, orderList.get(i).endTime));
		}
		
	}
	
	public void setButton(){
		//添加按钮
		check = new Button("查看");
		check.setId("CheckVIPAreaStrategy");
		check.setPrefSize(100, 40);
								
		//设置按钮位置
		check.setLayoutX(625);
		check.setLayoutY(525);
								
		//设置按钮监听
		check.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
									
		});
								
		//右侧pane添加
		rightPane.getChildren().add(check);
								
		AnchorPane.setLeftAnchor(check, 425.0);
		AnchorPane.setTopAnchor(check, 525.0);
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleBooleanProperty result;
		private final SimpleStringProperty orderId;
		private final SimpleStringProperty hotel;
		private final SimpleStringProperty userid;
		private final SimpleStringProperty lastexecutetime;
//		private final SimpleObjectProperty<Object> operation;
		
		private Person(String ORDERID, String hotel, String userid, String lastexecutetime){
			
			this.result = new SimpleBooleanProperty(false);
			this.orderId = new SimpleStringProperty(ORDERID);
			this.hotel = new SimpleStringProperty(hotel);
			this.userid = new SimpleStringProperty(userid);
			this.lastexecutetime =  new SimpleStringProperty(lastexecutetime);
//			this.operation =  new SimpleObjectProperty<Object>(operation);
			
		}
		
		public boolean getChoose(){
			return result.get();
		}
		
		public void setChoose(boolean bol){
			result.set(bol);
		}
		
		public String getOrderid(){
			return orderId.get();
		}
		
		public void setOrderId(String Orderid){
			orderId.set(Orderid);
		}
		
		public String getHotel(){
			return hotel.get();
		}
		
		public void setHotel(String Hotel){
			hotel.set(Hotel);
		}
		
		public String getUserid(){
			return userid.get();
		}
		
		public void setUserId(String userId){
			userid.set(userId);
		}
		
		public String getLastexecutetime(){
			return lastexecutetime.get();
		}
		
		public void setLastExecuteTime(String LastExecuteTime){
			lastexecutetime.set(LastExecuteTime);
		}
		
//		public Button getOperation(){
//			return (Button)operation.get();
//		}
//		
//		public void setOperation(Object Operation){
//			operation.set(Operation);
//		}
		
	}
	
	public void view(){
		wbcontroller = new WBOrderManagementController(controller.getStage(), controller.getUserId());
		wbcontroller.setUnexecuteOrderView();
		wbcontroller.getStage().show();
	}
}
