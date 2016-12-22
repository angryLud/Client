package businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import businesslogicservice.loginservice;
import dataservice.userdataservice;
import po.HotelPo;
import po.OrderPo;
import po.UserPo;
import presentation.userui.SearchHotelController;
import rmi.RemoteHelper;
import vo.HotelVo;
import vo.OrderVo;
import vo.UserVo;

public class userserviceimpl implements businesslogicservice.userservice {
	private userdataservice userdaser;
	private UserPo upo;
	private loginservice logs;
	private List<HotelPo> hpolist;
	public userserviceimpl(){

	}
	public userserviceimpl(int userId){
//		try {
//			upo=RemoteHelper.getInstance().getUserdataservice().find(userId);
//			opo=RemoteHelper.getInstance().getOrderdataservice().findbyuserid(userId);
//			hpolist=RemoteHelper.getInstance().getHoteldataservice().usergethotellist(userId);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		logs=new login();
	}

	@Override
	public int getcredit() {
		// TODO Auto-generated method stub
		return 100;
	}
	//1,"已执行订单","如家","08/08","08/09",100
	@Override
	public List<OrderVo> getAllOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(19,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		OrderVo y=new OrderVo(23,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		OrderVo z=new OrderVo(28,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		OrderVo u=new OrderVo(69,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		l.add(y);
		l.add(z);
		l.add(u);
		return l;
	}

	@Override
	public List<OrderVo> getUnfinishedOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(19,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}

	@Override
	public List<OrderVo> getFinishedOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(19,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}

	@Override
	public List<OrderVo> getAbnormalOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(19,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}
	public List<OrderVo> getCancelOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(19,1,20161209,20161210,20161210,20161213,198,1,"大床房",2);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}

	@Override
	public int getOrderUser(int orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrderPrice(int orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HotelVo> getAllHotels(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStars(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMark(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createorder(OrderVo ovo) {
		// TODO Auto-generated method stub
		//计算价格
		
		int value = 0;
		
		
//		插入数据库
		 try {
			RemoteHelper.getInstance().getOrderdataservice().insert(new OrderPo(ovo.getUserid(),ovo.getHotelid(),ovo.getCreatetime(),ovo.getExecutetime(),ovo.getDelaytime(),ovo.getEndtime(),value,ovo.getStatus(),ovo.getRoomstyle(),ovo.getRoomnum()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	}

	@Override
	public int getuserid() {
		// TODO Auto-generated method stub
		return upo.getId();
	}
//按条件搜索酒店（商圈、地址、是否预定过）
	@Override
	public Vector<HotelVo> usersearchhotel(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
//搜索筛选
		Vector<HotelVo> x=new Vector<>();
//		List<HotelVo> hpolist=SearchHotelController.getAllHotels(0);
//			for(int i=0;i<hpolist.size();i++){
//				if(hpolist.get(i).get(3).equals(s1)){
//					
//				}
//			}
		return x;
	}

	@Override
	public String getname() {
		return  "a";
		//return upo.getUserName();
	}

	@Override
	public void logout(int userid) {
		logs.logout(userid);
	}

	@Override
	public void updateuserinfo(UserVo uvo) {
		// TODO Auto-generated method stub
		//插入数据库
		try {
			RemoteHelper.getInstance().getUserdataservice().update(new UserPo(0,uvo.getUserName(),null,uvo.getPhone(),100,null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getphone() {
		// TODO Auto-generated method stub
		return upo.getPhone();
	}

	@Override
	public int insert(String name, String number,char[] password) {
		UserPo x=new UserPo(0,name,null,number,0,null);
		int i=0;
		try {
			i=RemoteHelper.getInstance().getUserdataservice().insert(x,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


}
