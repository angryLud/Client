package presentation.hotelui;

import presentation.controller.controller;

public interface ManageRoomViewController {
	public void setcon(controller con);
	
	public void setView(ManageRoomView view);
	
	public void ExitButtonClicked();
	
	public boolean updateHotel(int hotelID);
  
    public void refresh();
}
