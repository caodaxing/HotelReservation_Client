package viewController;

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

public class UserMyOrderController {
	
	private Stage stage;
	private String userID;

	/*
	private AccountService accountService;
	private ClientService clientService;
	private CreditService creditService;
	private EvaluationService evaluationService;
	private OrderService orderService;
	*/
	
	private AbnormalOrder abnormalOrderUI ;
	private CheckArriveInfo checkArriveInfoUI ;
	private CheckLeaveInfo checkLeaveInfoUI ;
	private Evaluate evaluateUI ;
	private EvaluationInfo evaluationInfoUI ;
	private ExecuteOrder executeOrderUI ;
	private First firstUI ;
	private OrderList orderListUI ;
	private UndoOrder undoOrderUI ;
	private UnexecuteOrder unexecuteOrderUI ;
	
	public UserMyOrderController(Stage stage , String userID){
		
		this.stage = stage;
		this.userID = userID;
		
		abnormalOrderUI = new AbnormalOrder(this);
		checkArriveInfoUI = new CheckArriveInfo(this);
		checkLeaveInfoUI = new CheckLeaveInfo(this);
		evaluateUI = new Evaluate(this);
		evaluationInfoUI = new EvaluationInfo(this);
		executeOrderUI = new ExecuteOrder(this);
		firstUI = new First(this);
		orderListUI = new OrderList(this);
		undoOrderUI = new UndoOrder(this);
		unexecuteOrderUI = new UnexecuteOrder(this);
	
	}
	
	public void setAbnormalOrderView(){
		
		stage.setScene(abnormalOrderUI.getScene());
		
	}
	
	public void setCheckArriveInfoView(){
		
		stage.setScene(checkArriveInfoUI.getScene());
		
	}
	
	public void setCheckLeaveInfoView(){
		
		stage.setScene(checkLeaveInfoUI.getScene());
	
	}
	
	public void setEvaluateView(){
		
		stage.setScene(evaluateUI.getScene());
		
	}
	
	public void setEvaluationInfoView(){
		
		stage.setScene(evaluationInfoUI.getScene());
	
	}
	
	public void setExecuteOrderView(){
		
		stage.setScene(executeOrderUI.getScene());
		
	}
	
	public void setFirstView(){
		
		stage.setScene(firstUI.getScene());
	
	}

	public void setOrderListView(){
		
		stage.setScene(orderListUI.getScene());
		
	}
	
	public void setUndoOrderView(){
		
		stage.setScene(undoOrderUI.getScene());
		
	}
	
	public void setUnexecuteOrderView(){
		
		stage.setScene(unexecuteOrderUI.getScene());
		
	}
	
}
