package presentation.controller;

import java.util.List;

import businesslogic.OrderServiceImpl;
import businesslogicservice.OrderService;
import dataservice.orderdataservice;
import presentation.hotelui.ManageOrderView;
import presentation.hotelui.ManageOrderViewController;
import vo.OrderVo;
//数据层接口未实现
public class ManageOrderViewControllerImpl implements ManageOrderViewController{
	private ManageOrderView view;
	
	private controller con;
	
	private int HotelID;
	
	private OrderService orderservice;
	
	
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

	
	

}
