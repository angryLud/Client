package dataservice;

import po.UserPo;
import po.OrderPo;
public interface orderdataservice {
	boolean insert(OrderPo opo);
	boolean update(OrderPo opo);
	OrderPo find(int id);
}
