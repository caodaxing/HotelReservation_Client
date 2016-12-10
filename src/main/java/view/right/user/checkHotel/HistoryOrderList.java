package view.right.user.checkHotel;

import java.util.ArrayList;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import view.right.user.checkHotel.RoomList.Person;
import viewController.UserCheckHotelController;

/**
 * 客户界面_查看酒店_酒店详情_历史订单
 * @author XueWang
 *
 */
public class HistoryOrderList{

	private UserCheckHotelController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private UserUI userUI;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> roomType;
	TableColumn<Person, String> orderState;
	TableColumn<Person, Button> operation;
	
	Button button1 = new Button("查看");
	Button button2 = new Button("查看");
	
	private final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("1111", "1111", "1111", button1),
			new Person("2222", "2222", "2222", button2));
	
	public HistoryOrderList(UserCheckHotelController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加返回按钮
		setRevertButton();
		
		//设置列表
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	private void setRevertButton(){
		
		//设置按钮
		revert = new Button("返回");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		revert.setLayoutX(650);
		revert.setLayoutY(550);
	
		//添加监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
			
		//添加组件
		rightPane.getChildren().add(revert);

		AnchorPane.setLeftAnchor(revert, 450.0);
		AnchorPane.setTopAnchor(revert, 550.0);
	
	}
	
	private void setList(){
		
		//创建列表对象
		tableView = new TableView<Person>();
		tableView.setEditable(false);
		
		//添加列表内容
				
		//添加列
		orderId = new TableColumn<>("订单号");
		orderId.setCellValueFactory(new PropertyValueFactory<Person, String>("orderId"));
		orderId.setMinWidth(125);
		
		roomType = new TableColumn<>("房间类型");
		roomType.setCellValueFactory(new PropertyValueFactory<Person, String>("roomType"));
		roomType.setMinWidth(125);
		
		orderState = new TableColumn<>("订单状态");
		orderState.setCellValueFactory(new PropertyValueFactory<Person, String>("orderState"));
		orderState.setMinWidth(125);
		
		operation= new TableColumn<>("操作");
		operation.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation"));
		operation.setMinWidth(125);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(orderId, roomType, orderState, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty orderId;
		private final SimpleStringProperty roomType;
		private final SimpleStringProperty orderState;
		private final SimpleObjectProperty<Object> operation;
		
		private Person(String orderId, String roomType, String orderState, Button operation){
			
			this.orderId = new SimpleStringProperty(orderId);
			this.roomType = new SimpleStringProperty(roomType);
			this.orderState = new SimpleStringProperty(orderState);
			this.operation =  new SimpleObjectProperty<Object>(operation);
			
		}
		
		public String getOrderId(){
			return orderId.get();
		}
		
		public void setOrderId(String OrderId){
			orderId.set(OrderId);
		}
		
		public String getRoomType(){
			return roomType.get();
		}
		
		public void setRoomType(String RoomType){
			roomType.set(RoomType);
		}
		
		public String getOrderState(){
			return orderState.get();
		}
		
		public void setOrderState(String OrderState){
			orderState.set(OrderState);
		}
		
		public Button getOperation(){
			return (Button)operation.get();
		}
		
		public void setOperation(Object Operation){
			operation.set(Operation);
		}
		
	}
	
}
