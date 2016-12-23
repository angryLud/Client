package businesslogic;

import businesslogicservice.ManageService;
import vo.UserVo;

import java.rmi.RemoteException;
import java.util.List;

import po.HotelPo;
import po.UserPo;
import rmi.RemoteHelper;

public class ManageServiceImpl implements ManageService {
	
	private UserVo userVo;
	
	private List<UserPo> userList;
	
	public boolean addUser(UserPo userPo){
//		try {
//			if(RemoteHelper.getInstance().getUserdataservice().insert(userPo)){
//				return true;
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return false;
	}
	
	public boolean changeUserInfo(int id,UserPo usPo){
		for(UserPo userPo :userList){
			if(userPo.getId() == id){
				userPo.setUserName(usPo.getUserName());
				userPo.setCompany(usPo.getCompany());
				userPo.setPhone(usPo.getPhone());
				userPo.setBirthday(usPo.getBirthday());
				try {
					if(RemoteHelper.getInstance().getUserdataservice().update(userPo)){
						return true;
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return false;
	}
	
	public boolean addHotel(HotelPo hotelPo){
		try {
			if(RemoteHelper.getInstance().getHoteldataservice().insert(hotelPo)){
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public UserVo uploadUser(int id){
		for(UserPo userPo : userList){
			if(userPo.getId() == id){
				userVo = new UserVo(userPo);
			}
		}
		return userVo;
	}
	
	public void logout(int id) {

	}

}
