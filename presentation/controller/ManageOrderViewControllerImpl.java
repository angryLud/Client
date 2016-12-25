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
//数据层接口未实现
public class ManageOrderViewControllerImpl implements ManageOrderViewController{
	private ManageOrderView view;
	
	private controller con;
	
	private int HotelID;
	
	private OrderService orderservice;
	
	private userservice userservice;
	
	
	public ManageOrderViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		orderservice = new OrderServiceImpl(HotelID);
		
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
//		return orderservice.getAllOrders(holelID);
		return null;
	}

	@Override
	public OrderVo searchOrder(int orderID) {
//		return orderservice.getOrder(orderID);
		return null;
	}

	@Override
	public boolean executeOrder(int orderID) {
//		return orderservice.executeOrder(orderID);
		return false;
	}

	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}

	@Override
	public void updateListModel(String selected) {
		view.updateListModel(selected);
		
	}

	@Override
	public List<OrderVo> getUnfinishedOrders(int hotelID) {
//    return orderservice.getUnfinishedOrders(hotelID);
	  return null;
	}

	@Override
	public List<OrderVo> getFinishedOrders(int hotelID) {
//		return orderservice.getFinishedOrders(hotelID);
		return null;
	}

	@Override
	public List<OrderVo> getAbnormalOrders(int hotelID) {
//		return orderservice.getAbnormalOrders(hotelID);
		return null;
	}

	@Override
	public boolean processAbnormalOrder(int orderId, String delayTime) {
//
		return false;
	}

	@Override
	public void CreditChange(int orderID,int userid,int credit) 
		{
			UserPo userpo = new UserPo();
			userpo = userservice.getUser(userid);
			userpo.setCredit(userpo.getCredit()+credit);
			OrderPo orderpo = new OrderPo(credit, credit, credit, credit, credit, credit, credit, credit, credit, credit, credit);
			orderpo = orderservice.getOrder(orderID);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		未完成
			
			
		}
	

	
	

}
