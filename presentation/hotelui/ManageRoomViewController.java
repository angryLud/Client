package presentation.hotelui;

import presentation.controller.controller;

public interface ManageRoomViewController {
	public void setcon(controller con);
	
	public void setView(ManageRoomView view);
	
	public void InputButtonClicked();
	
	public void manageModifyButtonClicked();
	
	public void manageConfirmButtonClicked();
	
	public void ExitButtonClicked();
  

}
