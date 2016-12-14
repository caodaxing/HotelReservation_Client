package view.right.vistor;

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
import view.left.UserUI;
import view.left.VistorUI;
import view.right.user.checkHotel.SearchResultList.Person;
import viewController.UserCheckHotelController;
import viewController.VistorController;
import viewController.WBOrderManagementController;
import vo.HotelVO;

/**
 * 游客界面_查看酒店_搜索结果列表
 * @author XueWang
 *
 */
public class SearchResultList {

	private VistorController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private VistorUI leftUI;
	
	Button ascendingSort;
	Button dscendingSort;
	Button starLevel;
	Button evaluation;
	
	Button revert;
	
	TableView<Person> tableView;
	
	TableColumn<Person, String> hotelName;
	TableColumn<Person, String> whetherReserve;
	TableColumn<Person, String> starlevel;
	TableColumn<Person, String> evalaution;
	TableColumn<Person, Button> operation1;
	
	private final ObservableList<Person> data = FXCollections.observableArrayList();;
	private Button check;
	
	public SearchResultList(VistorController controller){
		
		this.controller = controller;
		
		leftUI = new VistorUI(controller);
		//service
		
		leftPane = leftUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加排序和返回按钮
		setSortButton();
		
		//设置列表,列表值初始化放到controller中
		setList();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_搜索结果列表背景.jpg\")");
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	public void setSortButton(){
		
		//设置按钮
		ascendingSort = new Button("价格升序");
		ascendingSort.setId("searchResultList");
		ascendingSort.setPrefSize(80, 30);
		
		dscendingSort = new Button("价格降序");
		dscendingSort.setId("searchResultList");
		dscendingSort.setPrefSize(80, 30);
		
		starLevel = new Button("星级");
		starLevel.setId("searchResultList");
		starLevel.setPrefSize(80, 30);
		
		evaluation = new Button("评价");
		evaluation.setId("searchList");
		evaluation.setPrefSize(80, 30);
		
		revert = new Button("返回");
		revert.setId("searchList");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		ascendingSort.setLayoutX(350);
		ascendingSort.setLayoutY(100);
		
		dscendingSort.setLayoutX(450);
		dscendingSort.setLayoutY(100);
		
		starLevel.setLayoutX(550);
		starLevel.setLayoutY(100);
		
		evaluation.setLayoutX(650);
		evaluation.setLayoutY(100);
		
		revert.setLayoutX(650);
		revert.setLayoutY(550);
		
		//设置按钮监听
		ascendingSort.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		dscendingSort.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		starLevel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		evaluation.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//返回搜索酒店界面，每次返回搜索界面都将list和iD清空
				controller.setSearchHotelView();
				controller.getStage().show();
			}
			
		});
			
		//添加组件
		rightPane.getChildren().add(ascendingSort);
		rightPane.getChildren().add(dscendingSort);
		rightPane.getChildren().add(starLevel);
		rightPane.getChildren().add(evaluation);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(ascendingSort, 150.0);
		AnchorPane.setLeftAnchor(dscendingSort, 250.0);
		AnchorPane.setLeftAnchor(starLevel, 350.0);
		AnchorPane.setLeftAnchor(evaluation, 450.0);
		AnchorPane.setLeftAnchor(revert, 450.0);
		
		AnchorPane.setTopAnchor(ascendingSort, 100.0);
		AnchorPane.setTopAnchor(dscendingSort, 100.0);
		AnchorPane.setTopAnchor(starLevel, 100.0);
		AnchorPane.setTopAnchor(evaluation, 100.0);
		AnchorPane.setTopAnchor(revert, 550.0);
		
	}
	
	private void setList(){
		
		//创建列表对象
		tableView = new TableView<Person>();
		tableView.setEditable(false);
		
		//添加列表内容
				
		//添加列
		hotelName = new TableColumn<>("酒店名称");
		hotelName.setCellValueFactory(new PropertyValueFactory<Person, String>("hotelName"));
		hotelName.setMinWidth(200);
		
		whetherReserve = new TableColumn<>("是否预定过");
		whetherReserve.setCellValueFactory(new PropertyValueFactory<Person, String>("whetherReserve"));
		whetherReserve.setMinWidth(80);
		
		starlevel = new TableColumn<>("星级");
		starlevel.setCellValueFactory(new PropertyValueFactory<Person, String>("starlevel"));
		starlevel.setMinWidth(50);
		
		evalaution = new TableColumn<>("评价");
		evalaution.setCellValueFactory(new PropertyValueFactory<Person, String>("evaluation"));
		evalaution.setMinWidth(50);
		
		operation1= new TableColumn<>("操作");
		operation1.setCellValueFactory(new PropertyValueFactory<Person, Button>("operation1"));
		operation1.setCellFactory(new Callback<TableColumn<Person, Button>, TableCell<Person, Button>>(){
			public TableCell<Person, Button> call(TableColumn<Person, Button> param){
				return new TableCell<Person, Button>(){
					protected void updateItem(Button Item, boolean empty){
						if(!empty){
							Item = new Button("查看");
							Item.setPrefWidth(100);
							Item.setOnAction(event->{
								int row = this.getTableRow().getIndex();
								controller.setHotelID(row);
								controller.setHotelInfoView();
								controller.getStage().show();
							});
						}
						setGraphic(Item);
					}
				};
			}
		});
		operation1.setMinWidth(120);
		
		
		tableView.setItems(data);
		tableView.setPrefHeight(380);
		tableView.setPrefWidth(500);
		tableView.getColumns().addAll(hotelName, whetherReserve, starlevel, evalaution, operation1);
		
		//设置列表位置
		rightPane.getChildren().add(tableView);
		
		AnchorPane.setLeftAnchor(tableView, 50.0);
		AnchorPane.setTopAnchor(tableView, 150.0);
	
	}
	
	public void setListValue(){
		ArrayList<HotelVO> hotelList = controller.getSearchHotelList();
		for(int i=0;i<hotelList.size();i++){
			check = new Button("查看");
			data.add(new Person(hotelList.get(i).hotelName,"请先登录", Integer.toString(hotelList.get(i).levelOfHotel), Double.toString(hotelList.get(i).evaluationGrades), check));
		}
	}
	
	public static class Person{
		private final SimpleStringProperty hotelName;
		private final SimpleStringProperty whetherReserve;
		private final SimpleStringProperty starlevel;
		private final SimpleStringProperty evaluation;
		private final SimpleObjectProperty<Object> operation1;
		
		private Person(String hotelName, String whetherReserve, String starlevel, String evaluation, Button operation1){
			
			this.hotelName = new SimpleStringProperty(hotelName);
			this.whetherReserve = new SimpleStringProperty(whetherReserve);
			this.starlevel = new SimpleStringProperty(starlevel);
			this.evaluation =  new SimpleStringProperty(evaluation);
			this.operation1 =  new SimpleObjectProperty<Object>(operation1);
			
		}
		
		public String getHotelName(){
			return hotelName.get();
		}
		
		public void setOrderId(String HotelName){
			hotelName.set(HotelName);
		}
		
		public String getWhetherReserve(){
			return whetherReserve.get();
		}
		
		public void setWhetherReserve(String WhetherReserve){
			whetherReserve.set(WhetherReserve);
		}
		
		public String getStarlevel(){
			return starlevel.get();
		}
		
		public void setStarlevel(String Starlevel){
			starlevel.set(Starlevel);
		}
		
		public String getEvaluation(){
			return evaluation.get();
		}
		
		public void setEvaluation(String Evaluation){
			evaluation.set(Evaluation);
		}
		
		public Button getOperation1(){
			return (Button)operation1.get();
		}
		
		public void setOperation1(Object Operation1){
			operation1.set(Operation1);
		}
		
	}
}
