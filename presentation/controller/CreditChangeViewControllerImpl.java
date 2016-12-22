package presentation.controller;


import businesslogic.CreditServiceImpl;
import businesslogicservice.CreditService;
import presentation.promotionui.CreditChangeView;
import presentation.promotionui.CreditChangeViewControllerService;

public class CreditChangeViewControllerImpl implements CreditChangeViewControllerService {
	
	private CreditChangeView view;
	
	private CreditService creditService;

	private controller con;
	
	public CreditChangeViewControllerImpl(){
		creditService = new CreditServiceImpl();
	}
	
	
	public void setView(CreditChangeView view){
		this.view = view;
	}
	
	public void confirmButtonClicked(){
		view.confirmButtonClicked();
	}

	@Override
	public void setcon(controller controller) {
		this.con=con;
	}

}
