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
import view.right.user.checkHotel.RoomList.Person;
import viewController.UserCheckHotelController;
import vo.HotelVO;
import vo.OrderVO;

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
	TableColumn<Person,Button> operation;
	
	private final ObservableList<Person> data = FXCollections.observableArrayList();
	private Button check;
	
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
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_历史订单列表背景.jpg\")");
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
				//返回酒店界面
				controller.setHotelInfoView();
				controller.getStage().show();
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
		orderId.setMinWidth(200);
		
		roomType = new TableColumn<>("房间类型");
		roomType.setCellValueFactory(new PropertyValueFactory<Person, String>("roomType"));
		roomType.setMinWidth(100);
		
		orderState = new TableColumn<>("订单状态");
		orderState.setCellValueFactory(new PropertyValueFactory<Person, String>("orderState"));
		orderState.setMinWidth(100);
	
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
								controller.setOrderID(row);
								controller.setOrderView();
								controller.getStage().show();
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
		tableView.getColumns().addAll(orderId, roomType, orderState);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public void setListValue(){
		ArrayList<OrderVO> historyList = controller.getOrderList();
		if(historyList == null){
			return;
		}
		for(OrderVO o : historyList){
			check = new Button("查看");
			data.add(new Person(o.orderId,MessageHelper.roomTypeToString(o.roomType),MessageHelper.orderStateToString(o.orderState),check ) );
		}
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty orderId;
		private final SimpleStringProperty roomType;
		private final SimpleStringProperty orderState;
		private final SimpleObjectProperty<Object> operation;
		
		private Person(String orderId, String roomType, String orderState,Button operation){
			
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
