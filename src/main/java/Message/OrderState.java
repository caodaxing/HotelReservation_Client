package Message;

// 0:未执行  1:已经执行 2:异常状态 3:撤销(异常)状态 4.撤销(未执行)订单
public enum OrderState {
	 UNEXECUTED, EXECUTED, ABNORMAL, UNDOED_ABNORMAL, UNDOED_UNEXECUTED
}
