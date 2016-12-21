package view.right.user.myInfo;

import java.util.ArrayList;

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
import view.helpTools.MessageHelper;
import view.left.UserUI;
import viewController.UserMyInfoController;
import vo.CreditChangeVO;

/**
 * 客户界面_我的信息_查看历史信用记录
 * @author XueWang
 *
 */
public class HistoryCredit {

	private UserMyInfoController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private UserUI userui ;
	
	Button revert;

	TableView<Person> tableView;
	
	TableColumn<Person, String> time;
	TableColumn<Person, String> orderID;
	TableColumn<Person, String> action;
	TableColumn<Person, String> change;
	TableColumn<Person, String> result;
	
	private final ObservableList<Person> data = FXCollections.observableArrayList();;
	
	public HistoryCredit(UserMyInfoController controller){
		
		this.controller = controller;
		
		userui = new UserUI(controller);
		
		leftPane = userui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setRevertButton();
		
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/infoManagement/基本信息_查看信用记录界面背景.jpg\")");
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
				//返回查看基本信息界面
				controller.setCheckMyInfoView();
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
		time = new TableColumn<>("时  间");
		time.setCellValueFactory(new PropertyValueFactory<Person, String>("time"));
		time.setMinWidth(100);
		
		orderID = new TableColumn<>("订单号");
		orderID.setCellValueFactory(new PropertyValueFactory<Person, String>("orderID"));
		orderID.setMinWidth(150);
		
		action = new TableColumn<>("动作");
		action.setCellValueFactory(new PropertyValueFactory<Person, String>("action"));
		action.setMinWidth(100);
		
		change = new TableColumn<>("信用值变化");
		change.setCellValueFactory(new PropertyValueFactory<Person, String>("change"));
		change.setMinWidth(100);
		
		result= new TableColumn<>("信用值结果");
		result.setCellValueFactory(new PropertyValueFactory<Person, String>("result"));
		result.setMinWidth(100);
		
		
		tableView.setItems(data);
		tableView.setPrefHeight(430);
		tableView.setPrefWidth(555);
		tableView.getColumns().addAll(time, orderID, action, change, result);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 30.0);
		AnchorPane.setTopAnchor(tableView, 100.0);
	
	}
	
	public void setListValue(){
		ArrayList<CreditChangeVO> creditList = controller.getCreditList();
		if(creditList == null || creditList.isEmpty() || creditList.size() == 0){
			return;
		}
		for(CreditChangeVO c:creditList){
			String type = MessageHelper.creditChangeTypeToString(c.action);
			data.add(new Person(c.time,c.orderID,type,Integer.toString(c.cerditChange),Integer.toString(c.nowCredit)));
		}
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty time;
		private final SimpleStringProperty orderID;
		private final SimpleStringProperty action;
		private final SimpleStringProperty change;
		private final SimpleStringProperty result;
		
		private Person(String time, String orderID, String action, String change, String result){
			
			this.time = new SimpleStringProperty(time);
			this.orderID = new SimpleStringProperty(orderID);
			this.action = new SimpleStringProperty(action);
			this.change =  new SimpleStringProperty(change);
			this.result =  new SimpleStringProperty(result);
			
		}
		
		public String getTime(){
			return time.get();
		}
		
		public void setTime(String time){
			this.time.set(time);
		}
		
		public String getOrderID(){
			return orderID.get();
		}
		
		public void setOrderID(String orderID){
			this.orderID.set(orderID);
		}
		
		public String getAction(){
			return action.get();
		}
		
		public void setAction(String action){
			this.action.set(action);
		}
		
		public String getChange(){
			return change.get();
		}
		
		public void setChange(String change){
			this.change.set(change);
		}
		
		public String getResult(){
			return result.get();
		}
		
		public void setResult(String result){
			this.result.set(result);
		}
		
	}
}
