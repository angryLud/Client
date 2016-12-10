package presentation.controller;


import presentation.promotionui.ChangeOrderView;
import presentation.promotionui.ChangeOrderViewControllerService;

public class ChangeOrderViewControllerImpl implements ChangeOrderViewControllerService {
	
	private ChangeOrderView view;
	
	public ChangeOrderViewControllerImpl(){
		
	}
	
	public void setView(ChangeOrderView view){
		this.view = view;
	}

}
