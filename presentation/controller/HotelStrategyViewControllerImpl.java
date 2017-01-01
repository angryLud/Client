package presentation.controller;

import businesslogic.OrderServiceImpl;
import businesslogicservice.OrderService;
import po.OrderPo;
import presentation.hotelui.HotelStrategyView;
import presentation.hotelui.HotelStrategyViewController;


public class HotelStrategyViewControllerImpl implements HotelStrategyViewController{
	
	private int HotelID;
	
	private HotelStrategyView view;
	
	private controller con;
	
	private OrderService orderservice;
	
	public HotelStrategyViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		orderservice = new OrderServiceImpl(HotelID);
	}

	@Override
	public void StrategyConfirmButtonClicked() {
		view.StrategyConfirmButtonClicked();
		
	}

//	@Override
//	public void StrategyAddButtonClicked() {
//		view.StrategyAddButtonClicked();
//		
//	}

	@Override
	public void setView(HotelStrategyView view) {
		this.view = view;
		
	}

	@Override
	public void ExitButtonClicked() {
		con.loggedin(HotelID+"");
		
	}

	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}

	@Override
	public boolean updateOrder(OrderPo opo) {
		
		return orderservice.updateOrder(opo);
		
	}

}