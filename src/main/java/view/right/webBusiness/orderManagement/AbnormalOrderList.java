package view.right.webBusiness.orderManagement;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBOrderManagementController;

/**
 * 网站营销人员界面_订单管理_异常订单列表
 * @author XueWang
 *
 */
public class AbnormalOrderList {
	
	private WBOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui = new WebBusinessUI();
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> hotel;
	TableColumn<Person, String> userId;
	TableColumn<Person, String> lastExecuteTime;
	TableColumn<Person, Button> operation;
	
	Button button1 = new Button("查看");
	Button button2 = new Button("查看");
	private final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("1111", "1111", "1111", "1111", button1),
			new Person("2222", "2222", "2222", "2222", button2));
	
	public AbnormalOrderList(WBOrderManagementController controller){
		
		this.controller = controller;
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加文本框
		setList();
		
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
		orderId = new TableColumn<>("订单号");
		orderId.setCellValueFactory(new PropertyValueFactory<Person, String>("orderid"));
		orderId.setMinWidth(100);
		
		hotel = new TableColumn<>("酒店");
		hotel.setCellValueFactory(new PropertyValueFactory<Person, String>("hotel"));
		hotel.setMinWidth(100);
		
		userId = new TableColumn<>("用户ID");
		userId.setCellValueFactory(new PropertyValueFactory<Person, String>("userid"));
		userId.setMinWidth(100);
		
		lastExecuteTime = new TableColumn<>("最晚执行时间");
		lastExecuteTime.setCellValueFactory(new PropertyValueFactory<Person, String>("lastexecutetime"));
		lastExecuteTime.setMinWidth(100);
		
		operation= new TableColumn<>("操作");
		operation.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation"));
		operation.setMinWidth(100);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(orderId, hotel, userId, lastExecuteTime, operation);
		
		//
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
