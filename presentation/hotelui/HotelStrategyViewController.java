package presentation.hotelui;

import presentation.controller.controller;

public interface HotelStrategyViewController {
	public void setcon(controller con);
	
	public void setView(HotelStrategyView view);
	
	public void StrategyConfirmButtonClicked();
	
//	public void StrategyAddButtonClicked();
	
	public void ExitButtonClicked();

}
