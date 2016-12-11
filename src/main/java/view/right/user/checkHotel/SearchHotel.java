package view.right.user.checkHotel;

import java.text.DecimalFormat;

import Message.RoomType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserCheckHotelController;
import vo.HotelSearchVO;
/**
 * 客户界面_查看酒店_搜索酒店
 * @author XueWang
 *
 */
public class SearchHotel {

	private UserCheckHotelController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField city ;
	TextField area ; 
	TextField hotelName ;

	ChoiceBox roomType ;
	
	CheckBox haveRoom ;
	CheckBox haveReserved ;
	
	TextField priceLeft ;
	TextField evaluationLeft ;
	TextField starLeft ;
	TextField priceRight ;
	TextField evaluationRight ;
	TextField starRight ;
	
	Button search ;
	Button back ;
	
	public SearchHotel(UserCheckHotelController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		//设置Button
		setButton();
		
		//设置ChoiceBox
		setChoiceBox();
		
		//设置CheckBox
		setCheckBox();
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setTextField(){
		
		//ArrayList<String> infoList = controller.getInfoList();
		
		//初始化textField
		city = new TextField();
		area = new TextField();
		hotelName = new TextField();

		priceLeft = new TextField();
		evaluationLeft = new TextField();
		starLeft = new TextField();
		priceRight = new TextField();
		evaluationRight = new TextField();
		starRight = new TextField();
		
		//设置textField可操作性
		city.setEditable(true);
		area.setEditable(true);
		hotelName.setEditable(true);

		priceLeft.setEditable(true);
		evaluationLeft.setEditable(true);
		starLeft.setEditable(true);
		priceRight.setEditable(true);
		evaluationRight.setEditable(true);
		starRight.setEditable(true);
		
		
		//设置textField大小
		city.setPrefSize(200, 30);
		area.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);

		priceLeft.setPrefSize(75, 30);
		evaluationLeft.setPrefSize(75, 30);
		starLeft.setPrefSize(75, 30);
		priceRight.setPrefSize(75, 30);
		evaluationRight.setPrefSize(75, 30);
		starRight.setPrefSize(75, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(city);
		rightPane.getChildren().add(area);
		rightPane.getChildren().add(hotelName);

		rightPane.getChildren().add(priceLeft);
		rightPane.getChildren().add(evaluationLeft);
		rightPane.getChildren().add(starLeft);
		rightPane.getChildren().add(priceRight);
		rightPane.getChildren().add(evaluationRight);
		rightPane.getChildren().add(starRight);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(city, 200.0);
		AnchorPane.setLeftAnchor(area, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		
		AnchorPane.setLeftAnchor(priceLeft, 200.0);
		AnchorPane.setLeftAnchor(evaluationLeft, 200.0);
		AnchorPane.setLeftAnchor(starLeft, 200.0);
		
		AnchorPane.setLeftAnchor(priceRight, 325.0);
		AnchorPane.setLeftAnchor(evaluationRight, 325.0);
		AnchorPane.setLeftAnchor(starRight, 325.0);
		
		AnchorPane.setTopAnchor(city, 150.0);
		AnchorPane.setTopAnchor(area, 200.0);
		AnchorPane.setTopAnchor(hotelName, 250.0);
		
		AnchorPane.setTopAnchor(priceLeft, 400.0);
		AnchorPane.setTopAnchor(evaluationLeft, 450.0);
		AnchorPane.setTopAnchor(starLeft, 500.0);
		
		AnchorPane.setTopAnchor(priceRight, 400.0);
		AnchorPane.setTopAnchor(evaluationLeft, 450.0);
		AnchorPane.setTopAnchor(starLeft, 500.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		search = new Button();
		back = new Button();
		
		//设置Button文字
		search.setText("搜索");
		back.setText("返回");
				
		//设置Button大小
		search.setPrefSize(100, 40);
		back.setPrefSize(100, 40);
		
		//添加listener
		search.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(search);
		rightPane.getChildren().add(back);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(search, 475.0);
		AnchorPane.setTopAnchor(search, 425.0);
		
		AnchorPane.setLeftAnchor(back, 475.0);
		AnchorPane.setTopAnchor(back, 490.0);
				
	}
	
	private void setChoiceBox(){
		
		//待修改，根据controller
		roomType = new ChoiceBox(FXCollections.observableArrayList("标准房","钟点房"));
		
		roomType.setPrefSize(200, 30);
		
		rightPane.getChildren().add(roomType);
		
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setTopAnchor(roomType, 300.0);
		
	}
	
	private void setCheckBox(){
		
		haveRoom = new CheckBox();
		haveReserved = new CheckBox();
		
		haveRoom.setPrefSize(30, 30);
		haveReserved.setPrefSize(30, 30);
		
		rightPane.getChildren().add(haveRoom);
		rightPane.getChildren().add(haveReserved);
		
		AnchorPane.setLeftAnchor(haveRoom, 200.0);
		AnchorPane.setTopAnchor(haveRoom, 350.0);
		
		AnchorPane.setLeftAnchor(haveReserved, 350.0);
		AnchorPane.setTopAnchor(haveReserved, 350.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}

	public HotelSearchVO getSearchVO(){
		String c = city.getText();
		String tradingArea = area.getText();
		String name = hotelName.getText();
		int t = roomType.getSelectionModel().getSelectedIndex();
		RoomType type = null;
		switch(t){
		case 0:
			type = RoomType.SINGLE_ROOM;
			break;
		case 1:
			type = RoomType.STANDARD_ROOM;
			break;
		case 2:
			type = RoomType.TRIPLE_ROOM;
			break;
		case 3:
			type = RoomType.BIGBED_ROOM;
			break;
		case 4:
			type = RoomType.SUITE;
			break;
		case -1:
		default:
			break;
		}
		DecimalFormat df=new DecimalFormat("#.00");
		double priceLow = Double.valueOf(df.format(Double.valueOf(priceLeft.getText())));
		double priceHigh =  Double.valueOf(df.format(Double.valueOf(priceRight.getText())));
		double commentLow =  Double.valueOf(df.format(Double.valueOf(evaluationLeft.getText())));
		double commentHigh =  Double.valueOf(df.format(Double.valueOf(evaluationRight.getText())));
		int starLow = Integer.valueOf(starLeft.getText());
		int starHigh = Integer.valueOf(starRight.getText());
		HotelSearchVO vo = new HotelSearchVO(c,tradingArea,name,type,priceLow,priceHigh,commentLow,commentHigh,starLow,starHigh);
		return vo;
	}
	
}
