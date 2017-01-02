package view.right.webBusiness.promotion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBPromotionController;
import vo.PromotionVO;

/**
 * 网站营销人员界面_促销策略_查看会员特定商圈折扣策略
 * @author XueWang
 *
 */
public class CheckVIPAreaStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField lowestVIPLevel1;
	TextField lowestVIPLevel2;
	TextField lowestVIPLevel3;
	
	ChoiceBox tradingArea;
	TextField discountRange1;
	TextField discountRange2;
	TextField discountRange3;
	TextField discountName;
	
	Button revert;
	ArrayList<PromotionVO> promotionList;
	
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
	
	public CheckVIPAreaStrategy(WBPromotionController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本框
		setTextField();
		
		//添加按钮
		setButton();
				
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/webPromotion/网站促销策略_会员特定商圈折扣_查看.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//初始化文本框
		lowestVIPLevel1 = new TextField();
		lowestVIPLevel2 = new TextField();
		lowestVIPLevel3 = new TextField();
		tradingArea = new ChoiceBox();
		discountRange1 = new TextField();
		discountRange2 = new TextField();
		discountRange3 = new TextField();
		discountName = new TextField();
		
		lowestVIPLevel1.setId("CheckVIPAreaStrategy");
		lowestVIPLevel2.setId("CheckVIPAreaStrategy");
		lowestVIPLevel3.setId("CheckVIPAreaStrategy");
		tradingArea.setId("CheckVIPAreaStrategy");
		discountRange1.setId("CheckVIPAreaStrategy");
		discountRange2.setId("CheckVIPAreaStrategy");
		discountRange3.setId("CheckVIPAreaStrategy");
		discountName.setId("CheckVIPAreaStrategy");
		
		//设置文本框内容不可更改
		lowestVIPLevel1.setEditable(false);
		lowestVIPLevel2.setEditable(false);
		lowestVIPLevel3.setEditable(false);
		discountRange1.setEditable(false);
		discountRange2.setEditable(false);
		discountRange3.setEditable(false);
		discountName.setEditable(false);
		
		//设置文本框大小
		lowestVIPLevel1.setPrefSize(60, TEXTFIELD_HEIGHT);
		lowestVIPLevel2.setPrefSize(60, TEXTFIELD_HEIGHT);
		lowestVIPLevel3.setPrefSize(60, TEXTFIELD_HEIGHT);
		tradingArea.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		discountRange1.setPrefSize(60, TEXTFIELD_HEIGHT);
		discountRange2.setPrefSize(60, TEXTFIELD_HEIGHT);
		discountRange3.setPrefSize(60, TEXTFIELD_HEIGHT);
		discountName.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		
		//设置文本框位置
		lowestVIPLevel1.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		lowestVIPLevel1.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		lowestVIPLevel2.setLayoutX(TEXTFIELD_START_HORIZONTAL + 70);
		lowestVIPLevel2.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		lowestVIPLevel3.setLayoutX(TEXTFIELD_START_HORIZONTAL + 140);
		lowestVIPLevel3.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		tradingArea.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		tradingArea.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP);
		
		discountRange1.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		discountRange1.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2);
		
		discountRange2.setLayoutX(TEXTFIELD_START_HORIZONTAL + 70);
		discountRange2.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2);
		
		discountRange3.setLayoutX(TEXTFIELD_START_HORIZONTAL + 140);
		discountRange3.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2);
		
		discountName.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		discountName.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*3);
		
		
		//右侧pane添加组件
		rightPane.getChildren().add(lowestVIPLevel1);
		rightPane.getChildren().add(lowestVIPLevel2);
		rightPane.getChildren().add(lowestVIPLevel3);
		rightPane.getChildren().add(tradingArea);
		rightPane.getChildren().add(discountRange1);
		rightPane.getChildren().add(discountRange2);
		rightPane.getChildren().add(discountRange3);
		rightPane.getChildren().add(discountName);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(lowestVIPLevel1, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(lowestVIPLevel2, TEXTFIELD_START_HORIZONTAL + 70 - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(lowestVIPLevel3, TEXTFIELD_START_HORIZONTAL + 140 - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(tradingArea, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountRange1, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountRange2, TEXTFIELD_START_HORIZONTAL + 70 - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountRange3, TEXTFIELD_START_HORIZONTAL + 140 - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountName, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
						
		AnchorPane.setTopAnchor(lowestVIPLevel1, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(lowestVIPLevel2, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(lowestVIPLevel3, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(tradingArea, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP));
		AnchorPane.setTopAnchor(discountRange1, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2));
		AnchorPane.setTopAnchor(discountRange2, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2));
		AnchorPane.setTopAnchor(discountRange3, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2));
		AnchorPane.setTopAnchor(discountName, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*3));
		
	}
	
	private void setButton(){
		
		//添加按钮
		revert = new Button("返回");
		revert.setId("CheckVIPAreaStrategy");
		revert.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		
		//设置按钮位置
		revert.setLayoutX(BUTTON_START_HORIZONTAL);
		revert.setLayoutY(BUTTON_START_VERTICAL);
		
		//设置按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				controller.setExistStrategyView();
				controller.getStage().show();
			}
			
		});
		
		//右侧pane添加
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, BUTTON_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setTopAnchor(revert, (double)BUTTON_START_VERTICAL);
	}
	
	@SuppressWarnings("unchecked")
	public void setText(){
		PromotionVO vo = controller.getPromotionVO();
System.out.println(vo.vipTradeAreaDiscount);
		ArrayList<String> areaList = new ArrayList<String>();
		@SuppressWarnings("rawtypes")
		Iterator iter = vo.vipTradeAreaDiscount.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			tradingArea.getItems().add(key);
			areaList.add(key.toString());
		}
		
		tradingArea.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				int num = tradingArea.getSelectionModel().getSelectedIndex();
				double[] d = vo.vipTradeAreaDiscount.get((Object)areaList.get(num));
				if(d.length == 1){
					discountRange1.setText(String.valueOf(d[0]));
					lowestVIPLevel1.setText("1");
				}else if(d.length == 2){
					discountRange1.setText(String.valueOf(d[0]));
					discountRange2.setText(String.valueOf(d[1]));
					lowestVIPLevel1.setText("1");
					lowestVIPLevel2.setText("2");
				}else if(d.length == 3){
					discountRange1.setText(String.valueOf(d[0]));
					discountRange2.setText(String.valueOf(d[1]));
					discountRange3.setText(String.valueOf(d[2]));
					lowestVIPLevel1.setText("1");
					lowestVIPLevel2.setText("2");
					lowestVIPLevel3.setText("3");
				}
				
			}
			
		});
		discountName.setText(vo.promotionName);
		
	}
}
