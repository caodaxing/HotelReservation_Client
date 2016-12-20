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
import vo.EvaluationVO;
import vo.HotelVO;

/**
 * 客户界面_查看酒店_酒店详情_评价列表
 * @author XueWang
 *
 */
public class EvaluationList {

	private UserCheckHotelController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private UserUI leftUI;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> orderId;
	TableColumn<Person, String> score;
	TableColumn<Person, Button> operation;
	
	private final ObservableList<Person> data ;
	private Button check;
	
	public EvaluationList(UserCheckHotelController controller){
		
		this.controller = controller;
		data = FXCollections.observableArrayList();
		
		leftUI = new UserUI(controller);
		
		leftPane = leftUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加返回按钮
		setRevertButton();
		
		//设置列表
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
		//添加样式表
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_酒店评价列表背景.jpg\")");
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
				// 返回酒店界面
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

		score = new TableColumn<>("评分");
		score.setCellValueFactory(new PropertyValueFactory<Person, String>("score"));
		score.setMinWidth(200);
		
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
								controller.setEvaluationID(row);
								controller.setEvaluationView();
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
		tableView.getColumns().addAll(orderId, score, operation);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		
		AnchorPane.setTopAnchor(tableView, 125.0);
	}
	
	public void setListValue(){
		ArrayList<EvaluationVO> evaluationList = controller.getEvaluationList();
		if(evaluationList == null || evaluationList.size() == 0 || evaluationList.isEmpty()){
			return;
		}
		
		for(EvaluationVO vo : evaluationList){
			
//			System.out.println(vo == null);
//			System.out.println(vo.commentLevel);
//			System.out.println(vo.orderID);
//			System.out.println(vo.evaluationContent);
			
			check = new Button("查看");
			data.add(new Person(vo.orderID, Double.toString(vo.commentLevel),check));
		}
	}
	
	/**
	 * 异常订单列表的内部数据类
	 */
	public static class Person{
		private final SimpleStringProperty orderId;
		private final SimpleStringProperty score;
		private final SimpleObjectProperty<Object> operation;
		
		private Person(String ORDERID, String score, Button operation){
			
			this.orderId = new SimpleStringProperty(ORDERID);
			this.score =  new SimpleStringProperty(score);
			this.operation =  new SimpleObjectProperty<Object>(operation);
			
		}
		
		public String getOrderid(){
			return orderId.get();
		}
		
		public void setOrderId(String Orderid){
			orderId.set(Orderid);
		}
		
		public String getScore(){
			return score.get();
		}
		
		public void setScore(String Score){
			score.set(Score);
		}
		
		public Button getOperation(){
			return (Button)operation.get();
		}
		
		public void setOperation(Object Operation){
			operation.set(Operation);
		}
		
	}
}
