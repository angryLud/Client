package presentation.hotelui;

import po.OrderPo;
import presentation.controller.controller;

public interface HotelStrategyViewController {
	public void setcon(controller con);
	
	public void setView(HotelStrategyView view);
	
	public void StrategyConfirmButtonClicked();
	
//	public void StrategyAddButtonClicked();
	
	public void ExitButtonClicked();
	
	public boolean updateOrder(OrderPo opo);

}
