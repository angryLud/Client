package businesslogic;

import businesslogicservice.ChangeOrderService;
import vo.OrderVo;
import po.OrderPo;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChangeOrderServiceImpl implements ChangeOrderService{
	
	private List<OrderPo> orderList;
	
	private int hotelId;
	
	public ChangeOrderServiceImpl(int hotelId){
		this.hotelId = hotelId;
		try {
			orderList = RemoteHelper.getInstance().getOrderdataservice().findorderbyhotelid(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderVo> getAbnormalOrder(int hotelId){
		List<OrderVo> list = new ArrayList<OrderVo>();
		for (OrderPo orderPo : orderList) {
//			if(orderPo.getStatus() == 2){
//				OrderVo orderVo = new OrderVo(orderPo);
//				list.add(orderVo);
//			}
		}
		return list;
	}
	
	public void logout() {

	}

}
