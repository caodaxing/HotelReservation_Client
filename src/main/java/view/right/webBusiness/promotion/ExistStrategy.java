package view.right.webBusiness.promotion;

import java.util.ArrayList;

import Message.PromotionType;
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
import view.left.WebBusinessUI;
import view.right.webBusiness.orderManagement.TodayUnexecuteOrder.Person;
import viewController.WBPromotionController;
import vo.OrderVO;
import vo.PromotionVO;


/**
 * 网站营销人员界面_促销策略_查看现有策略列表
 * @author XueWang
 *
 */
public class ExistStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	
	private WebBusinessUI wbui;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> promotionType;
	TableColumn<Person, String> promotionName;
	TableColumn<Person, Button> operation1;
	TableColumn<Person, Button> operation2;
	
	private ObservableList<Person> data;
	private Button check;
	private Button delete;
	ArrayList<PromotionVO> promotionList;
	
	public ExistStrategy(WBPromotionController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		data = FXCollections.observableArrayList();
		
		leftPane = wbui.getPane();
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
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看现有促销策略列表背景.jpg\")");
		
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
				controller.setFirstVeiw();
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
		tableView.setPrefSize(560, 430);
		tableView.setEditable(false);
				
		//添加列
		promotionType = new TableColumn<>("策略类型");
		promotionType.setCellValueFactory(new PropertyValueFactory<Person, String>("promotiontype"));
		promotionType.setMinWidth(185);
		
		promotionName = new TableColumn<>("策略名称");
		promotionName.setCellValueFactory(new PropertyValueFactory<Person, String>("promotionname"));
		promotionName.setMinWidth(185);
		
		operation1 = new TableColumn<>("操作1");
		operation1.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation1"));
		operation1.setCellFactory(new Callback<TableColumn<Person, Button>, TableCell<Person, Button>>(){
			public TableCell<Person, Button> call(TableColumn<Person, Button> param){
				return new TableCell<Person, Button>(){
					protected void updateItem(Button Item, boolean empty){
						if(!empty){
							Item = new Button("查看");
							Item.setPrefWidth(90);
							Item.setOnAction(event->{
								int row = this.getTableRow().getIndex();
								controller.setPromotionId(row);
								promotionList = controller.getPromotionList();
								PromotionVO promotionVO = controller.getPromotionVO();
									if(promotionVO.promotionType == PromotionType.WEB_11_11){
										controller.setCheckSpecialTimeStrategyView();
										controller.getStage().show();
									}else if(promotionVO.promotionType == PromotionType.WEB_VIP_LEVEL){
										controller.setCheckVIPStrategyView();
										controller.getStage().show();
									}else if(promotionVO.promotionType == PromotionType.WEB_VIP_TRADINGAREA){
										controller.setCheckVIPAreaStrategyView();
										controller.getStage().show();
									}
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation1.setMinWidth(90);
		
		operation2= new TableColumn<>("操作2");
		operation2.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation2"));
		operation2.setCellFactory(new Callback<TableColumn<Person, Button>, TableCell<Person, Button>>(){
			public TableCell<Person, Button> call(TableColumn<Person, Button> param){
				return new TableCell<Person, Button>(){
					protected void updateItem(Button Item, boolean empty){
						if(!empty){
							Item = new Button("删除");
							Item.setPrefWidth(90);
							Item.setOnAction(event->{
								int num = this.getTableRow().getIndex();
								controller.setPromotionId(num);
									if(controller.getDeletePromotionResult(num) == ResultMessage.SUCCESS){
										controller.showDialog("删除成功");
										controller.setExistStrategyView();
										controller.getStage().show();
									}else{
										controller.showDialog("删除失败");
									}
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation2.setMinWidth(90);
		
		tableView.setItems(data);
		tableView.getColumns().addAll(promotionType, promotionName, operation1, operation2);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 30.0);
		
		AnchorPane.setTopAnchor(tableView, 100.0);
	}

	
	public void initialData(){
		
		promotionList = controller.getPromotionList();
		if(promotionList == null){
			return ;
		}
		for(PromotionVO o :promotionList){
			data.add(new Person(MessageHelper.promotionTypeToString(o.promotionType),o.promotionName,check,delete));
		}
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
