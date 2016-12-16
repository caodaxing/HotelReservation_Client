package view.right.hotelManager.orderManagement;

import java.util.ArrayList;

import Message.OrderListCondition;
import Message.OrderState;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import logicService.order.OrderListService;
import logicService.stub.OrderService_Stub;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.HotelManagerUI;
import view.right.user.myOrder.OrderList.Person;
import viewController.HMOrderManagementController;
import viewController.HotelManagerLeftController;
import vo.OrderVO;

/**
 * 酒店工作人员界面_管理订单_订单列表
 * @author XueWang
 */
public class OrderList {
	
	private HotelManagerLeftController controller;
	private HMOrderManagementController hmcontroller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	
	private HotelManagerUI hmui;
	
	Button revert;
	Button search;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> hotel;
	TableColumn<Person, String> orderState;
	TableColumn<Person, String> price;
	TableColumn<Person, Button> operation;
	
	private ObservableList<Person> data;
	private Button check;
	private int row;
	private ArrayList<OrderVO> orderList;
	
	public OrderList(HotelManagerLeftController controller){
		
		this.controller = controller;
//		hmcontroller = new HMOrderManagementController(controller.getStage(),controller.getUserId());
		hmui = new HotelManagerUI(controller);
		data = FXCollections.observableArrayList();
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加返回按钮
		setRevertButton();
		
		//设置列表
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单界面_全部订单背景.jpg\")");
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	private void setRevertButton(){
		
		//设置按钮
		revert = new Button("返回");
		revert.setPrefSize(100, 40);
		
		search = new Button("查询");
		search.setPrefSize(100, 40);
		
		//设置按钮位置
		search.setLayoutX(450);
		search.setLayoutY(550);
		
		revert.setLayoutX(650);
		revert.setLayoutY(550);
	
		//添加监听
		search.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				hmcontroller.setSearchOrderView();
				hmcontroller.getStage().show();
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setBlankView();
				controller.getStage().show();
			}
			
		});
			
		//添加组件
		rightPane.getChildren().add(search);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(search, 250.0);
		AnchorPane.setLeftAnchor(revert, 450.0);
		
		AnchorPane.setTopAnchor(search, 550.0);
		AnchorPane.setTopAnchor(revert, 550.0);
	
	}
	
	private void setList(){
		
		//创建列表对象
		tableView = new TableView<Person>();
		tableView.setEditable(false);
		
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
		operation.setCellFactory(new Callback<TableColumn<Person, Button>, TableCell<Person, Button>>(){
			public TableCell<Person, Button> call(TableColumn<Person, Button> param){
				return new TableCell<Person, Button>(){
					protected void updateItem(Button Item, boolean empty){
						if(!empty){
							Item = new Button("查看");
							Item.setPrefWidth(100);
							Item.setOnAction(event->{
								row = this.getTableRow().getIndex();
								System.out.println(row);
								checkFunction();
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation.setMinWidth(100);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(orderId, hotel, orderState, price, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public int getRow(){
		return row;
	}
	
	/*
	 * left下的列表内容控制
	 */
	public void initialData(){
		orderList = controller.getlist();
		if(orderList == null){
			return ;
		}
		for(OrderVO o :orderList){
			String state = MessageHelper.orderStateToString(o.orderState);
			data.add(new Person(o.orderId,o.hotelID,state,Double.toString(o.afterPrice),check));
		}
	}
	
	/*
	 * orderManagementController下的列表内容控制
	 */
	public void InitialData(){
		orderList = hmcontroller.getOrderList();
		if(orderList == null){
			return ;
		}
		for(OrderVO o :orderList){
			String state = MessageHelper.orderStateToString(o.orderState);
			data.add(new Person(o.orderId,o.hotelID,state,Double.toString(o.afterPrice),check));
		}
	}
	
	/*
	 * 查看按钮功能实现
	 */
	public void checkFunction(){
		System.out.println(controller.getlist().get(row).orderState.toString());
			if(controller.getlist().get(row).orderState == OrderState.EXECUTED ){
				hmcontroller = new HMOrderManagementController(controller.getStage(),controller.getUserId(),row);
				hmcontroller.setExecuteOrderView();
				hmcontroller.getStage().show();
			}else if(controller.getlist().get(row).orderState == OrderState.ABNORMAL){
				hmcontroller = new HMOrderManagementController(controller.getStage(),controller.getUserId(),row);
				hmcontroller.setAbnormalOrderView();
				hmcontroller.getStage().show();
			}else if(controller.getlist().get(row).orderState == OrderState.UNEXECUTED){
				hmcontroller = new HMOrderManagementController(controller.getStage(),controller.getUserId(),row);
				hmcontroller.setUnexecuteOrderView();
				hmcontroller.getStage().show();
			}else{
				hmcontroller = new HMOrderManagementController(controller.getStage(),controller.getUserId(),row);
				hmcontroller.setUndoOrderView();
				hmcontroller.getStage().show();
			}
		
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
