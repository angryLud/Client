package businesslogicservice;

import java.util.List;

import vo.OrderVo;

public interface ChangeOrderService {
	
	List<OrderVo> getAbnormalOrder(int hotelId);
	
	boolean updateOrder(int orderId);
	
	void logout();

}
