package vo;
import po.OrderPo;
import java.util.*;
public class OrderVo extends Vector<String>{
private String access;
private int score;
public OrderVo(OrderPo orderPo){
	this.add(String.valueOf(orderPo.getOrderid()));
	this.add(String.valueOf(orderPo.getUserid()));
	this.add(String.valueOf(orderPo.getHotelid()));
	this.add(String.valueOf(orderPo.getCreatetime()));
	this.add(String.valueOf(orderPo.getExecutetime()));
	this.add(String.valueOf(orderPo.getDelaytime()));
	this.add(String.valueOf(orderPo.getEndtime()));
	this.add(String.valueOf(orderPo.getValue()));
	this.add(String.valueOf(orderPo.getStatus()));
	this.add(String.valueOf(orderPo.getRoomstyle()));
	this.add(String.valueOf(orderPo.getRoomnum()));
}


public OrderVo(int orderid,int userid, int hotelid,  long createtime, long executetime, long delaytime, long endtime,int value,int status,String roomstyle,int roomnum){
	this.add(String.valueOf(orderid));
	this.add(String.valueOf(userid));
	this.add(String.valueOf(hotelid));
	this.add(String.valueOf(createtime));
	this.add(String.valueOf(executetime));
	this.add(String.valueOf(delaytime));
	this.add(String.valueOf(endtime));
	this.add(String.valueOf(value));
	this.add(String.valueOf(status));
	this.add(String.valueOf(roomstyle));
	this.add(String.valueOf(roomnum));
}
public int getOrderid(){
	return Integer.parseInt(this.get(0));
}
public int getUserid(){
	return Integer.parseInt(this.get(1));
}
public int getHotelid(){
	return Integer.parseInt(this.get(2));
}
public long getCreatetime(){
	return Integer.parseInt(this.get(3));
}
public long getExecutetime(){
	return Integer.parseInt(this.get(4));
}
public long getDelaytime(){
	return Integer.parseInt(this.get(5));
}
public long getEndtime(){
	return Integer.parseInt(this.get(6));
}

public String getValue(){
	return this.get(7);
}
public int getStatus(){
	return Integer.parseInt(this.get(8));
}
public int getRoomstyle(){

	return Integer.parseInt(this.get(9));
}
public int getRoomnum(){
	return Integer.parseInt(this.get(10));
}
}
