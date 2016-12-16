package view.helpTools;

import Message.CreditChangeType;
import Message.OrderState;
import Message.RoomType;

public class MessageHelper {

	public static String creditChangeTypeToString(CreditChangeType t){
		
		String type = "错误";
		if(t == CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE){
			type = "生成订单增加";
		}else if(t == CreditChangeType.SET_ABNORMAL_ORDER_DECREASE){
			type = "订单异常扣除";
		}else if(t == CreditChangeType.SUPPLY_ABNORAML_ORDER_RECOVER){
			type = "异常订单恢复";
		}else if(t == CreditChangeType.UNDO_ABNORAML_ORDER_RECOVER){
			type = "异常订单撤销";
		}else if(t == CreditChangeType.RECHARGE_CREDIT){
			type = "信用充值";
		}else if(t == CreditChangeType.UNDO_UNEXECUTED_ORDER_DECREASE){
			type = "撤销订单扣除";
		}
		
		return type;
	
	}
	
	public static String orderStateToString(OrderState o){
		
		String state = "错误";
		if(o == OrderState.UNEXECUTED){
			state = "未执行";
		}else if(o == OrderState.EXECUTED){
			state = "已执行";
		}else if(o == OrderState.ABNORMAL){
			state = "异常";
		}else if(o == OrderState.UNDOED_ABNORMAL){
			state = "已撤销异常";
		}else if(o == OrderState.UNDOED_UNEXECUTED){
			state = "已撤销";
		}
		
		return state;
		
	}
	
	public static String roomTypeToString(RoomType t){
		
		String type = "错误";
		
		if(t== RoomType.BIGBED_ROOM){
			type = "大床房";
		}else if(t == RoomType.SINGLE_ROOM){
			type = "单人间";
		}else if(t == RoomType.STANDARD_ROOM){
			type = "标准间";
		}else if(t == RoomType.SUITE){
			type = "套间";
		}else if(t == RoomType.TRIPLE_ROOM){
			type = "三人间";
		}
		
		return type;
		
	}
	
}
