package view.left;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import logic.picture.Picture;
import view.helpTools.DefaultNums;
import viewController.WebBusinessLeftController;

/**
 * 网站营销人员的左侧导航栏
 * @author XueWang
 *
 */
public class WebBusinessUI{

	private GridPane pane;
	
	private WebBusinessLeftController leftcontroller;
	
	public WebBusinessUI(WebBusinessLeftController controller){
		
		this.leftcontroller = controller;
		pane = this.initGridPane();
	}
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane(){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		String userId = leftcontroller.getUserId();
		Picture picture = new Picture();
		Image image = picture.getHeadImage(userId);
		ImageView headImage = new ImageView(image);
		headImage.setFitHeight(200);
		headImage.setFitWidth(200);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button webPromotion = new Button("网站促销策略");
		webPromotion.setId("light-button");
		webPromotion.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(webPromotion, 0, 1);
		
		Button creditRecharge = new Button("信用充值");
		creditRecharge.setId("light-button");
		creditRecharge.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(creditRecharge, 0, 2);
		
		Button manageVIPLevel = new Button("管理会员等级");
		manageVIPLevel.setId("light-button");
		manageVIPLevel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageVIPLevel, 0, 3);
		
		Button todayUnexecuteOrder = new Button("今日未执行订单");
		todayUnexecuteOrder.setId("dark-button");
		todayUnexecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(todayUnexecuteOrder, 0, 4);
		
		Button manageAbnormalOrder = new Button("异常订单管理");
		manageAbnormalOrder.setId("dark-button");
		manageAbnormalOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageAbnormalOrder, 0, 5);
		
		Button changePassword = new Button("修改密码");
		changePassword.setId("light-button");
		changePassword.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(changePassword, 0, 6);
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 7);
		
		webPromotion.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setFirstVeiw();
				leftcontroller.getStage().show();
			}
			
		});
		
		creditRecharge.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setRechargeCreditView();
				leftcontroller.getStage().show();
			}
			
		});
		
		manageVIPLevel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setVIPLevelView();
				leftcontroller.getStage().show();
			}
			
		});
		
		todayUnexecuteOrder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setTodayUnexecuteOrderView();
				leftcontroller.getStage().show();
			}
			
		});
		
		manageAbnormalOrder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setAbnormalOrderView();
				leftcontroller.getStage().show();
			}
			
		});
		
		changePassword.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setModifyPasswordView();
			}
			
		});
		
		signOut.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setFirstUIView();
			}
			
		});
		grid.getStylesheets().add(getClass().getResource("/CSS/left.css").toExternalForm());
		
		return grid;
	}
	
}
