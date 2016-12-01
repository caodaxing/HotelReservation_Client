package Message;

//0:正常执行订单增加 1:异常订单扣除 2.撤销订单扣除 3.充值
public enum CreditChangeType {
	NORMAL_EXECUTE_ORDER_INCRESE(0),
	ABNORMAL_EXECUTE_ORDER_DECREASE(1),
	UNDO_ORDER_DECREASE(2),
	RECHARGE_CREDIT(3);
	
	private int index;
	
	public int getIndex() {
		return index;
	}

	private CreditChangeType(int index) {
		this.index = index;
	}
}
