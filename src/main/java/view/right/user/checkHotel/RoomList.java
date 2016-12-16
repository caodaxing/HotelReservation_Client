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
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder.Person;
import viewController.UserCheckHotelController;
import viewController.UserLeftController;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 客户界面_查看酒店_酒店详情_酒店房间列表
 * @author XueWang
 *
 */
public class RoomList{

	private UserCheckHotelController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private UserUI userui;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> roomType;
	TableColumn<Person, String> initialPrice;
	TableColumn<Person, String> remainedNum;
	TableColumn<Person, Button> operation;
	
	private final ObservableList<Person> data = FXCollections.observableArrayList();
	private Button reverse;
	
	public RoomList(UserCheckHotelController controller){
		
		this.controller = controller;
		
		userui = new UserUI(controller);
		
		leftPane = userui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//设置返回按钮
		setRevertButton();
		
		//添加列表
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_酒店房间列表背景.jpg\")");
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
		roomType = new TableColumn<>("房间类型");
		roomType.setCellValueFactory(new PropertyValueFactory<Person, String>("roomType"));
		roomType.setMinWidth(125);
		
		initialPrice = new TableColumn<>("原始价格");
		initialPrice.setCellValueFactory(new PropertyValueFactory<Person, String>("initialPrice"));
		initialPrice.setMinWidth(125);
		
		remainedNum = new TableColumn<>("剩余数量");
		remainedNum.setCellValueFactory(new PropertyValueFactory<Person, String>("remainedNum"));
		remainedNum.setMinWidth(125);
		
		operation= new TableColumn<>("操作");
		operation.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation"));
		operation.setCellFactory(new Callback<TableColumn<Person, Button>, TableCell<Person, Button>>(){
			public TableCell<Person, Button> call(TableColumn<Person, Button> param){
				return new TableCell<Person, Button>(){
					protected void updateItem(Button Item, boolean empty){
						if(!empty){
							Item = new Button("预订");
							Item.setPrefWidth(100);
							Item.setOnAction(event->{
								int row = this.getTableRow().getIndex();
								controller.setRoomType(row);
								controller.setMakeOrderView();
								controller.getStage().show();
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation.setMinWidth(125);
		
		tableView.setItems(data);
		tableView.setPrefHeight(380);
		tableView.setPrefWidth(520);
		tableView.getColumns().addAll(roomType, initialPrice, remainedNum, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public void setListValue(){
		ArrayList<RoomVO> roomList = controller.getRoomList();
		if(roomList == null){
			return;
		}
		for(RoomVO r:roomList){
			reverse = new Button("预订");
			data.add(new Person(MessageHelper.roomTypeToString(r.roomType), Double.toString(r.price) ,Integer.toString(r.roomNum), reverse));
		}
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty roomType;
		private final SimpleStringProperty initialPrice;
		private final SimpleStringProperty remainedNum;
		private final SimpleObjectProperty<Object> operation;
		
		private Person(String RoomType, String InitialPrice, String RemainedNum, Button operation){
			
			this.roomType = new SimpleStringProperty(RoomType);
			this.initialPrice = new SimpleStringProperty(InitialPrice);
			this.remainedNum = new SimpleStringProperty(RemainedNum);
			this.operation =  new SimpleObjectProperty<Object>(operation);
			
		}
		
		public String getRoomType(){
			return roomType.get();
		}
		
		public void setRoomType(String RoomType){
			roomType.set(RoomType);
		}
		
		public String getInitialPrice(){
			return initialPrice.get();
		}
		
		public void setInitialPrice(String InitialPrice){
			initialPrice.set(InitialPrice);
		}
		
		public String getRemainedNum(){
			return remainedNum.get();
		}
		
		public void setRemainedNum(String RemainedNum){
			remainedNum.set(RemainedNum);
		}
		
		public Button getOperation(){
			return (Button)operation.get();
		}
		
		public void setOperation(Object Operation){
			operation.set(Operation);
		}
		
	}
	
	
}
