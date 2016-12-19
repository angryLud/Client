package businesslogicservice;

import java.util.*;

import vo.OrderVo;

public interface OrderService {
	
	List<OrderVo> getAllOrders(int hotelID);
	
	OrderVo getOrder(int orderID);

	public boolean executeOrder(int orderID);
	
	
}
