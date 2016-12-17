package presentation.controller;

import presentation.hotelui.ManageRoomView;
import presentation.hotelui.ManageRoomViewController;

public class ManageRoomViewControllerImpl implements ManageRoomViewController{
	
	private int HotelID;
	
	private ManageRoomView view;
	
	private controller con;
	
	public ManageRoomViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
	}

	@Override
	public void setView(ManageRoomView view) {
		this.view = view;
		
	}

	@Override
	public void InputButtonClicked() {
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

	@Override
	public void ExitButtonClicked() {
		view.ExitButtonClicked();
	}

	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}
	
}
