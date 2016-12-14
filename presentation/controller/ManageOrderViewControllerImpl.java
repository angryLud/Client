package presentation.controller;

import java.util.List;

import dataservice.orderdataservice;
import presentation.hotelui.ManageOrderView;
import presentation.hotelui.ManageOrderViewController;
import vo.OrderVo;
//数据层接口未实现
public class ManageOrderViewControllerImpl implements ManageOrderViewController{
	private ManageOrderView view;
	
	private int HotelID;
	
	private orderdataservice orderservice;
	
	public ManageOrderViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		
	}

	@Override
	public void setView(ManageOrderView view) {
		this.view = view;
		
	}

	@Override
	public void OrderBrowseButtonClicked() {
		view.OrderBrowseButtonClicked();
		
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
		view.ExitButtonClicked();
		
	}

	@Override
	public List<OrderVo> getAllOrders(int holelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVo searchOrder(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean executeOrder(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
