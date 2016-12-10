package presentation.controller;


import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.ReserveHotel;
import presentation.userui.ReserveHotelController;

public class ReserveHotelControllerimpl  implements ReserveHotelController {
	private userservice userser;
	private ReserveHotel view;
	private controller con;
	
	
	public ReserveHotelControllerimpl(){
		userser = new userserviceimpl(1);
	}
	@Override
	public int getcredit() {
		// TODO Auto-generated method stub
		return userser.getcredit();
	}
	@Override
	public void setview(ReserveHotel view) {
		// TODO Auto-generated method stub
		this.view=view;
	}
	@Override
	public void setcon(controller controller) {
		// TODO Auto-generated method stub
		this.con=controller;
	}
	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}
	


}
