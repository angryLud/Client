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
	
	public ChangeOrderServiceImpl(int hotelid){
		this.hotelId = hotelid;
		try {
			orderList = RemoteHelper.getInstance().getOrderdataservice().findorderbyhotelid(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderVo> getAbnormalOrder(int hotelId){
		if(orderList==null){
			return null;
		}
		List<OrderVo> list = new ArrayList<OrderVo>();
		for (OrderPo orderPo : orderList) {
			if(orderPo.getStatus() == 2){
				OrderVo orderVo = new OrderVo(orderPo);
				list.add(orderVo);
			}
		}
		return list;
	}
	
	public boolean updateOrder(int orderid){
		try {
			OrderPo orderPo = RemoteHelper.getInstance().getOrderdataservice().orderfind(orderid);
			orderPo.setStatus(3);
			if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(orderPo)){
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void logout(int id) {
		try {
            RemoteHelper.getInstance().getloginservice().logout(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

	}

}
