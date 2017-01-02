package presentation.controller;


import businesslogic.ManageServiceImpl;
import businesslogic.userserviceimpl;
import businesslogicservice.ManageService;
import businesslogicservice.userservice;
import presentation.manageui.ManageView;
import presentation.manageui.ManageViewControllerService;

public class ManageViewControllerImpl implements ManageViewControllerService {
	
	
	private ManageView view;
	private controller con;
	private int id;
	private ManageService manageService;

	public ManageViewControllerImpl (int id){
		manageService = new ManageServiceImpl();
		this.id = id;


	}
	
	public void back() {
        con.login();
		manageService.logout(this.id);
    }
	
	public void setView(ManageView view){
		this.view = view;
	}
	
	public void updateScene(String comboboxValue){
		view.updateScene(comboboxValue);
	}
	
	public void searchButtonClicked(){
		view.searchButtonClicked();
	}
	
	public void newMemberButtonClicked(){
		view.newMemberButtonClicked();
	}
	
	public void newHotelButtonClicked(){
		view.newHotelButtonClicked();
	}

	@Override
	public void setcon(controller con) {
		this.con=con;
	}


}
