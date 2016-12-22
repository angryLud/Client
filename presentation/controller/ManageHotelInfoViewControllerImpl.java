package presentation.controller;

import businesslogic.HotelServiceImpl;
import businesslogicservice.HotelService;
import presentation.hotelui.ManageHotelInfoView;
import presentation.hotelui.ManageHotelInfoViewController;
import presentation.hotelui.ManageRoomView;

public class ManageHotelInfoViewControllerImpl implements ManageHotelInfoViewController{
	
    private ManageHotelInfoView view;
    
    private HotelService hotelservice;
    
    private controller con;
	
	private int HotelID;
	
	public ManageHotelInfoViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		hotelservice = new HotelServiceImpl(HotelID);
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
		con.loggedin(HotelID+"");
		
	}


	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}


	@Override
	public boolean updateHotel(int hotelID) {
//		return hotelservice.updateHotel(hotelID);
		return false;
	}

	

}
