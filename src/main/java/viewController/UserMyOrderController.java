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

public class UserMyOrderController extends UserLeftController {

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
		undoOrderUI = new UndoOrder(this);
		unexecuteOrderUI = new UnexecuteOrder(this);
	
	}
	
	public Stage getStage(){
		return stage;
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
	
	public void setUndoOrderView(){
		
		stage.setScene(undoOrderUI.getScene());
		
	}
	
	public void setUnexecuteOrderView(){
		
		stage.setScene(unexecuteOrderUI.getScene());
		
	}
	
}
