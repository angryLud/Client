package vo;
import po.OrderPo;
import java.util.*;
public class OrderVo extends Vector<String>{
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
public OrderVo(int orderid,int userid, int hotelid,  long createtime, long executetime, long delaytime, long endtime,int value,int status){
	this.add(String.valueOf(orderid));
	this.add(String.valueOf(userid));
	this.add(String.valueOf(hotelid));
	this.add(String.valueOf(createtime));
	this.add(String.valueOf(executetime));
	this.add(String.valueOf(delaytime));
	this.add(String.valueOf(endtime));
	this.add(String.valueOf(value));
	this.add(String.valueOf(status));
}

public String getOrderid(){
	return this.get(0);
}
public String getUserid(){
	return this.get(1);
}
public String getHotelid(){
	return this.get(2);
}
public String getCreatetime(){
	return this.get(3);
}
public String getExecutetime(){
	return this.get(4);
}
public String getDelaytime(){
	return this.get(5);
}
public String getEndtime(){
	return this.get(6);
}

public String getValue(){
	return this.get(8);
}
public String getStatus(){
	return this.get(9);
}
}
