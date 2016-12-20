package view.right.hotelManager.roomInfo;

import java.util.ArrayList;

import Message.ResultMessage;
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
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.helpTools.OneButtonDialog;
import view.left.HotelManagerUI;
import viewController.HMRoomInfoController;
import vo.RoomVO;

/**
 * 酒店工作人员界面_客房管理_查看现有客房列表
 * @author XueWang
 *
 */
public class ExistRooms {
	
	private HMRoomInfoController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private HotelManagerUI hmui;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> roomType;
	TableColumn<Person, String> initialPrice;
	TableColumn<Person, String> remainedNum;
	TableColumn<Person, Button> operation;
	
	private ObservableList<Person> data;
	private ArrayList<RoomVO> roomList;
	private int remainNum;
	private Button change;
	
	public ExistRooms(HMRoomInfoController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		data = FXCollections.observableArrayList();
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//设置返回按钮
		setRevertButton();
		
		//添加列表
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
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
				controller.setFirstView();
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
							Item = new Button("修改");
							Item.setPrefWidth(100);
							Item.setOnAction(event->{
								int row = this.getTableRow().getIndex();
								controller.setRoomList();
								controller.setRoomType(row);
								controller.setModifyRoomsView();
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
		tableView.getColumns().addAll(roomType, initialPrice, remainedNum, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public void initialData(){
		
		roomList = controller.getRoomList();
		if(roomList == null){
			return;
		}else{
			for(int i=0;i<roomList.size();i++){
				controller.setRemainedNum(roomList.get(i).roomType);
				remainNum = controller.getRemainedNum();
				data.add(new Person(MessageHelper.roomTypeToString(roomList.get(i).roomType), String.valueOf(roomList.get(i).price),
						String.valueOf(remainNum), change));
			}
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
		
		private Person(String RoomType, String InitialPrice, String RemainedNum, Button Operation){
			
			this.roomType = new SimpleStringProperty(RoomType);
			this.initialPrice = new SimpleStringProperty(InitialPrice);
			this.remainedNum = new SimpleStringProperty(RemainedNum);
			this.operation =  new SimpleObjectProperty<Object>(Operation);
			
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
