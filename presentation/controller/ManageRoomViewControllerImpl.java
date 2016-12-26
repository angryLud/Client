package presentation.controller;

import businesslogicservice.HotelService;
import presentation.hotelui.ManageRoomView;
import presentation.hotelui.ManageRoomViewController;

public class ManageRoomViewControllerImpl implements ManageRoomViewController{
	
	private int HotelID;
	
	private ManageRoomView view;
	
	private controller con;
	
	private HotelService hotelservice;
	
	public ManageRoomViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
	}

	@Override
	public void setView(ManageRoomView view) {
		this.view = view;
		
	}

	@Override
	public void ExitButtonClicked() {
		con.loggedin(HotelID+"");
	}

	@Override
	public void setcon(controller con) {

		this.con = con;
		
	}
	
	public void refresh(){
		con.ManageRoom();
	}

	@Override
	public boolean updateHotel(int hotelID) {
//		return hotelservice.updateHotel(hotelID);
		return false;
	}
	
	
}
