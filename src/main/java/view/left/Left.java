package view.left;

/**
 * 左侧导航栏的接口
 * @author XueWang
 *
 */
public interface Left {

	/**
	 * 刷新左侧导航栏（临时，待修改）
	 * @author XueWang
	 * @param identity 当前用户身份
	 * @param chosen 当前被选中的按钮id（由右侧提供,待定）
	 */
	public void refreshLeft();
	
}
