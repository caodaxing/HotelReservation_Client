package view.left;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import viewController.AccountController;
import viewController.WBCreditController;
import viewController.WBOrderManagementController;
import viewController.WBPromotionController;
import viewController.WBVIPInfoController;

/**
 * 网站营销人员的左侧导航栏
 * @author XueWang
 *
 */
public class WebBusinessUI{

	private GridPane pane;
	
	private Stage stage = new Stage();
	
	public WebBusinessUI(){
		pane = this.initGridPane();
	}
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane(){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		//Pane pane = new GridPane();
		//Image image = new Image("Image\\index2.jpg", 200, 180, false, true);
		//ImageView headImage = new ImageView(image);
		//pane.getChildren().add(headImage);
		//grid.add(pane, 0, 0);
		
		Button webPromotion = new Button("网站促销策略");
		webPromotion.setId("light-button");
		webPromotion.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(webPromotion, 0, 1);
		webPromotion.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBPromotionController wbPromotionController = new WBPromotionController(new Stage());
				wbPromotionController.setFirstView();
				stage = wbPromotionController.getStage();
				stage.show();
			}
			
		});
		
		Button creditRecharge = new Button("信用充值");
		creditRecharge.setId("light-button");
		creditRecharge.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(creditRecharge, 0, 2);
		creditRecharge.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBCreditController wbCreditController = new WBCreditController(new Stage());
				wbCreditController.setRechargeCreditView();
				stage = wbCreditController.getStage();
				stage.show();
			}
			
		});
		
		Button manageVIPLevel = new Button("管理会员等级");
		manageVIPLevel.setId("light-button");
		manageVIPLevel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageVIPLevel, 0, 3);
		manageVIPLevel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBVIPInfoController wbVIPController = new WBVIPInfoController(stage);
				stage.setScene(wbVIPController.getSetVIPCreditScene());
				stage.show();
			}
			
		});
		
		Button manageOrder = new Button("订单管理");
		manageOrder.setId("light-button");
		manageOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageOrder, 0, 4);
		manageOrder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBOrderManagementController wbOrderManagementController = new WBOrderManagementController(new Stage());
				wbOrderManagementController.setUnexecuteOrderView();
				stage = wbOrderManagementController.getStage();
				stage.show();
			}
			
		});
		
		Button todayUnexecuteOrder = new Button("今日未执行订单");
		todayUnexecuteOrder.setId("dark-button");
		todayUnexecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(todayUnexecuteOrder, 0, 5);
		todayUnexecuteOrder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBOrderManagementController wbOrderManagementController = new WBOrderManagementController(new Stage());
				wbOrderManagementController.setTodayUnexecuteOrderView();
				stage = wbOrderManagementController.getStage();
				stage.show();
			}
			
		});
		
		Button manageAbnormalOrder = new Button("异常订单管理");
		manageAbnormalOrder.setId("dark-button");
		manageAbnormalOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageAbnormalOrder, 0, 6);
		manageAbnormalOrder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBOrderManagementController wbOrderManagementController = new WBOrderManagementController(new Stage());
				wbOrderManagementController.setAbnormalOrderListView();
				stage = wbOrderManagementController.getStage();
				stage.show();
			}
			
		});
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 7);
		signOut.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				AccountController accountController = new AccountController(new Stage());
				accountController.setFirstView();
				stage = accountController.getStage();
				stage.show();
			}
			
		});
		
		return grid;
	}
	
}
