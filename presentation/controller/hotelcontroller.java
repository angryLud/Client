package presentation.controller;

import businesslogic.HotelServiceImpl;
import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import businesslogicservice.HotelService;
import presentation.hotelui.mainframecontroller;

/**
 * Created by huihantao on 2016/12/13.
 */
public class hotelcontroller implements mainframecontroller {
    private controller con;
    private String HotelID;
	private userservice usv;
	private HotelService hse;
    
    public hotelcontroller(String HotelID){
    	this.HotelID = HotelID;
    	usv=new userserviceimpl();
		hse=new HotelServiceImpl(Integer.parseInt(HotelID));
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
		usv.logout(Integer.parseInt(this.HotelID));
	}

	@Override
	public String getname() {
		return hse.getHotelName();
	}
}
