package presentation.controller;

import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.UserInformation;
import presentation.userui.UserInformationCotroller;

public class UserInformationCotrollerimpl  implements UserInformationCotroller {
	private UserInformation view;
	private userservice userser;
	private controller con;
	private int UserID;
public UserInformationCotrollerimpl(int UserID){
	this.UserID = UserID;
}
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setview(UserInformation view) {
		// TODO Auto-generated method stub
		this.view = view;
	}

	@Override
	public void registerprocessButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setcon(controller con) {
		this.con=con;
	}

	public int getcredit(){
		return 0;
	}
	@Override
	public void ExitButtonClicked() {
		con.loggedin(UserID+"");
		
	}





}
