package presentation.controller;

import presentation.hotelui.HotelStrategyView;
import presentation.hotelui.HotelStrategyViewController;


public class HotelStrategyViewControllerImpl implements HotelStrategyViewController{
	
	private int HotelID;
	
	private HotelStrategyView view;
	
	private controller con;
	
	public HotelStrategyViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
	}

	@Override
	public void StrategyConfirmButtonClicked() {
		view.StrategyConfirmButtonClicked();
		
	}

	@Override
	public void StrategyAddButtonClicked() {
		view.StrategyAddButtonClicked();
		
	}

	@Override
	public void setView(HotelStrategyView view) {
		this.view = view;
		
	}

	@Override
	public void ExitButtonClicked() {
		view.ExitButtonClicked();
		
	}

	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}

}