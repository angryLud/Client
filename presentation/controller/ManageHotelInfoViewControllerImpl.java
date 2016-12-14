package presentation.controller;

import presentation.hotelui.ManageHotelInfoView;
import presentation.hotelui.ManageHotelInfoViewController;
import presentation.hotelui.ManageRoomView;

public class ManageHotelInfoViewControllerImpl implements ManageHotelInfoViewController{
	
    private ManageHotelInfoView view;
	
	private int HotelID;
	
	public ManageHotelInfoViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		
	}
	
	
	@Override
	public void setView(ManageHotelInfoView view) {
	    this.view = view;
		
	}
	
	@Override
	public void ModifyButtonClicked() {
		view.ModifyButtonClicked();
		
	}

	@Override
	public void ConfirmButtonClicked() {
		view.ConfirmButtonClicked();
		
	}


	@Override
	public void ExitButtonClicked() {
		view.ExitButtonClicked();
		
	}

	

}
