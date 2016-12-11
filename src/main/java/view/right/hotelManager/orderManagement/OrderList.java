package view.right.hotelManager.orderManagement;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面_管理订单_订单列表
 * @author XueWang
 */
public class OrderList {
	
	private HotelManagerLeftController controller;
	
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	
	private HotelManagerUI hmui;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> hotel;
	TableColumn<Person, String> orderState;
	TableColumn<Person, String> price;
	TableColumn<Person, Button> operation;
	
	Button button1 = new Button("查看");
	Button button2 = new Button("查看");
	
	private final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("1111", "1111", "1111", "1111", button1),
			new Person("2222", "2222", "2222", "2222", button2));
	
	public OrderList(HotelManagerLeftController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
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
		orderId.setCellValueFactory(new PropertyValueFactory<Person, String>("orderid"));
		orderId.setMinWidth(100);
		
		hotel = new TableColumn<>("酒店");
		hotel.setCellValueFactory(new PropertyValueFactory<Person, String>("hotel"));
		hotel.setMinWidth(100);
		
		orderState = new TableColumn<>("订单状态");
		orderState.setCellValueFactory(new PropertyValueFactory<Person, String>("orderstate"));
		orderState.setMinWidth(100);
		
		price = new TableColumn<>("价格");
		price.setCellValueFactory(new PropertyValueFactory<Person, String>("price"));
		price.setMinWidth(100);
		
		operation= new TableColumn<>("操作");
		operation.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation"));
		operation.setMinWidth(100);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(orderId, hotel, orderState, price, operation);
		
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
		private final SimpleStringProperty hotel;
		private final SimpleStringProperty orderState;
		private final SimpleStringProperty price;
		private final SimpleObjectProperty<Object> operation;
		
		private Person(String orderId, String hotel, String orderState, String price, Button operation){
			
			this.orderId = new SimpleStringProperty(orderId);
			this.hotel = new SimpleStringProperty(hotel);
			this.orderState = new SimpleStringProperty(orderState);
			this.price =  new SimpleStringProperty(price);
			this.operation =  new SimpleObjectProperty<Object>(operation);
			
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
		
		public String getOrderstate(){
			return orderState.get();
		}
		
		public void setOrderstate(String Orderstate){
			orderState.set(Orderstate);
		}
		
		public String getPrice(){
			return price.get();
		}
		
		public void setPrice(String Price){
			price.set(Price);
		}
		
		public Button getOperation(){
			return (Button)operation.get();
		}
		
		public void setOperation(Object Operation){
			operation.set(Operation);
		}
		
	}
}
