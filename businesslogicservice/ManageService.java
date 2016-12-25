package businesslogicservice;

import po.HotelPo;
import po.PromotionerPo;
import po.UserPo;
import vo.UserVo;

public interface ManageService {
	
	/**
	 * @param userPo
	 * @return 增加用户
	 */
	public int addUser(PromotionerPo ppo,String password);
	
	/**
	 * @param userPo
	 * @return 更改用户信息
	 */
	public boolean changeUserInfo(int id, UserPo userPo);
	
	/**
	 * @param hotelPo
	 * @return 增加酒店
	 */
	public int addHotel(HotelPo hotelPo,String password);
	/**
	 * @param id
	 * @return 上传用户信息
	 */
	public UserVo uploadUser(int id);
	
	void logout(int id);
	
}
