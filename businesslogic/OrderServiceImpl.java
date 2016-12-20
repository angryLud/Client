package businesslogic;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.OrderService;
import po.OrderPo;
import rmi.RemoteHelper;
import vo.OrderVo;
import dataservice.orderdataservice;

public class OrderServiceImpl implements OrderService{
	private int hotelID;
	
	private List<OrderPo> hotelOrderList;
	
	private orderdataservice orderdataservice;
	//未新建orderdataservice对象可以直接使用吗？
	public OrderServiceImpl(int hotelID) {
		this.hotelID = hotelID;
		try {
			hotelOrderList=RemoteHelper.getInstance().getOrderdataservice().findbyhotelid(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderVo> getAllOrders(int hotelID) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		for(OrderPo po:hotelOrderList){
			OrderVo vo = new OrderVo(po);
			list.add(vo);
		}
		return list;
	}

	@Override
	public OrderVo getOrder(int orderID) {
		OrderPo po = new OrderPo(0,0,0,0,0,0,0,0,"0",0);
		OrderVo vo = new OrderVo(po);
		try{
		po = orderdataservice.find(orderID);
		vo = new OrderVo(po);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean executeOrder(int orderID) {
		OrderPo po = new OrderPo(0,0,0,0,0,0,0,0,"0",0);
        	try {
				po = orderdataservice.find(orderID);
				if(po.getExecutetime()==0){
					Date date=new Date();
					DateFormat format=new SimpleDateFormat("yyyy/MM/dd");
					String time=format.format(date);
					String res = time.replaceAll("/","");
					po.setExecutetime(Long.parseLong(time));
					if(orderdataservice.update(po)){
						for(OrderPo o : hotelOrderList){
							if(o.getOrderid()==orderID){
								o = po;
								break;
							}
						}
						return true;
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
        
		return false;
	}

}
