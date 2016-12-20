package viewController;

import java.util.ArrayList;

import Message.OrderState;
import Message.ResultMessage;
import javafx.stage.Stage;
import logicService.order.ExecuteOrderService;
import view.right.user.myOrder.AbnormalOrder;
import view.right.user.myOrder.Evaluate;
import view.right.user.myOrder.EvaluationInfo;
import view.right.user.myOrder.ExecuteOrder;
import view.right.user.myOrder.UndoOrder;
import view.right.user.myOrder.UnexecuteOrder;
import vo.EvaluationVO;
import vo.OrderVO;

public class UserMyOrderController extends UserLeftController {
	
	private ExecuteOrderService executeService ;
	
	private AbnormalOrder abnormalOrderUI ;
	private Evaluate evaluateUI ;
	private EvaluationInfo evaluationInfoUI ;
	private ExecuteOrder executeOrderUI ;
	private UndoOrder undoOrderUI ;
	private UnexecuteOrder unexecuteOrderUI ;
	
	public UserMyOrderController(Stage stage , String userID){
		
		super(stage,userID);
		
		executeService = new logic.order.ExecuteOrder();
		
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
		double grd = evaluateUI.getGrade();
		if(grd == -1){
			return;
		}
		String info = evaluateUI.getInfo();
		EvaluationVO vo = new EvaluationVO(orderID,grd,info);
		ResultMessage result = orderService.evaluate(vo);
		if(result == ResultMessage.SUCCESS){
			showDialog("评价成功");
			evaluateUI.setBlank();
			setExecuteOrderView();
		}else{
			showDialog("评价失败，请重试");
			return;
		}
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
		setOrderView();
		
	}

	public void setOrderID(String orderID){
		this.orderID = orderID;
	}
	
	public void setOrderID(int row){
		orderID = orderList.get(row).orderId;
	}
	
	public void setOrderList(ArrayList<OrderVO> list){
		orderList = list;
	}

	public void setOrderView() {
		OrderState state = orderService.getOrderInfo(orderID).orderState;
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
	
	/*
	 * 撤销订单
	 */
	public void undoOrder() {
		//是否添加选择框?
		ResultMessage result = executeService.undoUnexecutedOrder(orderID);
		if(result == ResultMessage.SUCCESS){
			showDialog("撤销成功");
			setUndoOrderView();
		}else {
			showDialog("撤销失败，请重试");
			return;
		}
	}
	
}
