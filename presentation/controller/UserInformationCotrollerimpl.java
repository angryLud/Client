package presentation.controller;

import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.UserInformation;
import presentation.userui.UserInformationCotroller;

public class UserInformationCotrollerimpl  implements UserInformationCotroller {
	private UserInformation view;
	private userservice userser;

public UserInformationCotrollerimpl(){
	userser = new userserviceimpl(1);
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
	public int getcredit(){
		return 0;
	}





}
