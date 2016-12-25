package presentation.userui;

import presentation.controller.controller;

public interface UserInformationCotroller {

	int getcredit();
	void cancel();
    void setview(UserInformation view);
    void registerprocessButton();
    void setcon(controller con);
	void ExitButtonClicked();
	void updateuserinfor(String name, String phone);
	String getusername();
	int getuserid();
	String getphone();
	void updatecompanyvip(String company);
	void updatenormalvip(String birthday);
}
