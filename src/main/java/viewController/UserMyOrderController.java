package viewController;

import logic.account.Account;
import logic.credit.CreditController;
import logic.user.Client;
import logicService.promotion.AccountService;
import logicService.promotion.ClientService;
import logicService.promotion.CreditService;
import logicService.promotion.EvaluationService;
import logicService.promotion.OrderService;
import view.right.user.myOrder.ExecuteOrder;

public class UserMyOrderController {

	private AccountService accountService;
	private ClientService clientService;
	private CreditService creditService;
	private EvaluationService evaluationService;
	private OrderService orderService;
	
	private ExecuteOrder view ;
	
	public UserMyOrderController(){
		
		//初始化依赖
		accountService = new Account();
		clientService = new Client();
		//creditService = new CreditController();
	
	}
	
	public void setView(ExecuteOrder view){
		this.view = view;
	}
	
}
