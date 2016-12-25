package businesslogicservice;

import java.util.List;
import java.util.Vector;

import vo.HotelVo;
import vo.OrderVo;
import vo.UserVo;

public interface userservice {
	
public int getcredit();
/**
 * @param userId
 * @return	获取用户所有订单列表
 */
public   List<OrderVo> getAllOrders(int userId);
/**
 * @param userId
 * @return	获取用户未执行订单列表
 */
public List<OrderVo> getUnfinishedOrders(int userId);

/**
 * @param userId
 * @return	获取用户已执行订单列表
 */
public List<OrderVo> getFinishedOrders(int userId);

/**
 * @param userId
 * @return	获取用户异常订单列表
 */
public List<OrderVo> getAbnormalOrders(int userId);
/**
 * @param userId
 * @return	获取用户已撤销订单列表
 */
public List<OrderVo> getCancelOrders(int userId);

public List<HotelVo> getAllHotels(int userId);

public int createorder(OrderVo ovo);

public int getuserid();

String getname();

void logout(int userid);

public void updateuserinfo(String name,String phone);

public String getphone();

int insert(String name, String number,char[] password);

public void updateorderinfo(int orderid,String assess, int score);
public void updatecompanyvip(String company);
public void updatenormalvip(String birthday);
public void cancelorder(int orderid);
}
