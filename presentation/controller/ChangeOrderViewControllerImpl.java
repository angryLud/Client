package presentation.controller;


import presentation.promotionui.ChangeOrderView;
import presentation.promotionui.ChangeOrderViewControllerService;
import vo.OrderVo;

import java.util.List;

public class ChangeOrderViewControllerImpl implements ChangeOrderViewControllerService {
	
	private ChangeOrderView view;
	
	private int hotelId;
	
	public ChangeOrderViewControllerImpl(int hotelId){
		this.hotelId = hotelId;
	}
	
	public void setView(ChangeOrderView view){
		this.view = view;
	}
	
	public int getHotelId(){
		return hotelId;
	}
	
	public List<OrderVo> getAbnormalOrder(){
		return null;
//		return changeOrderService.getAbnormalOrder();
	}
	
	public void changeButtonClicked(){
		view.changeButtonClicked();
	}

}
