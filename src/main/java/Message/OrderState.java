package Message;

//0:撤销状态 1:异常状态 2:已经执行 3:未执行 4:异常订单被撤销后执行
public enum OrderState {
	UNDOED, ABNORMAL, EXECUTED, UNEXECUTED, ABNORMAL_UNDO_EXECUTED
}
