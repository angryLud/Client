package presentation.userui;

import javax.swing.JPanel;

import presentation.controller.controller;

public interface ReserveHotelController{

	int getcredit();

	void setview(ReserveHotel view);

	void setcon(controller controller);
	
	void change();

}
