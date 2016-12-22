package presentation.promotionui;


import presentation.controller.controller;

public interface CreditChangeViewControllerService {
	
	public void setView(CreditChangeView view);
	
	public void confirmButtonClicked();
	
	void cancleButtonClicked();

    void setcon(controller controller);
}
