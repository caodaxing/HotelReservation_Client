package view.right.user.myOrder;

import java.util.ArrayList;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.UserUI;
import viewController.UserLeftController;
import viewController.UserMyOrderController;
import vo.OrderVO;

/**
 * 客户界面_我的订单_订单列表
 * @author XueWang
 *
 */
public class OrderList {
	
	private UserLeftController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private UserUI userUI;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> hotel;
	TableColumn<Person, String> orderState;
	TableColumn<Person, String> price;
	TableColumn<Person, Button> operation;
	
	private ObservableList<Person> data ;
	private Button check;
	
	public OrderList(UserLeftController controller){
		
		this.controller = controller;
		
		data = FXCollections.observableArrayList();
		
		userUI = new UserUI(controller);
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//设置列表
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单界面_全部订单背景.jpg\")");
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
		orderId = new TableColumn<>("订单号");
		orderId.setCellValueFactory(new PropertyValueFactory<Person, String>("orderid"));
		orderId.setMinWidth(120);
		
		hotel = new TableColumn<>("酒店");
		hotel.setCellValueFactory(new PropertyValueFactory<Person, String>("hotel"));
		hotel.setMinWidth(100);
		
		orderState = new TableColumn<>("订单状态");
		orderState.setCellValueFactory(new PropertyValueFactory<Person, String>("orderstate"));
		orderState.setMinWidth(90);
		
		price = new TableColumn<>("价格");
		price.setCellValueFactory(new PropertyValueFactory<Person, String>("price"));
		price.setMinWidth(100);
		
		operation= new TableColumn<>("操作");
		operation.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation"));
		operation.setCellFactory(new Callback<TableColumn<Person, Button>, TableCell<Person, Button>>(){
			public TableCell<Person, Button> call(TableColumn<Person, Button> param){
				return new TableCell<Person, Button>(){
					protected void updateItem(Button Item, boolean empty){
						if(!empty){
							Item = new Button("查看");
							Item.setPrefWidth(100);
							Item.setOnAction(event->{
								int row = this.getTableRow().getIndex();
								//待修改
								UserMyOrderController right = new UserMyOrderController(controller.getStage(),controller.getUserID());
								right.setOrderList(controller.getOrderList());
								right.setOrderID(row);
								right.setOrderView();
								right.getStage().show();
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation.setMinWidth(100);
		
		tableView.setItems(data);
		tableView.setPrefHeight(380);
		tableView.setPrefWidth(520);
		tableView.getColumns().addAll(orderId, hotel, orderState, price, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	/*
	 * 界面层传入orderist构造界面
	 * @param controller传入的
	 */
	public void setTextValue(){
		ArrayList<OrderVO> orderList = controller.getOrderList();
		if(orderList == null){
			return ;
		}
		for(OrderVO o :orderList){
			check = new Button("查看");
			String state = MessageHelper.orderStateToString(o.orderState);
			data.add(new Person(o.orderId,controller.getHotelName(o.hotelID),state,Double.toString(o.afterPrice),check));
		}
	}

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

