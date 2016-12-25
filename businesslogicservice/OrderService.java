package businesslogicservice;

import java.util.*;

import po.OrderPo;
import vo.OrderVo;

public interface OrderService {
	
	List<OrderVo> getAllOrders(int hotelID);
	
	OrderPo getOrder(int orderID);

	public boolean executeOrder(int orderID);
	
	public boolean updateOrder(int orderID);
	
	List<OrderVo> getUnfinishedOrders(int hotelID);
	
	List<OrderVo> getFinishedOrders(int hotelID);
	
	List<OrderVo> getAbnormalOrders(int hotelID);
	
}
