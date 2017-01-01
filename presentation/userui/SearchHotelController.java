package presentation.userui;

import java.util.Collection;
import java.util.List;

import presentation.controller.controller;
import vo.HotelVo;
import vo.OrderVo;

public interface SearchHotelController {

	void setview(SearchHotel view);

	int getUserID();

	List<HotelVo> getAllHotels(int userid);

    void setcon(controller con);

	void ExitButtonClicked();

	void reservehotel();
	
    int getcredit();

	int createorder(int orderid, int userid, int hotelid, int intnowtime, long s5, long s7, long s6, int status,
			String s1, int s2);

	String getname();

	String getAddress();

	void creatpo(int selectedhotelid);

	String getPosition();

	int getDachuangfangprice();

	String getDescription();

	int getShuangrenfangprice();
	
	int getSanrenjianprice();

	int getStar();

	boolean isreserved(int selectedhotelid,int userId);
}
