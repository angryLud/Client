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
}


public OrderVo(int userid, int hotelid,  long createtime, long executetime, long delaytime, long endtime,int value,int status,String roomstyle,int roomnum){

	this.add(String.valueOf(userid));
	this.add(String.valueOf(hotelid));
	this.add(String.valueOf(createtime));
	this.add(String.valueOf(executetime));
	this.add(String.valueOf(delaytime));
	this.add(String.valueOf(endtime));
	this.add(String.valueOf(value));
	this.add(String.valueOf(status));
	this.add(roomstyle);
	this.add(String.valueOf(roomnum));
}
public OrderVo(String access, int score) {
	// TODO Auto-generated constructor stub
this.access = access;
this.score = score;
}
public int getOrderid(){
	return 1;
}
public int getUserid(){
	return 11;
}
public int getHotelid(){
	return 22;
}
public long getCreatetime(){
	return 1;
}
public long getExecutetime(){
	return 1;
}
public long getDelaytime(){
	return 1;
}
public long getEndtime(){
	return 1;
}

public String getValue(){
	return this.get(8);
}
public int getStatus(){
	return 1;
}
public int getRoomstyle(){
	return 0;
}
public int getRoomnum(){
	return 0;
}
}
