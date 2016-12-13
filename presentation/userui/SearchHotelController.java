package presentation.userui;

import java.util.Collection;
import java.util.List;

import vo.HotelVo;
import vo.OrderVo;

public interface SearchHotelController {
	void setview(SearchHotel view);

	int getUserID();

	List<HotelVo> getAllHotels(int userId);
}
