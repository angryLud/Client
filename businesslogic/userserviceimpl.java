package businesslogic;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.userservice;
import dataservice.userdataservice;

import vo.OrderVo;

public class userserviceimpl implements userservice {
	private userdataservice userdaser;
	public userserviceimpl(int userId){
		
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
		OrderVo x=new OrderVo(1,19,1,20161209,20161210,20161210,20161213,198,1);
		OrderVo y=new OrderVo(2,23,1,20161209,20161210,20161210,20161213,198,1);
		OrderVo z=new OrderVo(3,28,1,20161209,20161210,20161210,20161213,198,1);
		OrderVo u=new OrderVo(4,69,1,20161209,20161210,20161210,20161213,198,1);
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
		OrderVo x=new OrderVo(1,19,1,20161209,20161210,20161210,20161213,198,1);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}

	@Override
	public List<OrderVo> getFinishedOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(1,19,1,20161209,20161210,20161210,20161213,198,1);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}

	@Override
	public List<OrderVo> getAbnormalOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(1,19,1,20161209,20161210,20161210,20161213,198,1);
		ArrayList<OrderVo> l=new ArrayList<OrderVo>();
		l.add(x);
		return l;
	}
	public List<OrderVo> getCancelOrders(int userId) {
		// TODO Auto-generated method stub
		OrderVo x=new OrderVo(1,19,1,20161209,20161210,20161210,20161213,198,1);
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
	public boolean login(String userid, char[] password) {

		return false;
	}

}
