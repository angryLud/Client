package presentation.controller;

import presentation.hotelui.hotelmainframe;
import presentation.hotelui.mainframecontroller;

/**
 * Created by huihantao on 2016/12/13.
 */
public class hotelcontroller implements mainframecontroller {
	private hotelmainframe frame;
    private controller con;
    private String HotelID;
    
    public hotelcontroller(String HotelID){
    	this.HotelID = HotelID;
    }
    @Override
    public void signout() {
        con.login();
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }

	@Override
	public void HotelInfoButtonClicked() {
		con.ManageHotelInfo();
		
	}

	@Override
	public void ManageRoomButtonClicked() {
		con.ManageRoom();
		
	}

	@Override
	public void ManageOrderButtonClicked() {
		con.ManageOrder();
		
	}

	@Override
	public void HotelStrategyButtonClicked() {
		con.HotelStrategy();
		
	}
	public void ExitButtonClicked(){
		con.loggedin(this.HotelID);
	}
}
