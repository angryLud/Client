package presentation.controller;

import presentation.hotelui.StrategyView;
import presentation.hotelui.StrategyViewController;

public class StrategyViewControllerImpl implements StrategyViewController{
	
	private int HotelID;
	
	private StrategyView view;
	
	public StrategyViewControllerImpl(int HotelID){
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
	public void setView(StrategyView view) {
		this.view = view;
		
	}

	@Override
	public void ExitButtonClicked() {
		view.ExitButtonClicked();
		
	}

}
