package viewController;

import view.right.user.myOrder.ExecuteOrder;

public class UserMyOrderController {

	/*
	private AccountService accountService;
	private ClientService clientService;
	private CreditService creditService;
	private EvaluationService evaluationService;
	private OrderService orderService;
	*/
	
	private ExecuteOrder executeOrderUI ;
	
	public UserMyOrderController(){
		
		//初始化依赖
		//accountService = new Account();
		//clientService = new Client();
		//creditService = new CreditController();
	
	}
	
	public void setView(ExecuteOrder view){
		this.executeOrderUI = view;
	}
	
}
