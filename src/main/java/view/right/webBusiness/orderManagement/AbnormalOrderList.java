package view.right.webBusiness.orderManagement;

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
import logic.order.ManageOrder;
import logicService.order.ManageOrderService;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder.Person;
import viewController.WBOrderManagementController;
import viewController.WebBusinessLeftController;
import vo.OrderVO;

/**
 * 网站营销人员界面_订单管理_异常订单列表
 * @author XueWang
 *
 */
public class AbnormalOrderList {
	
	private WebBusinessLeftController controller;
	private WBOrderManagementController wbcontroller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> hotel;
	TableColumn<Person, String> userId;
	TableColumn<Person, String> lastExecuteTime;
	TableColumn<Person, Button> operation;
	
	private ObservableList<Person> data;
	private ArrayList<OrderVO> orderList;
	private Button check;
	
	public AbnormalOrderList(WebBusinessLeftController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		wbcontroller = new WBOrderManagementController(controller.getStage(), controller.getUserId());
		data = FXCollections.observableArrayList();
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本框
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单管理_异常订单列表背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setList(){
		
		//创建列表对象
		tableView = new TableView<Person>();
		tableView.setEditable(false);
		
		//添加列
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
								wbcontroller = new WBOrderManagementController(controller.getStage(), controller.getUserId());
								wbcontroller.setOrderList(controller.getOrderList());
								wbcontroller.setOrderId(row);
								wbcontroller.setabnormalOrderView();
								wbcontroller.getStage().show();
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation.setMinWidth(100);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(orderId, hotel, userId, lastExecuteTime, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public void initialData(){
		orderList = controller.getOrderList();
		if(orderList == null){
			return ;
		}
		for(OrderVO o :orderList){
			data.add(new Person(o.orderId,o.hotelID,o.userID,o.endTime,check));
		}
		
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty orderId;
		private final SimpleStringProperty hotel;
		private final SimpleStringProperty userid;
		private final SimpleStringProperty lastexecutetime;
		private final SimpleObjectProperty<Object> operation;
		
		private Person(String ORDERID, String hotel, String userid, String lastexecutetime, Button operation){
			
			this.orderId = new SimpleStringProperty(ORDERID);
			this.hotel = new SimpleStringProperty(hotel);
			this.userid = new SimpleStringProperty(userid);
			this.lastexecutetime =  new SimpleStringProperty(lastexecutetime);
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
		
		public Button getOperation(){
			return (Button)operation.get();
		}
		
		public void setOperation(Object Operation){
			operation.set(Operation);
		}
		
	}
}
