package businesslogicservice;

import java.util.List;

import vo.OrderVo;

public interface ChangeOrderService {
	
	List<OrderVo> getAbnormalOrder();

}
