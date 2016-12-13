package presentation.controller;


import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.ReserveHotel;
import presentation.userui.ReserveHotelController;
import vo.OrderVo;

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
	@Override
	public int createorder(int userid,int hotelid,int intnowtime,long s5,long s7,long s6,int status,String s1,int s2) {
		// TODO Auto-generated method stub
		
		OrderVo ovo = new OrderVo(userid,hotelid,intnowtime,s5,s7,s6,status,s1,s2);
		
		return userser.createorder(ovo);
		
	}
	@Override
	public int getuserid() {
		// TODO Auto-generated method stub
		return userser.getuserid();
	}
	


}
