package presentation.manageui;


import presentation.controller.controller;

public interface ManageViewControllerService {
	
	public void setView(ManageView view);
	
	void back();
	
	public void updateScene(String comboboxValue);
	
	public void searchButtonClicked();
	
	public void newMemberButtonClicked();
	
	public void newHotelButtonClicked();

	public void setcon(controller con);

}
