package presentation.hotelui;

import presentation.controller.controller;

/**
 * Created by huihantao on 2016/12/13.
 */
public interface mainframecontroller {
    void signout();
    public void setcon(controller con); 
    void HotelInfoButtonClicked();
    void ManageRoomButtonClicked();
    void ManageOrderButtonClicked();
    void HotelStrategyButtonClicked();
    void ExitButtonClicked();

    String getname();
}
