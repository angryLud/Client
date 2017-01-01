package businesslogicservice;

import po.HotelPo;
import po.PromotionerPo;
import po.UserPo;
import vo.HotelVo;
import vo.PromotionerVo;
import vo.UserVo;

public interface ManageService {
	
	/**
	 * @param userPo
	 * @return 增加用户
	 */
	public int addPromotioner(PromotionerPo ppo,String password);
	
	/**
	 * @param userPo
	 * @return 更改用户信息
	 */
	public boolean changeUserInfo(UserPo userPo);
	
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
	
	public HotelPo uploadHotel(int id);
	
	public PromotionerVo uploadPromotioner(int id);
	
	public boolean changePromotionerInfo(PromotionerPo ppo);
	
	public boolean changeHotelInfo(HotelPo hpo);
	

}
