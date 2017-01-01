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
	
	private OrderPo opo;

	public OrderServiceImpl(int hotelID) {
		this.hotelID = hotelID;
		try {
			orderdataservice = RemoteHelper.getInstance().getOrderdataservice();
			hotelOrderList=RemoteHelper.getInstance().getOrderdataservice().findorderbyhotelid(hotelID);
			
		} catch (RemoteException e){
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
	public OrderPo getOrder(int orderID) {
		OrderPo po = new OrderPo(0,0,0,0,0,0,0,0,0,0,0);
		OrderVo vo = new OrderVo(po);
		try{
		po = orderdataservice.orderfind(orderID);
		vo = new OrderVo(po);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public boolean executeOrder(int orderID) {
		OrderPo po = new OrderPo(0,0,0,0,0,0,0,0,0,0,0);
        	try {
				po = orderdataservice.orderfind(orderID);
				if(po.getExecutetime()==0){
					Date date=new Date();
					DateFormat format=new SimpleDateFormat("yyyy/MM/dd");
					String time=format.format(date);
					String res = time.replaceAll("/","");
					po.setExecutetime(Long.parseLong(time));
					if(orderdataservice.orderupdate(po)){
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
	public boolean updateOrder(OrderPo opo){
		try {
			RemoteHelper.getInstance().getOrderdataservice().orderupdate(opo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<OrderVo> getUnfinishedOrders(int hotelID) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		for(OrderPo po:hotelOrderList){
			if(po.getStatus()==0){
			OrderVo vo = new OrderVo(po);
			list.add(vo);
			}
		}
		
		return list;
	}

	@Override
	public List<OrderVo> getFinishedOrders(int hotelID) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		for(OrderPo po:hotelOrderList){
			if(po.getStatus()==1){
			OrderVo vo = new OrderVo(po);
			list.add(vo);
			}
		}
		return list;
	}

	@Override
	public List<OrderVo> getAbnormalOrders(int hotelID) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		for(OrderPo po:hotelOrderList){
			if(po.getStatus()==2){
			OrderVo vo = new OrderVo(po);
			list.add(vo);
		    }
	    }
		return list;
	}

	@Override
	public List<OrderVo> getCanceledOrders(int hotelID) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		for(OrderPo po:hotelOrderList){
			if(po.getStatus()==3){
			OrderVo vo = new OrderVo(po);
			list.add(vo);
		    }
	    }
		return list;
	}
}
