package Message;

//0:正常执行订单增加 1:异常订单扣除 2.撤销订单扣除 3.充值
public enum CreditChangeType {
	NORMAL_EXECUTE_ORDER_INCRESE,
	ABNORMAL_EXECUTE_ORDER_DECREASE,
	UNDO_ORDER_DECREASE,
	RECHARGE_CREDIT;
	
//	private int index;
//	
//	public int getIndex() {
//		return index;
//	}
//
//	private CreditChangeType(int index) {
//		this.index = index;
//	}
}
