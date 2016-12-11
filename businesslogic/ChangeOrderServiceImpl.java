package businesslogic;

import businesslogicservice.ChangeOrderService;
import vo.OrderVo;
import po.OrderPo;

import java.util.ArrayList;
import java.util.List;

public class ChangeOrderServiceImpl implements ChangeOrderService{
	
	List<OrderPo> orderList;
	
	public List<OrderVo> getAbnormalOrder(){
		List<OrderVo> list = new ArrayList<OrderVo>();
		for (OrderPo orderPo : orderList) {
//			if(orderPo.getStatus() == 2){
//				UserPo userPo = userDao.getUser(orderPo.getUserId());
//				OrderVo orderVo = new OrderVo(orderPo, userPo);
//				list.add(orderVo);
//			}
		}
		return list;
	}

}
