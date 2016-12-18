package logic.user;

import Message.ResultMessage;
import po.ClientPO;

/**
 * 给account调用的 在注册成功后添加client的信息
 * @author Mark.W
 *
 */
public interface AddClientInfo {

	 public ResultMessage addClient(ClientPO po);
}
