package presentation.controller;


import presentation.manageui.ManageView;
import presentation.manageui.ManageViewControllerService;

public class ManageViewControllerImpl implements ManageViewControllerService {
	
	private int HotelID;
	
	private ManageView view;
	
	public ManageViewControllerImpl (int HotelID){
		this.HotelID = HotelID;
	}
	
	public void setView(ManageView view){
		this.view = view;
	}
	
	public void updateScene(String comboboxValue){
		view.updateScene(comboboxValue);
	}
	
	public void searchButtonClicked(){
		view.searchButtonClicked();
	}
	
	public void newMemberButtonClicked(){
		view.newMemberButtonClicked();
	}
	
	public void newHotelButtonClicked(){
		view.newHotelButtonClicked();
	}
	
}
