package Message;

//0:正常执行订单增加 1:被置为异常订单扣除 2.酒店工作人员补登记异常订单恢复 3.撤销异常订单恢复 4.充值
public enum CreditChangeType {
	NORMAL_EXECUTE_ORDER_INCRESE,
	SET_ABNORMAL_ORDER_DECREASE,
	SUPPLY_ABNORAML_ORDER_RECOVER,
	UNDO_ABNORAML_ORDER_RECOVER,
	RECHARGE_CREDIT;
}
