package view.right.hotelManager.promotion;

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
import viewController.HMPromotionController;

/**
 * 酒店工作人员界面_促销策略_查看现有策略列表
 * @author XueWang
 *
 */
public class ExistStrategy {
	
	private HMPromotionController controller;
	
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	
	private HotelManagerUI hmui;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> promotionType;
	TableColumn<Person, String> promotionName;
	TableColumn<Person, Button> operation1;
	TableColumn<Person, Button> operation2;
	
	Button button11 = new Button("查看");
	Button button12 = new Button("预定");
	Button button21 = new Button("查看");
	Button button22 = new Button("预定");
	
	private final ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("1111", "1111", button11, button12),
			new Person("2222", "2222", button21, button22));
	
	public ExistStrategy(HMPromotionController controller){
		
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
		
		//添加列表内容
				
		//添加列
		promotionType = new TableColumn<>("策略类型");
		promotionType.setCellValueFactory(new PropertyValueFactory<Person, String>("promotiontype"));
		promotionType.setMinWidth(140);
		
		promotionName = new TableColumn<>("策略名称");
		promotionName.setCellValueFactory(new PropertyValueFactory<Person, String>("promotionname"));
		promotionName.setMinWidth(140);
		
		operation1 = new TableColumn<>("操作1");
		operation1.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation1"));
		operation1.setMinWidth(80);
		
		operation2= new TableColumn<>("操作2");
		operation2.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation2"));
		operation2.setMinWidth(80);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(promotionType, promotionName, operation1, operation2);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty promotionType;
		private final SimpleStringProperty promotionName;
		private final SimpleObjectProperty<Object> operation1;
		private final SimpleObjectProperty<Object> operation2;
		
		private Person(String promotionType, String promotionName, Button operation1, Button operation2){
			
			this.promotionType = new SimpleStringProperty(promotionType);
			this.promotionName = new SimpleStringProperty(promotionName);
			this.operation1 =  new SimpleObjectProperty<Object>(operation1);
			this.operation2 =  new SimpleObjectProperty<Object>(operation2);
			
		}
		
		public String getPromotiontype(){
			return promotionType.get();
		}
		
		public void setPromotiontype(String Promotiontype){
			promotionType.set(Promotiontype);
		}
		
		public String getPromotionname(){
			return promotionName.get();
		}
		
		public void setPromotionname(String Promotionname){
			promotionName.set(Promotionname);
		}
		
		public Button getOperation1(){
			return (Button)operation1.get();
		}
		
		public void setOperation1(Object Operation1){
			operation1.set(Operation1);
		}
		
		public Button getOperation2(){
			return (Button)operation2.get();
		}
		
		public void setOperation2(Object Operation){
			operation2.set(Operation);
		}
		
	}
}
