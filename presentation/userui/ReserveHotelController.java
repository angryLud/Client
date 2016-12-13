package presentation.userui;

import javax.swing.JPanel;

import presentation.controller.controller;

public interface ReserveHotelController{

	int getcredit();
	
	int getuserid();

	void setview(ReserveHotel view);

	void setcon(controller controller);
	
	void change();

	int createorder(int userid,int hotelid,int intnowtime,long s5,long s7,long s6,int status,String s1,int s2);
}
