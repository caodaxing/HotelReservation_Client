package logic.hotel;

/**
 * 酒店列表排序时升序或者降序
 * @author Mark.W
 *
 */
public interface UpOrDownSort {
	
	/**
	 * 对两个数值的比较结果
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean compare(double a, double b);

}
