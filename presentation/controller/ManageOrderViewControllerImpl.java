package presentation.controller;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import businesslogic.OrderServiceImpl;
import businesslogicservice.OrderService;
import dataservice.orderdataservice;
import po.OrderPo;
import po.UserPo;
import presentation.hotelui.ManageOrderView;
import presentation.hotelui.ManageOrderViewController;
import rmi.RemoteHelper;
import vo.OrderVo;
import businesslogic.userserviceimpl;
import businesslogicservice.userservice;

public class ManageOrderViewControllerImpl implements ManageOrderViewController{
	private ManageOrderView view;
	
	private controller con;
	
	private int HotelID;
	
	private OrderService orderservice;
	
	private userservice userservice;
	
	private UserPo userpo;
	
	private OrderPo orderpo;
	
	
	public ManageOrderViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		orderservice = new OrderServiceImpl(HotelID);
		userservice = new userserviceimpl();
	}

	@Override
	public void setView(ManageOrderView view) {
		this.view = view;
		
	}

	@Override
	public void OrderSearchButtonClicked() {
		view.OrderSearchButtonClicked();
		
	}

	@Override
	public void ExecuteButtonClicked() {
		view.ExecuteButtonClicked();
		
	}
	

	@Override
	public void ExitButtonClicked() {
		con.loggedin(HotelID+"");
		
	}

	@Override
	public List<OrderVo> getAllOrders(int holelID) {
		return orderservice.getAllOrders(holelID);
	}

	@Override
	public OrderPo searchOrder(int orderID) {
		return orderservice.getOrder(orderID);
	}

	@Override
	public boolean executeOrder(int orderID) {
		return orderservice.executeOrder(orderID);
	}

	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}

	@Override
	public List<OrderVo> getUnfinishedOrders(int hotelID) {
      return orderservice.getUnfinishedOrders(hotelID);
	}

	@Override
	public List<OrderVo> getFinishedOrders(int hotelID) {
		return orderservice.getFinishedOrders(hotelID);
	}

	@Override
	public List<OrderVo> getAbnormalOrders(int hotelID) {
		return orderservice.getAbnormalOrders(hotelID);
	}

	@Override
	public void CreditChange(int orderID,int userid,int credit) 
		{
			try {
				userpo = RemoteHelper.getInstance().getUserdataservice().userfind(userid);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			userpo.setCredit(userpo.getCredit()+credit);
			try {
				orderpo = RemoteHelper.getInstance().getOrderdataservice().orderfind(orderID);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			orderpo.setStatus(1);
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy/MM/dd");
			String time=format.format(date);
			String res = time.replaceAll("/","");
			orderpo.setExecutetime(Long.parseLong(time));
			try {
				if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(orderpo)&&RemoteHelper.getInstance().getUserdataservice().userupdate(userpo)){
					JOptionPane.showMessageDialog(null, "执行成功！","", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "执行失败！","", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

	@Override
	public void refresh() {
		con.ManageOrder();
		
	}

	@Override
	public void CreditRestore(int orderNo, int userid, int credit, long delaytime) throws RemoteException {
		try {
			userpo = RemoteHelper.getInstance().getUserdataservice().userfind(userid);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		userpo.setCredit(userpo.getCredit()+credit);
		try {
			orderpo = RemoteHelper.getInstance().getOrderdataservice().orderfind(orderNo);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		orderpo.setStatus(1);
		orderpo.setDelaytime(delaytime);
		try {
			if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(orderpo)&&RemoteHelper.getInstance().getUserdataservice().userupdate(userpo)){
				JOptionPane.showMessageDialog(null, "执行成功！","", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "执行失败！","", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderVo> getcanceledOrders(int hotelID) {
		return orderservice.getCanceledOrders(hotelID);
	}
	

	
	

}
