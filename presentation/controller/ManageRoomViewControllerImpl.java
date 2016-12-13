package presentation.controller;

import presentation.hotelui.ManageRoomView;
import presentation.hotelui.ManageRoomViewController;

public class ManageRoomViewControllerImpl implements ManageRoomViewController{
	
	private int HotelID;
	
	private ManageRoomView view;
	
	public ManageRoomViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
	}

	@Override
	public void setView(ManageRoomView view) {
		this.view = view;
		
	}

	@Override
	public void inputButtonClicked() {
		view.InputButtonClicked();
		
	}


	@Override
	public void manageModifyButtonClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void manageConfirmButtonClicked() {
		// TODO Auto-generated method stub
		
	}
	
}
