package presentation.hotelui;

import presentation.controller.controller;

public interface ManageHotelInfoViewController {
	public void ModifyButtonClicked();
	
	public void ConfirmButtonClicked();
	
	public void ExitButtonClicked();
	
	public void setView(ManageHotelInfoView view);
	
	public void setcon(controller con);
}
