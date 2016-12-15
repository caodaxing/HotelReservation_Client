package viewController;

import Message.OrderState;
import javafx.stage.Stage;
import view.right.user.myOrder.AbnormalOrder;
import view.right.user.myOrder.CheckArriveInfo;
import view.right.user.myOrder.CheckLeaveInfo;
import view.right.user.myOrder.Evaluate;
import view.right.user.myOrder.EvaluationInfo;
import view.right.user.myOrder.ExecuteOrder;
import view.right.user.myOrder.First;
import view.right.user.myOrder.OrderList;
import view.right.user.myOrder.UndoOrder;
import view.right.user.myOrder.UnexecuteOrder;
import vo.EvaluationVO;
import vo.OrderVO;

public class UserMyOrderController extends UserLeftController {
	
	private AbnormalOrder abnormalOrderUI ;
	private CheckArriveInfo checkArriveInfoUI ;
	private CheckLeaveInfo checkLeaveInfoUI ;
	private Evaluate evaluateUI ;
	private EvaluationInfo evaluationInfoUI ;
	private ExecuteOrder executeOrderUI ;
	private UndoOrder undoOrderUI ;
	private UnexecuteOrder unexecuteOrderUI ;
	
	public UserMyOrderController(Stage stage , String userID){
		
		this.stage = stage;
		this.userID = userID;
		
		//abnormalOrderUI = new AbnormalOrder(this);
		//checkArriveInfoUI = new CheckArriveInfo(this);
		//checkLeaveInfoUI = new CheckLeaveInfo(this);
		evaluateUI = new Evaluate(this);
		//evaluationInfoUI = new EvaluationInfo(this);
		//executeOrderUI = new ExecuteOrder(this);
		//undoOrderUI = new UndoOrder(this);
		//unexecuteOrderUI = new UnexecuteOrder(this);
	
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setAbnormalOrderView(){
		
		abnormalOrderUI = new AbnormalOrder(this);
		stage.setScene(abnormalOrderUI.getScene());
		abnormalOrderUI.setText();
		
	}
	
	public void setCheckArriveInfoView(){
		
		stage.setScene(checkArriveInfoUI.getScene());
		checkArriveInfoUI.setText();
		
	}
	
	public void setCheckLeaveInfoView(){
		
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		stage.setScene(checkLeaveInfoUI.getScene());
		checkLeaveInfoUI.setText();
		
	}
	
	public void setEvaluateView(){
		
		stage.setScene(evaluateUI.getScene());
		
	}
	
	public void setEvaluationInfoView(){
		
		evaluationInfoUI = new EvaluationInfo(this);
		stage.setScene(evaluationInfoUI.getScene());
		evaluationInfoUI.setText();
		
	}
	
	public void setExecuteOrderView(){
		
		executeOrderUI = new ExecuteOrder(this);
		stage.setScene(executeOrderUI.getScene());
		executeOrderUI.setText();
		
	}
	
	public void setUndoOrderView(){
		
		undoOrderUI = new UndoOrder(this);
		stage.setScene(undoOrderUI.getScene());
		undoOrderUI.setText();
		
	}
	
	public void setUnexecuteOrderView(){
		
		unexecuteOrderUI = new UnexecuteOrder(this);
		stage.setScene(unexecuteOrderUI.getScene());
		unexecuteOrderUI.setText();
		
	}

	public OrderVO getOrderInfo() {
		return orderService.getOrderInfo(orderID);
	}

	public EvaluationVO getEvaluationInfo() {
		return orderService.getEvaluationInfo(orderID);
	}
	

	public void whetherEvaluateAndSetView() {
		//判断是否评价过
		EvaluationVO vo = orderService.getEvaluationInfo(orderID);
		if(vo == null){
			showDialog("尚未评价，请先评价");
			setEvaluateView();
			return ;
		}
		setEvaluationInfoView();
	}
	
	public void evaluate(){
		
	}

	public void searchOrder() {
		orderID = orderFirstUI.getOrderID();
		OrderVO vo = orderService.getOrderInfo(orderID);
		if(vo == null){
			//若订单不存在，对话框，清空textfield，清空orderID
			showDialog("订单不存在");
			orderID = null;
			return;
		}
		OrderState state = vo.orderState;
		if(state == OrderState.ABNORMAL){
			setAbnormalOrderView();
		}else if(state == OrderState.EXECUTED){
			setExecuteOrderView();
		}else if(state == OrderState.UNDOED_ABNORMAL || state == OrderState.UNDOED_UNEXECUTED){
			setUndoOrderView();
		}else if(state == OrderState.UNEXECUTED){
			setUnexecuteOrderView();
		}else{
			showDialog("系统错误，请重试");
			return;
		}
		
	}
	
}
