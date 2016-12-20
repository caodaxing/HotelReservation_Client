package view.right.webBusiness.promotion;

import java.util.ArrayList;
import java.util.HashMap;

import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBPromotionController;
import vo.PromotionVO;

/**
 * 网站营销人员界面_促销策略_制定会员特定商圈促销策略
 * @author XueWang
 *
 */
public class SetVIPAreaStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField VIPLevel1;
	TextField VIPLevel2;
	TextField VIPLevel3;
	ComboBox city;
	ComboBox tradingArea1;
	
	TextField discountRange;
	TextField discountName;
	
	Button cancel;
	Button ok;
	
	ArrayList<String> cityList;
	ArrayList<String> tradingAreaList;
	
	private static final int 
	TEXTFIELD_WIDTH = 200,//文本框的宽度
	TEXTFIELD_HEIGHT = 30,//文本框的高度
	TEXTFIELD_START_HORIZONTAL = 400,//文本框X起始位置
	TEXTFIELD_START_VERTICAL = 150,//文本框Y起始位置
	TEXTFIELD_GAP = 50,//文本框之间的间隔
	BUTTON_WIDTH = 100,//按钮宽
	BUTTON_HEIGHT = 40,//按钮高
	BUTTON_START_HORIZONTAL = 625,//按钮X起始位置
	BUTTON_START_VERTICAL = 525;//按钮Y起始位置
	
	public SetVIPAreaStrategy(WBPromotionController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		
		//添加文本框
		setTextField();
		
		//设置城市对应商圈
		setTradingArea();
		
		//添加按钮
		setButton();
				
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/webPromotion/网站促销策略_会员特定商圈折扣背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//初始化文本框
		VIPLevel1 = new TextField();
		VIPLevel2 = new TextField();
		VIPLevel3 = new TextField();
		discountRange = new TextField();
		discountName = new TextField();
		
		VIPLevel1.setId("SetVIPAreaStrategy");
		VIPLevel2.setId("SetVIPAreaStrategy");
		VIPLevel3.setId("SetVIPAreaStrategy");
		discountRange.setId("SetVIPAreaStrategy");
		discountName.setId("SetVIPAreaStrategy");
		
		
		//设置文本框内容不可更改
		VIPLevel1.setEditable(true);
		VIPLevel2.setEditable(true);
		VIPLevel3.setEditable(true);
		discountRange.setEditable(true);
		discountName.setEditable(true);
		
		//设置文本框大小
		VIPLevel1.setPrefSize(50, TEXTFIELD_HEIGHT);
		VIPLevel2.setPrefSize(50, TEXTFIELD_HEIGHT);
		VIPLevel3.setPrefSize(50, TEXTFIELD_HEIGHT);
		discountRange.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		discountName.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		
		//设置文本框位置
		VIPLevel1.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		VIPLevel1.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		VIPLevel2.setLayoutX(TEXTFIELD_START_HORIZONTAL+70);
		VIPLevel2.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		VIPLevel3.setLayoutX(TEXTFIELD_START_HORIZONTAL+140);
		VIPLevel3.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		discountRange.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		discountRange.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2);
		
		discountName.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		discountName.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*3);
		
		
		//右侧pane添加组件
		rightPane.getChildren().add(VIPLevel1);
		rightPane.getChildren().add(VIPLevel2);
		rightPane.getChildren().add(VIPLevel3);
		rightPane.getChildren().add(discountRange);
		rightPane.getChildren().add(discountName);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(VIPLevel1, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(VIPLevel2, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH + 70);
		AnchorPane.setLeftAnchor(VIPLevel3, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH + 140);
		AnchorPane.setLeftAnchor(discountRange, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountName, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
						
		AnchorPane.setTopAnchor(VIPLevel1, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(VIPLevel2, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(VIPLevel3, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(discountRange, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2));
		AnchorPane.setTopAnchor(discountName, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*3));
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setTradingArea(){
		city = new ComboBox();
		
		city.setVisibleRowCount(3);
		
		city.setPrefSize(100, 30);
		
		city.setLayoutX(400);
		city.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP);
		
		rightPane.getChildren().add(city);
		
		AnchorPane.setLeftAnchor(city, 400 - (double)DefaultNums.LEFT_WIDTH);
		
		AnchorPane.setTopAnchor(city, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP));
		
		cityList = controller.getCityList();
		if(cityList != null){
			for(int i=0;i<cityList.size();i++){
				city.getItems().addAll(cityList.get(i));
			}
		}else{
			controller.showDialog("系统错误，请重试");
		}
		city.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				int t = city.getSelectionModel().getSelectedIndex();
				tradingAreaList = controller.getTradingAreaList(cityList.get(t));
				tradingArea1 = new ComboBox();
				if(tradingAreaList != null){
					for(int i=0;i<tradingAreaList.size();i++){
						tradingArea1.getItems().addAll(tradingAreaList.get(i));
					}
				}else{
					controller.showDialog("系统错误，请重试");
				}
				tradingArea1.setVisibleRowCount(3);
				tradingArea1.setPrefSize(100, 30);
				tradingArea1.setLayoutX(520);
				tradingArea1.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP);
				rightPane.getChildren().add(tradingArea1);
				AnchorPane.setLeftAnchor(tradingArea1, 520 - (double)DefaultNums.LEFT_WIDTH);
				AnchorPane.setTopAnchor(tradingArea1, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP));
			}
			
		});
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确认");
		ok.setId("SetVIPAreaStrategy");
		ok.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		
		cancel = new Button("取消");
		cancel.setId("SetVIPAreaStrategy");
		cancel.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		
		
		
		//设置按钮位置
		ok.setLayoutX(450);
		ok.setLayoutY(BUTTON_START_VERTICAL);
		
		cancel.setLayoutX(BUTTON_START_HORIZONTAL);
		cancel.setLayoutY(BUTTON_START_VERTICAL);
		
		//设置按钮监听
		ok.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//传输vo
				try{
					double d1 = Double.parseDouble(VIPLevel1.getText());
					double d2 = Double.parseDouble(VIPLevel2.getText());
					double d3 = Double.parseDouble(VIPLevel2.getText());
					double[] d = {d1,d2,d3};
					int t1 = city.getSelectionModel().getSelectedIndex();
					int t2 = tradingArea1.getSelectionModel().getSelectedIndex();
					String s = discountName.getText();
					if(cityList.get(t1) != null && tradingAreaList.get(t2) != null){
						HashMap<String, double[]> hashmap = new HashMap<String, double[]>();
						hashmap.put(tradingAreaList.get(t2), d);
						if(s != null){
							PromotionVO promotionVO = new PromotionVO(null,s,hashmap);
							if(controller.getAddPromotionResult(promotionVO) == ResultMessage.SUCCESS){
								controller.showDialog("添加成功");
								controller.setChooseView();
								controller.getStage().show();
							}else{
								controller.showDialog("添加失败");
							}
						}else{
							controller.showDialog("请输入策略名称");
						}
					}else{
						controller.showDialog("请选择城市和商圈");
					}
				}catch(NumberFormatException e){
					controller.showDialog("折扣输入错误");
				}
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {

				controller.setChooseView();
				controller.getStage().show();
			}
			
		});
		
		//右侧pane添加
		rightPane.getChildren().add(ok);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(ok, 450 - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(cancel, BUTTON_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		
		AnchorPane.setTopAnchor(ok, (double)BUTTON_START_VERTICAL);
		AnchorPane.setTopAnchor(cancel, (double)BUTTON_START_VERTICAL);
	}
}
